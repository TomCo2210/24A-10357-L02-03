package dev.tomco.a24a_10357_l02_03.Logic;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

import java.util.ArrayList;

import dev.tomco.a24a_10357_l02_03.Model.Country;

public class GameManager {

    private static final int ANSWER_POINTS = 10;
    private int score = 0;
    private int questionIndex = 0;
    private int wrongAnswers = 0;
    private int life;
    private ArrayList<Country> allCountries;

    public GameManager() {
        this.life = 3;
        allCountries = DataManager.getCountries();
    }

    public GameManager(int life) {
        this.life = life;
        allCountries = DataManager.getCountries();
    }

    public Country getCurrentCountry() {
        return allCountries.get(getQuestionIndex());
    }

    public int getScore() {
        return score;
    }

    public int getQuestionIndex() {
        return questionIndex;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public int getLife() {
        return life;
    }

    public boolean isGameEnded (){
        return getQuestionIndex() == allCountries.size();
    }

    public boolean isGameLost (){
        return getLife() == getWrongAnswers();
    }

    public void checkAnswer(boolean answer){
        if (getCurrentCountry().isCanEnter() == answer)
            score += ANSWER_POINTS;
        else {
            wrongAnswers++;
        }
        questionIndex++;
    }
}


