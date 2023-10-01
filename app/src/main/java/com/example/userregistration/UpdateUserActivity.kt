package com.example.userregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.userregistration.databinding.ActivityMainBinding
import com.example.userregistration.databinding.ActivityUpdateUserBinding

class UpdateUserActivity : AppCompatActivity() {

    lateinit var updateUserBinding: ActivityUpdateUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateUserBinding = ActivityUpdateUserBinding.inflate(layoutInflater)
        val view = updateUserBinding.root
        setContentView(view)

        updateUserBinding.buttonUpdateUser.setOnClickListener {

        }
    }
}