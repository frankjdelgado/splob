$(document).ready(function(){
  // getEvento();
  // getFeedEvento();
});

function getEvento(){
  // request de eventos
  $.ajax({
      type: "GET",
      url: ""
      dataType: "json",
		success: function (json) {

      		var i,n=json.length;
      		for(i=0;i<n;i++){
				$('#calendar').fullCalendar({
					events: [
						{
						    title  	: json[i].title,
						    start  	: json[i].start, //'2014-05-31'
						    url		: json[i].url,
						},
					]
				});
    		}
    	}
    });

}

// URL automatica
// start = fecha en milisegundos
// json a recibir:
// {
//     title: 'Event1',
//     start: '2011-04-04',
//     url: 'http://www.google.com/your_feed_url/',
// }
// /myfeed.php?start=1262332800&end=1265011200&_=1263178646
function getFeedEvento(){
	$('#calendar').fullCalendar({
	    events: '/archivo.java'
	});
}

