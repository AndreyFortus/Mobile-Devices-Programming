import com.example.lab_10.Quote
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitAPI {
    @GET("/quotes")
    fun getQuotes(): Call<List<Quote>>

    @POST("/quotes")
    fun createQuote(@Body newQuote: Quote): Call<Quote>

    @DELETE("/quotes/{id}")
    fun deleteQuote(@Path("id") id: Int): Call<Void>
}
