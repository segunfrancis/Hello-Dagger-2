package com.project.segunfrancis.hellodagger.ui.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.project.segunfrancis.hellodagger.R
import com.project.segunfrancis.hellodagger.adapter.HomeAdapter.Companion.ARG_OBJECT
import com.project.segunfrancis.hellodagger.ui.main.PageViewModel
import kotlinx.android.synthetic.main.fragment_popular.*

class PopularFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private lateinit var popularViewModel: PopularViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        popularViewModel = ViewModelProviders.of(this).get(PopularViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_popular, container, false)
        val textView: TextView = root.findViewById(R.id.fragment_popular)
        popularViewModel.text.observe(this, Observer {
            //textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?. apply {
            fragment_popular.text = getInt(ARG_OBJECT).toString()
        }
    }
}