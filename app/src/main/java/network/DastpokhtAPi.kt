package network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.edamam.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DastpokhtAPiService {
    @GET("search")
    fun getProperties(
        @Query("q") querySearchFood: String,
        @Query("app_id") app_id: String,
        @Query("app_key") app_key: String
    ): Call<ApiFood>
}

object DastpokhtAPi {
    val retrofitService: DastpokhtAPiService by lazy {
        retrofit.create(DastpokhtAPiService::class.java)
    }
}