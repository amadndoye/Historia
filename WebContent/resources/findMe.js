 if (navigator.geolocation) {
	navigator.geolocation.getCurrentPosition(function(position) {
	document.getElementById("formId:latitude").value = position.coords.latitude;
	document.getElementById("formId:longitude").value = position.coords.longitude;
    }, function() {
		alert("no html5")

    });	
} else {
	alert("no html5")
}