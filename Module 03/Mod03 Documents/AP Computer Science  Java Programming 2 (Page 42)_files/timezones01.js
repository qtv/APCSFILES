var tz =
{
	process:
		function ()
		{
			function standardTime( d, withseconds, withampmspace )
			{
				var hours = d.getHours(),
					ampm = "am",
					min = "" + d.getMinutes();

				if ( hours >= 12 )
				{
					ampm = "pm";
					if ( hours > 12 )
						hours -= 12;
				}
				else if ( hours == 0 )
				{
					hours += 12;
				}

				if ( min.length == 1 )
					min = "0" + min;

				function padZero( n )
				{
					if (n < 10)
						return "0" + n.toString();
					else
						return n.toString();
				}

				return hours + ":" + min + (withseconds ? ":" + padZero( d.getSeconds() ) : "") + (withampmspace ? " " : "") + ampm;
			}

			function isValidDate( d )
			{
				return d != null && Object.prototype.toString.call( d ) == "[object Date]" && !isNaN( d.getTime() );
			}

			function standardDateString( d )
			{
				return (isValidDate( d ) ? (d.getMonth() + 1) + "/" + d.getDate() + "/" + d.getFullYear() : "");
			}

			function standardDateTimeString( d, withseconds, withampmspace )
			{
				return (!isValidDate( d ) ? "" : d.toLocaleDateString() + " " + standardTime( d, withseconds, withampmspace ));
			}

			function standardShortDateTimeString( d, withseconds, withampmspace )
			{
				return (!isValidDate( d ) ? "" : (d.getMonth() + 1) + "/" + d.getDate() + "/" + d.getFullYear() + " " + standardTime( d, withseconds, withampmspace ));
			}

			$(".tzc:not(.tzdone)").each(
				function()
				{
					var t = $(this),
						text = t.text(),
						d = new Date( text );

					function datepicker()
					{
						var name = t.attr( "title" ),
							withtime = t.hasClass( "dtp" ),
							isLocal = t.hasClass( "local" ),
							when = (withtime ? standardShortDateTimeString( d, false, true ) : standardDateString( d ));

						t.attr( "title", null );

						t.empty().append(
							"<input type=\"hidden\" name=\"" + name + "\" value=\"\" />" + // will be filled in momentarily by change method
							"<input type=\"text\" style=\"text-align:center;\" size=\"" + (withtime ? 20 : 8) + "\" class=\"datepicker\" value=\"" + when + "\" />"
						);

						var y = t.find( "input.datepicker" );
						if ( withtime )
							y.datetimepicker( {ampm: true} );
						else
							y.datepicker();

						y.change(
							function()
							{
								var t = $(this),
									d = new Date( t.val() ),
									prev = t.prev();

								prev.val( "" );
								if ( isValidDate( d ) )
								{
									if ( !withtime )
										d.setUTCHours( 12 );

									prev.val( d.toUTCString() );
								}

								function convert ( dts )
								{ // only used for local conversion of the stubborn name field since name field is in weird format
									var out = "";
									out = out + dts.substring(0,3); // day of week
									out = out + ", ";
									out = out + dts.substring(8,10); // day num
									out = out + " ";
									out = out + dts.substring(4,7); // monthname
									out = out + " ";
									out = out + dts.substring(11,15); // year
									out = out + " ";
									out = out + dts.substring(16,24); // time, no GMT postfix
									return out;
								}

								if ( isLocal ) {
									var ld = new Date( t.parent().find( "input[name=" + name + "]" ).val() ),
									    ls = ld.toString(),
									    ns = ls.substring(0, ls.indexOf( "GMT" )),
									    nd = new Date( ns );
									t.parent().find( "input[name=" + name + "]" ).val( convert( nd.toString() ) );
								}

								return true;
							}
						)

						.change();
					}

					function locale()
					{
						var zone = ((new Date()).getTimezoneOffset() / 60);

						t.css( {display: "block", textAlign: "center", fontSize: "11px", color: "#909090", margin: "1em 0"} );
						t.html( "All times are GMT" + (zone > 0 ? "&ndash;" + zone : "+" + Math.abs( zone ) ) );
					}

					if ( t.hasClass( "dp" ) || t.hasClass( "dtp" ) )
					{
						datepicker();
					}
					else
					{
						if ( t.hasClass( "tzdo" ) )
							t.text( standardDateString( d ) );
						else if ( t.hasClass( "tzto" ) )
							t.text( standardTime( d, t.hasClass( "tzws" ), false ) );
						else if ( t.hasClass( "sd" ) )
							t.text( standardShortDateTimeString( d, t.hasClass( "tzws" ), false ) );
						else if ( t.hasClass( "locale" ) )
							locale();
						else
							t.text( standardDateTimeString( d, t.hasClass( "tzws" ), false ) );

						if ( t.hasClass( "tzt" ) )
							t.attr( "title", d.toLocaleString() );
					}

					t.addClass( "tzdone" );
				}
			);
		}
};

$(document).ready(
	function()
	{
		tz.process();
	}
);

