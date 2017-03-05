
/* global google, gmap*/

function calcRoute() { 
    var directionsService = new google.maps.DirectionsService();
    var directionsDisplay = new google.maps.DirectionsRenderer();
    var address = document.getElementById("directionFormID:addressStart").value;
    var addressPlaceHolder =document.getElementById("directionFormID:addressStart").getAttribute("placeholder");
    var latlngstart = new google.maps.LatLng($('.latstart').val(),$('.lngstart').val()); 
    var latlngsend = new google.maps.LatLng($('.latitudedest').val(),$('.longitudedest').val()); 
    var map = gmap;

    if(address !== "" ){
        latlngstart = address ;

    }else if(address ==="" && addressPlaceHolder !== ""){
        latlngstart = addressPlaceHolder ;
    }
    
    directionsDisplay.setMap(map);
    directionsDisplay.setPanel(document.getElementById("formdialogID:directionsPanel")); 

    var request = {
        origin:latlngstart,
        destination:latlngsend,
        travelMode: google.maps.TravelMode.DRIVING
    };
    directionsService.route(request, function(response, status) {
        if (status === google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
        }
    });
google.maps.event.addDomListener(window, 'load', calcRoute);

} 
