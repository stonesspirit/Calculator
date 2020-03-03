package com.example.calculator

import java.util.*

class Calculate {
    private val ReversePolishNotation = ReversePolishNotation()

    fun calculate(text:String) : String {

        return calc(ReversePolishNotation.parse(text)).toString()
    }

    fun calc(postfix: List<String>): Double? {
        val stack = ArrayDeque<Double>()
        for (x in postfix) {
            if (x == "+")
                stack.push(stack.pop() + stack.pop())
            else if (x == "-") {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a!! - b!!)
            } else if (x == "*")
                stack.push(stack.pop() * stack.pop())
            else if (x == "/") {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a!! / b!!)
            } else if (x == "u-")
                stack.push(-stack.pop())
            else
                stack.push(java.lang.Double.valueOf(x))
        }
        return stack.pop()
    }
}
