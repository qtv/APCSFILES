$(document).ready( function() {AdFolder.prepForMobile();AdFolder.onReady();} );

var AdFolder =
{
    prepForMobile: function()
    {
        if ( typeof( QuizPopNextAddClickFunction ) != "undefined" )
             QuizPopNextAddClickFunction(
				function() { AdFolder.onMobileNext(); } );
    } ,

    onReady: function()
    {
        var isHomePage = ( location.href.indexOf( "home.aspx" ) > -1 );
        var isMobilePage = ( location.href.indexOf( "mobile" ) > -1 );

        var getBannerInfo = function( bNode )
        {
            if ( bNode.attr( "enabled" ) == "false" )
                return null;
            if ( !isHomePage && bNode.attr( "homepageonly" ) == "true" )
                return null;
            if ( !isMobilePage && bNode.attr( "mobilepageonly" ) == "true" )
                return null;
            if ( bNode.attr( "type" ) == 'standard' )
            {
                return {
                    html: bNode.text() ,
                    id: bNode.attr( "id" ) || null ,
                    priority: bNode.attr( "priority" ) || -999
                };
            }
            else if ( bNode.attr( "type" ) == 'random' )
            {
                var choices = [];
                bNode.children( "banner" ).each(
					function()
					{
						var x = getBannerInfo( $( this ) );
						if ( x != null )
							choices.push( x.html );
					}
				);

                var r = Math.floor( Math.random() * choices.length );

                return {
                    html: bNode.find( "pre" ).first().text() + choices[ r ] + bNode.find( "post" ).first().text() ,
                    id: bNode.attr( "id" ) || null ,
                    priority: bNode.attr( "priority" ) || -99999
                };
            }
            else return null;
        }

        Ajax( "adfolders", "controlfiles",
			{
					uid: $("#currentuid").val(),
					cid: $("#currentcid").val(),
					pid: $("#currentpid").val()
			},
			function( xml )
			{
				var infos = [];
				var priorities = {};

				$(xml).find( "reply > root" ).each(
					function()
					{
						var t = $( this );

						if ( t.attr( "enabled" ) == "true" )
						{
							t.children( "banner" ).each(
								function()
								{
									var info = getBannerInfo( $( this ) );
									if ( info )
									{
										infos.push( info );
										if ( info.id != null )
										priorities[ info.id ] =
											Math.max( parseInt( info.priority ), parseInt( priorities[ info.id ] || -99999 ) );
									}
								}
							);
						}
					}
				);

				s = "";
				for ( var i = 0 ; i < infos.length ; i++ )
				{
					if ( infos[ i ].id == null || priorities[ infos[ i ].id ] == infos[ i ].priority )
						s += infos[ i ].html;
				}

				if ( s != "" )
				{
					s = "<div class=\"theadbanners\">" + s + "</div>";
					if ( isMobilePage || isHomePage )
						$("#page").append( s );
					else
						$("#pagecontrols").before( s );

					$(".theadbanners").find( "img" ).each(
						function()
						{
							var src = $(this).attr( "src" );
							if ( src != undefined )
								$(this).attr( "src", src.toLowerCase() );
						}
					);
				}
			}
        );
    },

    onMobileNext:
		function()
		{
			$( "#page > form" ).siblings().remove();
			AdFolder.onReady();
		}
};