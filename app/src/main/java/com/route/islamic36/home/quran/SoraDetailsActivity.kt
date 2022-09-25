package com.route.islamic36.home.quran

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.route.islamic36.R
import com.route.islamic36.home.adapter.VersesAdapter


class SoraDetailsActivity : AppCompatActivity() {

    lateinit var titleTextView: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VersesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sora_details)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        titleTextView = findViewById(R.id.title_sora_view)
        initRecyclerVirw()
        val soraName:String = intent.getStringExtra(Constants.Extra_Sora_Name)as String
        val soraPos:Int = intent.getIntExtra(Constants.Extra_Sora_pos,-1)
        titleTextView.setText(soraName)

        readSoraFile(soraPos)

    }

    private fun initRecyclerVirw() {
        recyclerView = findViewById(R.id.recycler_view)
        adapter = VersesAdapter()
        recyclerView.adapter=adapter
    }

    fun readSoraFile(pos:Int){
            val fileName = "${pos+1}.txt"
            val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
            val verses :List<String> = fileContent.split("\n")
            adapter.changeData(verses)
        }
}