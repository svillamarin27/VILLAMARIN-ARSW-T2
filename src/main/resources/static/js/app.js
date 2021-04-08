const app = (() => {
	const mapeo = (weather) => {
		let table1 = $("#clima > tbody");
		let table0 = $("#cityinfo > tbody");
		let wd = weather.data;
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
	const getWeatherByCity = (city) => {
		apiclient.getWeatherByCity(city, mapeo);
	}
	return {
		getWeatherByCity: getWeatherByCity
	}
})();