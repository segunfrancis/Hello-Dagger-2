package com.project.segunfrancis.hellodagger.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.project.segunfrancis.hellodagger.ui.popular.PopularFragment

/**
 * Created by SegunFrancis
 */
class HomeAdapter(val fragment: Fragment) : FragmentStateAdapter(fragment) {

    companion object {const val ARG_OBJECT = "fragment_key"}

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
        val fragment = PopularFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment
    }
}