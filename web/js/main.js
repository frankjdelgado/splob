// Variables globales. Proxima pagina a cargar
var page = 1;

$(document).ready(function(){
  smooth();
  calendar();
  postFeed();
  bottom();
});

function smooth(){
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

function calendar(){
  var options = {
   allDayDefault:false,
   header: {
    left: 'prev,next today',
    center: 'title',
    right: 'month,agendaWeek,agendaDay'
   },
   timeFormat: {
    agenda: 'h(:mm)t{ - h(:mm)t}',
    '': 'h(:mm)t{-h(:mm)t }'
   },
   monthNames: ["Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" ],
   monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
   dayNames: [ 'Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
   dayNamesShort: ['Dom','Lun','Mar','Mié','Jue','Vie','Sáb'],
   buttonText: {
    today: 'hoy',
    month: 'mes',
    week: 'semana',
    day: 'día'
   }
  };

  if($('#calendar').length>0)
    $('#calendar').fullCalendar(options);
}


// Ajax methods

// Registrarse
function postReg(){

  var frm = $('#reg form');

  $(document).on('click','#reg',function(){
    $.ajax({
      type: frm.attr('method'),
      url: frm.attr('action'),
      data: frm.serialize(),
      success: function (data) {
      },
      error: function(){
        $("#error .alert-danger").toggleClass('hide');
      }
    });
  });

}


// Login
function postLogin(){

  var frm = $('#login form');

  $(document).on('click','#login',function(){
    $.ajax({
      type: frm.attr('method'),
      url: frm.attr('action'),
      data: frm.serialize(),
      success: function (data) {
      },
      error: function(){
        $("#error .alert-danger").toggleClass('hide');
      }
    });
  });

}

// Obtener feeds con scroll
function bottom(){
  window.onscroll = function(ev) {
      if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
          getFeeds();
      }
  };
}


// Feeds
function getFeeds(){
  // request de datos
  $.ajax({
      type: "GET",
      url: //url aqui
      dataType: "json",
      success: function (json) {
        setFeeds(json,'feeds');
      }
    });
  // Proxima pagina para siguiente request
  page++;
}

function postFeed(){

  var frm = $('#feed');

  $(document).on('click','#feed',function(){
    $.ajax({
      type: frm.attr('method'),
      url: frm.attr('action'),
      data: frm.serialize(),
      success: function (data) {
      },
      error: function(){
        $("#error .alert-danger").toggleClass('hide');
      }
    });
  });

}

// Evento
function postEvent(){

  var frm = $('#ev');

  $(document).on('click','#ev',function(){
    $.ajax({
      type: frm.attr('method'),
      url: frm.attr('action'),
      data: frm.serialize(),
      success: function (data) {
      },
      error: function(){
        $("#error .alert-danger").toggleClass('hide');
      }
    });
  });
}

// Publicacion


// Helpers

// Insertar Feed en html
function setFeeds(json,parent){

  var i,n=json.length;

  // Solo imprimir data si el resultado del get devolvio objetos
  if( n > 0){
    parent = document.getElementById(parent);
    for(i=0;i<n;i++){
      parent.innerHTML += setDom(json[i].id,json[i].content,json[i].username,json[i].img);
    }
  }
}

// armar dom con contenido
function setDom(id,content,username,img){
  var dom = '<li><div class="timeline"></div><span class="icon-bubble"></span><div class="feedContent"><p>'+content+'</p><img src="'+img+'" alt=""></div></li>';
  return dom;
}
