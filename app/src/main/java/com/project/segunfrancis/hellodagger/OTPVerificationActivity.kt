package com.project.segunfrancis.hellodagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowManager
import android.widget.EditText

class OTPVerificationActivity : AppCompatActivity() {

    lateinit var et1: EditText
    lateinit var et2: EditText
    lateinit var et3: EditText
    lateinit var et4: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otpverification)

        et1 = findViewById(R.id.editText1)
        et2 = findViewById(R.id.editText2)
        et3 = findViewById(R.id.editText3)
        et4 = findViewById(R.id.editText4)

        // Transparent status bar for Versions above KITKAT
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        et1.addTextChangedListener(GenericTextWatcher(et1, et1, et2, et3, et4))
        et2.addTextChangedListener(GenericTextWatcher(et2, et1, et2, et3, et4))
        et3.addTextChangedListener(GenericTextWatcher(et3, et1, et2, et3, et4))
        et4.addTextChangedListener(GenericTextWatcher(et4, et1, et2, et3, et4))
    }

    class GenericTextWatcher constructor(
        val view: View,
        private val et1: EditText,
        private val et2: EditText,
        private val et3: EditText,
        private val et4: EditText
    ) : TextWatcher {

        override fun afterTextChanged(editable: Editable?) {
            val text = editable.toString()
            when (view.id) {
                R.id.editText1 -> {
                    if (text.length == 1) {
                        et2.requestFocus()
                    }
                }
                R.id.editText2 -> {
                    if (text.length == 1) {
                        et3.requestFocus()
                    } else if (text.length == 0) {
                        et1.requestFocus()
                    }
                }
                R.id.editText3 -> {
                    if (text.length == 1) {
                        et4.requestFocus()
                    } else if (text.length == 0) {
                        et2.requestFocus()
                    }
                }
                R.id.editText4 -> {
                    if (text.length == 0) {
                        et3.requestFocus()
                    }
                }
            }
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }
    }
}
