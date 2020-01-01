package com.project.segunfrancis.hellodagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rilixtech.widget.countrycodepicker.CountryCodePicker
import kotlinx.android.synthetic.main.activity_country_code_picker.*

class CountryCodePickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_code_picker)

        country_picker.registerPhoneNumberTextView(phone_number)
    }
}
