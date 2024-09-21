package com.example.lab1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Calculator2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_2_activity)

        val input1: EditText = findViewById(R.id.number_1_value)
        val input2: EditText = findViewById(R.id.number_2_value)
        val input3: EditText = findViewById(R.id.number_3_value)
        val input4: EditText = findViewById(R.id.number_4_value)
        val input5: EditText = findViewById(R.id.number_5_value)
        val input6: EditText = findViewById(R.id.number_6_value)
        val input7: EditText = findViewById(R.id.number_7_value)
        val input8: EditText = findViewById(R.id.number_8_value)

        val result_field: TextView = findViewById(R.id.result_value)

        val backButton: Button = findViewById(R.id.back_button_1)
        val sumButton: Button = findViewById(R.id.result_button)

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        sumButton.setOnClickListener {
            val carbonContent = input1.text.toString().toFloat()
            val hydrogenContent = input2.text.toString().toFloat()
            val oxygenContent = input3.text.toString().toFloat()
            val sulfurContent = input4.text.toString().toFloat()
            val lowerHeatingValue = input5.text.toString().toFloat()
            val moistureContent = input6.text.toString().toFloat()
            val ashContent = input7.text.toString().toFloat()
            val vanadiumContent = input8.text.toString().toFloat()

            val workingCarbonContent = carbonContent*(100 - moistureContent - ashContent) / 100
            val workingHydrogenContent = hydrogenContent*(100 - moistureContent - ashContent) / 100
            val workingOxygenContent = oxygenContent*(100 - moistureContent - ashContent) / 100
            val workingSulfurContent = sulfurContent*(100 - moistureContent - ashContent) / 100
            val workingAshContent = ashContent*(100 - moistureContent) / 100
            val workingVanadiumContent = vanadiumContent*(100 - moistureContent) / 100
            val workingLowerHeatingValue = lowerHeatingValue*(100 - moistureContent - ashContent) / 100 - 0.025*lowerHeatingValue

            val results = """
            Робоча маса мазуту:
            Вуглець: $workingCarbonContent%
            Водень: $workingHydrogenContent%
            Кисень: $workingOxygenContent%
            Сірка: $workingSulfurContent%
            Зола: $workingAshContent%
            Ванадій: $workingVanadiumContent мг/кг
            Нижча теплота згоряння: $workingLowerHeatingValue МДж/кг
        """.trimIndent()



            result_field.text = results
        }

    }
}