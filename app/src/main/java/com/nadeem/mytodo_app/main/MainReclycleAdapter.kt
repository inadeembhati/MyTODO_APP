package com.nadeem.mytodo_app.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.nadeem.mytodo_app.R
import com.nadeem.mytodo_app.utilities.DataTask
import com.nadeem.mytodo_app.utilities.LOG_TAG
import kotlinx.android.synthetic.main.task_item_grid.view.*

class MainReclycleAdapter(val context: Context, val dataTasks: List<DataTask>) :
    RecyclerView.Adapter<MainReclycleAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val taskCheckBox = itemView.findViewById<CheckBox>(R.id.checkBox)
    }

    override fun getItemCount() = dataTasks.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =  inflater.inflate(R.layout.task_item_grid,parent,false)
    return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataTask  = dataTasks[position]
        with(holder){
                taskCheckBox?.let{
                    it.text = dataTask.taskName
                    it.isChecked = dataTask.status == "Done"
                it.setOnClickListener{checkBoxChanged(text = dataTask.taskName)}
                }


        }
    }

    private fun checkBoxChanged(text: String) {
    Log.i(LOG_TAG,text)
    }
}