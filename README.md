# AccuWeatherAPI
Unofficial AccuWeatherAPI implementation and written in Kotlin language.  
Currently, it only support **developers** API which is an API that addressed at [http://dataservice.accuweather.com](http://dataservice.accuweather.com).

## How to use
* Instantiate new instance
```kotlin
val aw = AccuWeather("{API_KEY}")
```
* Accessing Locations API and use IP Address end-point
```kotlin
val response: String? = aw.useLocationsAPI().getByIPAddress(ipaddr = "10.2.1.1")
```
**NOTE**: All the response from API classes are a String of JSON if the request successfully sent.

## TODO
* [ ] Implement more API
    * [ ] Locations
    * [x] ~~Forecast~~
    * [ ] Current Condition
    * [ ] Indices
    * [ ] Weather Alarms
    * [ ] Alerts
    * [ ] Imagery
    * [ ] Tropical
    * [ ] Translations

## Contribute
Opening new PR is free for all! Thanks for all the support and obviously special thanks for [AccuWeather](https://developer.accuweather.com/) to providing free API for developers.  

Authors: [@KennFatt](https://github.com/KennFatt)