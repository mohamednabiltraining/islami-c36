package com.route.islamic36.suraDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic36.Constants
import com.route.islamic36.R

class SuraDetailsActivity : AppCompatActivity() {

    lateinit var titleTextView: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        titleTextView = findViewById(R.id.changesuranme)
        initRecyclerView()
        val suraName = intent.getStringExtra(Constants.EXTRS_SURANAME)//key not value
        val suraPostion = intent.getIntExtra(Constants.EXTRS_SURAPOSTION, -1)
        titleTextView.setText(suraName)
        readSuraFile(suraPostion)
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recycleview_quransura)
        adapter = VersesAdapter()
        recyclerView.adapter = adapter
    }

    fun readSuraFile(pos: Int) {
        val filename = "${pos + 1}.txt"
        val fileContent = assets.open(filename).bufferedReader().use { it.readText() }
        val verses: List<String> = fileContent.split("\n")
        adapter.changeData(verses)

    }
}