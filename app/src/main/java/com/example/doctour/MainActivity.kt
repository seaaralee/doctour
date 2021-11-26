package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.doctour.R
import com.example.doctour.fragment.chat_fragment
import com.example.doctour.fragment.dashboard_fragment
import com.example.doctour.fragment.setting_fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dashboardFragment = dashboard_fragment()
        val chatFragment = chat_fragment()
        val settingFragment = setting_fragment()

        makeCurrentFragment (dashboardFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> makeCurrentFragment(dashboardFragment)
                R.id.lainnya -> makeCurrentFragment(chatFragment)
                R.id.settings -> makeCurrentFragment(settingFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }

    }
}