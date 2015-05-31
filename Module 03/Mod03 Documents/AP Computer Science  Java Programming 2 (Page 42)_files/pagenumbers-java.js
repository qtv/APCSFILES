$(document).ready(
	function()
	{
		var epid = $("#currentepid").val(),
			subsetid = $("#currentsubset").val(),
			cid = $("#currentcid").val();

		$("button,input[type=button]").button();

		if ( epid != null && epid != "" )
		{
			Ajax( "coursepage", "pagenumbers", { epid : epid, cid : cid, subsetid: subsetid },
				function( xml )
				{
					var requirelogin = ($(xml).find( "reply" ).attr( "requirelogin" ) == "true");
					if ( requirelogin )
					{
						alertDialog( "Your login has expired. Please login now.",
							function() { location.href = "signin?sessionexpired=1"; } );
						return;
					}

					var pn = $(xml).find( "pagenumber" );
					if ( pn.length > 0 )
					{
						var n = pn.attr( "n" ),
							m = pn.attr( "m" );

						if ( n != "-1" )
						{
							$("#pagenumbercontrol").append(
								"Page <input type=\"text\" id=\"pagenumberinput\" size=\"3\" value=\"" + n + "\" /> of " + m +
								" <button id=\"gobutton\" style=\"padding:0.4em;\" title=\"Go to a new page\"></button>"  );

							$("#pagenumberinput").focus( function() { $("#gobutton").show().css( "visibility", "visible" ); } );

							$("#gobutton").button( { icons: { primary: "ui-icon-play" }, text: false} ).click(
								function()
								{
									Ajax( "coursepage", "pid", { pagenumber : $("#pagenumberinput").val(), cid : cid, subsetid: subsetid },
										function( xml )
										{
											var epid = $(xml).find( "reply" ).attr( "epid" );
											if ( typeof( epid ) != "undefined" )
												location.href = "?epid=" + epid;
											else
												$("#pagenumberinput").val( n );
										}
									);

									return false;
								}
							)
						}
					}
				}
			);
		}
	}
);
