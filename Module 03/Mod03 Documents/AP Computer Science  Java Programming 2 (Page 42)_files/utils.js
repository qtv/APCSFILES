function Trim( d )
{
	if ( typeof( d ) != 'string' )
		return d;

	return d.replace( /^\s*|\s*$/g, '' );
}

function IsNull( a, b ) { return ( typeof( a ) == 'undefined' || a == null ? b : a ); }

function IsNaN( a, b ) { return ( typeof( a ) == 'undefined' || isNaN( a ) || a == null ? b : a ); }

function Package( fields, data, elementid, escaped )
{
	this.data = data; 
	this.fields = fields; 
	this.length = ( data == null ? 0 : (data.length / fields.length) );
	
	function KeyItem( fields, data, index )
	{
		this.Value = function( name )
			{
				name = name.toLowerCase();
				for ( var i = 0 ; i < fields.length ; i++ )
					if ( fields[ i ] == name )
						return data[ index + i ];
							
				return null;
			};
		
		this.SetValue = function( name, value )
			{
				name = name.toLowerCase();
				for ( var i = 0 ; i < fields.length ; i++ )
					if ( fields[ i ] == name )
						data[ index + i ] = value;
			};
	}
	
	this.Item = function( index )
		{
			return new KeyItem( this.fields, this.data, index * this.fields.length );
		};
		
	this.Write = function() { return SafeJoin( [ SafeJoin( this.fields ), SafeJoin( this.data ) ] ); };
	
	this.Read = function( elementid, escaped ) 
		{ 
			var e = GetElement( elementid );
	
			// if ( !e ) { alert( elementid ); }  // DEBUG
			
			var r = null;
			if ( e.tagName.toLowerCase() == 'input' )
				r = e.value;
			else
				r = e.innerHTML;
			
			if ( escaped )
				r = unescape( r );
			this.ReadBlock( r );
		};
	
	this.ReadBlock = function( r )
		{
			r = SafeSplit( r );
			this.fields = SafeSplit( r[ 0 ] );
			this.data = SafeSplit( r[ 1 ] );
			this.length = this.data.length / this.fields.length;
		};
		
	this.SetValue = function( index, name, value )
		{
			name = name.toLowerCase();
			for ( var i = 0 ; i < this.fields.length ; i++ )
				if ( this.fields[ i ] == name )
					break;
					
			this.data[ (index * this.fields.length) + i ] = value;
		};

	this.CopyItem = function( from, to )
		{
			from *= this.fields.length;
			to *= this.fields.length;
			for ( var i = 0 ; i < this.fields.length ; i++ )
				this.data[ to++ ] = this.data[ from++ ];
		};
	
	this.InsertAt = function( index )
		{
			if ( index == null )
				index = this.length;
				
			var i = index * this.fields.length;
			this.data = this.data.slice( 0, i ).concat( this.fields ).concat( this.data.slice( i ) );
			this.length += 1;
			
			return this.Item( index );
		};
	
	if ( elementid )
		this.Read( elementid, escaped );
}

function StringStream()
{
	this.s = '';
	this.Write = function( t ) { this.s += t; };
	this.String = function() { return this.s; };
	this.Close = function()	{};
}

function SafeJoin( a )
{
	if ( a == null || a.length == 0 )
		return '';

	var jn = 0;
	var joiners = ',. ;:|/&%$#@!~*()<>[]{}abcdefg01234';
	var joiner = joiners.charAt( jn );
	var b = new Array();
	for ( var i = 0 ; i < a.length ; i++ )
	{
		if ( a[ i ] == null )
			b[ i ] = '';
		else if ( typeof( a[ i ] ) == 'boolean' )
			b[ i ] = (a[ i ] ? '1' : '0')
		else if ( typeof( a[ i ] ) != 'string' )
			b[ i ] = String( a[ i ] );
		else
			b[ i ] = a[ i ];
				
		if ( b[ i ].indexOf( joiner ) > -1 )
		{
			joiner = joiners.charAt( ++jn );
			for ( var j = 0 ; j <= i ; j++ )
				if ( b[ j ].indexOf( joiner ) > -1 )
					joiner = joiners.charAt( ++jn ), j = -1;
		}
	}
	
	return joiner + b.join( joiner );
}

function SafeSplit( a )
{
	if ( typeof( a ) != 'string' || a.length < 2 )
		return new Array();
		
	return a.substring( 1 ).split( a.charAt( 0 ) );
}

function EncodeN( d )
{
	var k = 153;

	var t = 0;
	while ( t == 0 )
		t = Math.round( Math.random() * 49 );
	var r = String(t ^ k);
	while ( r.length < 3 )
		r =  '0' + r;

	return r + (t * d);
}
	
function DecimalPlaces( m, n )
{
	if ( n == 2 )
		return Math.round( (m + 0.000005) * 100 ) / 100;
	else
		return Math.round( (m + 0.000005) * 10 ) / 10;
}

function Money( a, prefix, negparen )
{	// format with two decimal places
	if ( typeof( a ) != 'number' || isNaN( a ) )
		return '';

	var neg = false;
	
	if ( typeof( prefix ) == 'undefined' )
		prefix = '$';

	if ( a < 0 )
	{
		a = -a, neg = true;
		if ( typeof( negparen ) != 'boolean' )
			negparen = true;
	}

	a = (a + 0.000005).toString();
	
	var whole = a;
	var dec = '00';
	if ( a.indexOf( '.' ) >= 0 )
	{
		// already contains a decimal point
		a.match( /(\d*)\.(\d*)/ );
		whole = RegExp.$1;
		dec = RegExp.$2;
		if ( dec.length > 2 )
			dec = dec.substring( 0, 2 );
		while ( dec.length < 2 )
			dec += '0';
	}

	whole = NumberCommas( whole );
		
	if ( !neg )
		return prefix + whole + '.' + dec;

	if ( negparen )
		return '(' + prefix + whole + '.' + dec + ')';
		
	return prefix + '-' + whole + '.' + dec;
}

function NumberCommas( whole )
{	// insert thousand-separating commas
	whole = whole.toString();
	
	var leadIdx = whole.length % 3;
	if ( leadIdx == 0 ) { leadIdx = 3; }
	if ( whole.length > 3 )
		whole = whole.substring( 0, leadIdx ) + ',' + NumberCommas( whole.substring( leadIdx ) );
	
	return whole;
}

/* DOM replacement for InputTable, if needed
function DOMInputTable( parent, inputs, withsubmit )
{	// prompt, name, type, value, size, or name is a function that 
	// takes a single id argument and returns a control
	var table = document.createElement( 'table' );
	table.border = '0';
	table.cellSpacing = '2';
	table.cellPadding = '0';
	var tbody = document.createElement( 'tbody' );
	var row, cell, label, inpt;
	for ( var i = 0; i < inputs.length; i++ )
	{
		row = document.createElement( 'tr' );
		cell = document.createElement( 'td' );
		cell.style.textAlign = 'right';
		cell.style.whiteSpace = 'nowrap';
		label = document.createTextNode( inputs[ i ][ 0 ] + ':' );
		cell.appendChild( label );
		row.appendChild( cell );
		cell = document.createElement( 'td' );
		var id = IsNull( inputs[ i ][ 1 ], inputs[ i ][ 0 ] );
		if ( typeof( inputs[ i ][ 2 ] ) == 'string' )
		{
			inpt = document.createElement( 'input' );
			inpt.type = inputs[ i ][ 2 ];
			inpt.name = id;
			inpt.id = id;
			inpt.value = IsNull( inputs[ i ][ 3 ], '' );
			if ( inputs[ i ][ 4 ] != null )
				inpt.size = inputs[ i ][ 4 ];
			inpt.className = 'tx';
			cell.appendChild( inpt );
		}
		else
		{
			cell.appendChild( inputs[ i ][ 2 ]( id ) );
		}
		row.appendChild( cell );
		tbody.appendChild( row );
	}
	if ( withsubmit )
	{
		row = document.createElement( 'tr' );
		cell = document.createElement( 'td' );
		row.appendChild( cell );
		cell = document.createElement( 'td' );
		inpt = document.createElement( 'input' );
		inpt.type = 'submit';
		inpt.name = 'submit1';
		inpt.value = 'Submit';
		inpt.className = 'iv';
		cell.appendChild( inpt );
		row.appendChild( cell );
		tbody.appendChild( row );
	}
	table.appendChild( tbody );
	parent.appendChild( table );
}
*/
