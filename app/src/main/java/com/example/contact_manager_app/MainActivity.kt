package com.example.contact_manager_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.contact_manager_app.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var Database:DatabaseReference




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


            val name=findViewById<TextInputEditText>(R.id.Name)
            val eid=findViewById<TextInputEditText>(R.id.email)
            val mno=findViewById<TextInputEditText>(R.id.mobile)
            val pass=findViewById<EditText>(R.id.Password)
            binding.button.setOnClickListener {
                val uname=name.text.toString()
                val ename=eid.text.toString()
                val mobileno=mno.text.toString()
                val passwd=pass.text.toString()

                val user=User(uname,mobileno,ename,passwd)

                Database=FirebaseDatabase.getInstance().getReference("Users")
                Database.child(mobileno).setValue(user).addOnSuccessListener {
                    name.text?.clear()
                    eid.text?.clear()
                    mno.text?.clear()
                    pass.text?.clear()
                    val intent=Intent(this,MainActivity2::class.java)
                    startActivity(intent)

                    Toast.makeText(this,"User Register successfully",Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show()

                }
                binding.signintent.setOnClickListener{
                    val intent=Intent(this,MainActivity2::class.java)
                    startActivity(intent)
                }



            }





    }
}