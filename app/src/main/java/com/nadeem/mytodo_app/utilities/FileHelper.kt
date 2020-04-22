package com.nadeem.mytodo_app.utilities

import android.app.Application
import android.content.Context
import java.io.File
import java.lang.Appendable
import java.nio.charset.Charset

class FileHelper {

    companion object{
        fun getTextFromResource(context: Context) : String? {

            /*return context.resources.openRawResource(resourceID).use {
                it.bufferedReader().use {
                        it.readText()
                }
            }*/
            return readTextFromFile(context as Application)
        }

        fun saveTextToFile(app:Application, json:String?){
            val file = File(app.filesDir,"task.json") //if you want to save into cache user cacheDir
            file.writeText(json ?: "", Charsets.UTF_8)
        }
        fun readTextFromFile(app: Application) :String?{
         val file = File(app.filesDir,"task.json")
            return  if(file.exists()){
                file.readText()
            }else null
        }

    }
}