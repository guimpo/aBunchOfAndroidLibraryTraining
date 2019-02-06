package com.guimpo.shopping.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.guimpo.shopping.App
import com.guimpo.shopping.data.MemoryDataBase
import com.guimpo.shopping.domain.entity.User
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import android.content.Intent
import com.guimpo.shopping.R
import com.guimpo.shopping.presentation.quotes.QuotesActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    @Inject lateinit var user: User

    @Inject lateinit var user1: User

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: ProductRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).component.inject(this)

        // user and user1 will be two different objects
        // User@14dc075b User@1cca166a
        // because we didn't annotate the function provideUser
        // with @Singleton
        Log.d("mainActivity", user.toString())
        Log.d("mainActivity", user1.toString())

        linearLayoutManager = LinearLayoutManager(this)
        rv.layoutManager = linearLayoutManager
        val products = MemoryDataBase().list() as ArrayList
        adapter = ProductRecyclerAdapter(products)
        rv.adapter = adapter

        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity(Intent(applicationContext, QuotesActivity::class.java))
            }
        }, 3000)
    }
}
