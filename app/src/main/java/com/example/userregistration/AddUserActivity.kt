package com.example.userregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.userregistration.databinding.ActivityMainBinding

class AddUserActivity : AppCompatActivity() {

    lateinit var addUserBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addUserBinding= ActivityMainBinding.inflate(layoutInflater)
        val view = addUserBinding.root
        setContentView(view)
    }
}