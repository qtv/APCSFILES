// referenced
//	skins/2/templates/js-libraries.htm
//	/filedata/commonscripts/common-java.htm

var browser = {}; // copy of $.browser, see checkEMFBrowser()

$(document).ready(
	function()
	{
		function setupClicks()
		{
			$("a.more", "#navbar").addClass( "closed" );
			$( "a.more", "#navbar" ).click(
				function ()
				{
					// opens/closes the sub menus
					if ( $(this).attr( "class" ).indexOf( "closed" ) > -1 )
					{
						$(this).removeClass( "closed" );
						$(this).addClass( "open" );

						if ( $.browser.msie )
							$(this).next().show( 500 );
						else
							$(this).next().slideToggle( 500 );
					}
					else if ( $(this).attr( "class" ).indexOf( "open" ) > -1 )
					{
						$(this).removeClass( "open" );
						$(this).addClass( "closed" );
						$(this).next().slideToggle( 500 );
					}

					return false;
				}
			);
		}

		function setupNavmenu()
		{
			var menuLi = $( '#navmenu' ).parent();

			if ( menuLi.size() == 0 )
				return;

			var mPos = menuLi.offset(),
				lt = mPos.left,
				tp = mPos.top,
				wd = menuLi.width(),
				ht = menuLi.height();

			$("#navbar").css( { left: ( lt + wd - 151 ) + "px", top: ( tp + ht + 1 ) + "px" } );
			//$("a.more", "#navbar").addClass( "closed" );

			// IE hacks to overcome no hover style for a-tags with IDs
			$( "#navmenu" ).hover( function () { $(this).css( "color", "#abfc08" ); }, function () { $(this).css( "color", "#fff" ); } );
			$( "a.more", "#navbar" ).hover( function () { $(this).css( "backgroundColor", "#fff" ); }, function () { $(this).css( "backgroundColor", "#a3b8db" ); } );
			// end of IE hacks

			$( "#navmenu" ).click(
				function ()
				{
					// this opens or closes the Options menu
					var closed = ($( "#navbar:visible" ).size() == 0);  // $( "#arrow" ).css( "background" ).indexOf( "expand" ) > -1;

					// $( "#navbar" ).slideToggle( "slow" );

					if ( closed )
					{
						if ( $.browser.mozilla )
							$( "#navbar" ).fadeIn( "slow" );
						else
							$( "#navbar" ).slideDown( "slow" );
					}
					else
					{
						if ( $.browser.mozilla )
							$( "#navbar" ).fadeOut( "slow" );
						else
							$( "#navbar" ).slideUp( "slow" );
					}

					if ( !closed )
					{
						$( "#navbar ul ul" ).hide();
						$( "a.more", "#navbar" ).removeClass( "open" );
						$( "a.more", "#navbar" ).addClass( "closed" );
					}

					$( "#arrow" ).css( "background", "transparent url(/scripts/css/images/"
										+ ( closed ? "collapse" : "expand-btn" )
										+ ".gif) no-repeat 0.2em 50%" );
					return false;
				}
			);

			setupClicks();
		}

		function setupHovermenu()
		{
			$("#navmenu").mouseover(
				function()
				{
					$("#navbar").show();
				}
			);

			$("#navbar").hover( function() {}, function() { $(this).hide(); } );

			setupClicks();
		}

		checkEMFBrowser();

		if ( $("#navmenu").hasClass( "hovermenu" ) )
			setTimeout( setupHovermenu, 0 );
		else
			setTimeout( setupNavmenu, 0 );

		setTimeout( setupQtip, 0 );
	}
);

function makeFootnote( t )
{
	var text = t.attr( "title" );

	if ( text === undefined )
	{
		var classes = t.attr( "class" ).split( " " ),
			thecontentclass;

		for ( var i = 0 ; i < classes.length ; i++ )
			if ( classes[ i ].indexOf( "content" ) == 0 )
				thecontentclass = classes[ i ];

		text = $("." + thecontentclass).not( t );
	}
	else
	{
		var thebar = text.indexOf( "|" );
		if ( thebar >= 0 )
			text = text.substring( thebar + 1 );
	}

	t.qtip(
		{
			position: { my: 'bottom center', at: "top center" },
			content: { text: text }
		}
	);
}

function qtip( jq, title )
{
	jq.each(
		function()
		{
			if ( title )
				$(this).attr( "title", title );
			$(this).qtip( { position: { my: "bottom center", at: "top center" } } );
		}
	);
}

function qtipShow( jq, title )
{
	if ( !title )
		title = jq.attr( "title" );

	jq.qtip(
		{
			position: { my: 'bottom center', at: 'top center' },
			content:
				{
					text: title
				}
		} ).qtip( "toggle", true );
}

function qtipHide( jq )
{
	jq.qtip( "toggle", false );
}

function qtipRemove( jq )
{
	jq.qtip( "destroy" );
}

function setupQtip( jq )
{
	(jq ? jq.find( "[title]:not('.notip')" ) : $("[title]:not('.notip')")).qtip( { position: { my: "bottom center", at: "top center" } } );
}

function checkEMFBrowser()
{
	function jQueryuaMatch( ua )
	{
		ua = ua.toLowerCase();

		var match = /(chrome)[ \/]([\w.]+)/.exec( ua ) ||
			/(webkit)[ \/]([\w.]+)/.exec( ua ) ||
			/(opera)(?:.*version|)[ \/]([\w.]+)/.exec( ua ) ||
			/(msie) ([\w.]+)/.exec( ua ) ||
			ua.indexOf("compatible") < 0 && /(mozilla)(?:.*? rv:([\w.]+)|)/.exec( ua ) ||
			[];

		return { browser: match[ 1 ] || "", version: match[ 2 ] || "0" };
	}

	var agent = navigator.userAgent,
		matched = jQueryuaMatch( agent ),
		browser = {},
		majorversion,
		status = -1;

	if ( matched.browser )
	{
		browser[ matched.browser ] = true;
		browser.version = matched.version;
		browser.mobile=/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(a)||/1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test( (navigator.userAgent||navigator.vendor||window.opera).substr(0,4));
	}

	// Chrome is Webkit, but Webkit is also Safari.
	if ( browser.chrome )
	{
		browser.webkit = true;
	}
	else if ( browser.webkit )
	{
		var a = /Version\/([\d\.]+)/.exec( agent );

		browser.safari = true;
		browser.version = a[ 1 ];
	}

	majorversion = parseInt( browser.version.substring( 0, browser.version.indexOf( "." ) ) );

	//$.browser.chrome = /chrome/.test( navigator.userAgent.toLowerCase() );
	//$.browser.safari = /safari/.test( navigator.userAgent.toLowerCase() );
	$.browser = browser;
	$.browser.svgchrome = browser.webkit;

	if ( browser.mobile )
		status = 3; // return 3;
	else if ( browser.safari )
		status = (majorversion >= 5 ? 1 : 0);
	else if ( browser.chrome )
		status = (majorversion >= 21 ? 1 : 0);
	else if ( browser.mozilla )
		status = (majorversion >= 14 ? 1 : 0);
	else if ( browser.opera )
		status = (majorversion >= 12 ? 1 : 0);
	else if ( browser.msie )
		status = 2;

	return status; // -1 unknown, 0 - ok, but not up-to-date, 1 - ok, 2 - IE, 3 - mobile
}
