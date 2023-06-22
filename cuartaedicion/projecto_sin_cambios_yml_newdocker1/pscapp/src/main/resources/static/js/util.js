function showPIIDoc()
{
    console.log("Entramos en la función")
    var x = document.getElementById("urlImg").value;
    console.log("valor de la url :" +  x)
    document.getElementById("imagen").src = x;
}
function initMap() {
    console.log("Entramos en la initmap")
    // A couple of places
    var brunchPos = {lat: 41.3882793, lng: 2.1615454};
    var faboritPos = {lat: 41.3915233, lng: 2.1650537};

    // Create map, draw it in the targetElem and sets the cameraPosition
    var targetElem = document.getElementById('map');
    var cameraPosition = { zoom: 13, center: faboritPos };
    var map = new google.maps.Map(targetElem, cameraPosition);

    // We have already displayed the map, let's add markers

    // Create markers in the map
    var marker1 = new google.maps.Marker({ map: map, position: faboritPos });
    var marker2 = new google.maps.Marker({ map: map, position: brunchPos });

    // Now let's setup the autocomplete input, with which we can add more markers

    // Autocomplete input
    var input = document.getElementById('searchTextField');
    var autocomplete = new google.maps.places.Autocomplete(input);
    autocomplete.bindTo('bounds', map);

    // Listen to autocomplete input
    autocomplete.addListener('place_changed', function() {

        var place = autocomplete.getPlace();
        if (!place.geometry) {
            // User entered the name of a place that was not suggested and
            // pressed the Enter key, or the Place Details request failed.
            window.alert("No details available for input: '" + place.name + "'. Select one of the results.");
            return;
        }

        // Add marker in map
        var marker = new google.maps.Marker({ map: map, position: place.geometry.location });
    });

}