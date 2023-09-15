package com.mcl.eletriccarapp.ui

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mcl.eletriccarapp.R

class CalculateAutonomyActivity : AppCompatActivity() {
    lateinit var price: EditText
    lateinit var kmTravel: EditText
    lateinit var btnCalculate: Button
    lateinit var calcResult: TextView
    lateinit var btnClose: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_autonomy)
        setupView()
        setupListeners()
        setupCachedResult()
    }

    private fun setupCachedResult() {
        val calculateValue = getSharedPref()
        calcResult.text = calculateValue.toString()
    }

    fun setupView(){
        price = findViewById(R.id.et_price_kwh)
        kmTravel = findViewById(R.id.et_travel_km)
        btnCalculate = findViewById(R.id.bt_calculator)
        calcResult = findViewById(R.id.tv_result_value)
        btnClose = findViewById(R.id.iv_close)
    }

    fun setupListeners(){
        btnCalculate.setOnClickListener { calculate() }
        btnClose.setOnClickListener{ finish() }
    }

    fun calculate() {
        val price = price.text.toString().toFloat()
        val km = kmTravel.text.toString().toFloat()
        val result = (price / km)

        calcResult.text = result.toString()
        saveSharedPref(result)
    }

    fun saveSharedPref(result: Float){
        val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()){
            putFloat(getString(R.string.string_saved_calc), result)
            apply()
        }
    }

    fun getSharedPref(): Float {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        return sharedPref.getFloat(getString(R.string.string_saved_calc), 0.0f)
    }
}