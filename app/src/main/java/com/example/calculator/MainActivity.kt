package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    var isDecimal = false
    var operator = false

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
        var equals = findViewById<Button>(R.id.equals)

        var result = findViewById<EditText>(R.id.result)
        var finalResult = findViewById<EditText>(R.id.finalResult)
        var builder = StringBuilder()

        lateinit var button: Feature

        /*CALCULATION*/
        var calculation: Calculation = Calculation()
        var operand: StringBuilder = StringBuilder()

        one.setOnClickListener {
            button = Feature.ONE
            button.action(builder, result, operand)
            operator = false
            Log.i(TAG, "button 1 is pressed!")
        }
        two.setOnClickListener {
            button = Feature.TWO
            button.action(builder, result, operand)
            operator = false
            Log.i(TAG, "button 2 is pressed!")
        }
        three.setOnClickListener {
            button = Feature.THREE
            button.action(builder, result, operand)
            operator = false
            Log.i(TAG, "button 3 is pressed!")
        }
        four.setOnClickListener {
            button = Feature.FOUR
            button.action(builder, result, operand)
            operator = false
            Log.i(TAG, "button 4 is pressed!")
        }
        five.setOnClickListener {
            button = Feature.FIVE
            button.action(builder, result, operand)
            operator = false
            Log.i(TAG, "button 5 is pressed!")
        }
        six.setOnClickListener {
            button = Feature.SIX
            button.action(builder, result, operand)
            operator = false
            Log.i(TAG, "button 6 is pressed!")
        }
        seven.setOnClickListener {
            button = Feature.SEVEN
            button.action(builder, result, operand)
            operator = false
            Log.i(TAG, "button 7 is pressed!")
        }
        eight.setOnClickListener {
            button = Feature.EIGHT
            button.action(builder, result, operand)
            operator = false
            Log.i(TAG, "button 8 is pressed!")
        }
        nine.setOnClickListener {
            button = Feature.NINE
            button.action(builder, result, operand)
            operator = false
            Log.i(TAG, "button 9 is pressed!")
        }
        zero.setOnClickListener {
            button = Feature.ZERO
            button.action(builder, result, operand)
            operator = false
            Log.i(TAG, "button 0 is pressed!")
        }
        decimalPoint.setOnClickListener {
            button = Feature.DECIMAL_POINT
            if (isDecimal == false) {
                isDecimal = true
                button = Feature.DECIMAL_POINT
                button.action(builder, result, operand)
                Log.i(TAG, "button , is pressed!")
            }
            else {
                Log.i(TAG, "the number is already a decimal!")
            }
        }

        add.setOnClickListener {
            button = Feature.ADD
            if (operator == true) {
                calculation.deleteOperator()
                calculation.addOperator("+")
                button.cancelPreviousOperator(builder, result)
            }
            else {
                calculation.addOperand(operand.toString())
                calculation.addOperator("+")
                button.action(builder, result, operand)
                operator = true
            }
            Log.i(TAG, "${calculation.operands}, ${calculation.operators}, ${calculation.result}")
            operand.clear()
            calculation.calculate()
            Log.i(TAG, "${calculation.operands}, ${calculation.operators}, ${calculation.result}")
            Log.i(TAG, "button + is pressed!")
        }
        sub.setOnClickListener {
            button = Feature.SUB
            if (operator == true) {
                calculation.deleteOperator()
                calculation.addOperator("-")
                button.cancelPreviousOperator(builder, result)
            }
            else {
                calculation.addOperand(operand.toString())
                calculation.addOperator("-")
                button.action(builder, result, operand)
                operator = true
            }
            Log.i(TAG, "${calculation.operands}, ${calculation.operators}, ${calculation.result}")
            operand.clear()
            calculation.calculate()
            Log.i(TAG, "${calculation.operands}, ${calculation.operators}, ${calculation.result}")
            Log.i(TAG, "button - is pressed!")
        }
        mul.setOnClickListener {
            button = Feature.MUL
            if (operator == true) {
                calculation.deleteOperator()
                calculation.addOperator("*")
                button.cancelPreviousOperator(builder, result)
            }
            else {
                calculation.addOperand(operand.toString())
                calculation.addOperator("*")
                button.action(builder, result, operand)
                operator = true
            }
            operand.clear()
            calculation.calculate()
            Log.i(TAG, "${calculation.operands}, ${calculation.operators}, ${calculation.result}")
            Log.i(TAG, "button * is pressed!")
        }
        div.setOnClickListener {
            button = Feature.DIV
            if (operator == true) {
                calculation.deleteOperator()
                calculation.addOperator("/")
                button.cancelPreviousOperator(builder, result)
            }
            else {
                calculation.addOperand(operand.toString())
                calculation.addOperator("/")
                button.action(builder, result, operand)
                operator = true
            }
            operand.clear()
            calculation.calculate()
            Log.i(TAG, "${calculation.operands}, ${calculation.operators}, ${calculation.result}")
            Log.i(TAG, "button / is pressed!")
        }
        cancel.setOnClickListener {
            if (builder.isNullOrEmpty()) {
                Log.i(TAG, "cannot cancel more!")
            }
            else {
                button = Feature.CANCEL
                button.action(builder, result, operand)
                Log.i(TAG, "cancel button is pressed!")
                if (!builder.contains(",")) {
                    isDecimal = false
                }
            }
        }
        equals.setOnClickListener {
            if (calculation.operands.size == 0 && calculation.operators.size == 0) {

            }
            else {
                calculation.addOperand(operand.toString())
                operand.clear()
                calculation.calculate()
            }
            Log.i(TAG, "${calculation.operands}, ${calculation.operators}, ${calculation.result}")
            finalResult.setText(calculation.result.toString())
        }
    }
}
