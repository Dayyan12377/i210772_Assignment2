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
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class HomeActivity : AppCompatActivity() {



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
            setContentView(R.layout.activity_home)

            var logout = findViewById<Button>(R.id.logout)
            var mAuth = FirebaseAuth.getInstance()

            var name = findViewById<TextView>(R.id.ali)

            var user = mAuth.currentUser

            var db = Firebase.database
            var ref = db.getReference("Users")

            var currUser= mAuth.currentUser?.uid.toString()




//        ref.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                val value = dataSnapshot.getValue(String::class.java)
//                name.setText(value.name)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(this@mainScreen, "Failed to read value", Toast.LENGTH_LONG).show()
//            }
//        })

            var user1=FirebaseAuth.getInstance().currentUser?.uid

            if(user1!=null) {
                val databaseReference =
                    FirebaseDatabase.getInstance().reference.child("users").child(user1)



                databaseReference.child("name").addListenerForSingleValueEvent(object :
                    ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val value = dataSnapshot.getValue(String::class.java)

                        name.setText(value)


                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(this@HomeActivity, "Failed to read value", Toast.LENGTH_LONG)
                            .show()
                    }
                })


            }
            logout.setOnClickListener {
                mAuth.signOut()
                var intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

}
