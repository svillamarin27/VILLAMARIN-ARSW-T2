const apiclient = (() =>{
    const getWeatherByCity = (city,callback) =>{
        axios.get('/informacion/weather/' + city).then(res=>{
            callback(res);
        })
    }
    return{
        getWeatherByCity:getWeatherByCity
    }
})();