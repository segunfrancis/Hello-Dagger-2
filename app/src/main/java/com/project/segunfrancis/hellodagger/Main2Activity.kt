package com.project.segunfrancis.hellodagger

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.project.segunfrancis.hellodagger.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        view_pager2.adapter = ViewPagerAdapter()
        view_pager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        indicator1.isSelected = true
                        indicator2.isSelected = false
                        indicator3.isSelected = false
                        indicator4.isSelected = false
                    }
                    1 -> {
                        indicator2.isSelected = true
                        indicator1.isSelected = false
                        indicator3.isSelected = false
                        indicator4.isSelected = false
                    }
                    2 -> {
                        indicator3.isSelected = true
                        indicator1.isSelected = false
                        indicator2.isSelected = false
                        indicator4.isSelected = false
                    }
                    3 -> {
                        indicator4.isSelected = true
                        indicator1.isSelected = false
                        indicator2.isSelected = false
                        indicator3.isSelected = false
                    }
                }
            }
        })

    }
}
