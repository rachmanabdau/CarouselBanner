package com.volvoxglobator.carouselbanner

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.size
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var slideTimer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        banner_view_pager.adapter = BannerAdapter(bannerList)
        banner_view_pager.offscreenPageLimit = 1

        TabLayoutMediator(
            dotted_tab,
            banner_view_pager,
            object : TabLayoutMediator.TabConfigurationStrategy {
                override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                    // Custom your tablayout style programmatically here
                }
            }).attach()

        slideTimer = Timer()
        slideTimer.scheduleAtFixedRate(SliderTimer(), 3000, 5000)
    }

    override fun onDestroy() {
        super.onDestroy()
        slideTimer.cancel()
    }

    private inner class SliderTimer : TimerTask() {

        override fun run() {
            runOnUiThread {
                if (banner_view_pager.currentItem < bannerList.size - 1) {
                    banner_view_pager.setCurrentItem(banner_view_pager.currentItem + 1)
                } else {
                    banner_view_pager.setCurrentItem(0)
                }
                Toast.makeText(
                    this@MainActivity,
                    banner_view_pager.size.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
