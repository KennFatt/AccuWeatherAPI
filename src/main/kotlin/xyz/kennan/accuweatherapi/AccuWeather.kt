package xyz.kennan.accuweatherapi

import xyz.kennan.accuweatherapi.api.ForecastAPI
import xyz.kennan.accuweatherapi.api.LocationsAPI
import xyz.kennan.accuweatherapi.net.HttpRequest

/**
 * AccuWeather Class
 *
 * Create new instance and it ready to retrieve data from
 * https://dataservice.accuweather.com
 *
 * @param apiKey Your private developers API Key
 */
class AccuWeather (val apiKey: String) {

    /** Accessing HTTP Request with a single instance */
    val httpRequest: HttpRequest = HttpRequest()

    /** API object implementation and its sub end-points */
    private val locationsAPI: LocationsAPI = LocationsAPI(this)
    private val forecastAPI: ForecastAPI = ForecastAPI(this)

    /**
     * Using Locations API to create a new request.
     *
     * @return LocationsAPI
     */
    fun useLocationsAPI(): LocationsAPI {
        return locationsAPI
    }

    /**
     * Using Forecast API to create a new request.
     *
     * @return ForecastAPI
     */
    fun useForecastAPI(): ForecastAPI {
        return forecastAPI
    }

}