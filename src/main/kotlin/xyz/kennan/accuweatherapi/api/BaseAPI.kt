package xyz.kennan.accuweatherapi.api

import xyz.kennan.accuweatherapi.AccuWeather
import xyz.kennan.accuweatherapi.net.HttpRequest

open class BaseAPI(val accuWeather: AccuWeather) {
    val httpRequest: HttpRequest = HttpRequest()
}