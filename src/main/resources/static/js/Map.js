function mapView() {
    var element = document.getElementById('osm-map');
// Create Leaflet map on map element.
    var map = L.map(element);

    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET','http://127.0.0.1:8080/api/anti-police')
    ourRequest.onload = function (){
        var ourData = JSON.parse(ourRequest.responseText);
        var marker;
        for(let i = 0; i<ourData.length; i++){
            marker = L.marker(ourData[i].latlng)
            map.addLayer(marker);
            marker.bindPopup('<p>Type of police: ' + ourData[i].state + ' </p>' +
                '<p>From user: ' + ourData[i].user.username);
        }

    };
    ourRequest.send();

// Add OSM tile layer to the Leaflet map.
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

// Target's GPS coordinates.
    var target = L.latLng('0','0');
    map.locate({setView: false, watch: true, maxZoom: 20});
    map.on('locationfound', function(ev){
        target.lat = ev.latlng.lat;
        target.lng = ev.latlng.lng;
        map.setView(target,17);
    });


// Set map's center to target with zoom 14.
//     map.setView(target, 15);

}

function showLatLng(){
    var element = document.getElementById('osm-map');
// Create Leaflet map on map element.
    var map = L.map(element);



// Add OSM tile layer to the Leaflet map.
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    var target = L.latLng('0','0');
    map.locate({setView: false, watch: true, maxZoom: 20});
    map.on('locationfound', function(ev){
        target.lat = ev.latlng.lat;
        target.lng = ev.latlng.lng;
        map.setView(target,17);
    });
    // map.on('mousemove', function (e) {
    // });
    var marker;
    map.once('click', function (e){
        marker = L.marker(e.latlng, {
            draggable: true
        });
        map.addLayer(marker);
        marker.bindPopup('<p>You are here kosta</p>');
        $('#cord').val(e.latlng.lat + ", "+ e.latlng.lng);
        marker.on('drag',function (e){
            $('#cord').val(e.latlng.lat + ", "+ e.latlng.lng);
        });
    });

}