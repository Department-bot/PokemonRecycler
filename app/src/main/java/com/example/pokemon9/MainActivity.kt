package com.example.pokemon9

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var figureImage = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.Poke_button)
        val imageView = findViewById<ImageView>(R.id.imageView)

        getNextImage(button, imageView)
       /* button.setOnClickListener {

            getAstronomyPhoto(pokemonImage)
        }*/
    }



    private fun getAstronomyPhoto(){
        val client =AsyncHttpClient()
        var choice = Random.nextInt(53)
        client["https://dog.ceo/api/breeds/image/random", object :
            //"https://dog.ceo/api/breeds/image/random"
            //https://pokeapi.com/api/v2/pokemon/
            //"https://pokeapi.co/api/v2/pokemon/pikachu/
            JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
               // Log.d("success", json.jsonObject.toString())
                Log.d("Dog", "response successful$json")
                figureImage = json.jsonObject.getString("message")


            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Error", errorResponse)




            }
        }]


    }
    private fun getNextImage(button: Button, imageView: ImageView){
        button.setOnClickListener{
            //val choice = Random.nextInt(2)
          // if (choice == 0){
                getAstronomyPhoto()
           // }
            //else{
           //    getCatImageURL()
          // }
            
            Glide.with(this)
                .load(figureImage)
                .fitCenter()
                .into(imageView)
        }
    }

    private fun getCatImageURL() {
        TODO("Not yet implemented")
    }
}











