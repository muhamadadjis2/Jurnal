@file:Suppress("DEPRECATION")

package com.example.jurnal6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.courtcounter.MainViewModel
import com.example.jurnal6.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {


    private lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val B: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        B.btnTrii.setOnClickListener {
            viewModel.addScore(3,"a")
        }
        B.btnTw.setOnClickListener {
            viewModel.addScore(2,"a")
        }
        B.btnOnee.setOnClickListener {
            viewModel.addScore(1,"a")
        }

        B.btnTri.setOnClickListener {
            viewModel.addScore(3,"b")
        }
        B.btnTwoo.setOnClickListener {
            viewModel.addScore(2,"b")
        }
        B.btnOne.setOnClickListener {
            viewModel.addScore(1,"b")
        }
        B.btnReset.setOnClickListener {
            viewModel.resetScore()
        }

        viewModel.scorea.observe(this, Observer { newScorea ->
            B.teamAScore.text = newScorea.toString()
        })
        viewModel.scoreb.observe(this, Observer { newScoreb ->
            B.teamBScore.text = newScoreb.toString()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === R.id.aboutFragment) {
            startActivity(Intent(this, About::class.java))
        }
        return true
    }
}
