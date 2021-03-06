@file:Suppress("DEPRECATION")

package com.nadeem.mytodo_app.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.example.androiddata.ui.main.MainViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.nadeem.mytodo_app.R
import com.nadeem.mytodo_app.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
   // private   var mapplication = getContext() as Application
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //   var mviewModel= MainViewModel(application)
        //mapplication = application
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.taskData.observe(this, Observer {
        })


        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val addTODO: FloatingActionButton = findViewById(R.id.addTDOD)
        if(tabs.selectedTabPosition == 0){
            addTODO.show()
            addTODO.setOnClickListener { view ->
        val intent = Intent(this, AddTask::class.java)
                startActivity(intent)
            }
        }

    }

}