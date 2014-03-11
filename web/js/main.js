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

$(document).ready(function(){

    smooth();
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

    $('#calendar').fullCalendar(options);

});