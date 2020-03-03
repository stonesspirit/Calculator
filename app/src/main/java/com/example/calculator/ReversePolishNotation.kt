package com.example.calculator
import java.util.*

class ReversePolishNotation {
    private val operators = "+-*/"
    private val delimiters = "() $operators"
    private fun isDelimiter(token: String): Boolean {
        if (token.length != 1) return false
        for (i in 0 until delimiters.length) {
            if (token[0] == delimiters[i]) return true
        }
        return false
    }

    private fun isOperator(token: String): Boolean {
        if (token == "u-") return true
        for (i in 0 until operators.length) {
            if (token[0] == operators[i]) return true
        }
        return false
    }

    private fun priority(token: String): Int {
        if (token == "(") return 1
        if (token == "+" || token == "-") return 2
        return if (token == "*" || token == "/") 3 else 4
    }

    fun parse(infix: String): List<String> {
        val postfix = ArrayList<String>()
        val stack = ArrayDeque<String>()
        val tokenizer = StringTokenizer(infix, delimiters, true)
        var prev = ""
        while (tokenizer.hasMoreTokens()) {
            var curr = tokenizer.nextToken()
            if (curr == " ") continue
            else if (isDelimiter(curr)) {
                if (curr == "(")
                    stack.push(curr)
                else if (curr == ")") {
                    stack.pop()
                } else {
                    if (curr == "-" && (prev == "" || isDelimiter(prev) && prev != ")")) {
                        curr = "u-"
                    } else {
                        while (!stack.isEmpty() && priority(curr) <= priority(stack.peek()!!)) {
                            postfix.add(stack.pop())
                        }

                    }
                    stack.push(curr)
                }

            } else {
                postfix.add(curr)
            }
            prev = curr
        }

        while (!stack.isEmpty()) {
            if (isOperator(stack.peek()!!))
                postfix.add(stack.pop())
        }
        return postfix
    }
}


