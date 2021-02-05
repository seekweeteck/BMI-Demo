package my.edu.tarc.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    //Module-level
    private lateinit var editTextNumberWeight : EditText
    private lateinit var editTextNumberHeight: EditText
    private lateinit var textViewBMI: TextView
    private lateinit var textViewStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Load the UI (layout)
        setContentView(R.layout.activity_main)

        //Link UI component (view) to local variable
        editTextNumberWeight = findViewById(R.id.editTextNumberWeight)
        editTextNumberHeight = findViewById(R.id.editTextNumberHeight)
        textViewBMI = findViewById(R.id.textViewBMI)
        textViewStatus = findViewById(R.id.textViewStatus)

        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val buttonReset: Button = findViewById(R.id.buttonReset)
        buttonCalculate.setOnClickListener {
            if(editTextNumberWeight.text.isEmpty()){
                editTextNumberWeight.setError("Valid required")
                return@setOnClickListener //stop execution here
            }

            val weight = editTextNumberWeight.text.toString().toFloat()
            val height = editTextNumberHeight.text.toString().toFloat()
            val bmi = weight/(height/100).pow(2)
            var status: String = ""

            if(bmi<=18.50){
                //textViewStatus.text = "Underweight"
                textViewStatus.text = getString(R.string.underweight)
                status = getString(R.string.underweight)
                textViewBMI.text = String.format("%4.2f", bmi)
            }else if(bmi >=25){

            }
            textViewStatus.text = String.format("%s", status)
            textViewBMI.text = String.format("%4.2f", bmi)
        }
    }
}