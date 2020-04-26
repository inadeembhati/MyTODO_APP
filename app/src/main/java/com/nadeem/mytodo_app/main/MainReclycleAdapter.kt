package com.nadeem.mytodo_app.main

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.CheckBox
import android.widget.CheckedTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.nadeem.mytodo_app.R
import com.nadeem.mytodo_app.utilities.DataTask
import com.nadeem.mytodo_app.utilities.LOG_TAG
import kotlinx.android.synthetic.main.task_item_grid.view.*

class MainReclycleAdapter(val context: Context, var dataTasks: List<DataTask>,val tabName:String ) :
    RecyclerView.Adapter<MainReclycleAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
     val taskCheckBox = itemView.findViewById<CheckBox>(R.id.checkBox)
    }

    override fun getItemCount() = dataTasks.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view =  inflater.inflate(R.layout.task_item_grid,parent,false)
        Log.i(LOG_TAG,  "OnCreateViewHolder $viewType")
    return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(LOG_TAG,  "OnBindViewHolder $position")
        val dataTask  = dataTasks[position]
        with(holder) {
            taskCheckBox?.let {
                it.text = dataTask.taskName
                it.isChecked = dataTask.status == "done"
                it.isClickable = tabName == "todo"
            if(tabName == "todo"){
                it.setOnClickListener{
                    Log.i(LOG_TAG,"$tabName")
                }
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

}