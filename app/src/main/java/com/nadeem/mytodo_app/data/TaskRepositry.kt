package com.nadeem.mytodo_app.data

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.nadeem.mytodo_app.R
import com.nadeem.mytodo_app.utilities.DataTask
import com.nadeem.mytodo_app.utilities.FileHelper
import com.nadeem.mytodo_app.utilities.LOG_TAG
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class TaskRepositry(val app : Application) {

    val taskData  = MutableLiveData<List<DataTask>>()

    private  val listType = Types.newParameterizedType(
        List::class.java, DataTask::class.java
    )

    fun refreshData(){
        getTaskData()

        Log.i(LOG_TAG ,"Refreshed")
    }
    init {
        refreshData()
    }
    fun getTaskData () {
        val text = FileHelper.getTextFromResource(app, R.raw.todo)
        val moshi = Moshi.Builder()
            .build()
        val adapater : JsonAdapter<List<DataTask>> = moshi.adapter(listType)
        taskData.value = adapater.fromJson(text) ?: emptyList()
        saveDataToCache(taskData.value!!)
    }

    private  fun saveDataToCache(dataTask : List<DataTask>){
        val moshi = Moshi.Builder()
            .build()
        val adapater : JsonAdapter<List<DataTask>> = moshi.adapter(listType)
        val json = adapater.toJson(dataTask)
        FileHelper.saveTextToFile(app,json)
    }

}