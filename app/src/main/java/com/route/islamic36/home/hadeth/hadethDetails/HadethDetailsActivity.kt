package com.route.islamic36.home.hadeth.hadethDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic36.Constants
import com.route.islamic36.R
import com.route.islamic36.home.quran.suraDetails.VersesAdapter


class HadethDetailsActivity : AppCompatActivity() {
    lateinit var titleTextView: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        titleTextView = findViewById(R.id.changehadethnme)
        initRecyclerView()
        val hadethName = intent.getStringExtra(Constants.EXTRS_HADETHNAME)
        val hadethPostion = intent.getIntExtra(Constants.EXTRS_HADETHPOSTION, -1)
        titleTextView.setText(hadethName)
        readHadethFile(hadethPostion)
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recycleview_singlehadeth)
        adapter = VersesAdapter()
        recyclerView.adapter = adapter
    }

    fun readHadethFile(pos: Int) {
        val filename = "h" + "${pos + 1}.txt"
        val fileContent = assets.open(filename).bufferedReader().use { it.readText() }
        val verses: List<String> = fileContent.split("\n")
        adapter.changeData(verses)

    }
}