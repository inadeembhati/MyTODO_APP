package com.nadeem.mytodo_app.data

import android.app.Application
import android.text.Editable
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.nadeem.mytodo_app.utilities.DataTask
import com.nadeem.mytodo_app.utilities.FileHelper
import com.nadeem.mytodo_app.utilities.LOG_TAG
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.util.*


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
        val text = FileHelper.getTextFromResource(app)
        if(text.isNullOrEmpty())
            return
        val moshi = Moshi.Builder()
            .build()
        val adapater : JsonAdapter<List<DataTask>> = moshi.adapter(listType)
        taskData.value = adapater.fromJson(text) ?: emptyList()
        //saveDataToCache(taskData.value!!)
    }

    private  fun saveDataToCache(dataTask : List<DataTask>){
        val moshi = Moshi.Builder()
            .build()
        val adapater : JsonAdapter<List<DataTask>> = moshi.adapter(listType)
        val json = adapater.toJson(dataTask)
        Log.i(LOG_TAG,"Before calling Savetexttile from helper")
        FileHelper.saveTextToFile(app,json)
    }
    fun addTask(taskText: Editable) {
        var newTask = DataTask(uniqueID = UUID.randomUUID().toString(), taskName = taskText.toString(), status = "todo")
        val text = FileHelper.getTextFromResource(app)

        if (!text.isNullOrEmpty()){
        val moshi = Moshi.Builder()
            .build()
        val adapater: JsonAdapter<List<DataTask>> = moshi.adapter(listType)
        val data = (adapater.fromJson(text) ?: emptyList()).toMutableList()
        data.add(newTask)
//            taskData.value = data
            saveDataToCache(data)
        }else{
  //          taskData.value = listOf(newTask)
           saveDataToCache(listOf(newTask))
        }



        //  refreshData()

    }


}