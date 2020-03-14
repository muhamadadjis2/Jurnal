package com.example.versioncontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nilai1 = findViewById(R.id.etNilai1) as EditText
        val nilai2 = findViewById(R.id.etNilai2) as EditText
        val nilai3 = findViewById(R.id.etNilai3) as EditText
        val hasil = findViewById(R.id.tvHasil) as TextView

        btnHitung.setOnClickListener {
            val a: String = nilai1.text.toString()
            val b: String = nilai2.text.toString()
            val c: String = nilai3.text.toString()
            if (etNilai1.text.isEmpty() && etNilai2.text.isEmpty() && etNilai3.text.isEmpty()) {
                Toast.makeText(applicationContext, "silahkan isi", Toast.LENGTH_SHORT).show()
            } else {
                val a = a.toInt()
                val b = b.toInt()
                val c = c.toInt()
                val d = (-b+ sqrt((b*b - 4 *a*c).toDouble()))/2*a
                val e = (-b- sqrt((b*b - 4 *a*c).toDouble()))/2*a
                hasil.setText("Nilai akar adalah " + d.toString() + " dan " + e.toString())
                
            }
        }
    }
}




