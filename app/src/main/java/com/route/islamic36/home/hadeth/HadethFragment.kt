package com.route.islamic36.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic36.R
import com.route.islamic36.databinding.FragmentHadethBinding
import com.route.islamic36.home.adapter.HadethNameAdapter


class HadethFragment : Fragment() {


    private var _binding: FragmentHadethBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHadethBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    lateinit var recycler: RecyclerView
    lateinit var adapter: HadethNameAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler = view.findViewById(R.id.ahadeth_list)
        adapter = HadethNameAdapter(hadethList())
        adapter.onHadethSelect = object : HadethNameAdapter.onHadethClick {
            override fun onClick(pos: Int, item: String) {
                val intent = Intent(this@HadethFragment.activity, HadethDetails::class.java)
                intent.putExtra("Hadeth Num", pos)
                startActivity(intent)
            }
        }
        recycler.adapter = adapter
    }



    }


    private fun hadethList() : ArrayList<String>{

        val list = ArrayList<String>()

        for (i in 1..40 ){
            val hadethNum = "الحديث رقم $i"
            list.add(hadethNum)
        }
        return  list

    }



