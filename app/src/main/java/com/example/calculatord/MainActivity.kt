package com.example.calculatord

import android.os.Bundle
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


    lateinit var plus:TextView
    lateinit var minus:TextView
    lateinit var divide:TextView
    lateinit var multiply:TextView
    lateinit var modulo:TextView
    lateinit var equals:TextView

    lateinit var changeSign:TextView

    lateinit var decimal:TextView

    lateinit var expression:TextView
    lateinit var result:TextView

    lateinit var ac:TextView
    lateinit var back:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        one=findViewById(R.id.one)
        two=findViewById(R.id.two)
        three=findViewById(R.id.three)
        four=findViewById(R.id.four)
        five=findViewById(R.id.five)
        six=findViewById(R.id.six)
        seven=findViewById(R.id.seven)
        eight=findViewById(R.id.eight)
        nine=findViewById(R.id.nine)
        zero=findViewById(R.id.zero)

        plus=findViewById(R.id.addition)
        minus=findViewById(R.id.subtraction)
        divide=findViewById(R.id.division)
        multiply=findViewById(R.id.multiplication)
        modulo=findViewById(R.id.modulo)
        equals=findViewById(R.id.equals)

        changeSign=findViewById(R.id.change_sign)

        decimal=findViewById(R.id.decimal)

        expression=findViewById(R.id.expression)
        result=findViewById(R.id.result)

        ac=findViewById(R.id.ac)
        back=findViewById(R.id.back)
        //oneText=findViewById(R.id.one)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        one.setOnClickListener{
            appendText("1",  true)
        }
        two.setOnClickListener{
            appendText("2",  true)
        }
        three.setOnClickListener{
            appendText("3",  true)
        }
        four.setOnClickListener{
            appendText("4",  true)
        }
        five.setOnClickListener{
            appendText("5",true)
        }
        six.setOnClickListener{
            appendText("6",  true)
        }
        seven.setOnClickListener{
            appendText("7",  true)
        }
        eight.setOnClickListener{
            appendText("8",  true)
        }
        nine.setOnClickListener{
            appendText("9",  true)
        }
        zero.setOnClickListener{
            appendText("0",  true)
        }

        decimal.setOnClickListener{
            appendText(".",  true)
        }


        plus.setOnClickListener{
            appendText("+",  false)
        }
        minus.setOnClickListener{
            appendText("-",  false)
        }
        divide.setOnClickListener{
            appendText("/",  false)
        }
        multiply.setOnClickListener{
            appendText("*",  false)
        }
        modulo.setOnClickListener{
            appendText("%",  false)
        }
        equals.setOnClickListener{
            try {
                val expr=ExpressionBuilder(expression.text.toString()).build()
                val answer= expr.evaluate()
                result.text=answer.toString()

            }catch (e:Exception){
                result.text=e.message

            }
        }
        changeSign.setOnClickListener{
            result.text=""
            result.hint=""

            if(expression.text.isNotEmpty()&&expression.text[0]=='-'){
                expression.text=expression.text.substring(1)
            }else{
                expression.text="-${expression.text}"
            }
        }
        back.setOnClickListener{
            result.text= ""
            result.hint=""
            val value = expression.text
            if (value.isNotEmpty()){
                expression.text=value.substring(0,value.length-1)
            }

        }
        ac.setOnClickListener{
            expression.text=""
            result.text=""
            result.hint=""
        }



    }
    private fun appendText(value:String,toBeCleared:Boolean){


        if (result.text!=""){
            expression.text=""
        }


        if (toBeCleared){//value is a number
            result.text=""
            expression.append(value)

        }else{ //value is a operator
            expression.append(result.text)
            expression.append(value)
            result.text=""
        }

        result.hint=expression.text

    }

}