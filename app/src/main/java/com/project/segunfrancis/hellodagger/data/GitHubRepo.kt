package com.project.segunfrancis.hellodagger.data

data class GitHubRepo(
    var id: Int,
    var name: String,
    var htmlUrl: String,
    var description: String,
    var language: String,
    var stargazersCount: Int
) {
    constructor() : this(-1, "", "", "", "", -1)
}