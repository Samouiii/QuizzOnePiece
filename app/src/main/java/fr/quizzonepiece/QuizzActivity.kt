package fr.quizzonepiece

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.TextView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

import android.util.Log;


class QuizzActivity : AppCompatActivity() {

    private lateinit var CheckBoxSelected: RadioButton
    private lateinit var idCheckBoxSelected:Number
    private lateinit var nextActivity:Intent
    val data = Data()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz)

        // Récupération des variableExtra
        val question = intent.getStringExtra("question")
        val answerPosssible = intent.getStringArrayListExtra("answerPossible")
        var answer = intent.getStringExtra("answer")
        var step = intent.getIntExtra("step", 0)
        var result = intent.getIntExtra("result", 0)

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
                Toast.makeText(this,
                    "Aucune réponse séléctionné", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            CheckBoxSelected = findViewById(idCheckBoxSelected.toInt())
            Log.d("answerSelected", CheckBoxSelected.text.toString())
            //Log.d("answer", answer)
            if(CheckBoxSelected.text.toString() == answer){
                Toast.makeText(this,"Bonne réponse", Toast.LENGTH_SHORT).show()
                result ++
            }
            else{
                Toast.makeText(this,"Mauvaise réponse", Toast.LENGTH_SHORT).show()
            }

            step ++
            if(step == 3){
                nextActivity = Intent(this, ResultActivity::class.java)
            }
            else nextActivity = Intent(this, QuizzActivity::class.java)
            Log.d("step",step.toString())

            nextActivity.putExtra("question", data.question.get(step))
            nextActivity.putExtra("answerPossible", data.answerPossible.get(step))
            nextActivity.putExtra("answer", data.answer.get(step))
            nextActivity.putExtra("step", step)
            nextActivity.putExtra("result", result)

            startActivity(nextActivity)
        }
    }
}