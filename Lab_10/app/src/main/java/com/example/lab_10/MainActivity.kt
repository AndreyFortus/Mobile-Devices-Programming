package com.example.lab_10

import RetrofitAPI
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_10.databinding.ActivityMainBinding
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val baseURL = "https://dummyjson.com"

    var quotesList = ArrayList<Quote>()
    lateinit var adapter: QuotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RecycleView.layoutManager = LinearLayoutManager(this)

        showQuotes()
    }

    fun showQuotes() {
        val client = OkHttpClient.Builder()
            .addInterceptor(CustomInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitAPI: RetrofitAPI = retrofit.create(RetrofitAPI::class.java)

        val call: Call<List<Quote>> = retrofitAPI.getQuotes()

        call.enqueue(object : Callback<List<Quote>> {
            override fun onResponse(call: Call<List<Quote>>, response: Response<List<Quote>>) {
                if (response.isSuccessful) {
                    Toast.makeText(applicationContext, "Data is loading", Toast.LENGTH_LONG).show()
                    binding.progressBar.isVisible = false
                    binding.RecycleView.isVisible = true

                    quotesList = response.body() as ArrayList<Quote>
                    saveQuotesToFile(quotesList)

                    adapter = QuotesAdapter(quotesList)
                    binding.RecycleView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<List<Quote>>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun saveQuotesToFile(quotes: List<Quote>) {
        val fileName = "quotes.txt"
        val file = File(filesDir, fileName)
        try {
            FileOutputStream(file).use { fos ->
                for (quote in quotes) {
                    fos.write("${quote.id} - ${quote.quote} - ${quote.quoteAuthor}\n".toByteArray())
                }
            }
            Toast.makeText(this, "Data saved to $fileName", Toast.LENGTH_LONG).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Error saving data", Toast.LENGTH_LONG).show()
        }
    }
}
