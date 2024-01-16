package com.example.contact_manager_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.contact_manager_app.databinding.ActivityMain2Binding
import com.example.contact_manager_app.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity2 : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    lateinit var binding: ActivityMain2Binding
    companion object{
        const val KEY1=" com.example.contact_manager_app.name"
        const val KEY2=" com.example.contact_manager_app.email"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val mobileid=findViewById<TextInputEditText>(R.id.uniqueMobile)
        val passwd=findViewById<EditText>(R.id.Password2)


        binding.login.setOnClickListener {
            val mobileString=mobileid.text.toString()
            if (mobileString.isNotEmpty()){
                readData(mobileString)
            }else{
                Toast.makeText(this,"Incorrect Input",Toast.LENGTH_SHORT).show()
            }

        }




    }

    private fun readData(mobileString: String) {
        databaseReference=FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(mobileString).get().addOnSuccessListener {
            if (it.exists()){
                //Welcome
                val yourname=it.child("name").value.toString()
                val youremail=it.child("email").value.toString()
                val intent=Intent(this,pageafterlogin::class.java)
                intent.putExtra(KEY1,yourname)
                intent.putExtra(KEY2,youremail)
                startActivity(intent)
            }else{
                Toast.makeText(this,"User not exits",Toast.LENGTH_SHORT).show()

            }

        }.addOnFailureListener {
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }


}