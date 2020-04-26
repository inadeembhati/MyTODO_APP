@file:Suppress("DEPRECATION")

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


class Done_Fragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private  lateinit var reclyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if(isVisibleToUser){
           // viewModel.refreshData()
            fragmentManager!!.beginTransaction().detach(this).attach(this).commit()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_todo, container, false)
        reclyclerView = view.findViewById(R.id.reclyclerView)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.refreshData()
        val newDataTask : MutableList<DataTask> = arrayListOf()
        if(viewModel.taskData.value != null) {
       for(task in viewModel.taskData.value!!){
            if(task.status == "done"){
                newDataTask.add(task)
            }
        }
        viewModel.taskData.value = newDataTask
        }
        viewModel.taskData.observe(this, Observer {
        val adapter = MainReclycleAdapter(requireContext(), it,"done")
            reclyclerView.adapter = adapter
        })

        return  view
    }
}
