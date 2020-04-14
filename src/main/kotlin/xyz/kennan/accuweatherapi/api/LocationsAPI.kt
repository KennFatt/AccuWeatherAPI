package xyz.kennan.accuweatherapi.api

import xyz.kennan.accuweatherapi.AccuWeather

class LocationsAPI (aw: AccuWeather) : BaseAPI(aw, "http://dataservice.accuweather.com/locations/v1") {

    fun getByGeoPosition(latitude: String, longitude: String, language: String = "en-us", details: Boolean = false, toplevel: Boolean = false): String? {
        val requestParams = hashMapOf<String, Any>(
            "apikey" to accuWeather.apiKey,
            "q" to "${latitude},${longitude}",
            "language" to language,
            "details" to details,
            "toplevel" to toplevel
        )

        val (code, body) = accuWeather.httpRequest.withGET(
            createRequest(requestParams, "/cities/geoposition/search")
        )

        return when (code) {
            200 -> body
            else -> null
        }
    }

    fun getByIPAddress(ipaddr: String, language: String = "en-us", details: Boolean = false): String? {
        val requestParams = hashMapOf<String, Any>(
            "apikey" to accuWeather.apiKey,
            "q" to ipaddr,
            "language" to language,
            "details" to details
        )

        val (code, body) = accuWeather.httpRequest.withGET(
            createRequest(requestParams, "/cities/ipaddress")
        )

        return when (code) {
            200 -> body
            else -> null
        }
    }
}