// Variables globales. Proxima pagina a cargar
var page = 1;

$(document).ready(function() {
    smooth();
    eventos();
    postFeed();
    bottom();
    getFeeds();
});

function smooth() {
    var offset = 220;
    var duration = 500;
    $(window).scroll(function() {
        if ($(this).scrollTop() > offset) {
            $('.back-to-top').fadeIn(duration);
        } else {
            $('.back-to-top').fadeOut(duration);
        }
    });

    $('.back-to-top').click(function(event) {
        event.preventDefault();
        $('html, body').animate({scrollTop: 0}, duration);
        return false;
    });
}

function calendar(json) {
    var options = {
        allDayDefault: false,
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        timeFormat: {
            agenda: 'h(:mm)t{ - h(:mm)t}',
            '': 'h(:mm)t{-h(:mm)t }'
        },
        monthNames: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb'],
        buttonText: {
            today: 'hoy',
            month: 'mes',
            week: 'semana',
            day: 'día'
        },
        events: json
    };

    if ($('#calendar').length > 0)
        $('#calendar').fullCalendar(options);
}

// Obtener feeds con scroll
function bottom() {
    window.onscroll = function(ev) {
        if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
            getFeeds();
        }
    };
}
// Feeds
function getFeeds() {
    // request de datos
    $.ajax({
        type: "GET",
        url: "Publicaciones", //url aqui
        data: {pag: page},
        dataType: "json",
        success: function(json) {
            setFeeds(json, 'feeds');
        }
    });
    // Proxima pagina para siguiente request
    page++;
}

function postFeed() {

    var frm = $('#feed');

    $(document).on('click', '#feed', function() {
        $.ajax({
            type: frm.attr('method'),
            url: frm.attr('action'),
            data: frm.serialize(),
            success: function(data) {
            },
            error: function() {
                $("#error .alert-danger").toggleClass('hide');
            }
        });
    });

}

// Evento
function postEvent() {

    var frm = $('#ev');

    $(document).on('click', '#ev', function() {
        $.ajax({
            type: frm.attr('method'),
            url: frm.attr('action'),
            data: frm.serialize(),
            success: function(data) {
            },
            error: function() {
                $("#error .alert-danger").toggleClass('hide');
            }
        });
    });
}

// Publicacion


// Helpers

// Insertar Feed en html
function setFeeds(json, parent) {

    var i, n = json.length;

    // Solo imprimir data si el resultado del get devolvio objetos
    if (n > 0) {
        parent = document.getElementById(parent);
        for (i = 0; i < n; i++) {
            parent.innerHTML += setDom(json[i].id, json[i].content, json[i].username, json[i].img, "icon-bubble");
        }
    }
}

// armar dom con contenido
function setDom(id, content, username, img, icon) {
    var dom;
    if (img === "null")
            dom = '<li><div class = "timeline" > </div><div class = "' + icon + '" ></div><div class = "feedContent" ><div class = "evento-desc" ><p> '+content+' </p><div class = "text-right" ><a href="post.html">Ver más</a>';
            else
            dom = '<li><div class = "timeline" > </div><div class = "' + icon + '" ></div><div class = "feedContent" ><div class = "evento-desc" ><img src = "img/profile.gif" alt = "" ><p> '+content+' </p><div class = "text-right" ><a href="post.html">Ver más</a>';
            
            if (username)
                dom += '<button class = "btn btn-default btn-sm" > Editar </button></div></div><form action = "EditarPost" class = "evento-edit hide" method="POST"><div class = "input-group col-md-12" ><input type = "file" class = "input-sm form-control" accept = "image/*" name = "imagen" value = "'+img+'" >'+
                    '</div><div class = "input-group col-md-12" ><textarea name = "contenido" id = "" cols = "30" rows = "5" class = "input-sm form-control" placeholder = "Descripción" required name = "contenido">'+content+'</textarea></div><input type = "hidden" name = "id" value = "'+id+'" >'+
                    '<div class = "text-right" ><input name = "eliminar" type = "submit" value = "Guardar" class = "btn btn-danger btn-sm"><button type = "button" name = "guardar" class = "btn btn-info btn-sm">Cancelar</button></div></form>';
            else
                dom += '</div></div>';
            dom += '</div></li>';

            return dom;
}

function eventos() {

    $.ajax({
        type: "GET",
        url: "ContarEventos", //url aqui
        dataType: "json",
        success: function(json) {
            calendar(json);
        }
    });

}