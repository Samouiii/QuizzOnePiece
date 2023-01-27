package fr.quizzonepiece

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent

import android.widget.Button
import android.widget.TextView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

import org.w3c.dom.Text
import android.util.Log;
import androidx.constraintlayout.widget.Group
import kotlin.system.exitProcess


class Quizz : AppCompatActivity() {

    private lateinit var CheckBoxSelected: RadioButton
    private lateinit var idCheckBoxSelected:Number


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)

        // Récupération des variableExtra
        val question:String = intent.getStringExtra("question").toString()
        val answerPosssible = intent.getStringArrayListExtra("answerPossible")
        var answer = intent.getStringExtra("answer").toString()


        // Récupération des Input par ID
        val textQuestion: TextView = findViewById(R.id.question)
        val answer_1: TextView = findViewById(R.id.answer_1)
        val answer_2: TextView = findViewById(R.id.answer_2)
        val answer_3: TextView = findViewById(R.id.answer_3)
        val answer_4: TextView = findViewById(R.id.answer_4)
        val radioGroup: RadioGroup = findViewById(R.id.group_answer)
        val buttonCheck: Button = findViewById(R.id.button_check)

        // Set Question
        textQuestion.setText(question)

        // Set Réponse
        answer_1.setText(answerPosssible?.get(0))
        answer_2.setText(answerPosssible?.get(1))
        answer_3.setText(answerPosssible?.get(2))
        answer_4.setText(answerPosssible?.get(3))

        //Event Boutton click
        buttonCheck.setOnClickListener {
            idCheckBoxSelected = radioGroup.checkedRadioButtonId

            if (idCheckBoxSelected ==-1) {
                // Todo Diplay Toat "answer not selected"
                Toast.makeText(this,
                    "Aucune réponse séléctionné", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            CheckBoxSelected = findViewById(idCheckBoxSelected.toInt())
            Log.d("answerSelected", CheckBoxSelected.text.toString())
            Log.d("answer", answer)
            if(CheckBoxSelected.text.toString() == answer){
                // Todo Diplay Toat "Good Answer"
                Toast.makeText(this,
                    "Bonne réponse", Toast.LENGTH_SHORT).show()
                Log.d("resultQuizz", "Good Answer !")

            }
            else{
                // Todo Diplay Toat "Bad Answer"
                Log.d("resultQuizz", "Bad Answer !")
                Toast.makeText(this,
                    "Mauvaise réponse", Toast.LENGTH_SHORT).show()
            }
        }
    }
}