package com.example.androiddata.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.nadeem.mytodo_app.data.TaskRepositry
import com.nadeem.mytodo_app.utilities.DataTask

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private  val dataRepo = TaskRepositry(app)
    val taskData  = dataRepo.taskData
    fun refreshData() {
        dataRepo.refreshData()
    }




}
