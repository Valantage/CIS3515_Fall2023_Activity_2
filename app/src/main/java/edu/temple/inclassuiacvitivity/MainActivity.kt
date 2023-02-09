package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* Step 1: Populate this array */
        val numberArray = Array(50) {2 * (it + 1)}
        //Log.d("Array Value:", "Howdy")
        /* Step 2: Create adapter to display items from array in Spinner */
        spinner.adapter = FontSizeAdapter(this, numberArray)

        // Step 3: Change TextView's text size to the number selected in the Spinner */
        spinner.onItemSelectedListener = object: OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                p0?.run { ///if p0 is not null execute a function
                    // where we can reference p0
                    //run is a scope function
                    displayTextView.textSize = getItemAtPosition(p2).toString().toFloat()

                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

    }
}