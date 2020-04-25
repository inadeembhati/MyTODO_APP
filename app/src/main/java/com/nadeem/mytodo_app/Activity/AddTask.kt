package com.nadeem.mytodo_app.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nadeem.mytodo_app.R
import android.util.DisplayMetrics
import com.google.android.material.snackbar.Snackbar
import com.nadeem.mytodo_app.data.TaskRepositry
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
            if(newTask.isEmpty()) {
                Snackbar.make(it, "Please add some Task", Snackbar.LENGTH_LONG).show()
            }else{
                val dataRepo = TaskRepositry(application)
                dataRepo.addTask(newTask)
            }
            finish()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
