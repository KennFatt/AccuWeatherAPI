package xyz.kennan.accuweatherapi.net

import java.net.HttpURLConnection
import java.net.URL

/**
 * HttpRequest class
 *
 * A class to communicate with HTTP Request.
 */
class HttpRequest {
    /**
     * HttpResponse data class
     *
     * It used to encapsulated the response from a single request.
     * Therefore, we could unpack it (destructuring declarations) to get
     * a response code and body at the same time.
     *
     * val (code, body) = HttpResponse(200, "[{}]")
     *  code -> 200
     *  body -> "[{}]"
     *
     * @param code HTTP response code
     * @param body HTTP response body
     */
    data class HttpResponse (val code: Int, val body: String)

    /**
     * Uses GET request method to access the url from `urlString`.
     *
     * @param urlString URL string
     *
     * @return HttpResponse
     */
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