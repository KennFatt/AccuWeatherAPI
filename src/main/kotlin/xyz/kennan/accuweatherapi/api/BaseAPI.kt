package xyz.kennan.accuweatherapi.api

import xyz.kennan.accuweatherapi.AccuWeather

/** TODO: Remove accuWeather from base class. Instead, use it directly from derived classes */
open class BaseAPI(protected val accuWeather: AccuWeather, open val baseUrl: String) {

    fun createRequest(params: HashMap<String, Any>, additionalEndPoint: String = ""): String {
        var requestParams = ""
        params.forEach {
            if (requestParams.isEmpty()) {
                requestParams += "?${it.key}=${it.value}"
                return@forEach
            }

            requestParams += "&${it.key}=${it.value}"
        }
        /** TODO: Validate the baseUrl, additionalEndPoint both leading and trailing */
        return baseUrl + additionalEndPoint + requestParams
    }

}