const app = (() => {
	const mapeo = (weather) => {
		let table1 = $("#clima > tbody");
		let table0 = $("#cityinfo > tbody");
		let wd = weather.data;
		enviarlongitud(wd.coord);
		table0.empty();
		table1.empty();
		table0.append(
			`<tr> 
                      <td>${wd.name}</td>
                      <td>${wd.timezone}</td>
					  <td>${wd.coord.long}</td>
					  <td>${wd.coord.lat}</td>
                      <td>${wd.visibility}</td>
					  <td>${wd.clouds.all}</td>
					  <td>${wd.cod}</td>
			          <td>Wind speed</td><td>${wd.wind.speed}</td>
                	 <tr><td>Wind deg</td><td>${wd.wind.deg}</td></tr>
			</tr>`
		);
		table1.append(
			`<tr> 
					  
					  <td>${wd.weather.id}</td>
					  <td>${wd.weather.main}</td>
					  <td>${wd.weather.description}</td>
					  
                </tr>`
		);
		
		
	}
	const init = () =>{
        initMap();
    }
    var initMap = () => {map = new google.maps.Map(document.getElementById("map-canvas"), {zoom: 4,center: {lat: 35.717, lng: 139.731},});
    }
    function enviarlongitud(m) {
        markers = [];
        bounds = new google.maps.LatLngBounds();
        var position = new google.maps.LatLng(m.lat, m.lon);
        markers.push(
            new google.maps.Marker({
                position: position,
                map: map,
                animation: google.maps.Animation.DROP
            })
        );
        bounds.extend(position);
        map.fitBounds(bounds);
        map.setZoom(4);
    }
	const getWeatherByCity = (city) => {
		apiclient.getWeatherByCity(city, mapeo);
	}
	return {
		getWeatherByCity: getWeatherByCity,
		init:init
	}
})();