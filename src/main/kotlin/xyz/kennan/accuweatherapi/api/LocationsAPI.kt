package xyz.kennan.accuweatherapi.api

import xyz.kennan.accuweatherapi.AccuWeather

class LocationsAPI (aw: AccuWeather) : BaseAPI(aw) {

    fun getByGeoPosition(latitude: String, longitude: String, language: String = "en-us", details: Boolean = false, toplevel: Boolean = false): String? {
        val url =
                "http://dataservice.accuweather.com/locations/v1/cities/geoposition/search" +
                "?apikey=${accuWeather.apiKey}" +
                "&q=${latitude},${longitude}" +
                "&language=${language}" +
                "&details=${details}" +
                "&toplevel=${toplevel}"

        val (code, body) = httpRequest.withGET(url)

        return when (code) {
            200 -> body
            else -> null
        }
    }

    fun getByIPAddress(ipaddr: String, language: String = "en-us", details: Boolean = false): String? {
        val url =
                "http://dataservice.accuweather.com/locations/v1/cities/ipaddress" +
                "?apikey=${accuWeather.apiKey}" +
                "&q=${ipaddr}" +
                "&language=${language}" +
                "&details=${details}"

        val (code, body) = httpRequest.withGET(url)

        return when (code) {
            200 -> body
            else -> null
        }
    }
}