package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    var isDecimal = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*FEATURES*/
        var one = findViewById<Button>(R.id.one)
        var two = findViewById<Button>(R.id.two)
        var three = findViewById<Button>(R.id.three)
        var four = findViewById<Button>(R.id.four)
        var five = findViewById<Button>(R.id.five)
        var six = findViewById<Button>(R.id.six)
        var seven = findViewById<Button>(R.id.seven)
        var eight = findViewById<Button>(R.id.eight)
        var nine = findViewById<Button>(R.id.nine)
        var zero = findViewById<Button>(R.id.zero)
        var decimalPoint = findViewById<Button>(R.id.decimalPoint)

        var add = findViewById<Button>(R.id.add)
        var sub = findViewById<Button>(R.id.sub)
        var mul = findViewById<Button>(R.id.mul)
        var div = findViewById<Button>(R.id.div)
        var cancel = findViewById<Button>(R.id.cancel)

        var result = findViewById<EditText>(R.id.result)
        var builder = StringBuilder()

        one.setOnClickListener {
            /*println("button 1 is pressed!")*/
            builder.append("1")
            result.setText(builder)
            Log.i(TAG, "button 1 is pressed!")
        }
        two.setOnClickListener {
            builder.append("2")
            result.setText(builder)
            Log.i(TAG, "button 2 is pressed!")
        }
        three.setOnClickListener {
            builder.append("3")
            result.setText(builder)
            Log.i(TAG, "button 3 is pressed!")
        }
        four.setOnClickListener {
            builder.append("4")
            result.setText(builder)
            Log.i(TAG, "button 4 is pressed!")
        }
        five.setOnClickListener {
            builder.append("5")
            result.setText(builder)
            Log.i(TAG, "button 5 is pressed!")
        }
        six.setOnClickListener {
            builder.append("6")
            result.setText(builder)
            Log.i(TAG, "button 6 is pressed!")
        }
        seven.setOnClickListener {
            builder.append("7")
            result.setText(builder)
            Log.i(TAG, "button 7 is pressed!")
        }
        eight.setOnClickListener {
            builder.append("8")
            result.setText(builder)
            Log.i(TAG, "button 8 is pressed!")
        }
        nine.setOnClickListener {
            builder.append("9")
            result.setText(builder)
            Log.i(TAG, "button 9 is pressed!")
        }
        zero.setOnClickListener {
            builder.append("0")
            result.setText(builder)
            Log.i(TAG, "button 0 is pressed!")
        }
        decimalPoint.setOnClickListener {
            if (isDecimal == false) {
                isDecimal = true
                builder.append(",")
                result.setText(builder)
                Log.i(TAG, "button , is pressed!")
            }
            else {
                Log.i(TAG, "the number is already a decimal!")
            }
        }

        add.setOnClickListener {
            builder.append("+")
            result.setText(builder)
            Log.i(TAG, "button + is pressed!")
        }
        sub.setOnClickListener {
            builder.append("-")
            result.setText(builder)
            Log.i(TAG, "button - is pressed!")
        }
        mul.setOnClickListener {
            builder.append("*")
            result.setText(builder)
            Log.i(TAG, "button * is pressed!")
        }
        div.setOnClickListener {
            builder.append("/")
            result.setText(builder)
            Log.i(TAG, "button / is pressed!")
        }
        cancel.setOnClickListener {
            if (builder.isNullOrEmpty()) {
                Log.i(TAG, "cannot cancel more!")
            }
            else {
                builder.deleteCharAt(builder.length - 1)
                result.setText(builder)
                Log.i(TAG, "cancel button is pressed!")
                if (!builder.contains(",")) {
                    isDecimal = false
                }
            }

        }
    }
}
