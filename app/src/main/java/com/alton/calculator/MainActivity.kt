package com.alton.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

//private const val STATE_PENDING_OPERATION = "PendingOperation"
//private const val STATE_OPERAND1 = "Operand1"
//private const val STATE_OPERAND1_STORED = "Operand1_Stored"

class MainActivity : AppCompatActivity() {
//    private lateinit var result: EditText//If you try to access this property before it is initialized, it will throw an exception
//    private lateinit var newNumber: EditText
//    private val displayOperation by lazy(LazyThreadSafetyMode.NONE) { findViewById<TextView>(R.id.operation) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)
        viewModel.stringResult.observe(
            this,
            Observer { stringResult -> result.setText(stringResult) })
        viewModel.stringNewNumber.observe(
            this,
            Observer { stringNumber -> newNumber.setText(stringNumber) })
        viewModel.stringOperation.observe(
            this,
            Observer { stringOperation -> operation.text = stringOperation })

        val listener = View.OnClickListener { v ->
            viewModel.digitPressed((v as Button).text.toString())
        }

        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        buttonDot.setOnClickListener(listener)

        val opListener = View.OnClickListener { v ->
            viewModel.operandPressed((v as Button).text.toString())
        }

        buttonEquals.setOnClickListener(opListener)
        buttonDivide.setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)
        buttonMinus.setOnClickListener(opListener)
        buttonPlus.setOnClickListener(opListener)

        buttonNeg.setOnClickListener {
            viewModel.negPressed()
        }

        buttonClear.setOnClickListener {
            newNumber.setText("")
        }

    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        if (operand1 != null) {
//            outState.putDouble(STATE_OPERAND1, operand1!!)
//            outState.putBoolean(STATE_OPERAND1_STORED, true)
//        }
//        outState.putString(STATE_PENDING_OPERATION, pendingOperation)
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        operand1 = if (savedInstanceState.getBoolean(STATE_OPERAND1_STORED, false)) {
//            savedInstanceState.getDouble(STATE_OPERAND1)
//        } else {
//            null
//        }
//        pendingOperation = savedInstanceState.getString(STATE_PENDING_OPERATION).toString()
//        operation.text = pendingOperation
//    }


}
