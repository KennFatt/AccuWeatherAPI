package xyz.kennan.accuweatherapi.api

import xyz.kennan.accuweatherapi.AccuWeather

/**
 * ForecastAPI class
 *
 * Accessing Forecast API interface for all end-points from:
 * http://dataservice.accuweather.com/forecasts/v1
 *
 * All methods should be returning a String of JSON if succeed and Null otherwise.
 */
class ForecastAPI (aw: AccuWeather) : BaseAPI(aw, "http://dataservice.accuweather.com/forecasts/v1") {

    /**
     * Get daily forecast information
     * End-point: /daily/{daysInString}/{locationKey}
     *
     * Due to free developers API Key there might be a limitation on accessing this API.
     *
     * @param locationKey   Specific location unique key that you retrieve from Locations API
     * @param days          Amount of daily information (1day, 5day, 10day, 15day) as an Integer
     * @param language
     * @param details
     * @param metric        Show all the metric (including Celsius), by default it only has Fahrenheit.
     *
     * @return String|null
     */
    fun getDailyForecast(locationKey: String, days: Int = 1, language: String = "en-us", details: Boolean = false, metric: Boolean = false): String? {
        val daysInString = when (days) {
            5       -> "5day"
            10      -> "10day"
            15      -> "15day"
            else    -> "1day"
        }

        val requestParams = hashMapOf<String, Any>(
            "apikey"    to accuWeather.apiKey,
            "language"  to language,
            "details"   to details,
            "metric"    to metric
        )

        val (code, body) = accuWeather.httpRequest.withGET(
            createRequest(requestParams, additionalEndPoint = "/daily/${daysInString}/${locationKey}")
        )

        return if (code == 200) body else null
    }

    /**
     * Get hourly forecast information
     * End-point: /hourly/{hoursInString}/{locationKey}
     *
     * Due to free developers API Key there might be a limitation on accessing this API.
     *
     * @param locationKey   Specific location unique key that you retrieve from Locations API
     * @param hours         Amount of hourly information (1hour, 12hour, 24hour, 72hour, 120hour) as an Integer
     * @param language
     * @param details
     * @param metric        Show all the metric (including Celsius), by default it only has Fahrenheit.
     *
     * @return String|null
     */
    fun getHourlyForecast(locationKey: String, hours: Int = 1, language: String = "en-us", details: Boolean = false, metric: Boolean = false): String? {
        val hoursInString = when (hours) {
            12      -> "12hour"
            24      -> "24hour"
            72      -> "72hour"
            120     -> "120hour"
            else    -> "1hour"
        }

        val requestParams = hashMapOf<String, Any>(
            "apikey"    to accuWeather.apiKey,
            "language"  to language,
            "details"   to details,
            "metric"    to metric
        )

        val (code, body) = accuWeather.httpRequest.withGET(
            createRequest(requestParams, additionalEndPoint = "/hourly/${hoursInString}/${locationKey}")
        )

        return if (code == 200) body else null
    }

}