 package com.example.quraan.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quraan.*
import com.example.quraan.Adapters.SurasRecyclerAdabter
import kotlinx.android.synthetic.main.activity_quran.*


 /**
 * A simple [Fragment] subclass.
 * Use the [QuranFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuranFragment : Fragment() {

    val adabter = SurasRecyclerAdabter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adabter.surasList= DataHolder.ArSuras
        adabter.onItemClickListener =object :
            SurasRecyclerAdabter.OnItemClickListener {
            override fun onItemClick(pos: Int, item: String) {
                val intent = Intent(activity,
                    SuraDetalisActivity::class.java)
                intent.putExtra(Constans.EXTRA_SURA_Name,item)
                intent.putExtra(Constans.EXTRA_SURA__FILE_NAME,(""+(pos+1) + ".txt"))
                startActivity(intent)
            }
        }
        recycler_view.adapter = adabter

    }
    }


