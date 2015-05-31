var loadedScriptLabels = new Array();

function GetElement( id )
{
	return document.getElementById( id );
}

function DOMSetParent( newparent, node )
{
	// removes node from current parent (appendChild
	// automatically does this) and appends to newparent
	if ( node.parentElement != newparent )
		newparent.appendChild( node );
}

function DOMEmpty( node )
{
	// removes all of node's children
	while ( node.hasChildNodes() )
		node.removeChild( node.firstChild );
}

function DOMRemove( node )
{
	// removes node from its parent, returns the removed node
	if ( node && node.parentNode )
		node.parentNode.removeChild( node );
	
	return node;
}

function DOMDiv( parent, id )
{
	// creates new div with given id, appends to parent, returns div
	var div = document.createElement( 'div' );
	div.id = id;
	return parent.appendChild( div );
}

function DOMTable( parent, border, cellspacing, cellpadding, id, w )
{
	// creates new table with given properties, appends to parent, returns the tbody
	var table = document.createElement( 'table' );
	if ( w != null )
		table.width = w;
		
	table.border = border;
	table.cellSpacing = cellspacing;	table.cellPadding = cellpadding;
	if ( id != null )
		table.id = id;
		
	var tbody = document.createElement( 'tbody' );
	table.appendChild( tbody );
	parent.appendChild( table );

	return tbody;
}

/* Retain for backward compatibility */
function DOMText( parent, text )
{
	return DOMStyledText( parent, text, 'plain' );
}

/* Unnecessary; use DOMStyledText instead
function DOMTextNode( parent, text )
{
	var tNode = document.createTextNode( text );
	return parent.appendChild( tNode );
}
*/

function DOMStyledText( parent, text, style )
{
	// appends text onto current contents of parent,
	// applying the specified style (either 'bold', 'italic',
	// 'bolditalic', 'plain', 'br', or the class name of a span)
	// to text. (If style is empty or missing, defaults to
	// 'plain'.) Returns the node that is appended to parent.
	var node, subNode;
	if ( style == null || style == '' )
		style = 'plain';
		
	switch ( style )
	{
		case 'bold':
			node = document.createElement( 'strong' );
			node.appendChild( document.createTextNode( text ) );
			break;
		case 'italic':
			node = document.createElement( 'em' );
			node.appendChild( document.createTextNode( text ) );
			break;
		case 'bolditalic':
			node = document.createElement( 'strong' );
			subNode = document.createElement( 'em' );
			subNode.appendChild( document.createTextNode( text ) );
			node.appendChild( subNode );
			break;
		case 'plain':
			node = document.createTextNode( text );
			break;
		case 'br':
			node = document.createElement( 'br' );
			break;
		default:
			node = document.createElement( 'span' );
			node.className = style;
			node.appendChild( document.createTextNode( text ) );
			break;
	}
	
	return parent.appendChild( node );
}

function DOMInput( parent, size, clss, name, val )
{
	// creates new text box with given properties, appends to parent, returns text box
	var inpt = document.createElement( 'input' );
	inpt.type = 'text';
	inpt.size = size;
	inpt.value = val;
	inpt.name = name;
	inpt.id = name;
	inpt.className = clss;
	return parent.appendChild( inpt );
}

function DOMTextarea( parent, rows, cols, clss, name, val )
{
	// creates new text area with given properties, appends to parent, returns text area
	var inpt = document.createElement( 'textarea' );
	inpt.rows = rows;
	inpt.cols = cols;
	inpt.value = val;
	inpt.name = name;
	inpt.id = name;
	inpt.className = clss;
	return parent.appendChild( inpt );
}

function DOMRadio( parent, name, val, checked )
{
	// creates new radio button with given properties, appends to parent, returns button
	var inpt = document.createElement( 'input' );
	inpt.type = 'radio';
	inpt.value = val;
	inpt.name = name;
	inpt.id = name;
	inpt.checked = ( checked ? 'checked' : '' );
	return parent.appendChild( inpt );
}

function DOMElement( parent, tag, id )
{
	// creates new element with tagName tag and given id, appends to parent, returns element
	var newchild = document.createElement( tag );
	if ( id != null )
		newchild.id = id;
		
	return parent.appendChild( newchild );
}

function DOMSelect( parent, name, clss, names, values, val )
{
	// creates new select combo with given properties, appends to parent, return combo
	// names and values are equal length arrays
	var select = document.createElement( 'select' );
	select.className = clss;
	select.name = name;
	select.id = name;
	var options = select.options;
	for ( var i = 0 ; i < names.length ; i++ )
	{
		var option = document.createElement( 'option' );
		option.text = names[ i ];
		option.value = values[ i ];
		select.options[ select.options.length ] = option;
		if ( val != null && values[ i ] == val )
			select.selectedIndex = i;
	}
	return parent.appendChild( select );
}

function DOMSelectSetValue( select, val )
{
	// sets combo selection to given value and deselects all others
	select.selectedIndex = -1;
	var options = select.options;
	for ( var i = 0 ; i < options.length ; i++ )
		if ( options[ i ].value == val )
		{
			select.selectedIndex = i;
			return;
		}
}

function ParentOffset( elt )
{
	// returns the left and top offsets of elt's offsetParent
	var x = 0, y = 0;
	while ( elt.offsetParent )
	{
		x += parseInt( elt.offsetParent.offsetLeft );
		y += parseInt( elt.offsetParent.offsetTop );
		elt = elt.offsetParent;
	}

	return [ x, y ];
}

function FlyerAppear( trig, flyer, dx, dy )
{
	// makes flyer visible offset by dx,dy from trig
	var elt = GetElement( trig );
	var fly = GetElement( flyer );

	var t = ParentOffset( elt );

	var x = t[ 0 ] + parseInt( elt.offsetLeft );
	var y = t[ 1 ] + parseInt( elt.offsetTop );

	if ( dx == null )
	{
		// offset from right edge of trigger element
		x += elt.offsetWidth;
	}
	else
	{
		x += dx,
		y += dy;
	}

	if ( navigator.appVersion.indexOf( "MSIE 5" ) > -1 
			&& navigator.appVersion.indexOf( "Mac" ) > -1 )
	{
		// fix for IE5/Mac thinking there are left and top margins even if they've been set to 0
		x += parseInt( document.body.leftMargin );
		y += parseInt( document.body.topMargin );
	}

	if ( $.browser.msie && $.browser.version == 7 ) // added 10/17/2008 by ECM
		y += $(elt).height();                   // to fix IE7 misbehavior

	fly.style.left = x + 'px';
	fly.style.top = y + 'px';
	fly.style.visibility = 'visible';
}

function DOMScrollToView( id )
{
	// after a short delay to allow rendering, scrolls window so that
	// the element with given id is visible
	var elt = GetElement( id );
	if ( elt && elt.scrollIntoView )
		setTimeout( 'GetElement("' + id + '").scrollIntoView( true );', 0 );
}

function DOMScrollToViewName( ename )
{
	// after a short delay to allow rendering, scrolls window so that the
	// first element with the given name is visible.
	// Only works for elements for which the name attribute is valid:
	//  a, applet, form, frame, iframe, img, input, map, meta, object,
	//  option, param, select, textarea.
	var elt = document.getElementsByName( ename );
	if ( elt && elt.length > 0 )
		setTimeout( 'if ( document.getElementsByName("' + ename + '").length > 0 ) document.getElementsByName("' + ename + '")[ 0 ].scrollIntoView( true );', 0 );
}

function DOMGetScrollPosition()
{
	// returns the window's scroll position as a 2-element array
	var sx = 0, sy = 0;
	if( typeof( window.pageYOffset ) == 'number' )
	{
		// Non-IE, standards compliant
		sy = window.pageYOffset;
		sx = window.pageXOffset;
	}
	else if( document.documentElement 
					&& ( document.documentElement.scrollLeft || document.documentElement.scrollTop ) )
	{
		// IE6/7 in standards compliant mode
		sy = document.documentElement.scrollTop;
		sx = document.documentElement.scrollLeft;
	}
	else if( document.body && ( document.body.scrollLeft || document.body.scrollTop ) )
	{
		// IE, DOM compliant
		sy = document.body.scrollTop;
		sx = document.body.scrollLeft;
	}
	return [ sx, sy ];
}

function DOMSaveScrollPosition()
{
	// if there is a scrollposition field, saves the scroll position to it
	if ( !GetElement( 'scrollposition' ) )
		return;

	var a = DOMGetScrollPosition();
	GetElement( 'scrollposition' ).value = a[ 0 ] + ',' + a[ 1 ];
}

function DOMScrollPosition()
{
	// if there is a scrollposition field with non-empty value, scrolls to
	// the saved scroll position
	if ( GetElement( 'scrollposition' ) && GetElement( 'scrollposition' ).value != '' )
		setTimeout( 'DOMScrollPositionAux()', 0 );
}

function DOMScrollPositionAux()
{
	var t = GetElement( 'scrollposition' ).value.split( ',' );
	window.scrollTo( parseInt( t[ 0 ] ), parseInt( t[ 1 ] ) );
}

function DOMLoadScript( label, URL )
{
	for ( var i = 0 ; i < loadedScriptLabels.length ; i++ )
		if ( label == loadedScriptLabels[ i ] )
			return;
	
	loadedScriptLabels[ loadedScriptLabels.length ] = label;
	var s = document.createElement( 'script' );
	s.src = URL;
	s.type = 'text/javascript';
	document.getElementsByTagName( 'head' )[ 0 ].appendChild( s );
}

function ScrollIntoViewElement( elementid )
{
	var t = $("#" + elementid);
	if ( t.size() > 0 )
		t.get( 0 ).scrollIntoView();
}