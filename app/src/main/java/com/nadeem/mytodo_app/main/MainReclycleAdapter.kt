package com.nadeem.mytodo_app.main

import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.nadeem.mytodo_app.Activity.MainActivity
import com.nadeem.mytodo_app.Fragments.TodoFragment
import com.nadeem.mytodo_app.R
import com.nadeem.mytodo_app.data.TaskRepositry
import com.nadeem.mytodo_app.utilities.DataTask
import com.nadeem.mytodo_app.utilities.LOG_TAG
import java.security.AccessController.getContext

class MainReclycleAdapter(
    val context: Context, var dataTasks: List<DataTask>,
    val tabName:String) :
    RecyclerView.Adapter<MainReclycleAdapter.ViewHolder>() {
    private  lateinit var  c:Context
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
     val taskCheckBox = itemView.findViewById<CheckBox>(R.id.checkBox)
    }

    override fun getItemCount() = dataTasks.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        c = parent.context
        val view =  inflater.inflate(R.layout.task_item_grid,parent,false)
    return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataTask  = dataTasks[position]
        with(holder) {
            taskCheckBox?.let {
                it.text = dataTask.taskName
                it.isChecked = dataTask.status == "done"
                it.isClickable = tabName == "todo"
            if(tabName == "todo"){
              it.setOnClickListener { updateTask(dataTask,c) }
            }
            }
        }
       /* with(holder){
            textChackedView?.let{
                it.text = dataTask.taskName
                it.isChecked = dataTask.status == "Done"

            }
        }*/
    }

    private fun updateTask(dataTask: DataTask,context: Context) {
        val datarepo = TaskRepositry(c.applicationContext as Application)
        datarepo.updateTask(dataTask)
        notifyDataSetChanged()

    }

}