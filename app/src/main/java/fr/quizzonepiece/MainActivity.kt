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
            // your code to perform when the user clicks on the button
            val quizzActivity = Intent(this, Quizz::class.java)
            quizzActivity.putExtra("question", "Quel personnage n'est pas un grand corsaire ?")
            quizzActivity.putExtra("answerPossible", arrayListOf("Jimbe", "Boa Hancock", "Barbe Blanche", "Mihawk"))
            quizzActivity.putExtra("answer", "Barbe Blanche")
            startActivity(quizzActivity)
        }
    }


}