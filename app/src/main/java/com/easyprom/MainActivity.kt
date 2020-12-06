package com.easyprom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.easyprom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // un cambio en master

        // un cambio nuevo para daniel

        //un cambio para juan
    }

}