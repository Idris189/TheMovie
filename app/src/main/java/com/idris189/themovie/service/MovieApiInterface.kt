package com.idris189.themovie.service

import com.idris189.themovie.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("/3/movie/popular?api_key=32cdfb1d18005856de5873cc0b789af5")
    fun getMovieList(): Call<MovieResponse>
}