package xyz.kennan.accuweatherapi

import xyz.kennan.accuweatherapi.api.ForecastAPI
import xyz.kennan.accuweatherapi.api.LocationsAPI

class AccuWeather (val apiKey: String) {

    private val locationsAPI: LocationsAPI = LocationsAPI(this)
    private val forecastAPI: ForecastAPI = ForecastAPI(this)

    fun useLocationsAPI(): LocationsAPI {
        return locationsAPI
    }

    fun useForecastAPI(): ForecastAPI {
        return forecastAPI
    }

}