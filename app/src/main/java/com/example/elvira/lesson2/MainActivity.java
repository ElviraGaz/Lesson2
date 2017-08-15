package com.example.elvira.lesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView valueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valueTextView = (TextView)findViewById(R.id.value);
        Button addOneButton = (Button) findViewById(R.id.add_one);
        Button addThreeButton = (Button) findViewById(R.id.add_three);
        Button addFiveButton = (Button) findViewById(R.id.add_five);
        Button clearButton = (Button) findViewById(R.id.clear);

        OnClickListener onClickListenerAddOne = new OnClickListener() {
            @Override
            public void onClick(View v) {
                valueTextView.setText(Add(1));
            }
        };

        addOneButton.setOnClickListener(onClickListenerAddOne);

        OnClickListener onClickListenerAddThree = new OnClickListener() {
            @Override
            public void onClick(View v) {
                valueTextView.setText(Add(3));
            }
        };

        addThreeButton.setOnClickListener(onClickListenerAddThree);

        OnClickListener onClickListenerAddFive = new OnClickListener() {
            @Override
            public void onClick(View v) {
                valueTextView.setText(Add(5));
            }
        };

        addFiveButton.setOnClickListener(onClickListenerAddFive);

        OnClickListener onClickListenerClear = new OnClickListener() {
            @Override
            public void onClick(View v) {
                valueTextView.setText("0");
            }
        };

        clearButton.setOnClickListener(onClickListenerClear);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Операции для выбранного пункта меню
        switch (item.getItemId())
        {
            case R.id.questions:
                startActivity(new Intent(MainActivity.this, QuestionsActivity.class));
                return true;
            case R.id.recycler:
                startActivity(new Intent(MainActivity.this, CountriesActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private String  Add (int value){
        Integer result =  Integer.parseInt(valueTextView.getText().toString()) + value;
        return  result.toString();
    }
}
