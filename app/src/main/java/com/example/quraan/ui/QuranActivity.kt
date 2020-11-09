package com.example.quraan.ui
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quraan.*
import com.example.quraan.Adapters.SurasRecyclerAdabter
import kotlinx.android.synthetic.main.activity_quran.*

class QuranActivity : AppCompatActivity() {

    val adabter = SurasRecyclerAdabter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran)

        adabter.surasList= DataHolder.ArSuras
        adabter.onItemClickListener =object :
            SurasRecyclerAdabter.OnItemClickListener {
            override fun onItemClick(pos: Int, item: String) {
            val intent = Intent(this@QuranActivity,
                SuraDetalisActivity::class.java)
                intent.putExtra(Constans.EXTRA_SURA_Name,item)
                 intent.putExtra(Constans.EXTRA_SURA__FILE_NAME,(""+(pos+1) + ".txt"))
                startActivity(intent)
            }
        }
        recycler_view.adapter = adabter

    }

}
