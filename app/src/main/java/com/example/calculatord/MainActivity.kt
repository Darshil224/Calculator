package com.example.calculatord

import android.content.res.Configuration
import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.exp

class MainActivity : AppCompatActivity() {

    lateinit var one: TextView    // lateinit is used so that this variable can be used in any other function as well outside the main function, for using lateinit, it is  necessary to initialise the variable.
    lateinit var two: TextView
    lateinit var three: TextView
    lateinit var four: TextView
    lateinit var five: TextView
    lateinit var six: TextView
    lateinit var seven: TextView
    lateinit var eight: TextView
    lateinit var nine: TextView
    lateinit var zero: TextView
    //var oneText:Textview?= null


    lateinit var plus: TextView
    lateinit var minus: TextView
    lateinit var divide: TextView
    lateinit var multiply: TextView
    lateinit var modulo: TextView
    lateinit var equals: TextView

    lateinit var changeSign: TextView

    lateinit var decimal: TextView

    lateinit var expression: TextView
    lateinit var result: TextView

    lateinit var ac: TextView
    lateinit var back: ImageView

    //for landscape views:
    lateinit var squareRoot: TextView
    lateinit var openBracket: TextView
    lateinit var closeBracket: TextView
    lateinit var pi: TextView
    lateinit var inv: TextView
    lateinit var exponent: TextView
    lateinit var factorial: TextView
    lateinit var sine: TextView
    lateinit var cosine: TextView
    lateinit var tangent: TextView
    lateinit var e: TextView
    lateinit var ln: TextView
    lateinit var log: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)

        plus = findViewById(R.id.addition)
        minus = findViewById(R.id.subtraction)
        divide = findViewById(R.id.division)
        multiply = findViewById(R.id.multiplication)
        modulo = findViewById(R.id.modulo)
        equals = findViewById(R.id.equals)

//        changeSign = findViewById(R.id.change_sign)

        decimal = findViewById(R.id.decimal)

        expression = findViewById(R.id.expression)
        result = findViewById(R.id.result)

        ac = findViewById(R.id.ac)
        back = findViewById(R.id.back)
        //oneText=findViewById(R.id.one)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        one.setOnClickListener {
            appendText("1", true)
            it.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_PRESS)//for haptic feedback
        }
        two.setOnClickListener {
            appendText("2", true)
            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback
        }
        three.setOnClickListener {
            appendText("3", true)
            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback
        }
        four.setOnClickListener {
            appendText("4", true)
            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback
        }
        five.setOnClickListener {
            appendText("5", true)
            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback
        }
        six.setOnClickListener {
            appendText("6", true)
            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback
        }
        seven.setOnClickListener {
            appendText("7", true)
            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback
        }
        eight.setOnClickListener {
            appendText("8", true)
            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback
        }
        nine.setOnClickListener {
            appendText("9", true)
            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback
        }
        zero.setOnClickListener {
            appendText("0", true)
            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback
        }

        decimal.setOnClickListener {
            appendText(".", true)
            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback
        }


        plus.setOnClickListener {
            appendText("+", false)
            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback
        }
        minus.setOnClickListener {
            appendText("-", false)
            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback
        }
        divide.setOnClickListener {
            appendText("/", false)
            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback
        }
        multiply.setOnClickListener {
            appendText("*", false)
            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback
        }
        modulo.setOnClickListener {
            appendText("%", false)
            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback
        }
        equals.setOnClickListener {

            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback

            try {
                val expr = ExpressionBuilder(expression.text.toString()).build()
                val answer = expr.evaluate()
                result.text = answer.toString()

            } catch (e: Exception) {
                result.text = e.message

            }
        }
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            changeSign = findViewById(R.id.change_sign)
            val changeSign = findViewById<TextView>(R.id.change_sign)

            changeSign.setOnClickListener {

                it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback

                result.text = ""
                result.hint = ""

                if (expression.text.isNotEmpty() && expression.text[0] == '-') {
                    expression.text = expression.text.substring(1)
                } else {
                    expression.text = "-${expression.text}"
                }
            }

        }
//        changeSign.setOnClickListener {
//
//            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback
//
//            result.text = ""
//            result.hint = ""
//
//            if (expression.text.isNotEmpty() && expression.text[0] == '-') {
//                expression.text = expression.text.substring(1)
//            } else {
//                expression.text = "-${expression.text}"
//            }
//        }
        back.setOnClickListener {

            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback

            result.text = ""
            result.hint = ""
            val value = expression.text
            if (value.isNotEmpty()) {
                expression.text = value.substring(0, value.length - 1)
            }

        }
        ac.setOnClickListener {

            it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)//for haptic feedback

            expression.text = ""
            result.text = ""
            result.hint = ""
        }


        //landscape mode views:-

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            val squareRoot = findViewById<TextView>(R.id.squareRoot)
            val closeBracket = findViewById<TextView>(R.id.closeBracket)
            val openBracket = findViewById<TextView>(R.id.openBracket)
            val pi = findViewById<TextView>(R.id.pi)
            val inv = findViewById<TextView>(R.id.inv)
            val exponent = findViewById<TextView>(R.id.exponent)
            val factorial = findViewById<TextView>(R.id.factorial)
            val sine = findViewById<TextView>(R.id.sine)
            val cosine = findViewById<TextView>(R.id.cosine)
            val tangent = findViewById<TextView>(R.id.tangent)
            val e = findViewById<TextView>(R.id.e)
            val ln = findViewById<TextView>(R.id.ln)
            val log = findViewById<TextView>(R.id.log)


        }
    }


    private fun appendText(value: String, toBeCleared: Boolean) {


        if (result.text != "") {
            expression.text = ""
        }


        if (toBeCleared) {//value is a number
            result.text = ""
            expression.append(value)

        } else { //value is a operator
            expression.append(result.text)
            expression.append(value)
            result.text = ""
        }

        result.hint = expression.text

    }
}

