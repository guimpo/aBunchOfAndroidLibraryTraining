package com.guimpo.dagger2training.presentation

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.guimpo.dagger2training.R
import com.guimpo.dagger2training.authentication.Auth
import com.guimpo.dagger2training.authentication.AuthenticationService
import com.guimpo.dagger2training.data.MemoryDataBase
import com.guimpo.dagger2training.domain.entity.User
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var user: User

    @Inject lateinit var user1: User

    @Inject lateinit var msg: String

    @Inject lateinit var authenticationService: AuthenticationService

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: ProductRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // user and user1 will be two different objects
        // User@14dc075b User@1cca166a
        // because we didn't annotate the function provideUser
        // with @Singleton
        Log.d("mainActivity", user.toString())
        Log.d("mainActivity", user1.toString())
        Log.d("mainActivity", msg)

        val call = authenticationService.getToken(Auth(email = "nilson@email.com", password = "nilson"))
        call.enqueue(object: Callback<Auth> {
            override fun onResponse(call: Call<Auth>, response: Response<Auth>) {
                when(response.code()) {
                    200 -> {
                        Log.d("MainActivity", response.body().toString())
                    }
                }
            }

            override fun onFailure(call: Call<Auth>, t: Throwable) {
                Log.d("MainActivity", t.message)
            }
        }
       )

        linearLayoutManager = LinearLayoutManager(this)
        rv.layoutManager = linearLayoutManager
        var products = MemoryDataBase().list() as ArrayList
        adapter = ProductRecyclerAdapter(products)
        rv.adapter = adapter
    }
}
