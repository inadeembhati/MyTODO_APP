package com.nadeem.mytodo_app.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nadeem.mytodo_app.R
import android.util.DisplayMetrics
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import com.nadeem.mytodo_app.utilities.LOG_TAG
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTask : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        var dm = DisplayMetrics()
          windowManager.defaultDisplay.getMetrics(dm)
        var width  = dm.widthPixels
        var height = dm.heightPixels

        window.setLayout((width*.8).toInt(), (height*.6).toInt())
        btn_AddTodo.setOnClickListener{

            var newTask =  txtAddTask.text
            Log.i(LOG_TAG,"${newTask.length}")
            if(newTask.isEmpty()) {
                Snackbar.make(it, "empty", Snackbar.LENGTH_LONG).show()
            }
                finish()
        }
    }
}
