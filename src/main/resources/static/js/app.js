const app = (() =>{
    const mapeo = (weather) =>{
        console.log(weather.data)
    }
    const getWeatherByCity = (city) =>{
        apiclient.getWeatherByCity(city,mapeo);
    }
    return{
        getWeatherByCity:getWeatherByCity
    }
})();