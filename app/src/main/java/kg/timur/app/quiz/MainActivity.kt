package kg.timur.app.quiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kg.timur.app.quiz.adapter.PagerAdapter
import kg.timur.app.quiz.fragments.HistoryFragment
import kg.timur.app.quiz.fragments.QuizFragment
import kg.timur.app.quiz.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuAdapter = PagerAdapter(initFragments(), supportFragmentManager)
        mainViewPager.adapter = menuAdapter

        main_bottom_nav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.quiz_fragment -> {
                    mainViewPager.currentItem = 0
                }
                R.id.history_fragment -> {
                    mainViewPager.currentItem = 1
                }
                R.id.settings_fragment -> {
                    mainViewPager.currentItem = 2
                }
            }
            true
        }

    }

    private fun initFragments(): ArrayList<Fragment>{
        return arrayListOf(
            QuizFragment.newInstance(),
            HistoryFragment.newInstance(),
            SettingsFragment.newInstance()
        )
    }
}