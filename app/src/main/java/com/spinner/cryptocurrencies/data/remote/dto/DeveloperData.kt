package com.spinner.cryptocurrencies.data.remote.dto


import com.google.gson.annotations.SerializedName

data class DeveloperData(
    val forks: Int,
    val stars: Int,
    val subscribers: Int,
    @SerializedName("total_issues")
    val totalIssues: Int,
    @SerializedName("closed_issues")
    val closedIssues: Int,
    @SerializedName("pull_requests_merged")
    val pullRequestsMerged: Int,
    @SerializedName("pull_request_contributors")
    val pullRequestContributors: Int,
    @SerializedName("code_additions_deletions_4_weeks")
    val codeAdditionsDeletions4Weeks: CodeAdditionsDeletions4Weeks,
    @SerializedName("commit_count_4_weeks")
    val commitCount4Weeks: Int,
    @SerializedName("last_4_weeks_commit_activity_series")
    val last4WeeksCommitActivitySeries: List<Any>
)