package com.project.segunfrancis.hellodagger.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.project.segunfrancis.hellodagger.data.GitHubRepo
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

class GitHubClient private constructor() {
    private val gitHubService: GitHubService

    companion object {
        private const val GITHUB_BASE_URL = "https://api.github.com/"
        private var instance: GitHubClient? = GitHubClient()

        fun getInstance(): GitHubClient? {
            if (instance == null) {
                instance = GitHubClient()
            }
            return instance
        }
    }

    fun getStarredRepos(userName: String): Observable<List<GitHubRepo>> {
        return gitHubService.getStarredRepositories(userName)
    }

    init {
        val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
        val retrofit = Retrofit.Builder().baseUrl(GITHUB_BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        gitHubService = retrofit.create(GitHubService::class.java)
    }
}