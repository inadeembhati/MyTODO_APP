package com.example.androiddata.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.nadeem.mytodo_app.R
import com.nadeem.mytodo_app.utilities.DataTask
import com.nadeem.mytodo_app.utilities.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private  val listType = Types.newParameterizedType(
        List::class.java,DataTask::class.java

    )
    init {
//        val text = FileHelper.getTextFromResources(app, R.raw.monster_data)
        val text = FileHelper.getTextFromResource(app, R.raw.todo)
        parseTest(text)
    }

    fun parseTest (text:String){
        val moshi = Moshi.Builder().build()
        val adapater :JsonAdapter<List<DataTask>> = moshi.adapter(listType)
        val taskData = adapater.fromJson(text) ?: emptyList()
        Log.i("TAG","${taskData.size}")


    }
}
