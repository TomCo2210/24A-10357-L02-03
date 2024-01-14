package dev.tomco.a24a_10357_l02_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import dev.tomco.a24a_10357_l02_03.Logic.GameManager;
import dev.tomco.a24a_10357_l02_03.R;

public class MainActivity extends AppCompatActivity {

    private MaterialTextView main_LBL_score;
    private MaterialTextView main_LBL_countryName;
    private MaterialButton main_BTN_yes;
    private MaterialButton main_BTN_no;
    private ShapeableImageView main_IMG_flag;
    private ShapeableImageView[] main_IMG_hearts;
    private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        gameManager = new GameManager(main_IMG_hearts.length);
        refreshUI();


        main_BTN_yes.setOnClickListener(view -> answerClicked(true));
        main_BTN_no.setOnClickListener(view -> answerClicked(false));

    }

    private void answerClicked(boolean answerClicked) {
        gameManager.checkAnswer(answerClicked);
        refreshUI();
    }

    private void refreshUI() {
        // lost:
        if (gameManager.isGameLost())
            changeActivity("GAME OVER", gameManager.getScore());
            // ended:
        else if (gameManager.isGameEnded())
            changeActivity("You WON!!!", gameManager.getScore());
            // game on:
        else {
            main_LBL_score.setText(gameManager.getScore() + "");
            main_LBL_countryName.setText(gameManager.getCurrentCountry().getName());
            main_IMG_flag.setImageResource(gameManager.getCurrentCountry().getFlagImage());
            if (gameManager.getWrongAnswers() != 0)
                main_IMG_hearts[main_IMG_hearts.length - gameManager.getWrongAnswers()].setVisibility(View.INVISIBLE);
        }
    }

    private void changeActivity(String status, int score) {
        Intent scoreIntent = new Intent(this, ScoreActivity.class);
        scoreIntent.putExtra(ScoreActivity.KEY_STATUS, status);
        scoreIntent.putExtra(ScoreActivity.KEY_SCORE, score);
        startActivity(scoreIntent);
        finish();
    }


    private void findViews() {
        main_LBL_score = findViewById(R.id.main_LBL_score);
        main_LBL_countryName = findViewById(R.id.main_LBL_countryName);
        main_BTN_yes = findViewById(R.id.main_BTN_yes);
        main_BTN_no = findViewById(R.id.main_BTN_no);
        main_IMG_flag = findViewById(R.id.main_IMG_flag);
        main_IMG_hearts = new ShapeableImageView[]{
                findViewById(R.id.main_IMG_heart1),
                findViewById(R.id.main_IMG_heart2),
                findViewById(R.id.main_IMG_heart3)
        };
    }
}