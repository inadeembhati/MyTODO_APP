package com.nadeem.mytodo_app.utilities

import android.content.Context

class FileHelper {

    companion object{
        fun getTextFromResource(context: Context,resourceID :Int) :String{

            return context.resources.openRawResource(resourceID).use {
                it.bufferedReader().use {
                        it.readText()
                }
            }
        }

    }
}