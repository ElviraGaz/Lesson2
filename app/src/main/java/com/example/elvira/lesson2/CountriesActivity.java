package com.example.elvira.lesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CountriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<CountryModel> countiesList = addCountries();

        final CountriesAdapter countriesAdapter = new CountriesAdapter(countiesList);
        recyclerView.setAdapter(countriesAdapter);

        // Создаём и задаём класс, отвечающий за "декорирование" элементов (добавляем разделители)
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        // Создаём и задаём класс, отвечающий за анимации
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        recyclerView.setItemAnimator(itemAnimator);

    }

    private List<CountryModel> addCountries(){
        List<CountryModel> list = new ArrayList<>();
        list.add(new CountryModel("Абхазия", "Сухум", "8600", R.drawable.abkhazia));
        list.add(new CountryModel("Азербайджан", "Баку", "86600", R.drawable.azerbaijan));
        list.add(new CountryModel("Россия", "Москва", "17102345", R.drawable.russia));
        list.add(new CountryModel("Болгария", "София", "110910", R.drawable.bulgaria));
        list.add(new CountryModel("Бельгия", "Брюссель", "32545", R.drawable.belgium));
        list.add(new CountryModel("Босния и Герцеговина", "Сараево","51129",R.drawable.bosniaandherzegovina));
        list.add(new CountryModel("Бразилия", "Бразилиа", "8511965", R.drawable.brazil));
        list.add(new CountryModel("Ватикан", "Ватикан", "0.44", R.drawable.vaticancity ));
        list.add(new CountryModel("Венесуэла", "Каракас","912050" , R.drawable.venezuela));
        list.add(new CountryModel("Гаити", "Порт-о-Пренс", "27750", R.drawable.haiti));
        list.add(new CountryModel("Греция", "Афины","131940", R.drawable.greece ));
        list.add(new CountryModel("Испания", "Мадрид","497304", R.drawable.spain ));
        list.add(new CountryModel("Италия", "Рим","301340", R.drawable.italy ));
        list.add(new CountryModel("Франция", "Париж", "547030", R.drawable.france));
        list.add(new CountryModel("Швейцария", "Берн", "41290", R.drawable.switzerland));
        list.add(new CountryModel("Швеция", "Стокгольм","449964" , R.drawable.sweden));
        list.add(new CountryModel("Эстония", "Таллин","45226", R.drawable.estonia ));
        list.add(new CountryModel("США", "Вашингтон", "9522057", R.drawable.unitedstates));
        list.add(new CountryModel("Узбекистан", "Ташкент", "447400", R.drawable.uzbekistan));
        list.add(new CountryModel("Великобритания", "Лондон", "244820", R.drawable.unitedkingdom));
        return list;
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
            case R.id.addValue:
                startActivity( new Intent(CountriesActivity.this, MainActivity.class));
                return true;
            case R.id.questions:
                startActivity(new Intent(CountriesActivity.this, QuestionsActivity.class));
                return true;
            case R.id.languages:
                startActivity(new Intent(CountriesActivity.this, ProgramLanguagesActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
