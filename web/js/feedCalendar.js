var page2 = 1;

$(document).ready(function() {
    bottom2();
    getEventos();
});

function bottom2() {
    window.onscroll = function(ev) {
        if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
            getEventos();
        }
    };
}
// Feeds
function getEventos() {
    // request de datos
    $.ajax({
        type: "GET",
        url: "Eventosjson", //url aqui
        data: {pag: page2, fecha:fechacalendario},
        dataType: "json",
        success: function(json) {
            setEventos(json, 'feedEventos');
        }
    });
    // Proxima pagina para siguiente request
    page2++;
}

function setEventos(json, parent) {

    var i, n = json.length;

    // Solo imprimir data si el resultado del get devolvio objetos
    if (n > 0) {
        parent = document.getElementById(parent);
        for (i = 0; i < n; i++) {
            parent.innerHTML += setDom2(json[i].id, json[i].content, json[i].username, json[i].img, "icon-calendar");
        }
    }
}

function setDom2(id, content, username, img, icon) {
    var dom;
    if (img === "null")
            dom = '<li><div class = "timeline" > </div><div class = "' + icon + '" ></div><div class = "feedContent" ><div class = "evento-desc" ><p> '+content+' </p><div class = "text-right" ><a href="Publicacion?id='+id+'">Ver más</a>';
            else
            dom = '<li><div class = "timeline" > </div><div class = "' + icon + '" ></div><div class = "feedContent" ><div class = "evento-desc" ><img src = "img/profile.gif" alt = "" ><p> '+content+' </p><div class = "text-right" ><a href="Publicacion?id='+id+'">Ver más</a>';
            
            if (username)
                dom += '<button class = "btn btn-default btn-sm" > Editar </button></div></div><form action = "EliminarEvento" class = "evento-edit hide" method="POST"><div class = "input-group col-md-12" ><input type = "file" class = "input-sm form-control" accept = "image/*" name = "imagen" value = "'+img+'" >'+
                    '</div><div class = "input-group col-md-12" ><textarea name = "contenido" id = "" cols = "30" rows = "5" class = "input-sm form-control" placeholder = "Descripción" required name = "contenido">'+content+'</textarea></div><input type = "hidden" name = "id" value = "'+id+'" ><input type = "hidden" name = "fecha" value = "'+fechacalendario+'" >'+
                    '<div class = "text-right" ><input name = "eliminar" type = "submit" value = "Eliminar" class = "btn btn-danger btn-sm"><button type = "button" id = "guardar" class = "btn btn-info btn-sm" type = "button">Cancelar</button></div></form>';
            else
                dom += '</div></div>';
            dom += '</div></li>';

            return dom;
}