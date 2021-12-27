function mapView(lista) {
    var element = document.getElementById('osm-map');
// Create Leaflet map on map element.
    var map = L.map(element);

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
        for (let i = 0; i<lista.length;i++){
            var marker = L.marker(lista[i].latlng);
            map.addLayer(marker);
        }
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