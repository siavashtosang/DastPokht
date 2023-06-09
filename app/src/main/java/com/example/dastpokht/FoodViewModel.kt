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

class FoodViewModel : ViewModel() {

    private val _hits = MutableLiveData<List<Hit>?>()
    val hits: MutableLiveData<List<Hit>?>
        get() = _hits

    var loading = MutableLiveData<Boolean?>()

    private var clickedUri: String? = null
    var findFood: Hit? = null


    fun clickedUri(uri: String?) {

        clickedUri = uri

        findFood(clickedUri)
    }

    private fun findFood(clickedUri: String?) {

        findFood = _hits.value?.find {

            it.recipe?.uri == clickedUri
        }

    }


    fun getFoodApi(foodSearch: String) {
        DastpokhtAPi.retrofitService.getProperties(
            foodSearch,
            "aeff32ad",
            "4481b20cba9b05be29907a5bef6f11a1"
        ).enqueue(object : Callback<ApiFood> {

            override fun onResponse(call: Call<ApiFood>, response: Response<ApiFood>) {

                Log.i("testLog", "onResponse --> ${response.message()}")

                _hits.value = response.body()?.hits

                loading.value = response.isSuccessful
            }

            override fun onFailure(call: Call<ApiFood>, t: Throwable) {

                Log.i("testlog", "onFailure ${t.message}")

                loading.value = t.equals(false)
            }
        })
    }

}