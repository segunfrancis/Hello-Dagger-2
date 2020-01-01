package com.project.segunfrancis.hellodagger.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.project.segunfrancis.hellodagger.R
import com.project.segunfrancis.hellodagger.adapter.HomeAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), TabLayout.OnTabSelectedListener {

    override fun onTabReselected(tab: TabLayout.Tab?) {

    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        position = tab!!.position
        Log.d(TAG, "OnTabSelected Position: $position")
    }

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeAdapter: HomeAdapter
    private var position: Int = 0
    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        tabLayout = root.findViewById(R.id.tabs)
        tabLayout.addOnTabSelectedListener(this)
        if (savedInstanceState != null) {
            tabLayout.setScrollPosition(savedInstanceState.getInt("tab_position"), 0f, true)
            view_pager.currentItem = savedInstanceState.getInt("tab_position")
        }
        Log.d(TAG, "OnCreateView Position: $position")
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeAdapter = HomeAdapter(this)
        view_pager.adapter = homeAdapter
        TabLayoutMediator(tabs, view_pager) { tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
            //this.position = position
        }.attach()
        position = tabs.selectedTabPosition
        Log.d(TAG, "OnViewCreated Position: $position")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("tab_position", position)
        Log.d(TAG, "SaveInstanceState Position: $position")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("tab_position")
            tabLayout.setScrollPosition(position, 0f, true)
            view_pager.currentItem = position
        }
    }

    companion object {
        private const val TAG = "HomeFragment"
    }
}