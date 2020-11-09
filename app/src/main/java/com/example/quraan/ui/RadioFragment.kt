package com.example.quraan.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.quraan.Adapters.RadioRecyclerAdabter
import com.example.quraan.ApiManager.ApiManager
import com.example.quraan.ApiManager.Model.RadioResponse
import com.example.quraan.R
import kotlinx.android.synthetic.main.fragment_radio.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.nio.channels.Channels


/**
 * A simple [Fragment] subclass.
 * Use the [RadioFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RadioFragment : Fragment() {

    val adapter = RadioRecyclerAdabter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_radio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.adapter=adapter

        //call API
         getChannelsFromApi()
    }
            private fun getChannelsFromApi(){
                ApiManager.getWebServices()
                    .getRadioChannels().enqueue(object :Callback<RadioResponse>{
                        override fun onFailure(call: Call<RadioResponse>, t: Throwable) {
                            Toast.makeText(activity,t.localizedMessage?:"Error ", Toast.LENGTH_LONG).show()
                        }

                        override fun onResponse(
                            call: Call<RadioResponse?>,
                            response: Response<RadioResponse>
                        ) {
                            progress_bar.visibility = View.GONE
                              val  channels = response.body()?.radios;
                            adapter.changeDate(channels?: listOf())
                        }

                    })
            }
    }


