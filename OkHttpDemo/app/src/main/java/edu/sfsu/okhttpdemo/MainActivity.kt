package edu.sfsu.okhttpdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import edu.sfsu.okhttpdemo.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(getLayoutInflater())
        val view = binding.root
        setContentView(view)

        // step2. build an instance of Retrofit
         val retrofit = Retrofit.Builder()
             .baseUrl("https://catfact.ninja/")
             .addConverterFactory(MoshiConverterFactory.create()) //remember to add a JSON converter of your choice
             .build()

        // step 3 create a service using retrofit
        val service = retrofit.create(CatFactService::class.java)

        // step 4. build a network request
        val networkCall = service.getFact()

        //net work call
        networkCall.enqueue(
            object : Callback<CatFact> {
                override fun onResponse(call: Call<CatFact>, response: Response<CatFact>) {
                    binding.catFact.text = response.body()?.fact
                }

                override fun onFailure(call: Call<CatFact>, t: Throwable) {
                    Log.w("ActivityMain", t.message.toString())
                }
            }
        )
    }

    // step 1. create the retrofit interface
    interface CatFactService {
        @GET("fact")
        fun getFact(): Call<CatFact>
    }

    // step 0. define the data class that represents the JSON
    data class CatFact(
        val fact: String,
        val length: Int
    )
}