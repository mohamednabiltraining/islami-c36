package com.route.islamic36

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.route.Constants
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var versesList: List<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        val name: String = intent.getStringExtra(Constants.EXTRA_SURA_NAME) ?: "";
        val pos: Int = intent.getIntExtra(Constants.EXTRA_SURA_POS, 0)
        readSura(pos)
    }

    fun readSura(pos: Int) {
        val myLines = mutableListOf<String>()
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(InputStreamReader(assets.open("${pos + 1}.txt")))
            var mLine: String?
            while (reader.readLine().also { mLine = it } != null) {
                myLines.add(mLine!!);
            }
        } catch (e: IOException) {
            Log.e("sura-details", "error reading file");
        } finally {
            if (reader != null) {
                try {
                    reader.close()
                } catch (e: IOException) {
                }
            }
        }
        versesList = myLines;
    }
}