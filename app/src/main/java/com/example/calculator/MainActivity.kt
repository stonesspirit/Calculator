package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val Calculate = Calculate()
    private val CalculatorButtons = CalculatorButtons()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_0.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "0") }
        bt_1.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "1") }
        bt_2.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "2") }
        bt_3.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "3") }
        bt_4.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "4") }
        bt_5.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "5") }
        bt_6.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "6") }
        bt_7.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "7") }
        bt_8.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "8") }
        bt_9.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "9") }
        plus.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "+") }
        minus.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "-") }
        multiply.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "*") }
        div.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "/") }
        bckt.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "bckt") }
        unar_minus.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "uminus") }
        dot.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), ".") }
        back.setOnClickListener { expression.text = CalculatorButtons.setText(expression.text.toString(), "back") }
        equally.setOnClickListener {
            result.text = ""
            val toast = Toast.makeText(applicationContext, "Некорректное выражение", Toast.LENGTH_SHORT)
            val toast1 = Toast.makeText(applicationContext, "Скобки не согласованы", Toast.LENGTH_SHORT)
            val toast2 = Toast.makeText(applicationContext, "Введите выраженеие", Toast.LENGTH_SHORT)
            if (expression.text.toString().isEmpty()) (toast2.show())
            else if (CalculatorButtons.endsWithOperatore(expression.text.toString())) (toast.show())
            else if(CalculatorButtons.getOpenBracketCount(expression.text.toString()) != CalculatorButtons.getCloseBracketCount(expression.text.toString())) (toast1.show())
            else {
                val res = Calculate.calculate(expression.text.toString())
                result.append(res.toString())
                expression.text = ""
            }
        }
        clear.setOnClickListener {
            expression.text = ""
            result.text = ""
        }

        }
}
