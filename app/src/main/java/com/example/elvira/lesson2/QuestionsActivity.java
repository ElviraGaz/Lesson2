package com.example.elvira.lesson2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import static android.widget.Toast.*;

/**
 * Created by bibi1 on 13.08.2017.
 */
public class QuestionsActivity extends AppCompatActivity {
    private String[][] questions;
    private int correctAnswerCount = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);
        LinearLayout questionsLL = (LinearLayout) findViewById(R.id.questions);
        final TextView correctAnswerLabel = (TextView) findViewById(R.id.counter);


        OnClickListener listenerCorrect = new OnClickListener() {
            @Override
            public void onClick(final View v) {
                v.setBackgroundColor(Color.YELLOW);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        v.setBackgroundResource(android.R.drawable.btn_default);
                    }
                }, 2000);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        v.setBackgroundColor(Color.GREEN);
                        Toast.makeText(QuestionsActivity.this, "Молодец!", LENGTH_SHORT).show();
                    }
                }, 1000);

                correctAnswerCount++;
                correctAnswerLabel.setText("Количество правильных ответов: " + correctAnswerCount);
            }
        };

        OnClickListener listenerIncorrect = new OnClickListener() {
            @Override
            public void onClick(final View v) {
                v.setBackgroundColor(Color.YELLOW);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        v.setBackgroundResource(android.R.drawable.btn_default);
                    }
                }, 2000);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        v.setBackgroundColor(Color.RED);
                        Toast.makeText(QuestionsActivity.this, "Ой! Это неправильный ответ!", LENGTH_SHORT).show();
                    }
                }, 1000);
                correctAnswerCount = 0;
                correctAnswerLabel.setText("Количество правильных ответов: " + correctAnswerCount);
            }
        };


        addQuestions();
        List<Integer> indexQuestion = new ArrayList<>();
        List<Integer> indexAnswer = new ArrayList<>();

        for (int i = 0; i < questions.length; i++)
            indexQuestion.add(i);
        int j = 1;
        int randomIndexQuestion;
        while (indexQuestion.size() > 0) {
            LinearLayout questionLinearLayout1 = new LinearLayout(this);
            LinearLayout.LayoutParams paramsMatchWrap =  new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            paramsMatchWrap.setMargins(0,0 ,0, 60);
            questionLinearLayout1.setLayoutParams(paramsMatchWrap);
            questionLinearLayout1.setOrientation(LinearLayout.VERTICAL);
            questionsLL.addView(questionLinearLayout1);


            LayoutParams params =  new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            TextView textViewQuestion = new TextView(this);
            randomIndexQuestion = getRandomIndex(indexQuestion.size());
            textViewQuestion.setText( j +". " + questions[indexQuestion.get(randomIndexQuestion)][0]);
            textViewQuestion.setTextSize(18);
            questionLinearLayout1.addView(textViewQuestion, params);

            for (int i = 1; i <= 4; i++)
                indexAnswer.add(i);

            while (indexAnswer.size() > 0) {
                int randomIndexAnswer = getRandomIndex(indexAnswer.size());
                Button buttonAnswer = new Button(this);
                buttonAnswer.setText(questions[indexQuestion.get(randomIndexQuestion)][indexAnswer.get(randomIndexAnswer)]);
                questionLinearLayout1.addView(buttonAnswer, params);
                if (indexAnswer.get(randomIndexAnswer) == 1)
                    buttonAnswer.setOnClickListener(listenerCorrect);
                else buttonAnswer.setOnClickListener(listenerIncorrect);
                indexAnswer.remove(randomIndexAnswer);
            }
            indexQuestion.remove(randomIndexQuestion);
            j++;
        }

    }

    private void addQuestions() {
        questions = new String[][]{{"Сколько лун имеет Марс?", "2", "4", "3", "1"},
                {"По наличию какого неорганического вещества планета Марс получила название «красная планета»?", "Оксид железа", "Оксид серы", "Оксид водорода", "Нет правильного ответа"},
                {"Как называется самая высокая гора в Солнечной системе и на Марсе?", "Олимп", "Эолида", "Горы Митчела", "Эверест"},
                {" Были ли найдены на Марсе свидетельства существования жизни?", "Были получены противоречивые результаты", "Да", "Нет", "Конечно, да. Я сам с Марса"},
                {"Что из нижесказанного верно?", "Свидетельства существования воды на Марсе противоречивы", "На Марсе нет воды", "На Марсе погода не меняется", "На Марсе классно!"},
                {"На Марсе находится самый большой в солнечной системе лабиринт пересекающихся каньонов, называемый:", "Лабиринт ночи", "Лонглит", "Импринт", "Лабиринт дня"},
                {" Как переводятся названия спутников Марса?", "Страх и Ужас", "Шок и Трепет", "Гордость и Предубеждение", "Малыш и Карлсон"},
                {" Как называется величайшее геологическое образование на Марсе?", "Долина Маринера", "Кремниевая Долина", "Долины Луары", "Долина темная долина"},
                {" Средняя температура на Марсе равна:", "–27°С", "5°С", "–10°С", "70°С"},
                {" Первым человеком, наблюдавшим Марс в телескоп, был:", "Галилео Галилей", "Карл Гаусс", "Николай Коперник", "Платон"},
                {"Как называются линзы, которые люди надевают, чтобы лучше видеть?", "Контактные", "Дружелюбные", "Общительные", "Коммуникабельные"}};
    }


    private int getRandomIndex(int maxValue) {
        return (int) (Math.random() * maxValue);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addValue:
                startActivity(new Intent(QuestionsActivity.this, MainActivity.class));
                return true;
            case R.id.recycler:
                startActivity(new Intent(QuestionsActivity.this, CountriesActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
