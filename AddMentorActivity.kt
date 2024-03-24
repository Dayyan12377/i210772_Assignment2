package com.muhammaddayyanahmad.i210772

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class AddMentorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_mentor)

        val spinner3: Spinner = findViewById(R.id.statusSpinner)
        val adapter3: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this,
            R.array.status,
            android.R.layout.simple_spinner_item
        )

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner3.adapter=adapter3


    }
}