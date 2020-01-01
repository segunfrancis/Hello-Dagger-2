package com.project.segunfrancis.hellodagger.ui.latest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.project.segunfrancis.hellodagger.R

class LatestFragment : Fragment() {

    lateinit var latestViewModel: LatestViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        latestViewModel = ViewModelProviders.of(this).get(LatestViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_latest, container, false)
        val textView: TextView = root.findViewById(R.id.latest_text)
        latestViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}