package com.project.segunfrancis.hellodagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.project.segunfrancis.hellodagger.adapter.OnBoardingPagerAdapter
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        onBoarding_viewPager.adapter = OnBoardingPagerAdapter()
        onBoarding_viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        indicator1.isSelected = true
                        indicator2.isSelected = false
                        indicator3.isSelected = false
                    }
                    1 -> {
                        indicator2.isSelected = true
                        indicator1.isSelected = false
                        indicator3.isSelected = false
                    }
                    2 -> {
                        indicator3.isSelected = true
                        indicator1.isSelected = false
                        indicator2.isSelected = false
                    }
                }
            }
        })
    }
}
