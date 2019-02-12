package com.guimpo.dagger2training.presentation

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.guimpo.dagger2training.R
import com.guimpo.dagger2training.data.MemoryDataBase
import com.guimpo.dagger2training.domain.entity.User
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var user: User

    @Inject lateinit var user1: User

    @Inject lateinit var msg: String

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

        linearLayoutManager = LinearLayoutManager(this)
        rv.layoutManager = linearLayoutManager
        var products = MemoryDataBase().list() as ArrayList
        adapter = ProductRecyclerAdapter(products)
        rv.adapter = adapter
    }
}
