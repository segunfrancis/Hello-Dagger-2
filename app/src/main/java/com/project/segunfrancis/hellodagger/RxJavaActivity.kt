package com.project.segunfrancis.hellodagger

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.segunfrancis.hellodagger.adapter.GitHubRepoAdapter
import com.project.segunfrancis.hellodagger.api.GitHubClient
import com.project.segunfrancis.hellodagger.data.GitHubRepo
import kotlinx.android.synthetic.main.activity_rx_java.*
import rx.Observer
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class RxJavaActivity : AppCompatActivity() {

    companion object {
        private val TAG = RxJavaActivity::class.java.simpleName
    }

    //private val adapter = GitHubRepoAdapter(repoList)
    private var subscription: Subscription? = null
    private val adapter = GitHubRepoAdapter()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_java)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        button_search.setOnClickListener {
            val username = edit_text_username.text.toString()
            if (!TextUtils.isEmpty(username)) {
                textView.text = "Loading..."
                textView.visibility = View.VISIBLE
                progressBar.visibility = View.VISIBLE
                getStarredRepos(username)
            }
        }
    }

    private fun getStarredRepos(username: String) {
        subscription = GitHubClient.getInstance()
            ?.getStarredRepos(username)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : Observer<List<GitHubRepo>> {
                override fun onNext(t: List<GitHubRepo>) {
                    Log.d(TAG, "In onNext()")
                    Log.d(TAG, "Next: $t")
                    adapter.setGitHubRepos(t)
                    textView.visibility = View.INVISIBLE
                    progressBar.visibility = View.INVISIBLE
                }

                override fun onCompleted() {
                    Log.d(TAG, "In onCompleted()")
                }

                override fun onError(e: Throwable?) {
                    e?.printStackTrace()
                    Log.d(TAG, "In onError()")
                    Log.d(TAG, "Error: ${e?.localizedMessage}")
                    progressBar.visibility = View.INVISIBLE
                    textView.text = "Error: ${e?.localizedMessage}"
                }
            })
    }

    override fun onDestroy() {
        if (subscription != null && !subscription!!.isUnsubscribed) {
            subscription!!.unsubscribe()
        }
        super.onDestroy()
    }
}