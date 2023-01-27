package fr.quizzonepiece
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonStart : Button = findViewById(R.id.button_start);
        buttonStart.setOnClickListener {

            val data = Data()

            // your code to perform when the user clicks on the button
            val quizzActivity = Intent(this, QuizzActivity::class.java)


            quizzActivity.putExtra("question", data.question.get(0))
            quizzActivity.putExtra("answerPossible", data.answerPossible.get(0))
            quizzActivity.putExtra("answer", data.answer.get(0))
            quizzActivity.putExtra("step", 0)
            quizzActivity.putExtra("result", 0)


            startActivity(quizzActivity)
        }
    }


}