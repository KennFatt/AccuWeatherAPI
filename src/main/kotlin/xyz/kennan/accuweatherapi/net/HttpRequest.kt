package xyz.kennan.accuweatherapi.net

import java.net.HttpURLConnection
import java.net.URL

data class HttpResponse (val code: Int, val body: String)

class HttpRequest {
    fun withGET(urlString: String): HttpResponse {
        var httpResponseCode = 200
        var httpResponseBody = ""

        try {
            with(URL(urlString).openConnection() as HttpURLConnection) {
                doOutput = true
                requestMethod = "GET"
                httpResponseCode = responseCode

                inputStream.bufferedReader().use {
                    it.lines().forEach {
                            line -> httpResponseBody += line
                    }
                }
            }
        } finally {
            return HttpResponse(httpResponseCode, httpResponseBody)
        }
    }
}