package com.example.userregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.userregistration.databinding.ActivityMainBinding
import com.example.userregistration.databinding.ActivityUpdateUserBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateUserActivity : AppCompatActivity() {

    lateinit var updateUserBinding: ActivityUpdateUserBinding

    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    val myReference : DatabaseReference = database.reference.child("MyUsers")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateUserBinding = ActivityUpdateUserBinding.inflate(layoutInflater)
        val view = updateUserBinding.root
        setContentView(view)

        supportActionBar?.title = "Update User"

        getAndSetData()

        updateUserBinding.buttonUpdateUser.setOnClickListener {

            upDateData()

        }
    }

    fun getAndSetData(){
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val age = intent.getIntExtra("age",0).toString()

        updateUserBinding.editUpdateName.setText(name)
        updateUserBinding.editUpdateEmail.setText(email)
        updateUserBinding.editUpdateAge.setText(age)
    }

    fun upDateData(){

        val updateName = updateUserBinding.editUpdateName.text.toString()
        val updateEmail = updateUserBinding.editUpdateEmail.text.toString()
        val updateAge = updateUserBinding.editUpdateAge.text.toString().toInt()
        val userId = intent.getStringExtra("id").toString()

        val userMap = mutableMapOf<String,Any>()
        userMap["userId"] = userId
        userMap["userName"] = updateName
        userMap["userEmail"] = updateEmail
        userMap["userAge"] = updateAge

        myReference.child(userId).updateChildren(userMap).addOnCompleteListener { task->

            if(task.isSuccessful){
                Toast.makeText(applicationContext,"User has been updated",Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
}