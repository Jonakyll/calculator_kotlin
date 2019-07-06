package com.example.calculator

import android.widget.EditText
import java.lang.StringBuilder

/**
 * File created by Jonathan CHU on 03/07/19
 */

enum class Feature() {
    ONE {
        override fun action(builder: StringBuilder, result: EditText, operand: StringBuilder) {
            builder.append("1")
            operand.append("1")
            result.setText(builder)
        }
    },
    TWO {
        override fun action(builder: StringBuilder, result: EditText, operand: StringBuilder) {
            builder.append("2")
            operand.append("2")
            result.setText(builder)
        }
    },
    THREE {
        override fun action(builder: StringBuilder, result: EditText, operand: StringBuilder) {
            builder.append("3")
            operand.append("3")
            result.setText(builder)
        }
    },
    FOUR {
        override fun action(builder: StringBuilder, result: EditText,  operand: StringBuilder) {
            builder.append("4")
            operand.append("4")
            result.setText(builder)
        }
    },
    FIVE {
        override fun action(builder: StringBuilder, result: EditText, operand: StringBuilder) {
            builder.append("5")
            operand.append("5")
            result.setText(builder)
        }
    },
    SIX {
        override fun action(builder: StringBuilder, result: EditText, operand: StringBuilder) {
            builder.append("6")
            operand.append("6")
            result.setText(builder)
        }
    },
    SEVEN {
        override fun action(builder: StringBuilder, result: EditText, operand: StringBuilder) {
            builder.append("7")
            operand.append("7")
            result.setText(builder)
        }
    },
    EIGHT {
        override fun action(builder: StringBuilder, result: EditText, operand: StringBuilder) {
            builder.append("8")
            operand.append("8")
            result.setText(builder)
        }
    },
    NINE {
        override fun action(builder: StringBuilder, result: EditText, operand: StringBuilder) {
            builder.append("9")
            operand.append("9")
            result.setText(builder)
        }
    },
    ZERO {
        override fun action(builder: StringBuilder, result: EditText, operand: StringBuilder) {
            builder.append("0")
            operand.append("0")
            result.setText(builder)
        }
    },
    DECIMAL_POINT {
        override fun action(builder: StringBuilder, result: EditText, operand: StringBuilder) {
            builder.append(",")
            result.setText(builder)
        }
    },
    ADD {
        override fun action(builder: StringBuilder, result: EditText, operand: StringBuilder) {
            builder.append("+")
            result.setText(builder)
        }
    },
    SUB {
        override fun action(builder: StringBuilder, result: EditText, operand: StringBuilder) {
            builder.append("-")
            result.setText(builder)
        }
    },
    MUL {
        override fun action(builder: StringBuilder, result: EditText, operand: StringBuilder) {
            builder.append("*")
            result.setText(builder)
        }
    },
    DIV {
        override fun action(builder: StringBuilder, result: EditText, operand: StringBuilder) {
            builder.append("/")
            result.setText(builder)
        }
    },
    CANCEL {
        override fun action(builder: StringBuilder, result: EditText, operand: StringBuilder) {
            builder.deleteCharAt(builder.length - 1)
            result.setText(builder)
        }
    },
    EQUALS {
        override fun action(builder: StringBuilder, result: EditText, operand: StringBuilder) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    };

    abstract fun action(builder: StringBuilder, result: EditText, operand: StringBuilder)

    fun cancelPreviousOperator(builder: StringBuilder, result: EditText) {
        builder.deleteCharAt(builder.length - 1)
        builder.append(when (this) {
            ADD -> "+"
            SUB -> "-"
            MUL -> "*"
            DIV -> "/"
            else -> ""
        })
        result.setText(builder)
    }
}