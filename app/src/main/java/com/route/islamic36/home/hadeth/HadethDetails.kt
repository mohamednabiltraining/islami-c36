package com.route.islamic36.home.hadeth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.route.islamic36.R

import java.io.IOException

class HadethDetails : AppCompatActivity() {
    lateinit var hadethContent : TextView
    var hadethNum = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeth_details2)
        hadethContent = findViewById(R.id.hadethContent)
        hadethNum = intent.getIntExtra("Hadeth Num" , 1)
        Log.e("intent data passed",hadethNum.toString())
        showHadethContent(hadethNum)

    }

    private fun showHadethContent(pos:Int) {

        var hadeth  = ""

        try {
            val hadethNum : String = pos.toString()
            val inputStream = assets.open("h$hadethNum.txt")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer).toString()
            inputStream.close()
            hadeth = String(buffer)

        }
        catch (e: IOException) {
            e.printStackTrace()
        }

         hadethContent.text = hadeth
    }
}

