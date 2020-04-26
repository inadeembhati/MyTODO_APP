package com.nadeem.mytodo_app.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddata.ui.main.MainViewModel
import com.nadeem.mytodo_app.R
import com.nadeem.mytodo_app.main.MainReclycleAdapter
import com.nadeem.mytodo_app.utilities.DataTask


class All_Fragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private  lateinit var reclyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_todo, container, false)
        reclyclerView = view.findViewById(R.id.reclyclerView)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.taskData.observe(this, Observer {
            val adapter = MainReclycleAdapter(requireContext(), it,"all")
            reclyclerView.adapter = adapter
        })

        return  view
    }
}
