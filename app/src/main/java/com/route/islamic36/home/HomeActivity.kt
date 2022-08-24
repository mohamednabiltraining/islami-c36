package com.route.islamic36.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.route.islamic36.R
import com.route.islamic36.home.hadeth.HadethFragment
import com.route.islamic36.home.quran.QuranFragment
import com.route.islamic36.home.radio.RadioFragment
import com.route.islamic36.home.tasbeh.TasbehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigation = findViewById(R.id.home_bottom_navigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            val itemId = item.itemId;
            if (itemId == R.id.navigation_quran) {
                pushFragment(QuranFragment())
            } else if (itemId == R.id.navigation_hadeth) {
                pushFragment(HadethFragment())
            } else if (itemId == R.id.navigation_radio) {
                pushFragment(RadioFragment())
            } else if (itemId == R.id.navigation_sebha) {
                pushFragment(TasbehFragment())
            }
            true;
        }
        bottomNavigation.selectedItemId = R.id.navigation_quran
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()
    }
}