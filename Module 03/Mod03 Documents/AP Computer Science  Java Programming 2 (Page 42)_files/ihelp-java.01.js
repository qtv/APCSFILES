// references in
//		skins/2/templates/js-libraries.htm
//		commonscripts/common-java-cdg.htm
//		commonscripts/common-java.htm
//
// // to do
// available=false then kill waiting for answer timer
// experts only get questions from students in their classes


var lastanswerihid,
	lastquestionihid,
	ihtimer,
	ihtimeidlebutvisible,
	ihtimewaitingforanswer,
	ihtimenotavailable,
	ihtimeexpertupdate,
	helptypevalues;

$(document).ready(
	function()
	{
		helptypevalues = $("#ihelpavailable").val();

		if ( helptypevalues == "" || helptypevalues == null )
			return;

		helptypevalues = helptypevalues.split( "," );

		if ( helptypevalues[ 0 ] != "1" )
			return; // iHelp not activated

		ihtimeidlebutvisible = parseInt( helptypevalues[ 3 ] );
		ihtimewaitingforanswer = parseInt( helptypevalues[ 4 ] );
		ihtimenotavailable = parseInt( helptypevalues[ 5 ] );
		ihtimeexpertupdate = parseInt( helptypevalues[ 6 ] );
		lastquestionihid = 0;
		lastanswerihid = 0;
		lastihid = 0;
		ihtimer = null;

		if ( helptypevalues[ 1 ] == "2" )
		{
			$("#ihelpimage").click( function() { StartExpert(); } );
			setTimeout( function() { StartExpert(); }, 0 );
		}
		else
		{
			$("#ihelpimage").click( function() { IHelp(); } );

			if ( helptypevalues[ 1 ] == "1" )
			{
				// iHelp is currently available
				$("#ihelpimage").show();
				if ( helptypevalues[ 2 ] == "1" || $("#displaywindowlink").val() == "false" ) // actively waiting for an answer on in a window
					IHelp();
			}
			else
			{
				// no help currently available
				ihtimer = setTimeout( function() { CheckStart(); }, ihtimenotavailable ); // no one available currently
			}
		}
	}
);

/******* Student ********************/
function IHelp()
{
	$("#ihelpimage").hide();

	$("#ihelpdiv-java").remove();

	$("#page").prepend(
		"<div id='ihelpdiv-java' class='ui-widget ui-corner-all ui-widget-content content'>" +
			"<div class='ihelptitle'>" +
				($("#displaywindowlink").val() == "false" ? "" : "<span class='ihelpclosespan'><a href='#' id='ihelpprevious'>Previous messages</a> " +
																	"<a href='#' id='ihelpclose'><img src='/eimacsstatics/shared/images/closebutton.gif' /></a></span>") +
																	"<img src='/eimacsstatics/shared/images/ihelp.gif' />" +
			"</div>" +
		"<div id='ihelphistory'></div>" +
		"<div id='ihelpquestion'>" +
			"Type your question in the box below, and press <em>Go</em>!" +
			"<table id='ihelptable' border='0' cellspacing='0' cellpadding='0'>" +
				"<tr><td><textarea id='ihelptext' rows='2'></textarea></td>" +
				"<td class='gobuttoncell'><button id='ihelpgo' value='Go'>Go</button></td></tr>" +
			"</table>" +
		"</div>" +
		($("#displaywindowlink").val() == "false" ?
			"" :
			"<div class='links'>" +
				"<a href='#' id='window'>Window</a> " +
			"</div>") +
		"</div>" );

	SetiHelpDraggable();

	$("#window").click(
		function()
		{
			window.open( "ihelp", "ihelp", "width=600,height=400,menubar=no,location=no,resizable=yes,scrollbars=yes,status=no" );
			$("#ihelpdiv-java").remove();
			return false;
		}
	);

	$("#ihelpprevious").click(
		function()
		{
			Ajax( "ihelp", "previous", { epid : $("#currentepid").val(), cid : $("#currentcid").val(), location: location.href },
				function( xml )
				{
					if ( $(xml).find( "reply" ).attr( "available" ) == "true" )
					{
						var reply = $(xml).find( "reply" ),
							answers = reply.find( "answer" );

						$("#ihelphistory").empty();
						$("#ihelpprevious").hide();

						answers.each(
							function()
							{
								var answer = $(this),
									text = answer.text(),
									ihid = answer.attr( "ihid" );
									uid = parseInt( answer.attr( "uid" ) ),
									touid = parseInt( answer.attr( "touid" ) ),
									date = answer.attr( "date" );

								$("#ihelphistory").append( "<div class='" + (touid == 0 ? "question" : "answer") + "'>" + IHelpEscape( text ) + "</div>" );

								lastanswerihid = Math.max( ihid, lastanswerihid );
							}
						);
					}
					else
					{
						IHClearTimer();
						$("#ihelpdiv-java").remove();
					}
				}
			);
		}
	);

	$("#ihelpclose")
		.click(
			function()
			{
				//$("#ihelpdiv-java").slideUp();
				$("#ihelpdiv-java").hide();
				$("#ihelpimage").show();
				return false;
			}
		)
		.hover(
			function()
			{
				$(this).find( "img" ).get( 0 ).src = "/eimacsstatics/shared/images/closebuttonhover.gif";
			},
			function()
			{
				$(this).find( "img" ).get( 0 ).src = "/eimacsstatics/shared/images/closebutton.gif";
			}
		);

	$("#ihelpgo").button().click(
		function()
		{
			var question = $.trim( $("#ihelptext").val() );
			if ( question == "" )
				return false;

			if ( question.length > 1000 )
			{
				alert( "Your question is too long (it is " + question.length + " characters, but the maximum allowed is 1000.) Please " +
					"shorten your question and try again." );
				return false;
			}

			$("#ihelphistory").append( "<div class='question tempquestion'>" + IHelpEscape( question ) + "</div>" );
			$("#ihelptext").val( "" );
			$("#ihelphistory").show();

			Ajax( "ihelp", "question", { epid : $("#currentepid").val(), cid : $("#currentcid").val(), question: question, location: location.href },
				function( xml )
				{
					if ( $(xml).find( "reply" ).attr( "available" ) == "true" )
					{
						lastquestionihid = parseInt( $(xml).find( "reply" ).attr( "ihid" ) );
						IHClearTimer();
						ihtimer = setTimeout( function() { IHelpWaitForAnswer(); }, ihtimewaitingforanswer );
					}
					else
					{
						IHClearTimer();
						$("#ihelpquestion")
							.empty()
							.append( "<div class='ihelphasclosed'>We're sorry, but the current iHelp session has come to an end.</div>" );
					}
					return false;
				}
			);

			return false;
		}
	);

	try
	{
		Ajax( "ihelp", "history", { epid : $("#currentepid").val(), cid : $("#currentcid").val(), location: location.href },
			function( xml )
			{
				if ( $(xml).find( "reply" ).attr( "available" ) == "true" )
				{
					var reply = $(xml).find( "reply" ),
						answers = reply.find( "answer" );

					answers.each(
						function()
						{
							var answer = $(this),
								text = answer.text(),
								ihid = answer.attr( "ihid" );
								uid = parseInt( answer.attr( "uid" ) ),
								touid = parseInt( answer.attr( "touid" ) ),
								date = answer.attr( "date" );

							$("#ihelphistory").append( "<div class='" + (touid == 0 ? "question" : "answer") + "'>" + IHelpEscape( text ) + "</div>" );

							lastanswerihid = Math.max( ihid, lastanswerihid );
						}
					);

					if ( answers.size() > 0 )
						$("#ihelphistory").show();

					//$("#ihelpdiv-java").slideDown();
					$("#ihelpdiv-java").show();

					if ( $(xml).find( "reply" ).attr( "ismore" ) != "true" )
						$("#ihelpprevious").hide();

					IHClearTimer();
					ihtimer = setTimeout( function() { IHelpWaitForAnswer(); },
						(helptypevalues[ 2 ] == "1" || lastquestionihid == 0 || (lastanswerihid < lastquestionihid) ? ihtimewaitingforanswer : ihtimeidlebutvisible) );
				}
				else
				{
					IHClearTimer();
					$("#ihelpdiv-java").remove();
				}
			}
		);
	}
	catch ( e )
	{
		if ( $.browser.msie )
			$("#ihelpdiv-java").empty().append( "You will have to enable ActiveX controls in order to use the iHelp system (try adding this site to your Trusted sites)." );
	}
}

function IHelpEscape( t )
{
	if ( t == null || t == "" )
		return "[No message]";

	return t.replace( "<", "&lt;" ).replace( ">", "&gt;" ).replace( /\n/g, "<br/>" ).replace( /\r/g, "" );
}

function CheckStart()
{
	IHClearTimer();

	// 20130605: this call is currently not processed on the server side
	/*Ajax( "ihelp", "available", { epid : $("#currentepid").val(), cid : $("#currentcid").val(), location: location.href },
		function( xml )
		{
			var result = $(xml).find( "reply" ).attr( "available" );
			if ( result == "true" )
				$("#ihelpimage").fadeIn( "slow" );
			else if ( result == "expired" )
				IHClearTimer();
			else
				ihtimer = setTimeout( function() { CheckStart(); }, ihtimenotavailable );

			return false;
		}
	);*/
}

function IHelpWaitForAnswer()
{
	ihtimer = null;

	Ajax( "ihelp", "waitforanswer", { epid : $("#currentepid").val(), cid : $("#currentcid").val() , ihid: lastanswerihid, location: location.href },
		function( xml )
		{
			if ( $(xml).find( "reply" ).attr( "available" ) == "true" )
			{
				var reply = $(xml).find( "reply" ),
					answers = reply.find( "answer" ),
					getsanswer = false;

				if ( lastanswerihid == 0 )
					$(".tempquestion").remove();

				answers.each(
					function()
					{
						var answer = $(this),
							text = answer.text(),
							ihid = answer.attr( "ihid" ),
							touid = answer.attr( "touid" );

						$("#ihelphistory").append( "<div class='" + (touid == 0 ? "question" : "answer") + "'>" + IHelpEscape( text ) + "</div>" );

						if ( touid != 0 )
						{
							getsanswer = true;
						}

						lastanswerihid = Math.max( ihid, lastanswerihid );
					}
				);

				if ( getsanswer )
				{
					IHFadeAlert( "There is an answer to your iHelp question." );
					helptypevalues[ 2 ] == "0";
				}

				ihtimer = setTimeout( function() { IHelpWaitForAnswer(); },
										(helptypevalues[ 2 ] == "1" || lastquestionihid == 0 || (lastanswerihid < lastquestionihid) ? ihtimewaitingforanswer : ihtimeidlebutvisible) );
			}
			else
			{
				IHClearTimer();
				$("#ihelpquestion")
					.empty()
					.append( "<div class='ihelphasclosed'>We're sorry, but the current iHelp session has come to an end.</div>" );
			}

			return false;
		}
	);
}

function IHFadeAlert( t )
{
	$("#ihfadealert").remove();
	//$("#content").append( "<div id='ihfadealert'>" + t + "</div>" );
	$("body").append( "<div id='ihfadealert'>" + t + "</div>" );

	$("#ihfadealert").css( { top: ($(window).scrollTop() + 8), left: 8 } );
	$("#ihfadealert").show();

	setTimeout( function() { $("#ihfadealert").fadeOut( "slow" ); }, 3000 );
}

function IHelpAdmin()
{
	$(document).ready(
		function()
		{
			$("#sysadmin").append( "<div id='currentsessions'><h4>Active Sessions</h4></div><div id='oldsessions'><h4>Inactive Sessions</h4></div>" );
			ListSessions( "currentsessions" );
			ListSessions( "oldsessions" );
		}
	);
}

function ListSessions( command )
{
	Ajax( "ihelp", command, { location: location.href },
		function( xml )
		{
			$(xml).find( "reply" ).find( "session" ).each(
				function()
				{
					var session = $(this),
						start = session.attr( "start" ),
						uid = session.attr( "uid" ),
						name = session.attr( "name" ),
						sessionid = parseInt( session.attr( "sessionid" ) );

					$("#" + command).append(
						"<div class='session'><a href='#' class='sessiondetails'><input type='hidden' value='" + sessionid + "' />" + start + ": " + name + " &#187;</a></div>" );
				}
			);

			$("#" + command).find(".sessiondetails").click(
				function()
				{
					var p = $(this).parent(),
						messagesdiv = p.find( ".sessionmessages" ),
						sessionid = parseInt( $(this).find( "input" ).val() );

					if ( messagesdiv.size() == 0 )
					{
						p.append( "<div class='sessionmessages'></div>" );
						messagesdiv = p.find( ".sessionmessages" );

						Ajax( "ihelp", "sessionmessages", { sessionid: sessionid, location: location.href },
							function( xml )
							{
								var answers = $(xml).find( "reply" ).find( "answer" );

								if ( answers.size() == 0 )
									messagesdiv.append( "<div style='margin-left:16px;'>No messages in this session</div>" );

								answers.each(
									function()
									{
										var answer = $(this),
											uid = parseInt( answer.attr( "uid" ) ),
											touid = parseInt( answer.attr( "touid" ) ),
											message = answer.text(),
											date = answer.attr( "date" ),
											ihid = answer.attr( "ihid" ),
											name = answer.attr( "name" ),
											studentuid = (touid == 0 ? uid : touid);

										messagesdiv.append(
											"<div class='" + (touid == 0 ? "question" : "answer") + "'>" +
												date + ": " + name + ": " +
												message +
											"</div>" );
									}
								);
							}
						);
					}
					else
					{
						messagesdiv.remove();
					}
					return false;
				}
			);

			return false;
		}
	);
}

/******** Expert **********/
function StartExpert()
{
	$("#ihelpdiv-java").remove();
	$("#ihelpimage").hide();

	$("#page").prepend(
		"<div id='ihelpdiv-java' class='ui-widget ui-corner-all ui-widget-content content'>" +
			"<div class='ihelptitle'>" +
				($("#displaywindowlink").val() == "false" ? "" : "<span class='ihelpclosespan'><a href='#' id='ihelpclose'><img src='/eimacsstatics/shared/images/closebutton.gif' /></a></span>") +
				"<img src='/eimacsstatics/shared/images/ihelp.gif' />" +
			"</div>" +

		"<div id='ihelpconversations'><div id='ihelpnochatter'>There are currently no messages to display.</div></div>" +
		($("#displaywindowlink").val() == "false" ?
			"" :
			"<div class='links'>" +
				"<a href='#' id='window'>Window</a> " +
				"<a href='#' id='refresh'>Refresh</a> " +
				"<a href='#' id='closesession'>Close this session</a> " +
				"<a href='ihelpadmin'>Session Admin</a>" +
			"</div>") +
		"</div>" );

	$("#ihelpdiv-java").show();

	SetiHelpDraggable();

	$("#ihelpquestion").hide();

	$("#window").click(
		function()
		{
			window.open( "ihelp", "ihelp", "width=600,height=400,menubar=no,location=no,resizable=yes,scrollbars=yes,status=no" );
			$("#ihelpdiv-java").remove();
			return false;
		}
	);

	$("#refresh").click(
		function()
		{
			$("#ihelpdiv-java").remove();
			setTimeout( function() { StartExpert(); }, 0 );
			return false;
		}
	);

	$("#closesession").click(
		function()
		{
			confirmDialog( "Are you sure?",
				function()
				{
					Ajax( "ihelp", "expertend", { epid : $("#currentepid").val(), cid : $("#currentcid").val(), location: location.href },
						function( xml )
						{
							$("#ihelpdiv-java").hide();
							IHClearTimer();
							location.href = "ihelpadmin";
							return false;
						}
					);
				}
			);

			return false;
		}
	);

	$("#ihelpclose")
		.click(
			function()
			{
				$("#ihelpdiv-java").hide();
				$("#ihelpimage").show();
				return false;
			}
		)
		.hover(
			function()
			{
				$(this).find( "img" ).get( 0 ).src = "/eimacsstatics/shared/images/closebuttonhover.gif";
			},
			function()
			{
				$(this).find( "img" ).get( 0 ).src = "/eimacsstatics/shared/images/closebutton.gif";
			}
		);

	try
	{
		Ajax( "ihelp", "expertstart", { epid : $("#currentepid").val(), cid : $("#currentcid").val(), location: location.href },
			function( xml )
			{
				if ( $(xml).find( "reply" ).attr( "isexpert" ) != "true" )
				{
					$("#ihelpdiv-java").append( "Your iHelp Session has been closed." );
					return false;
				}

				ExpertInsertAnswers( xml );

				IHClearTimer();
				ihtimer = setTimeout( function() { ExpertUpdate(); }, ihtimeexpertupdate );
			}
		);
	}
	catch ( e )
	{
		if ( $.browser.msie )
			$("#ihelpdiv-java").empty().append( "You will have to enable ActiveX controls in order to use the iHelp system (try adding this site to your Trusted sites)." );
	}
}

function ExpertInsertAnswers( xml )
{
	var answers = $(xml).find( "reply" ).find( "answer" ),
		newquestion = false;

	if ( answers.size() > 0 )
		$("#ihelpnochatter").hide();

	answers.each(
		function()
		{
			var answer = $(this),
				uid = parseInt( answer.attr( "uid" ) ),
				touid = parseInt( answer.attr( "touid" ) ),
				//sessionid = parseInt( answer.attr( "sid" ) ),
				message = answer.text(),
				date = answer.attr( "date" ),
				ihid = answer.attr( "ihid" ),
				name = answer.attr( "name" ),
				studentuid = (touid == 0 ? uid : touid),
				divname = "forstudent" + studentuid;

			lastihid = Math.max( lastihid, ihid );

			if ( $("#" + divname).size() == 0 )
				$("#ihelpconversations").append( "<div class='forstudent' id='" + divname + "'>" +
					"<span class='expertmore'><a href='#' onclick='return ExpertPrevious(" + studentuid + ");'>Previous</a></span>" +
					"<h4>" + name + "</h4>" +
					"<div class='lastpage'></div>" +
					"<div class='forstudentcontents'></div>" +
					"</div>" );

			var studentdiv = $("#" + divname + " > div.forstudentcontents");

			if ( studentdiv.find("#ihid" + ihid).size() == 0 )
			{
				studentdiv.append(
					"<div class='" + (touid == 0 ? "question" : "answer") + "' id='ihid" + ihid + "'>" +
					date + ": " +
					IHelpEscape( message ) +
					(touid == 0 ? " <a href='#' onclick='return ReplyNow(" + ihid + ");' class='replynow'><input type='hidden' value='" + ihid + "' />Reply</a>" : "") +
					"</div>" );

				if ( touid == 0 )
					newquestion = true;
			}
		}
	);

	$(xml).find( "reply userinfo u" ).each(
		function()
		{
			var u = $(this),
				cidname = u.attr( "cidname" ),
				uid = u.attr( "uid" ),
				pid = u.attr( "pid" ),
				title = u.attr( "title" ),
				cid = u.attr( "cid" );

			if ( title != "" && title != null )
			{
				title = title.replace( /&ndash;/g, " &#8211; " );
				while ( title.substr( title.length - 1 ) == "|" ) // remove trailing bars
					title = title.substr( 0, title.length - 1 );

				var last = title.lastIndexOf( "|" );

				var leadup = title.substr( 0, last ).replace( /\|/g, " &#187; " ),
					shorttitle = $.trim( title.substr( last + 1 ) );

				$("#forstudent" + uid + " .lastpage")
					.empty()
					.append( "Viewing page " + cidname + ": " + leadup + " &#187; <a href='mainpage?cid=" + cid + "&amp;epid=" + pid + "'>" + shorttitle + "</a>" );
			}
		}
	);

	DimOldReplyLinks();

	return newquestion;
}

function ExpertUpdate()
{
	Ajax( "ihelp", "expertstart", { epid : $("#currentepid").val(), cid : $("#currentcid").val(), lastihid: lastihid, location: location.href },
		function( xml )
		{
			$("#ihelpdiv-java .tempanswer").remove();

			if ( $(xml).find( "reply" ).attr( "isexpert" ) != "true" )
			{
				$("#ihelpdiv-java").append( "Your iHelp Session has been closed." );
				return false;
			}

			var newquestion = ExpertInsertAnswers( xml );

			IHClearTimer();
			ihtimer = setTimeout( function() { ExpertUpdate(); }, ihtimeexpertupdate );

			if ( newquestion )
			{
				IHFadeAlert( "There is a new iHelp question." );
				$("#ihelpdiv-java").show();
			}
		}
	);
}

function ExpertPrevious( studentuid )
{
	Ajax( "ihelp", "expertprevious", { epid : $("#currentepid").val(), cid : $("#currentcid").val(), studentuid: studentuid, location: location.href },
		function( xml )
		{
			$("#forstudent" + studentuid).remove();

			ExpertInsertAnswers( xml );
		}
	);

	return false;
}

function DimOldReplyLinks()
{
	// dim the reply links to questions except the last in each student div
	$("#ihelpdiv-java div.forstudentcontents").each(
		function()
		{
			$(this).find( "a.replynow" ).css( "color", "silver" );
			$(this).find( "a.replynow:last" ).css( "color", "blue" );
		}
	);
}

function IHClearTimer()
{
	if ( ihtimer != null )
		clearTimeout( ihtimer );
	ihtimer = null;
}

function ReplyNow( ihid )
{
	$("#ihelpanswer").remove();

	$("#ihid" + ihid).after(
		"<div id='ihelpanswer'>" +
			"<em>Type your answer in the box below, and press <em>Go</em>!</em>" +
			"<table id='ihelptable'>" +
				"<tr><td><textarea id='ihelptext' rows='2'></textarea></td>" +
				"<td class='gobuttoncell'><button id='ihelpgo' value='Go'>Go</button></td></tr>" +
			"</table>" +
		"</div>" );

	//$("#ihelptext").resizable( { autoHide: true } );

	$("#ihelpgo")
		.button()
		.unbind()
		.click(
			function()
			{
				var answer = $.trim( $("#ihelptext").val() );
				if ( answer == "" )
					return false;

				if ( answer.length > 1000 )
				{
					alert( "Your answer is too long (it is " + answer.length + " characters, but the maximum allowed is 1000.) Please " +
						"shorten your answer and try again." );
					return false;
				}

				$("#ihelpanswer")
					.before( "<div class='answer tempanswer'>" + IHelpEscape( answer ) + "</div>" )
					.hide();

				Ajax( "ihelp", "expertanswer", { epid : $("#currentepid").val(), cid : $("#currentcid").val(), ihid: ihid, answer: answer, location: location.href },
					function( xml )
					{
						return false;
					}
				);

				return false;
			}
		);

	return false;
}

function SetiHelpDraggable()
{
	$("#ihelpdiv-java")
		.draggable( { scroll: true } )
		.resizable( { autoHide: true } );
}

/***** iHelp Admin ****/
function EditorOpenIncluded()
{
	var c = $("input:checkbox:checked");

	c.parents( ".initiallyhidden" ).show();

	if ( c.size() == 0 )
		$(".initiallyhidden:first").show();

	return false;
}
