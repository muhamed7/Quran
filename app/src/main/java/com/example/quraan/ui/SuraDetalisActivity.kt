package com.example.quraan.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quraan.Constans
import com.example.quraan.R
import com.example.quraan.Adapters.VersesRecyclerAdabter
import kotlinx.android.synthetic.main.activity_sura_detalis.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class SuraDetalisActivity : AppCompatActivity() {
val adapter= VersesRecyclerAdabter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_detalis)

        val suraname = intent.getStringExtra(Constans.EXTRA_SURA_Name)
        val filename = intent.getStringExtra(Constans.EXTRA_SURA__FILE_NAME)
        name.setText(suraname)
        val suraContent= readSuraFile(filename)
        adapter.changeDate(suraContent)
        recycler_view.adapter=adapter
    }

    fun readSuraFile(fileName: String): MutableList<String> {

        val suraContent = mutableListOf<String>()

        var reader: BufferedReader? = null;
        try {
            reader = BufferedReader(
                InputStreamReader(getAssets().open(fileName))
            );

            // do reading, usually loop until end of file reading
            var mLine: String? = null;
            mLine = reader.readLine()
            while (mLine != null) {
                //process line
                suraContent.add(mLine)
                mLine = reader.readLine()
            }
        } catch (e: IOException) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (e: IOException) {
                    //log the exception
                }
            }

        }
        return suraContent

    }

}
