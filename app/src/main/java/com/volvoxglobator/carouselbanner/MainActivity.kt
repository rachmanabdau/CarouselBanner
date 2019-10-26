package com.volvoxglobator.carouselbanner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
    }
}
