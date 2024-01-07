package dev.tomco.a24a_10357_l02_03;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    private MaterialTextView main_LBL_score;
    private MaterialButton main_BTN_yes;
    private MaterialButton main_BTN_no;
    private ShapeableImageView main_IMG_flag;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        main_LBL_score.setText(score + "");
        main_BTN_yes.setOnClickListener(view -> increase());
        main_BTN_no.setOnClickListener(view -> decrease());

    }

    private void increase() {
        this.score += 10;
        main_LBL_score.setText(score + "");
    }
    private void decrease() {
        this.score -= 10;
        main_LBL_score.setText(score + "");
    }
    private void findViews() {
        main_LBL_score = findViewById(R.id.main_LBL_score);
        main_BTN_yes = findViewById(R.id.main_BTN_yes);
        main_BTN_no = findViewById(R.id.main_BTN_no);
        main_IMG_flag = findViewById(R.id.main_IMG_flag);
    }
}