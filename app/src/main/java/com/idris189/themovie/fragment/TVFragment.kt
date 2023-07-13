package com.idris189.themovie.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.idris189.themovie.R
import com.idris189.themovie.TVAdapter
import com.idris189.themovie.model.TV
import com.idris189.themovie.model.TVResponse
import com.idris189.themovie.service.TVApiInterface
import com.idris189.themovie.service.TVApiService
import kotlinx.android.synthetic.main.fragment_tv.rv_tv
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TVFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TVFragment : Fragment() {
    private val tv = arrayListOf<TV>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_tv.layoutManager = LinearLayoutManager(this.context)
        rv_tv.setHasFixedSize(true)
        getTVData { tv : List<TV> ->
            rv_tv.adapter = TVAdapter(tv)
        }
        showRecyclerView()
    }

    private fun getTVData(callback: (List<TV>) -> Unit){
        val apiService = TVApiService.getInstance().create(TVApiInterface::class.java)
        apiService.getTVList().enqueue(object : Callback<TVResponse> {
            override fun onFailure(call: Call<TVResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<TVResponse>, response: Response<TVResponse>) {
                return callback(response.body()!!.television)
            }

        })
    }

    private fun showRecyclerView() {
        rv_tv.layoutManager = LinearLayoutManager(this.context)
        rv_tv.adapter = TVAdapter(tv)
    }
}