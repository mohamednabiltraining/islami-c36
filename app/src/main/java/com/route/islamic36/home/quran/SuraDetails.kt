package com.route.islamic36.home.quran



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import com.route.islamic36.R
import java.io.IOException


class SuraDetails : AppCompatActivity() {
    lateinit var logo:ImageView
    lateinit var suradetails:ScrollView
    lateinit var sura:TextView
     var suraNumber : Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)

        logo = findViewById(R.id.logo)
        suradetails = findViewById(R.id.suradetails)
        sura = findViewById(R.id.Sura)
        suraNumber = intent.getIntExtra("Sura_number",1)
        Log.e("intent data passed",suraNumber.toString())
        showSuraContent(suraNumber)

    }


    private fun showSuraContent(pos:Int) {

        var suraContent = ""

        try {
            var suraNum : String = pos.toString()
            val inputStream = assets.open("$suraNum.txt")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer).toString()
            inputStream.close()
            suraContent = String(buffer)

        }
        catch (e: IOException) {
            e.printStackTrace()
        }

        sura.text = suraContent
    }
}