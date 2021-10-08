package com.swancodes.fooddecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.swancodes.fooddecider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var text = ""

    companion object {
        const val TAG = "Main Activity"
        const val KEY = "key_revenue"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate Called")

        if(savedInstanceState != null){
            text = savedInstanceState.getString(KEY, "")
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.addFoodButton.setOnClickListener {
            val newFood = binding.addFoodEditText.text.toString()

            when {
                newFood.isEmpty() -> {
                    Toast.makeText(this, "You have not entered anything.", Toast.LENGTH_LONG).show()
                }
                newFood.length < 2 -> {
                    Toast.makeText(this, "Please enter a valid food name", Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(this, "$newFood has been added successfully!", Toast.LENGTH_LONG).show()
                    binding.addFoodEditText.text.clear()
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Called")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY, text)
        Log.d(TAG, "onSaveInstance Called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.putString(KEY, text)
        Log.d(TAG, "onRestoreInstance Called")
    }
}