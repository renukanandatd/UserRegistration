package com.example.userregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.userregistration.databinding.ActivityAddUserBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddUserActivity : AppCompatActivity() {

    lateinit var addUserBinding: ActivityAddUserBinding

    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    val myReference : DatabaseReference = database.reference.child("MyUsers")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addUserBinding = ActivityAddUserBinding.inflate(layoutInflater)
        val view = addUserBinding.root
        setContentView(view)

        supportActionBar?.title = "Add User"

        addUserBinding.buttonAddUser.setOnClickListener {
            addUserToDataBase()
        }
    }

    fun addUserToDataBase(){
        val name : String = addUserBinding.editName.text.toString()
        val email : String = addUserBinding.editEmail.text.toString()
        val age : Int = addUserBinding.editAge.text.toString().toInt()

        val id : String = myReference.push().key.toString()

        val user = Users(id,name,email,age)

        myReference.child(id).setValue(user).addOnCompleteListener { task ->
            if(task.isSuccessful){
                Toast.makeText(applicationContext,
                    "The new user has been added to the database",
                    Toast.LENGTH_LONG).show()
                finish()
            }else{
                Toast.makeText(applicationContext
                ,task.exception.toString()
                ,Toast.LENGTH_LONG).show()
            }
        }
    }
}