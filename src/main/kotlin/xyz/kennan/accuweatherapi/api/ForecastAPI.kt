package xyz.kennan.accuweatherapi.api

import xyz.kennan.accuweatherapi.AccuWeather

class ForecastAPI (aw: AccuWeather) : BaseAPI(aw) {

    fun getDailyForecast(locationKey: String, days: Int = 1, language: String = "en-us", details: Boolean = false, metric: Boolean = false): String? {
        val daysInString = when (days) {
            5 -> "5day"
            10 -> "10day"
            15 -> "15day"
            else -> "1day"
        }

        val url =
            "http://dataservice.accuweather.com/forecasts/v1/daily/${daysInString}/${locationKey}" +
                    "?apikey=${accuWeather.apiKey}" +
                    "&language=${language}" +
                    "&details=${details}" +
                    "&metric=${metric}"

        val (code, body) = httpRequest.withGET(url)

        return when (code) {
            200 -> body
            else -> null
        }
    }

    fun getHourlyForecast(locationKey: String, hours: Int = 1, language: String = "en-us", details: Boolean = false, metric: Boolean = false): String? {
        val hoursInString = when (hours) {
            12 -> "12hour"
            24 -> "24hour"
            72 -> "72hour"
            120 -> "120hour"
            else -> "1hour"
        }

        val url =
            "http://dataservice.accuweather.com/forecasts/v1/hourly/${hoursInString}/${locationKey}" +
                    "?apikey=${accuWeather.apiKey}" +
                    "&language=${language}" +
                    "&details=${details}" +
                    "&metric=${metric}"

        val (code, body) = httpRequest.withGET(url)

        return when (code) {
            200 -> body
            else -> null
        }
    }

}