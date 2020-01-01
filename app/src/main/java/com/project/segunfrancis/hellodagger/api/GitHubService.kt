package com.project.segunfrancis.hellodagger.api

import com.project.segunfrancis.hellodagger.data.GitHubRepo
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface GitHubService {

    @GET("users/{user}/starred")
    fun getStarredRepositories(@Path("user") userName: String) : Observable<List<GitHubRepo>>
}