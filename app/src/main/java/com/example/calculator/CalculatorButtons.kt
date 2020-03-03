package com.example.calculator

class CalculatorButtons {
    fun endsWithOperatore(text: String): Boolean {
        return text.endsWith("+") || text.endsWith("-") || text.endsWith("/") || text.endsWith("*")|| text.endsWith(".")|| text.endsWith("(")
    }

    fun endsWithNumber(text: String): Boolean {
        return text.endsWith("0") || text.endsWith("1") || text.endsWith("2") || text.endsWith("3")|| text.endsWith("4")|| text.endsWith("5") || text.endsWith("6") || text.endsWith("7") || text.endsWith("8")|| text.endsWith("9")
    }

    fun getInput(text: String) : Boolean {
        return text.isEmpty()
    }

    fun isDecimalNumber(text: String): Boolean {
        return lastNumbers(text).contains(".")
    }

    fun lastNumbers (text: String): String {
        return text.split(
            delimiters = *arrayOf("+", "-", "*", "/"),
            ignoreCase = true,
            limit = 0).last()
    }

    fun getOpenBracketCount(text: String): Int {
        return text.toList().count { it == '(' }
    }

    fun getCloseBracketCount(text: String): Int {
        return text.toList().count { it == ')' }
    }

    fun setText(text: String, buttons: String) : String {
         return when (buttons) {
             "0" ->  "${text}0"
             "1" ->  "${text}1"
             "2" ->  "${text}2"
             "3" ->  "${text}3"
             "4" ->  "${text}4"
             "5" ->  "${text}5"
             "6" ->  "${text}6"
             "7" ->  "${text}7"
             "8" ->  "${text}8"
             "9" ->  "${text}9"
             "+" ->  if (endsWithOperatore(text) || getInput(text)) (text) else ("${text}+")
             "-" ->  if (endsWithOperatore(text) || getInput(text)) (text) else ("${text}-")
             "*" ->  if (endsWithOperatore(text) || getInput(text)) (text) else ("${text}*")
             "/" ->  if (endsWithOperatore(text) || getInput(text)) (text) else ("${text}/")
             "." -> {
                 if (isDecimalNumber(text)) {
                     text
                 } else if (endsWithOperatore(text) || text.isEmpty()) {
                     "${text}0."
                 } else {
                     "$text."
                 }
             }
             "uminus" -> {
                 if (text.isEmpty()) {
                     "-"
                 } else if (text.endsWith("-")) {
                     text
                 } else if (endsWithOperatore(text)) {
                     "${text}-"
                 } else {
                     text
                 }
             }
             "back" -> if (text.isNotEmpty()) ("${text.substring(0,text.length - 1)}") else (text)
             "bckt" -> {
                 if (text.isEmpty() || endsWithOperatore(text)) {
                     "$text("
                 } else if (text.endsWith("(")) {
                     "$text("
                 } else if (text.endsWith(")")) {
                     if (getOpenBracketCount(text) >
                         getCloseBracketCount(text)
                     ) {
                         "$text)"
                     } else {
                         "$text*("
                     }
                 } else if (text.endsWith(".")) {
                     if (getOpenBracketCount(text) >
                         getCloseBracketCount(text)
                     ) {
                         "${text}0)"
                     } else {
                         "${text}0*("
                     }
                 } else if (endsWithNumber(text)) {
                     if (getOpenBracketCount(text) >
                         getCloseBracketCount(text)
                     ) {
                         "$text)"
                     } else {
                         "$text*("
                     }
                 } else {
                     "$text*("
                    }
                }
             else -> text
        }
    }
}