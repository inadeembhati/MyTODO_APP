package com.nadeem.mytodo_app.Fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.androiddata.ui.main.MainViewModel

import com.nadeem.mytodo_app.R
import com.nadeem.mytodo_app.main.MainReclycleAdapter
import com.nadeem.mytodo_app.utilities.LOG_TAG
import kotlinx.android.synthetic.main.fragment_todo.*


class TodoFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private  lateinit var reclyclerView : RecyclerView
    //private var PERMISSION_REQUEST_CODE = 1001
    //private  lateinit var swipeLayout : SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       /* if(ContextCompat.checkSelfPermission(
                requireContext(),Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED
            ){

        }else{
            requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),PERMISSION_REQUEST_CODE)
        }
*/
        val view =  inflater.inflate(R.layout.fragment_todo, container, false)
        reclyclerView = view.findViewById(R.id.reclyclerView)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.taskData.observe(this, Observer {
      /// swipeLayout = view.findViewById(R.id.swipeLayoutTodo)
         //   swipeLayout.setOnRefreshListener {
           //    viewModel.refreshData()
            //}
            val adapter = MainReclycleAdapter(requireContext(), it)
            reclyclerView.adapter = adapter
          //  swipeLayout.isRefreshing = false
        })

        return  view
    }

  /*  override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
       if(requestCode == PERMISSION_REQUEST_CODE){
           if(grantResults.isNotEmpty() && grantResults[0]== PackageManager.PERMISSION_GRANTED){

           }else{
               Toast.makeText(requireContext(),"Denied",Toast.LENGTH_LONG)
                   .show()
           }
       }
    }*/

}
