package com.guimpo.dagger2training

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.guimpo.dagger2training.domain.User
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).component.inject(this)

        Log.d("mainActivity", user.toString())
    }
}
