package com.example.androiddata.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.nadeem.mytodo_app.data.TaskRepositry
import com.nadeem.mytodo_app.utilities.LOG_TAG

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private  val dataRepo = TaskRepositry(app)
    val taskData  = dataRepo.taskData



}
