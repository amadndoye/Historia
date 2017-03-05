 /* global google */

var options = {
  enableHighAccuracy: true,
  timeout: 5000,
  maximumAge: 0
};

 function geocodeLatLng(latitude, longitude) {
  var geocoder = new google.maps.Geocoder;
  var latlng = {lat: parseFloat(latitude), lng: parseFloat(longitude)};
  geocoder.geocode({'location': latlng}, function(results, status) {
    if (status === google.maps.GeocoderStatus.OK) {
      if (results[1]) {
         document.getElementById('formUserInfoId:userAddress').value =results[1].formatted_address.toString();
         remoteChangeCommand();

      } 
    } else {
      window.alert('Geocoder failed due to: ' + status);
    }
  });
  }

function success(pos) {
  var crd = pos.coords;
  document.getElementById('formUserInfoId:latitude').value = crd.latitude;
  document.getElementById('formUserInfoId:longitude').value = crd.longitude;
  geocodeLatLng(crd.latitude,crd.longitude);
  

};

function error(err) {
  console.warn(`ERROR(${err.code}): ${err.message}`);
  document.getElementById("arroundMeID:findArroudMeButton").disabled=true;
  document.getElementById("formUserInfoId:latitude").value = 48.866667;
  document.getElementById("formUserInfoId:longitude").value = 2.333333 ; 
  document.getElementById("formUserInfoId:userAddress").value = "Pyramides, 75001 Paris, France";
  alert(`${err.message}`+" \n default location will be used");           
      //remoteChangeCommand();
 
};

navigator.geolocation.getCurrentPosition(success, error, options);

 
 
