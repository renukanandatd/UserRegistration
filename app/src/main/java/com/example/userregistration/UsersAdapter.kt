package com.example.userregistration

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.userregistration.databinding.ActivityAddUserBinding
import com.example.userregistration.databinding.UserDataBinding

class UsersAdapter(var context : Context,
                   var userList : ArrayList<Users>) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>(){
      inner class UsersViewHolder(val adapterBinding: UserDataBinding)
          : RecyclerView.ViewHolder(adapterBinding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding = UserDataBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return UsersViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.adapterBinding.textViewName.text = userList[position].userName
        holder.adapterBinding.textViewEmail.text = userList[position].userEmail
        holder.adapterBinding.textViewAge.text = userList[position].userAge.toString()

        holder.adapterBinding.linearLayout.setOnClickListener {

            val intent = Intent(context,UpdateUserActivity::class.java)
            intent.putExtra("id",userList[position].userId)
            intent.putExtra("name",userList[position].userName)
            intent.putExtra("email",userList[position].userEmail)
            intent.putExtra("age",userList[position].userAge)
            context.startActivity(intent)
        }

    }

    fun getUserId(position : Int) : String{

        return userList[position].userId

    }
}