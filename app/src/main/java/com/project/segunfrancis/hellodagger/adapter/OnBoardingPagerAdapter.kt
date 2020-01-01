package com.project.segunfrancis.hellodagger.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.segunfrancis.hellodagger.R
import kotlinx.android.synthetic.main.item_onboarding.view.*

class OnBoardingPagerAdapter : RecyclerView.Adapter<OnBoardingPagerAdapter.OnBoardingViewHolder>() {

    private val images = intArrayOf(
        R.drawable.image_nine,
        R.drawable.image_ten,
        R.drawable.rectangle
    )

    private val titles = listOf(
        "Manage your Event with ease.",
        "Your Invitees all in One-Place.",
        "Asoebi Payment Made Easy."
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_onboarding,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) = holder.itemView.run {
        if (position == 0) {
            onboarding_textView.text = titles[position]
            onboarding_imageView.setImageResource(images[position])
        }
        if (position == 1) {
            onboarding_textView.text = titles[position]
            onboarding_imageView.setImageResource(images[position])
        }
        if (position == 2) {
            onboarding_textView.text = titles[position]
            onboarding_imageView.setImageResource(images[position])
        }
    }

    class OnBoardingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}