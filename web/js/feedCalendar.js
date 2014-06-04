// function getFeedEvento(){
// 	$('#calendar').fullCalendar({
// 	    events: [{title: 'Event1',start: '2014-06-04', url: 'http://www.google.com/your_feed_url/'}]
// 	});
// }
// function getEvento(){
//   // request de eventos
//   $.ajax({
//       type: "GET",
//       url: ""
//       dataType: "json",
// 		success: function (json) {

//       		var i,n=json.length;
//       		for(i=0;i<n;i++){
// 				$('#calendar').fullCalendar({
// 					events: [
// 						{
// 						    title  	: json[i].title,
// 						    start  	: json[i].start, //'2014-05-31'
// 						    url		: json[i].url,
// 						},
// 					]
// 				});
//     		}
//     	}
//     });

// }

// URL automatica
// start = fecha en milisegundos
// json a recibir:
// {
//     title: 'Event1',
//     start: '2011-04-04',
//     url: 'http://www.google.com/your_feed_url/',
// }
// /myfeed.php?start=1262332800&end=1265011200&_=1263178646
function getFeedEvento(eventos){
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
	   },
	   eventos

	};
    $('#calendar').fullCalendar(options);

 //   events: [
	// 	{
	// 	    title: 'Event1',
	// 	    start: '2014-06-03',
	// 	}
	// ]


}


