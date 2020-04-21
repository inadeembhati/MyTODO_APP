package com.nadeem.mytodo_app.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddata.ui.main.MainViewModel

import com.nadeem.mytodo_app.R
import com.nadeem.mytodo_app.main.MainReclycleAdapter
import com.nadeem.mytodo_app.utilities.LOG_TAG
import kotlinx.android.synthetic.main.fragment_todo.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TodoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TodoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = "String1"
    private var param2: String? = "String2"
    private lateinit var viewModel: MainViewModel
    private  lateinit var reclyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_todo, container, false)
        reclyclerView = view.findViewById(R.id.reclyclerView)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.taskData.observe(this, Observer {

            val adapter = MainReclycleAdapter(requireContext(), it)
            reclyclerView.adapter = adapter
        })

        return  view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            TodoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
