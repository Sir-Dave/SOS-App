package com.sirdave.sosapp.network

data class Request(
    var phoneNumbers: List<String>,
    var image: String,
    var location: Location,
    var id: Int? = null
)

data class Location(
    var longitude: String,
    var latitude: String
)

data class Response(
    var status: String,
    var data: Request,
    var message: String
)
