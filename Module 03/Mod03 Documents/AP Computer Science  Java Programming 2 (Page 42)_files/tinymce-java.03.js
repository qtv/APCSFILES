/*
 * for tinymce updates, refer to commonscripts/eimacs/common/solutions/templates-java.xml
 */

// tinymcejava - java/scheme editor using tinymce

var schemelibdefinedprocedures,
	tinymceroot = "/filedata/commonscripts/tinymcejq-4.0.28/";

$(document).ready(
        function()
        {
            initTinyMCEControls();
        }
);

function initTinyMCEControls(parent, initdata)
{
    var scrolltop = $("html").scrollTop(),
            needstoscrolltop = true, // false after one of the editors init's this
            windowposition = $("#windowposition").val();

    if (parent == undefined)
        parent = $("body");

    if (windowposition != undefined && windowposition != "")
        scrolltop = windowposition.split(",")[ 1 ];

    if (initdata == undefined)
        initdata = {};

    loadSchemelibDefinedProcedures();

    function init(ed)
    {
        var edid = ed.id.substring(2),
                shadowid = "shadow" + edid,
                val = $("#" + shadowid).val();

        if (schemelibdefinedprocedures != undefined)
        {
            // calls to ed.execCommand cause a jump to the last editor on the page. Delay does not help. Seems to be because call execCommand
            // gives the focus to the editor, causing the page to scroll. So scroll the page back after the editors have init'd
            ed.execCommand("mceSetSchemeLib", false, schemelibdefinedprocedures);
            schemelibdefinedprocedures = null;

            if (needstoscrolltop)
            {
                needstoscrolltop = false;
                setTimeout(function() {
                    $("html").scrollTop(scrolltop);
                }, 0);
            }
        }

        if (val != undefined && val != "")
        {
            var v = jePrepare(val);
            ed.execCommand("mceIMACSsetContent", false, v);

            if (needstoscrolltop)
            {
                needstoscrolltop = false;
                setTimeout(function() {
                    $("html").scrollTop(scrolltop);
                }, 0);
            }
        }
    }

    jeTinyMCEInit(parent.find("textarea.tinymcejava"), jeTinyMCECopyData(initdata), "java", init);
    jeTinyMCEInit(parent.find("textarea.tinymcescheme"), jeTinyMCECopyData(initdata), "scheme", init);
}

function loadSchemelibDefinedProcedures()
{
    if ($("textarea.tinymcescheme").length > 1 && schemelibdefinedprocedures == undefined)
    {
        Ajax("scheme", "definedsymbols", {},
                function(xml)
                {
                    schemelibdefinedprocedures = $(xml).find("reply").attr("symbols");

                    if (schemelibdefinedprocedures == undefined)
                        schemelibdefinedprocedures = "";

                }, null, true, null  // this is sync because otherwise potentially called several times
                );
    }
}

function jeTinyMCECopyData(from, to)
{
    to = (to == undefined ? {} : to);
    from = (from == undefined ? {} : from);

    for (var key in from)
        if (to[ key ] == null)
            to[ key ] = from[ key ];

    return to;
}

function jeTinyMCEInit(jq, data, language, after)
{
    var defaults =
                {
                    script_url: tinymceroot + 'js/tinymce/tinymce.min.js',
                    setup: function(ed)
                    {
                        ed.on( 'init',
							function()
							{
								$(".mce-edit-area").prev().hide(); // temporary, until "toolbar: false" is implemented
								$(".mce-path").hide(); // apparently no other way to remove path in statusbar
								if (after != null)
									after(ed);
							}
						);
                    },
                    entity_encoding: "numeric",
                    resize: "both",
                    external_plugins: {"imacsje": tinymceroot + "imacs/plugins/imacsje/plugin.js"},
                    imacsje_language: language,
                    menubar: false,
                    //toolbar : false, // not implemented by tinyMCE yet
                    content_css: tinymceroot + "imacs/css/content.css," +
                            tinymceroot + "imacs/plugins/imacsje/css/css.css",
                    valid_elements: "@[id|class|style|title],#p,-span,br"
                };

    for (var key in defaults)
        if (data[ key ] == null)
            data[ key ] = defaults[ key ];

    jq.tinymce(data);
}

function jePrepare(val)
{
    var v = "";

    if (val != null && val != "")
    {
        var ps = val.replace(/\r/g, "")
                //.replace( /&/g, "&amp;" )
                .replace(/</g, "&lt;")
                .replace(/>/g, "&gt;")
                .replace(/ /g, "&nbsp;")
                .split(/\n/);

        for (var i = 0; i < ps.length; i++)
            v += "<p>" + ps[ i ] + "</p>";
    }

    return v;
}

function jeCaptureThis(t)
{
    var name = t.attr("id").substr(6),
            editorobject = $("#jw" + name),
            html = editorobject.html(),
            div = $("<div>" + html + "</div>"),
            text = "";

    div.find("p").each(
            function()
            {
                text += (text == "" ? "" : "\n") + $(this).text();
            }
    );

    text = text.replace(/\u00a0/g, " ").replace(/\u03bb/g, "lambda").replace(/\u25bd/g, "'");

    return text;
}

function jeCapture()
{
    // copies editor contents into textareas ready for processing
    $(".jeshadow").each(
            function()
            {
                $(this).val(jeCaptureThis($(this)));
            }
    );
}

function jeUpdate(name) // puts shadow text into control
{
    if ($("#jw" + name).length > 0)
    {
        var shadowid = "shadow" + name,
                ed = $("#jw" + name).tinymce(),
                val = $("#" + shadowid).val();

        if (val != null)
        {
            var v = jePrepare(val);

            delay(
                    function()
                    {
                        ed.execCommand("mceIMACSsetContent", false, v);
                    }
            );
        }
    }
}
