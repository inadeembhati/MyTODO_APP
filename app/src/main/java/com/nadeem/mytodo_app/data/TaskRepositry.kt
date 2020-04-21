package com.nadeem.mytodo_app.data

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.nadeem.mytodo_app.R
import com.nadeem.mytodo_app.utilities.DataTask
import com.nadeem.mytodo_app.utilities.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class TaskRepositry(val app : Application) {

    val taskData  = MutableLiveData<List<DataTask>>()

    private  val listType = Types.newParameterizedType(
        List::class.java, DataTask::class.java
    )

    init {
        getTaskData()
    }
    fun getTaskData () {
        val text = FileHelper.getTextFromResource(app, R.raw.todo)
        val moshi = Moshi.Builder()
            .build()
        val adapater : JsonAdapter<List<DataTask>> = moshi.adapter(listType)
        taskData.value = adapater.fromJson(text) ?: emptyList()


    }
}