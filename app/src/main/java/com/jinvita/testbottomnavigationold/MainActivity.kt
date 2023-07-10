package com.jinvita.testbottomnavigationold

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.jinvita.testbottomnavigationold.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setBottomNavigation()
    }

    private fun setBottomNavigation() = with(binding.bottomNavView) {
        replaceFragment(FirstFragment())
        setOnItemSelectedListener {
            val fragment = when (it.itemId) {
                R.id.firstFragment -> FirstFragment()
                R.id.secondFragment -> SecondFragment()
                R.id.thirdFragment -> ThirdFragment()
                R.id.fourthFragment -> FourthFragment()
                else -> FirstFragment()
            }
            replaceFragment(fragment)
            return@setOnItemSelectedListener true
        }
    }

    private fun replaceFragment(fragment: Fragment) = with(supportFragmentManager) {
        beginTransaction().replace(R.id.container, fragment).commit()

    }
}