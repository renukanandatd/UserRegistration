package com.example.userregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.userregistration.databinding.ActivityMainBinding

class UpdateUserActivity : AppCompatActivity() {

    lateinit var updateUserBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateUserBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = updateUserBinding.root
        setContentView(view)
    }
}