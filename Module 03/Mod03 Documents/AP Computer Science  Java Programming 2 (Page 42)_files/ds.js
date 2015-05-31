var monthnames = [ "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" ],
	daynames = [ "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" ];

function Ajax( command, subcommand, data, success, failure, sync, datatype )
{
	if ( data == null )
		data = { };

	data.command = command;
	data.subcommand = subcommand;
	data.securitytoken = $("#securitytoken").val();
	data.lochref = location.href;

	var callbackurl = unescape( $("#callbackurl").val() );

	if ( !$.isFunction( success ) )
		success = function() { };

	if ( !$.isFunction( failure ) )
		failure =
			function( XMLHttpRequest, textStatus, errorThrown )
			{
				//alert( "Server failure (" + textStatus + "), please try again!" );
			};

	return $.ajax(
		{
			type: "POST",
			url: callbackurl,
			dataType: (typeof( datatype ) == "undefined" ? "xml" : datatype),
			async: (typeof( sync ) == "undefined" ? true : !sync),
			data: data,
			success: success,
			error: failure
		} );
}

function AjaxGetRows( xml )
{
	var rows = [],
		fieldnames = [],
		fieldtypes = [],
		fields = $(xml).find( "fields item" );

	fields.each(
		function()
		{
			var	name = $(this).attr( "name" ),
				type = $(this).attr( "type" );

			fieldnames.push( name );
			switch ( type )
			{
				case "Int32": case "Int16": case "Int64": case "Int8":
					fieldtypes.push( "Int" );
					break;

				default:
					fieldtypes.push( type );
					break;
			}
		}
	);

	$(xml).find( "r" ).each(
		function()
		{
			var o = { },
				row = $(this);

			for ( var i = 0 ; i < fieldnames.length ; i++ )
			{
				var fieldname = fieldnames[ i ],
					val = $(this).find( fieldname ).text();

				switch ( fieldtypes[ i ] )
				{
					default: // eg "String"
						o[ fieldname ] = val;
						break;

					case "DateTime":
						val = $.trim( val );
						o[ fieldname ] = (val == null || val == "" ? null : new Date( val ));
						break;

					case "Int":
						o[ fieldname ] = parseInt( val );
						break;

					case "Boolean":
						o[ fieldname ] = (val == "True");
						break;
				}
			}

			rows.push( o );
		}
	);

	return rows;
}

function JoinData( object1, object2 ) // modifies object1
{
	for ( var key in object2 )
		object1[ key ] = object2[ key ];

	return object1;
}

function SaveKey( object, key, val )
{
	if ( val != null && val != "" )
		object[ key ] = val;
}

function TextAreaResize( textarea )
{
	var val = textarea.val();

	var rows = 1;
	var b = val.match( /\n/g );
	if ( b != null && b.length > 1 )
		rows = b.length + 1;

	if ( rows < (val.length / 65) + 1 )
		rows = (val.length / 65) + 1;

	textarea.attr( "rows", rows );
}

function IsNull( a, b )
{
	return (a == null ? b : a);
}

function DateControl( name, val, withnulls, useids )
{
	// use a datepicker, don't use this anymore

	if ( typeof( withnulls ) != "boolean" )
		withnulls = false;

	if ( typeof( useids ) != "boolean" )
		useids = true;

	var d = new Date( val ),
		day = d.getDate(),
		month = d.getMonth(),
		year = d.getFullYear(),
		s = "",
		i;

	s += "<select style=\"margin-right:4px;\"" + (useids ? " id=\"day" + name + "\"" : "") + " name=\"day" + name + "\">" + (withnulls ? "<option />" : "" );
	for ( i = 1 ; i <= 31 ; i++ )
		s += "<option " + (val != null && day == i ? "selected=\"true\" ":"") + "value=\"" + i + "\">" + i + "</option>";
	s += "</select>";

	var m = monthnames;
	s += "<select style=\"margin-right:4px;\"" + (useids ? " id=\"month" + name + "\"" : "") + " name=\"month" + name + "\">" + (withnulls ? "<option />"  : "");
	for ( i = 0 ; i < 12 ; i++ )
		s += "<option " + (val != null && month == i ? "selected=\"true\" ":"") + "value=\"" + i + "\">" + m[ i ] + "</option>";
	s += "</select>";

	s += "<select " + (useids ? "id=\"year" + name + "\"" : "") + " name=\"year" + name + "\">" + (withnulls ? "<option />" : "");
	for ( var y = 1999 ; y < 2020 ; y++ )
		s += "<option value=\"" + y + "\"" + (year == y ? " selected=\"true\"" : "") + ">" + y + "</option>";
	s += "</select>";

	return s;
}

function DateControlRead( id )
{
	var eday = $("#day" + id).val(),
		emonth = $("#month" + id).val(),
		eyear = $("#year" + id).val();

	if ( eday == "" && emonth == "" && eyear == "" )
		return null;

	emonth = parseInt( emonth );

	if ( eday == "" )
		eday = 1;
	if ( isNaN( emonth ) )
		emonth = 0;
	if ( eyear == "" )
		eyear = (new Date()).getFullYear();

	return (emonth + 1) + "/" + eday + "/" + eyear;
}

function TimeControl( name, val )
{
	var d = new Date( val ),
		i;

	d.setSeconds( d.getSeconds() + 29 );

	var h = d.getHours(),
		m = d.getMinutes();

	var ampm = "am";

	if ( h >= 12 ) ampm = "pm";
	if ( h > 12 ) h-= 12;

	var s = "<select id=\"" + name + "h\" name=\"" + name + "h\">";
	for ( i = 0 ; i <= 12 ; i++ )
		s += "<option" + (h == i ? " selected=\"selected\"" : "") + ">" + i + "</option>";
	s+= "</select>" +
		"<select id=\"" + name + "m\" name=\"" + name + "m\">";
	for ( i = 0 ; i < 10 ; i += 5 )
		s += "<option" + (m == i ? " selected=\"selected\"" : "") + ">0" + i + "</option>";
	for ( i = 10 ; i < 59 ; i += 5 )
		s += "<option" + (m == i ? " selected=\"selected\"" : "") + ">" + i + "</option>";
	s += "</select>" +
		"<select id=\"" + name + "a\" name=\"" + name + "a\">" +
			"<option value=\"0\"" + (ampm == "am" ? " selected=\"selected\"" : "") + ">am</option>" +
			"<option value=\"1\"" + (ampm == "pm" ? " selected=\"selected\"" : "") + ">pm</option>" +
		"</select>";

	return s;
}

function timeControl( name, val, useids, withblank )
{
	var d = new Date( val ),
		i;

	d.setSeconds( d.getSeconds() + 29 );

	var h = d.getHours(),
		m = d.getMinutes(),
		ampm = "am";

	if ( h >= 12 ) ampm = "pm";
	if ( h > 12 ) h-= 12;

	var s = "<select class=\"timecontrol\" " + (useids ? "id=\"" + name + "h\" " : "") + "name=\"" + name + "h\">" +
				(withblank ? "<option/>" : "");
	for ( i = 0 ; i <= 12 ; i++ )
		s += "<option" + (h == i ? " selected=\"selected\"" : "") + ">" + i + "</option>";
	s+= "</select>" +
			"<select class=\"timecontrol\" " + (useids ? "id=\"" + name + "m\" " : "") + "name=\"" + name + "m\">" +
			(withblank ? "<option/>" : "");
	for ( i = 0 ; i < 10 ; i += 5 )
		s += "<option" + (m == i ? " selected=\"selected\"" : "") + ">0" + i + "</option>";
	for ( i = 10 ; i < 59 ; i += 5 )
		s += "<option" + (m == i ? " selected=\"selected\"" : "") + ">" + i + "</option>";
	s += "</select>" +
		"<select class=\"timecontrol\" " + (useids ? "id=\"" + name + "a\" " : "") + "name=\"" + name + "a\">" +
			"<option value=\"0\"" + (ampm == "am" ? " selected=\"true\"" : "") + ">am</option>" +
			"<option value=\"1\"" + (ampm == "pm" ? " selected=\"true\"" : "") + ">pm</option>" +
		"</select>";

	return s;
}

function TimeControl( name, val )
{
	// old version used id's
	return timeControl( name, val, true, false );
}

function timeControlRead( parent, name )
{
	if ( parent == null )
		parent = $( "body" );

	var h = parseInt( parent.find( "select[name=" + name + "h]" ).val() ),
		m = parseInt( parent.find( "select[name=" + name + "m]" ).val() ),
		a = parseInt( parent.find( "select[name=" + name + "a]" ).val() ),
		d = new Date();

	if ( isNaN( h ) ) h = 0;
	if ( isNaN( m ) ) m = 0;

	if ( h == 12 )
	    h = 0;

	d.setHours( a > 0 ? h + 12 : h );
	d.setMinutes( m );

	return d;
}

function TimeControlRead( name )
{
	// old version used id's
	return timeControlRead( $("#" + name + "h").parent(), name );
}

function ValidEmail( email )
{
    if ( email == null || $.trim( email ) == "" )
        return false;

	email = email.toLowerCase();

    var at = email.indexOf( "@" ),
		i;

    // must contain @ sign internally, and only one of them
    if ( at <= 0 || at >= (email.length - 1) || email.indexOf( "@", at + 1 ) > - 1 )
		return false;

	var domain = email.substr( at + 1 );

    // @ must be followed at some point by a period, but not right away
    if ( domain.substr( 1 ).indexOf( "." ) < 0 )
        return false;

	var invalidChars = "\/\"'\\ ;:?!()[]\{\}^|";

	for ( i = 0; i < invalidChars.length ; i++)
		if ( email.indexOf( invalidChars.charAt( i ), 0 ) > -1)
			return false;

	for ( i = 0; i < email.length ; i++ )
		if ( email.charCodeAt( i ) > 127 )
			return false;

	if ( email.indexOf( "@." ) > -1 || email.indexOf( ".@" ) > -1 || email.indexOf( ".." ) > -1 )
		return false;

	var suffix = email.substring( email.lastIndexOf( "." ) + 1 ),
		found = false;

	if ( suffix.length > 2 )
	{
		var allowed = [ "com", "net", "org", "edu", "int", "mil", "gov", "arpa", "biz", "aero", "name", "coop", "info", "pro", "museum" ];

		for ( i = 0 ; i < allowed.length ; i++ )
			found |= (suffix == allowed[ i ]);

		if ( !found )
			return false;
	}

    return true;
}

function delay( f )
{
    setTimeout( f, 0 );
}

function isValidDate( d )
{
    if ( d == null || Object.prototype.toString.call( d ) != "[object Date]" )
        return false;

    return !isNaN(d.getTime());
}

function toDateString( d )
{
	if ( !isValidDate( d ) )
		return "";

	return (d.getMonth() + 1) + "/" + d.getDate() + "/" + d.getFullYear();
}

function toDateTimeString( d ) // for ajax posts
{
	if ( !isValidDate( d ) )
		return "";

	return (d.getMonth() + 1) + "/" + d.getDate() + "/" + d.getFullYear() + " " + d.getHours() + ":" + d.getMinutes();
}

function alertDialog( message, after, title )
{
	$( "#alert" ).remove();
	$( "body" ).append( "<div id=\"alert\">" + message + "</div>" );
	$( "#alert" ).dialog(
		{
			buttons:
			{
				"Ok":
					function()
					{
						$(this).dialog( "close" );
					}
			},
			modal: true,
			dialogClass: "alertdialog",
			title: (title == undefined ? "Alert!" : title),
			close:
				function()
				{
					$(this).remove();
					if ( after != undefined )
						after();
				}
		}
	);
}

function confirmDialog( message, success, failure )
{
	$( "#alert" ).remove();
	$( "body" ).append( "<div id=\"alert\">" + message + "</div>" );
	$( "#alert" ).dialog(
		{
			buttons:
			{
				"Yes": function() { $(this).dialog( "close" ); if ( success != undefined ) success(); },
				"No": function() { $(this).dialog( "close" ); if ( failure != undefined ) failure(); }
			},
			modal: true,
			dialogClass: "confirmdialog",
			title: "Please Confirm!",
			close: function() { $(this).remove(); }
		}
	);
}

/**
sortTBody( {
    tbody: resultsdiv.find( "tbody" ), // parent of table rows to sort
    orderedIndexes: [ 0 , 2 ] , // e.g. first sort by column 0, and then by column 2.
                                // it looks at each column separately to see if it should sort numerically or alphabetically.
                                // default is [ 0 ]
    rowsToFuse: 2 // by default, this is 1. In this example, there is always a
				  // second row of data that must stay with the previous row
    compare: function( a , b ) { if ( a == "Ted" ) return -1; if ( b == "Ted" ) return 1; return ( a < b ? -1 : a > b : 1 : 0 ) }
		// by default, the compare function does alphabetically or numerical depending upon the inputs.
		// this compare function puts Ted on top (i.e. makes Ted the smallest possible value) and then proceeds alphabetically.
} );
*/
function sortTBody( options )
{
	options = $.extend( {
					tbody: $( "tbody" ) ,
					orderedIndexes: [0] ,
					rowsToFuse: 1 ,
					compare: function compare( a, b ) {;
						if ( isNaN( a ) )
						{
							a = a.toLowerCase();
							b = b.toLowerCase();
						}
						else
						{
							a = parseFloat( a );
							b = parseFloat( b );
						}
						return a < b ? -1 : a > b ? 1 : 0;
					}
				} , options );

	function getComparer()
	{


		return function( a , b )
		{
			for ( var i in options.orderedIndexes )
			{
				var temp = options.compare( $( a[0] ).find( "td:eq(" + options.orderedIndexes[ i ] + ")" ).html() ,
									$( b[0] ).find( "td:eq(" + options.orderedIndexes[ i ] + ")" ).html() );
				if ( temp != 0 )
					return temp;
			}
			return 0;
		}
	}

	var temp = options.tbody.find( "tr" ).get(),
	    rows = [];

	for ( var i = 0; i < temp.length ; i += options.rowsToFuse )
	{
		var toPush = [];
		for ( var j = 0; j < options.rowsToFuse ; j++ )
			toPush.push( temp[ i + j ] )
		rows.push( toPush )
	}
	$( rows.sort( getComparer( options.orderedIndexes ) ) )
	 .each( function() {
		 for ( var k = 0 ; k < $( this ).length ; k++ )
			options.tbody.append( $( $( this )[ k ] ) );
		} );
}


// IE has a native xml getter for an XML Node that returns the node in
// stringified form. Firefox, Chrome, & Opera have an XMLSerializer object
// that enables the same operation. This ensures that all 4 browsers can
// use an xml getter for XML-to-String conversion.
if ( typeof XMLSerializer != "undefined" && Node.prototype.__defineGetter__ )
{
     Node.prototype.__defineGetter__( "xml",
          function()
          {
                var xs = new XMLSerializer();
                return xs.serializeToString( this );
          } );
}

function ajaxLoader( parent, small )
{
	var pos = parent.position(),
		ajaxloader;

	if ( pos == undefined )
		pos = parent.parent().position();

	$("#ajaxloader").remove();
	$("body").append(
		"<div id=\"ajaxloader\"" + (small ? " class=\"small\"" : "") + ">" +
			"<div class=\"inner\"></div>" +
		"</div>" );
	ajaxloader = $("#ajaxloader");
	parent.after( ajaxloader );
	if ( pos != undefined )
		ajaxloader.css( { top: pos.top, left: pos.left, width: parent.width(), height: parent.height() } );

	return ajaxloader;
}
