package com.idris189.themovie.service

import com.idris189.themovie.model.TVResponse
import retrofit2.Call
import retrofit2.http.GET

interface TVApiInterface {
    @GET("/3/tv/popular?api_key=32cdfb1d18005856de5873cc0b789af5")
    fun getTVList(): Call<TVResponse>
}