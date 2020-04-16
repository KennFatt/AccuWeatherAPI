package xyz.kennan.accuweatherapi.api

import xyz.kennan.accuweatherapi.AccuWeather

/**
 * LocationsAPI class
 *
 * Accessing Locations API interface for all end-points from:
 * http://dataservice.accuweather.com/locations/v1
 *
 * All methods should be returning a String of JSON if succeed and Null otherwise.
 */
class LocationsAPI (aw: AccuWeather) : BaseAPI(aw, "http://dataservice.accuweather.com/locations/v1") {

    /**
     * Find location information by Geo Position (latitude,longitude)
     * End-point: /cities/geoposition/search
     *
     * @param latitude  Latitude in string format
     * @param longitude Longitude in string format
     * @param language
     * @param details
     * @param toplevel
     *
     * @return String|null
     */
    fun getByGeoPosition(latitude: String, longitude: String, language: String = "en-us", details: Boolean = false, toplevel: Boolean = false): String? {
        val requestParams = hashMapOf<String, Any>(
            "apikey"    to accuWeather.apiKey,
            "q"         to "${latitude},${longitude}",
            "language"  to language,
            "details"   to details,
            "toplevel"  to toplevel
        )

        val (code, body) = accuWeather.httpRequest.withGET(
            createRequest(requestParams, additionalEndPoint = "/cities/geoposition/search")
        )

        return if (code == 200) body else null
    }

    /**
     * Find location information by an IP Address
     * End-point: /cities/ipaddress
     *
     * @param ipaddr    IP Address in string format (I.e. "10.2.1.1")
     * @param language
     * @param details
     *
     * @return String|null
     */
    fun getByIPAddress(ipaddr: String, language: String = "en-us", details: Boolean = false): String? {
        val requestParams = hashMapOf<String, Any>(
            "apikey"    to accuWeather.apiKey,
            "q"         to ipaddr,
            "language"  to language,
            "details"   to details
        )

        val (code, body) = accuWeather.httpRequest.withGET(
            createRequest(requestParams, additionalEndPoint = "/cities/ipaddress")
        )

        return if (code == 200) body else null
    }

}