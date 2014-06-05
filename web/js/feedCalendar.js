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
        data: {pag: page2,fecha:fechacalendario},
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
            parent.innerHTML += setDom2(json[i].id, json[i].content, json[i].username, json[i].img, json[i].fecha,"icon-calendar");
        }
    }
}

//function setDom2(id, content, username, img, fecha, icon) {
//    var dom;
//    if (img === "null")
//        dom = '<li><div class="timeline"></div><span class="'+icon+'"></span><div class="feedContent"><p>'+content+'</p><div class="text-right">'+
//        '<a href="Publicacion?id=' + id + '">Ver más</a></div>';
//    else
//        dom = '<li><div class="timeline"></div><span class="'+icon+'"></span><div class="feedContent"><img src="img/profile.gif" alt=""><p>'+content+'</p><div class="text-right">'+
//        '<a href="Publicacion?id=' + id + '">Ver más</a></div>';
//        '<li><div class="timeline"></div><span class="'+icon+'"></span><div class="feedContent"><img src="img/profile.gif" alt=""><p>'+content+'</p><div class="text-right"><a href="Publicacion?id=' + id + '">Ver más</a><div class="text-right"><button class="btn btn-default btn-sm">Editar</button></div></div><form action="EditarPost" class="evento-edit hide"><div class="input-group col-md-6"><input value="'+fecha+'" type="date" class="input-sm form-control" placeholder="Fecha Evento" required name="fecha"></div><div class="input-group col-md-6"><input value="'+img+'" input type="file" class="input-sm form-control" accept="image/*" name="imagen"></div><div class="input-group col-md-12"><textarea name="contenido" id="" cols="30" rows="5" class="input-sm form-control" placeholder="Descripción" required name="descripcion">'+content+'</textarea></div><input type="hidden" name="id" value="'+id+'"><div class="text-right"><input name="eliminar" type="submit" value="Eliminar" class="btn btn-danger btn-sm"><input name="guardar" type="submit" value="cancelar" class="btn btn-info btn-sm"></div></form></div></li>'
//
//
//        dom+='</div></li>'
//            return dom;
//}