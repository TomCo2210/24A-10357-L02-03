package dev.tomco.a24a_10357_l02_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.textview.MaterialTextView;

public class ScoreActivity extends AppCompatActivity {

    public static final String KEY_STATUS = "KEY_STATUS";
    public static final String KEY_SCORE = "KEY_SCORE";

    private MaterialTextView score_LBL_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        findViews();

        Intent previousScreen = getIntent();

        String status = previousScreen.getStringExtra(KEY_STATUS);
        int score = previousScreen.getIntExtra(KEY_SCORE,0);

        refreshUI(status, score);
    }

    private void refreshUI(String status, int score) {
        score_LBL_score.setText(status + "\n" + score);
    }

    private void findViews() {
        score_LBL_score = findViewById(R.id.score_LBL_score);
    }
}