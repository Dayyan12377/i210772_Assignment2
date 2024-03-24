package com.muhammaddayyanahmad.i210772

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_signup)

    var signup = findViewById<Button>(R.id.signup1)

    val auth= FirebaseAuth.getInstance()

    val spinner1: Spinner = findViewById(R.id.spinner1)
    val adapter1: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
        this,
        R.array.countries,
        android.R.layout.simple_spinner_item
    )

    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    spinner1.adapter=adapter1

    val spinner2: Spinner = findViewById(R.id.spinner2)
    val adapter2: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
        this,
        R.array.cities,
        android.R.layout.simple_spinner_item
    )

    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    spinner2.adapter=adapter2


    var email = findViewById<EditText>(R.id.email2)
    //var email=email1.text.toString()

    var pass = findViewById<EditText>(R.id.pass2)
    //var pass=pass1.text.toString()

    var name = findViewById<EditText>(R.id.name)


    var number = findViewById<EditText>(R.id.number)





    signup.setOnClickListener  {
        auth.createUserWithEmailAndPassword(email.text.toString(), pass.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    val user = auth.currentUser
                    var intent = Intent(this,HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()

                }
            }

        var user = Users(name.text.toString(),email.text.toString(),number.text.toString(),spinner1.selectedItem.toString(),spinner2.selectedItem.toString())





        //var currUser= auth.currentUser?.uid.toString()

        var user1= FirebaseAuth.getInstance().currentUser?.uid

        if (user1 != null) {

            var db = FirebaseDatabase.getInstance().reference.child("Users")

            db.child(user1).setValue(
                user
            )
                .addOnSuccessListener {
                    Toast.makeText(this,"successful", Toast.LENGTH_LONG).show()
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this,"failure", Toast.LENGTH_LONG).show()
                }
        }




    }
}

}