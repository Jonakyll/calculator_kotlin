package com.example.calculator

import android.util.Log

/**
 * File created by Jonathan CHU on 06/07/19
 */

class Calculation(var operands: MutableList<Double> = mutableListOf<Double>(), var operators: MutableList<String> = mutableListOf<String>(), var result: Double = 0.0) {

    fun addOperand(operand: String) {
        if (operand != "") {
            this.operands.add(operand.toDouble())
        }
    }

    fun addOperator(operator: String) {
        if (this.operands.size > this.operators.size) {
            this.operators.add(operator)
        }
    }

    fun deleteOperator() {
        if (this.operators.isNotEmpty()) {
            this.operators.removeAt(this.operands.lastIndex)
        }
    }

    fun calculate() {
        if (this.operands.size >= 2 && this.operators.size >= 1) {
            this.result = when (this.operators[0]) {
                "+" -> this.operands[0] + this.operands[1]
                "-" -> this.operands[0] - this.operands[1]
                "*" -> this.operands[0] * this.operands[1]
                "/" -> this.operands[0] / this.operands[1]
                else -> this.result
            }
            if (this.result != null) {
                this.operands.removeAt(0)
                this.operands[0] = this.result
                this.operators.removeAt(0)
            }
        }
    }
}