// problem when there is a runtime error. It should be allowed to be submitted, but with minimal points.
// currently, it is not allowed to be submitted, and the system claims there is a comile error, which is false.

$(document).ready(
	function()
	{
		var javasubmitalldiv = $(".javasubmitalldiv");

		function captureCode( javacodediv )
		{
			var eid = parseInt( javacodediv.find( ".javacontroleid" ).val() ),
				data = { eid: eid, currentcid: $("#currentcid").val() };

			if ( typeof( jeCapture ) != undefined ) // copies code from code editors into corresponding textareas
				jeCapture();

			javacodediv.find( "input,textarea,select" ).each(
				function()
				{
					var t = $(this),
						name = t.attr( "name" );

					if ( name != undefined )
						data[ name ] = t.val();
				}
			);

			if ( javacodediv.find( "input[name=dontconvertspaces]" ).val() == "1" )
				data.dontconvertspaces = 1;

			return data;
		}

		function initCompileButtons()
		{
			$("input[name=compilecheck]").each(
				function()
				{
					var buttondiv = $(this).parents( ".javacodediv" ).find( ".javabtnsdiv" );
					//buttondiv.prepend( "<input type=\"button\" class=\"compilecheckbutton\" value=\"Compile\" />" );
					if ( buttondiv.find( ".compilecheckbutton" ).length == 0 )
					{
						buttondiv.prepend( "<button class=\"imacsbutton compilecheckbutton\">Compile</button>" );
						buttondiv.find( ".compilecheckbutton" ).button();
					}
					javasubmitalldiv.show();
				}
			);

			$(".compilecheckbutton").unbind().click(
				function()
				{
					var t = $(this),
						javacodediv = t.parents( ".javacodediv" );
						// color = t.css( "color" );

					t.button( "disable" );
					javacodediv.find( ".javacodeerror" ).remove();
					$(".editorlogreport").remove();

					var data = captureCode( javacodediv ),
						ajaxloader = ajaxLoader( t.parents( ".enclosing" ) );

					if ( !JavaRunButtonCheckBraces( javacodediv ) )
					{
						t.button( "enable" );
						return false;
					}

					ajaxloader.show();

					Ajax( "java", "compilecheck", data,
						function( xml )
						{
							var error = $(xml).find( "reply > error" ).text(),
								log = $(xml).find( "reply > log" ).text();

							t.parent().find( ".compiletestresult" ).remove();
							t.parent().append(
								"<div class=\"compiletestresult\">" +
									"<div class=\"h1\">Compile Result: " +
										(error == "" ? "<span style=\"color:green\">Success!</span>" : "<span style=\"color:crimson;\">Error:</span>") + "</div>" +
									(error == "" ? "" : "<div class=\"error\">" + error + "</div>") +
									(log == "" ? "" : "<div class=\"editorlogreport log\">Editor log: " + log.replace( /\\n/gi, "<br/>" ) + "</div>") +
								"</div>" );

							t.button( "enable" );
							ajaxloader.remove();
						},
						function()
						{
							alert( "We're sorry, there was a problem with the compile check, please try again." );
							t.button( "enable" );
							ajaxloader.remove();
						}
					);

					return false;
				}
			);
		}

		function collectAllGradable( checkbraces )
		{
			var bracesok = true,
				javacodedivs = $(".javacodediv"),
				eids = "";

			if ( typeof( jeCapture ) != undefined ) // copies code from code editors into corresponding textareas
				jeCapture();

			javacodedivs.each(
				function()
				{
					var t = $(this),
						eid = parseInt( t.find( ".javacontroleid" ).val() );

					if ( t.find( "input[name=gradeable]" ).val() == "1" )
					{
						eids += ( eids == "" ? "" : ",") + eid;

						if ( checkbraces && bracesok && !JavaRunButtonCheckBraces( t ) )
							bracesok = false;
					}
				}
			);

			var data = { eid: eids, currentcid: $("#currentcid").val() };
			javacodedivs.find( "input,textarea,select" ).each(
				function()
				{
					var t = $(this),
						name = t.attr( "name" );
					data[ name ] = t.val();
				}
			);

			return { data: data, bracesok: bracesok };
		}

		function releaseButtons()
		{
			$(".javasubmitalldiv > input").attr( "disabled", false );
			$(".javasubmitalldiv > input#freeresponsesubmit").css( { color: "#dc143c" } );
			$(".javasubmitalldiv > input#freeresponsesave").css( { color: "#000000" } );
		}

		function setupFreeResponseEvents()
		{
			$("#freeresponsesave").unbind().click(
				function()
				{
					var t = $(this);

					$(".editorlogreport").remove();

					$(".javasubmitalldiv > input").attr( "disabled", true );

					var d = collectAllGradable( false );

					$(".javasubmitalldiv > input").attr( "disabled", false ).css( { color: "#808080" } );

					Ajax( "java", "save", d.data,
						function()
						{
							releaseButtons();
							return true;
						}
					);
				}
			);

			$("#freeresponsesubmit").unbind().click(
				function()
				{
					$(".editorlogreport").remove();
					$(".javasubmitalldiv > input").attr( "disabled", false ).css( { color: "#808080" } );

					var d = collectAllGradable( true );

					if ( !d.bracesok ) // || !confirm( "Are you sure you are ready to submit these answers for grading?" ) )
					{
						releaseButtons();
						return false;
					}

					confirmDialog( "Are you sure you are ready to submit these answers for grading?",
						function()
						{
							javasubmitalldiv.hide();
							$("#page").parent().append( "<div class=\"javapleasewait\">Please wait while your work is graded ...</div>" );
							$(".javapleasewait").dialog(
								{
									resizable: false,
									modal: true,
									title: "Grading Your Answers",
									buttons:
									{
									}
								}
							);

							Ajax( "java", "submitmany", d.data,
								function( xml )
								{
									$(xml).find( "reply > result" ).each(
										function()
										{
											var t = $(this),
												eid = t.attr( "eid" ),
												element = t.find( "element" ).text(),
												enclosing = $("#javacodediv" + eid).parent();

											// replace the java code areas with the submitted forms. If there was an error preventing
											// submission, then this is indicated, and only those divs up to the error code are replaced
											// since the server does not return the rest.
											$("#enclosingmarker" + eid).remove();
											enclosing.before( "<span id=\"enclosingmarker" + eid + "\"></span>" );
											enclosing.remove();
											$("#enclosingmarker" + eid).after( element );
											$(".javapleasewait").dialog( "close" );
											initTinyMCEControls( enclosing );
										}
									);

									if ( $(xml).find( "reply" ).attr( "submitallowed" ) == "false" )
									{
										initCompileButtons();

										$(".javapleasewait").dialog( "destroy" );
										$(".javatryagain").remove();
										javasubmitalldiv.show();
										releaseButtons();

										delay(
											function()
											{
												$("#page").parent().append( "<div class=\"javatryagain\">One or more of your answers could not be submitted. " +
													"Check to see if any errors have been reported, and fix as necessary. Then check that your answers compile, and submit again.</div>" );
												$(".javatryagain").dialog(
													{
														resizable: false,
														modal: true,
														title: "Grading Your Answers",
														buttons:
														{
															"Ok": function() { $(this).dialog( "close" ); }
														}
													}
												);
											}
										);
									}

									return true;
								}
							);
						},
						function() { releaseButtons(); } );

					return false;
				}
			);
		}

		function setupButtons()
		{
			$("button.runbuttonsubmit").each(
				function()
				{
					var t = $(this),
						eid = t.parent().find( "input.theeid" ).val();

					t.button().click(
						function()
						{
							try
							{
								var id = "runbuttonsubmit" + eid;

								if ( typeof( jeCapture ) != "undefined" )
									jeCapture(); // tinymce java editor, does no harm if not present

								if ( !JavaRunButtonCheckBraces( $("#" + id).parents( ".javacodediv" ) ) )
									return false;

								SaveWindowPosition();

								confirmDialog( "Are you sure you are ready to submit this answer for grading?",
									function()
									{
										t.parent().append( "<input type=\"hidden\" name=\"runbuttonsubmit" + eid + "\" value=\"1\" />" );
										$("form")[ 0 ].submit();
									}
								);

								return false;
							}
							catch ( e )
							{
								alert( e ); // should never fire
							}

							return false;
						}
					);
				}
			);

			$("input.runbutton").each(
				function()
				{
					var t = $(this);

					t.after( "<button class=\"imacsbutton runbutton\">Run</button>" );

					var button = t.next();

					button.button().click(
						function()
						{
							var javacodediv = $(this).parents( ".javacodediv" ),
								data = captureCode( javacodediv );

							data[ "buttonname" ] = "runbutton";

							javacodediv.next( ".appletdiv" ).empty();

							delay( // to allow applet div to clear
								function()
								{
									var ajaxloader = ajaxLoader( javacodediv.parent() );

									ajaxloader.show();

									Ajax( "java", "run", data,
										function( xml )
										{
											javacodediv.find( ".editorloglink,.javacodeerror,.javacodeoutput,editorlogreport" ).remove();

											javacodediv.append(
												"<div class=\"javacodeoutput\" style=\"display:none;\"></div>" +
												"<div class=\"javacodeerror\" style=\"display:none;\"></div>" +
												"<div class=\"editorlogreport\" style=\"display:none;\"></div>" );

											var resultdiv = javacodediv.find( ".javacodeoutput" ),
												errordiv = javacodediv.find( ".javacodeerror" ),
												logdiv = javacodediv.find( ".editorlogreport" );

											$(xml).find( "reply > result" ).each( function() { resultdiv.show().append( $(this).text() ); } );
											$(xml).find( "reply > error" ).each( function() { errordiv.show().append( $(this).text() ); } );

											$(xml).find( "reply > log" ).each(
												function()
												{
													logdiv.html( "<div>" + $(this).text() + "</div>" );
													$('#elinks').prepend( "<a href=\"#\" class=\"editorloglink\" onclick=\"$('.editorlogreport').toggle();return false;\">Java log</a>" );
												}
											);

											$(xml).find( "reply > applet" ).each(
												function()
												{
													if ( !javacodediv.next().hasClass( "appletdiv" ) )
														javacodediv.after( "<div class=\"appletdiv\"></div>" );
													javacodediv.next().empty().html( $(this).text() );
												}
											);

											ajaxloader.remove();
										}
									);
								}
							);

							return false;
						}
					);
				}
			);

			$("input.runbutton").remove();
		}

		//if ( location.href.indexOf( "localhost" ) >= 0 || location.href.indexOf( "cdg.eimacs.com" ) >= 0 )
		setupButtons();
		initCompileButtons();
		setupFreeResponseEvents();
	}
);

function UpdateJavaEditControl( name )
{
	// an edit control in the program has changed, need to update the contents of the
	// program list if it exists

	var e = GetElement( "valuefor" + name );
	if ( e != null )
	{
		var editcontrol = GetElement( name ),
			t = editcontrol.value;

		switch ( editcontrol.tagName )
		{
			case "INPUT":
			case "SELECT":
				t = t.replace( / /gi, '&nbsp;' ).replace( />/gi, '&gt;' ).replace( /</gi, '&lt;' ).replace( /\n/gi, '<br />' ).replace( /\r/gi, '' );
				break;

			case "TEXTAREA":
				var indentspaces = GetElement( "indentstring" + name ).value;
				t = t.replace( /\r/gi, "" );
				t = indentspaces + t.replace( /\n/gi, "\n" + indentspaces );
				t = t.replace( / /gi, '&nbsp;' ).replace( />/gi, '&gt;' ).replace( /</gi, '&lt;' ).replace( /\n/gi, '\r\n<br />' );
				break;
		}

		$("#valuefor" + name).html( t );
	}
}

function JavaScroll()
{
	var e = GetElement( "windowpos" );
	if ( e )
	{
		$(document).ready( function()
			{
				var t = GetElement( "windowpos" ).value.split( ',' );
				window.scrollTo( parseInt( t[ 0 ] ), parseInt( t[ 1 ] ) );
			} );
	}
}

function TestCase( eid, idx, ctrlIDArr, ctrlValArr )
{
    var thisTestCase_jQ = $( '#testdata' + eid + '_' + idx );

    // hide any previous test case or error report
    var codeDiv_jQ = thisTestCase_jQ.parents( '.testdatadiv' ).siblings( '.javacodediv' );
    codeDiv_jQ.find( '.javacodeoutput' ).hide();
    codeDiv_jQ.find( '.javacodeerror' ).hide();

    var input_jQ, type, newVal;
    for ( var i = 0; i < ctrlIDArr.length; i++ )
    {
        var name = "javacontrol" + ctrlIDArr[ i ];

        input_jQ = $( "#" + name );

        if ( input_jQ.size() == 0 )
            // javawide controls are different
            input_jQ = $( "#shadow" + name );

        type = input_jQ.attr( 'type' );
        if ( type == null || type == '' )
          type = input_jQ[0].nodeName.toLowerCase();

        // On IE, before unescaping, change CRLF to CR
        if ( $.browser.msie )
          ctrlValArr[ i ] = ctrlValArr[ i ].replace( /%0a/gi, '' );

        newVal = unescape( ctrlValArr[ i ] );

        // If JavaEditor contents empty, leave seed contents alone
        // To clear, enter %%CLEAR%% as contents in JavaEditor
        if ( newVal != '' )
        {
            switch ( type )
            {
                case 'text':
                  input_jQ.val( (newVal == "%%CLEAR%%" ? "" : newVal) );
                  break;

                case 'select':
                case 'select-one':
                  input_jQ[0].value = newVal;
                  break;

                case 'textarea':
                {
                    //input_jQ.text( newVal == '%%CLEAR%%' ? '' : newVal );
					input_jQ.val( (newVal == "%%CLEAR%%" ? "" : newVal) );
					if ( typeof( jeUpdate ) != "undefined" && $(".jeshadow").length > 0 )
						jeUpdate( name );
                    else if ( typeof( jwUpdate ) != "undefined" )
                        jwUpdate( name );
                    break;
                }

                default:
                  break;
            }
        }
    }

    // highlight which test case we're working on
    thisTestCase_jQ.parents( '.testdatadiv' ).find( '.itemtestdata' ).removeClass( 'thistest' );
    thisTestCase_jQ.addClass( 'thistest' );

    return false;
}

function JavaRunButtonCheckBraces( javacodediv )
{
	var mismatchchar = "",
		problemarea = null;

	javacodediv.find( "textarea" ).each(
		function()
		{
			var val = $(this).val(),
				bracecount = 0,
				instring = false;

			for ( var i = 0 ; i < val.length ; i++ )
			{
				switch ( val[ i ] )
				{
					case "{":
						if ( !instring )
							bracecount++;
						break;

					case "}":
						if ( !instring )
							bracecount--;
						break;

					case "\"":
						instring = !instring;
						break;
				}
			}

			if ( bracecount != 0 )
			{
				problemarea = $(this);
				mismatchchar = (bracecount > 0 ? "{" : "}");
				return;
			}
		}
	);

	if ( mismatchchar != "" )
	{
		problemarea[ 0 ].focus();

		//alert( "Your program has one or more unmatched " +
		//	(mismatchchar == "{" ? "left" : "right") +
		//	" braces, \"" + mismatchchar + "\".\r\n\r\n" +
		//	"Please fix this problem before running the program." );

		alertDialog( "Your program has one or more unmatched " +
			(mismatchchar == "{" ? "left" : "right") +
			" braces, \"" + mismatchchar + "\".\r\n\r\n" +
			"Please fix this problem before compiling." );

		return false;
	}

	return true;
}
