var page = 1;

$(document).ready(function(){
	bottom();
});
$(document).on('click','.evento-desc button',function(){

	var des = $(this).parent().parent();
	var parent = $(this).parent().parent().parent().find('.evento-edit');
	$(parent).toggleClass('hide');
	$(des).toggleClass('hide');
});

$(document).on('click','.evento-edit input[name="guardar"]',function(){
	var parent_form = $(this).parent().parent();
	var parent_desc = $(this).parent().parent().parent().find('.evento-desc');
	$(parent_form).toggleClass('hide');
	$(parent_desc).toggleClass('hide');
});


// Obtener feeds con scroll
function bottom(){
  window.onscroll = function(ev) {
      if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
          getEventos();
      }
  };
}


function getEventos(){
  // request de datos
  $.ajax({
      type: "GET",
      // url: //url aqui 
      dataType: "json",
      success: function (json) {
        setEventos(json,'contenedor-eventos');
      }
    });
  // Proxima pagina para siguiente request
  page++;
}



function setEventos(json,parent){

  var i,n=json.length;
  if( n > 0){
    parent = document.getElementById(parent);
    for(i=0;i<n;i++){
      parent.innerHTML += setDom(json[i].id,json[i].titulo,json[i].descripcion,json[i].fecha);
    }
  }
}



function setDom(id,titulo,descripcion,fecha){
	var dom = '<li><div class="evento-desc"><h4><strong>Título: </strong>'+titulo+'</h4>p><strong>Fecha: </strong>'+fecha+'</p><p>'+descripcion+'</p><div class="text-right"><button class="btn btn-default btn-sm">Editar</button></div></div><form action="" class="evento-edit hide"><div class="input-group col-md-6"><input value="'+titulo+'"type="text" class="input-sm form-control" placeholder="Título" required name="titulo"></div><div class="input-group col-md-6"><input value="'+fecha+'" type="date" class="input-sm form-control" placeholder="Fecha Evento" required name="fecha"></div><div class="input-group col-md-12"><textarea name="" id="" cols="30" rows="5" class="input-sm form-control" placeholder="Descripción" required name="descripcion">'+descripcion+'</textarea></div><input type="hidden" name="id" value="'+id+'"><div class="text-right"><input name="eliminar" type="submit" value="Eliminar" class="btn btn-danger btn-sm"><input name="guardar" type="submit" value="Guardar" class="btn btn-info btn-sm"></div></form></li>';
  return dom;
}

