package com.muhammaddayyanahmad.i210772

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {



    var auth = FirebaseAuth.getInstance()




    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        var auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var auth = FirebaseAuth.getInstance()


        var signup = findViewById<TextView>(R.id.signup)
        var login = findViewById<Button>(R.id.login)


        var email = findViewById<EditText>(R.id.email1)
        var pass = findViewById<EditText>(R.id.editPW)




        signup.setOnClickListener{
            val intent = Intent(this,Signup_page::class.java)
            startActivity(intent)
        }

        login.setOnClickListener{
            auth.signInWithEmailAndPassword(
                email.text.toString(),
                pass.text.toString()
            ).addOnSuccessListener {
                //val user = auth.currentUser
                startActivity(Intent(this,HomeActivity::class.java))
                finish()
            }
                .addOnFailureListener {

                    Log.e("Sigin_Error",it.message.toString())
                    Toast.makeText(this,"Failed To Sign In",Toast.LENGTH_LONG).show()

                }
        }

    }
}