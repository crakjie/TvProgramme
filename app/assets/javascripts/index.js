$(function() {
    // add a click handler to the button
	$( document ).ready(function() {
		var date =new Date();
		
		$.getJSON( "/prog/"+date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate(), function( data ) {
			  var items = [];
			  $.each( data, function( key, programme ) {
				 var startDate = new Date(programme.start);
			    items.push( "<block  class='programme' id='" + key + "' >"+
			    				"<block>" + programme.name +"</block>"+			    				
			    				"<block>" +startDate.getHours() + ":" + startDate.getMinutes()+"</block>"+
			    				"<block>" +programme.channel+"</block>"+
			    				"<block>" +programme.description+"</block>"+
			    				
			    			"</block>" );
			  });
			 
			  $( "<block/>", {
			    "class": "cadre",
			    html: items.join( "" )
			  }).appendTo( "body" );
			});
	  })
    $("#getMessageButton").click(function(event) {
        // make an ajax get request to get the message
        jsRoutes.controllers.MessageController.getMessage().ajax({
            success: function(data) {
                console.log(data)
                $(".well").append($("<h1>").text(data.value))
            }
        })
    })
})