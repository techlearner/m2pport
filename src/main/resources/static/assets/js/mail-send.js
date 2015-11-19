
function validateMailForm() {
	
	
}

function postMailContent() {
	  var posting = $.post( url, { s: term } );
	  
	  // Put the results in a div
	  posting.done(function( data ) {
	    var content = $( data ).find( "#content" );
	    $( "#result" ).empty().append( content );
	  });
	
}