package com.route.islamic36.home.tasbeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.route.islamic36.R


class TasbehFragment : Fragment()  {

    lateinit var spinner:Spinner
    lateinit var counter:Button



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(
            R.layout.fragment_tasbeh,
            container, false
        )
    }

    var count = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spinner = view.findViewById(R.id.spinner1)
        counter = view.findViewById(R.id.counter)
        spinner.onItemSelectedListener = object :AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(requireActivity()," ${p0?.getItemAtPosition(p2).toString()}",Toast.LENGTH_SHORT).show()
                counter.text = "0"
                count = 0
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")

            }

        }
        counter.setOnClickListener{
            count++
            counter.text = count.toString()
            if (count == 30)
                count = 0

        }
    }
    
}


