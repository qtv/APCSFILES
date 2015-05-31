// Extend Javascript with version < 1.6 to include the forEach method for arrays
if (!Array.prototype.forEach)
{
  Array.prototype.forEach = function(fun /*, thisp*/)
  {
    var len = this.length;
    if (typeof fun != "function")
      throw new TypeError();

    var thisp = arguments[1];
    for (var i = 0; i < len; i++)
    {
      if (i in this)
        fun.call(thisp, this[i], i, this);
    }
  };
}

// Temporary -- for backward compatibility
var agt = navigator.userAgent.toLowerCase();
var isNetscape = ( agt.match( /gecko/g ) != null );

// Replace source of image, referenced by name
function changeSource( imgname, src )
{
	if ( document.images ) 
	{
		if ( document.images[imgname].src != src )
			document.images[imgname].src = src;
	}
}

// Replace source of image, referenced by id
function changeSource2( imgID, src ) 
{
  var img = GetElement( imgID );
  if ( img.tagName.toLowerCase() == 'img' && img.src != src )
    img.src = src;
}

// Open a new secondary window
function secWindow( url, name, w, h, top, left, props )
{
	if ( typeof( nosecondwindows ) == 'boolean' && nosecondwindows )
	{
		document.location.href = url;
		return;
	}
	
	var t = '';
	
	function add( name, y )
	{
		if ( y ) 
		{
			if ( t != '' )
				t += ',';
			
			if ( name != null )
				t += name + '=' + y;
			else
				t += y;
		}
	}	

	add( 'width', w );
	add( 'height', h ); 
	add( 'top', top ); 
	add( 'left', left ); 
	add( null, props );

	window.open( url, name, t, false );
}

// Jump to target given in list combo box 
// (which must be named "List") on a form
function jumpTo( form ) 
{
	location.href = form.List[form.List.selectedIndex].value;
}

// Scroll window to display location of 'jumpto' anchor on a page
function DoJumpTo()
{
	DOMScrollToViewName( 'jumpto' );
}

// Force submission of timed exam answers for grading
function ForceSubmit( url )
{
	var form = GetElement( 'form2' );
	if ( form != null && typeof( form ) != 'undefined' )
	{
		var t = form.action;
		var n = t.indexOf( '?' );
		if ( n > 0 )
			form.action = form.action.substr( 0, n );
		form.action += '?' + url;
		form.submit();
	}
	
	return true;
}

// Cross-browser addEventListener
function AddEvent( obj, evType, fn, useCapture )
{
	if ( obj.addEventListener )
	{
		obj.addEventListener( evType, fn, useCapture );
		return true;
	}
	else if ( obj.attachEvent )
	{
		var bSuccess = obj.attachEvent( 'on' + evType, fn );
		return bSuccess;
	}
}

// Cross-browser removeEventListener
function RemoveEvent( obj, evType, fn, useCapture )
{
	if ( obj.removeEventListener )
		obj.removeEventListener( evType, fn, useCapture );
	else if ( obj.detachEvent )
		// detachEvent has no return value
		var bSuccess = obj.detachEvent( 'on' + eType, fn );
}

// Cross-browser functions, allowing for IE w/ & w/o doctype
function getClientW()
{
	if ( self.innerWidth )
		return self.innerWidth;
	else if ( document.documentElement && document.documentElement.clientWidth )
		//ie6/7 with specified doctype
		return document.documentElement.clientWidth;
	else
		//ie5up, netscape, ie6/7 in backward compatible mode
		return document.body.clientWidth;
}

function getClientH()
{
	if ( self.innerHeight )
		return self.innerHeight;
	if ( document.documentElement && document.documentElement.clientHeight )
		//ie6/7 with specified doctype
		return document.documentElement.clientHeight;
	else
		//ie5up, netscape, ie6/7 in backward compatible mode
		return document.body.clientHeight;
}

function getScrollX ()
{
	if ( self.pageXOffset )
		//Mozilla, Netscape, Opera, Safari, and others
		return self.pageXOffset;
	else if ( document.documentElement && document.documentElement.scrollLeft )
		//ie6 with specified doctype
		return document.documentElement.scrollLeft;
	else
		//ie5up, ie6 in backward compatible mode
		return document.body.scrollLeft;
}

function getScrollY ()
{
	if ( self.pageYOffset )
		//Mozilla, Netscape, Opera, Safari, and others
		return self.pageYOffset;
	if ( document.documentElement && document.documentElement.scrollTop )
		//ie6 with specified doctype
		return document.documentElement.scrollTop;
	else
		//ie5up, ie6 in backward compatible mode
		return document.body.scrollTop;
}

// Cross-browser getPosition; also takes care of doctype issues for IE
function getPosition( evt )
{
	evt = evt || ( window.event ? window.event : null );
	var pos = { x:0, y:0 };
	if ( evt )
	{
		if ( evt.pageX || evt.pageY )
		{
			pos.x = evt.pageX;
			pos.y = evt.pageY;
		}
		else
		{
			pos.x = evt.clientX +
					( document.documentElement.scrollLeft || document.body.scrollLeft ) -
						document.documentElement.clientLeft;
			pos.y = evt.clientY +
					( document.documentElement.scrollTop || document.body.scrollTop ) -
						document.documentElement.clientTop;
		}
	}
	return pos;
}

function getOffsets( obj )
{
	var curleft = curtop = 0;

	if ( typeof( jQuery ) != 'undefined' && obj.id != null && obj.id != '' )
	{
		var obj_jQ = $( '#' + obj.id );
		var offsetObj = obj_jQ.offset();
		curleft = offsetObj.left;
		curtop = offsetObj.top;
	}
	else if ( obj.offsetParent )
	{
		curleft = obj.offsetLeft;
		curtop = obj.offsetTop;

		/* The following condition is deliberately NOT ==
		 * The value returned by the assignment is the new value of obj
		 * which will be null (and therefore stop the while loop) if
		 * the old value of obj has no offsetParent
		 */
		while ( obj = obj.offsetParent )
		{
			curleft += obj.offsetLeft;
			curtop += obj.offsetTop;
		}
	}
	return [curleft,curtop];
}

// Show popup note
function show( id, w, offsetx, offsety, evt )
{
	var pos = getPosition( evt );
	var sx = getScrollX();
	var sy = getScrollY();
	
	var ob = document.getElementById( id );
	
	var oParent = ob.offsetParent;
	var offsets = getOffsets( oParent );
	var x = pos.x + offsetx - offsets[ 0 ];
	var y = pos.y + offsety - offsets[ 1 ];
		
	ob.style.width = w + 'px';
	var obwid = ob.offsetWidth + ( 2 * offsetx );
	var obht = ob.offsetHeight + ( 2 * offsety );
	var pgwid = getClientW();
	var pght = getClientH();
	
	if ( pos.x + obwid > sx + pgwid )
	{
		if ( pos.x - obwid < sx )
		{
			x -= ( obwid * ( pos.x - sx ) / pgwid );
		}
		else { x -= obwid; }
	}
	if ( pos.y + obht > sy + pght )
	{
		if ( pos.y - obht < sy )
		{
			y -= ( obht * ( pos.y - sy ) / pght );
		}
		else { y -= obht; }
	}

	ob.style.left = x + 'px';
	ob.style.top = y + 'px';
	ob.style.visibility = 'visible';
}

// Hide popup
function hide(id) {
	document.getElementById( id ).style.visibility = 'hidden';
}

// Floating button
function InitFloaterButton()
{
	var bDiv = GetElement( 'floatingbutton' );
	if ( bDiv )
	{
		bDiv.style.top = '16px';
		bDiv.style.left = '8px';
		window.setInterval( 'FloatButton()', 1000 );
	}
}

function FloatButton()
{
	var topOffset = 16;
	var bDiv = GetElement( 'floatingbutton' );
	var tp = parseInt( bDiv.style.top );
	var sy = getScrollY();
	var dif = ( ( sy + 26 <= topOffset ) ? 0 - tp : sy + 26 - tp - topOffset);
	bDiv.style.top = tp + dif + 'px';
}


function SaveWindowPosition()
{
	if ( GetElement( "windowposition" ) != null )
	{
		var agt = navigator.userAgent.toLowerCase();
		var isNetscape = (agt.match( /gecko/g ) != null ? true : false);
		if ( !isNetscape ) 
			e = window.event; 
		
		var sx = (isNetscape ? window.scrollX : document.documentElement.scrollLeft + document.body.scrollLeft); 
		var sy = (isNetscape ? window.scrollY : document.documentElement.scrollTop + document.body.scrollTop );
		
		GetElement( "windowposition" ).value = sx + "," + sy;
	}
	
	return true;
}

function RestoreWindowPosition()
{
	$(document).ready( 
		function() 
		{
			var e = GetElement( "windowposition" );
			if ( e != null )
			{
				var t = e.value;
				if ( t != "" )
				{
					t = t.split( ',' );
					window.scrollTo( parseInt( t[ 0 ] ), parseInt( t[ 1 ] ) );
				} 
			}
		}
	);
}

// Safe opener location changer. Use in onclick method of <a href="#"> link
// and follow by return false;
function ChangeOpenerLocation( newLoc, closeSecondary )
{
	var opener = window.opener;
	if ( opener && !opener.closed )
	{
		opener.location.href = newLoc;
		if ( closeSecondary )
			self.close();
	}
	else
	{
		location.href = newLoc;
	}
}

function ToggleShowHide( div, link )
{
	var e = $("#" + div);
	e.toggle();
	$("#" + link).html( (e.css( "display" ) == "none" ? "Show&nbsp;&raquo;" : "&laquo;&nbsp;Hide") );
	return false;
}

