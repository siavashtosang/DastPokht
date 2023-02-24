package com.example.dastpokht

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import network.ApiFood
import network.DastpokhtAPi
import network.Hit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodSearchViewModel : ViewModel() {

    private val _hits = MutableLiveData<List<Hit>?>()
    val hits: MutableLiveData<List<Hit>?>
        get() = _hits




      fun getFoodApi() {
        DastpokhtAPi.retrofitService.getProperties(
            "pasta",
            "aeff32ad",
            "4481b20cba9b05be29907a5bef6f11a1"
        ).enqueue(object : Callback<ApiFood> {
            override fun onResponse(call: Call<ApiFood>, response: Response<ApiFood>) {

                _hits.value = response.body()?.hits
                Log.i("testlog", "onResponse >> $_hits")
            }

            override fun onFailure(call: Call<ApiFood>, t: Throwable) {

                Log.i("testlog", "onFailure ${t.message}")
            }
        })
    }

}