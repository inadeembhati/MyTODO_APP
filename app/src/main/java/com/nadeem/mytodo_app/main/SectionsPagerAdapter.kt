package com.nadeem.mytodo_app.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nadeem.mytodo_app.R
import com.nadeem.mytodo_app.Fragments.All_Fragment
import com.nadeem.mytodo_app.Fragments.Done_Fragment
import com.nadeem.mytodo_app.Fragments.TodoFragment

private val TAB_TITLES = arrayOf(
        R.string.tab_text_TODO,
        R.string.tab_text_Done,
        R.string.tab_text_All

)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
      return  when(position){
            0-> TodoFragment()
            1-> Done_Fragment()
            2->All_Fragment()
            else->TodoFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 3
    }
}