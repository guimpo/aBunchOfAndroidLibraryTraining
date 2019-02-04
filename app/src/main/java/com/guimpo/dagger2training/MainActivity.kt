package com.guimpo.dagger2training

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.guimpo.dagger2training.domain.entity.User
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var user: User

    @Inject
    lateinit var user1: User

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


    }
}
