package com.example.elvira.lesson2;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ProgramLanguagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_languages);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_languages);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final List<PostModel> languagesList = fillList();

        LanguagesAdapter languagesAdapter = new LanguagesAdapter(languagesList);
        recyclerView.setAdapter(languagesAdapter);

        // Создаём и задаём класс, отвечающий за "декорирование" элементов (добавляем разделители)
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        // Создаём и задаём класс, отвечающий за анимации
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        recyclerView.setItemAnimator(itemAnimator);

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (PostModel post : languagesList)
                            post.setLikeCount(0);
                        LanguagesAdapter languagesAdapter = new LanguagesAdapter(languagesList);
                        recyclerView.setAdapter(languagesAdapter);
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }


        });
    }

        private List<PostModel> fillList() {
            List<PostModel> list = new ArrayList<>();
            list.add(new PostModel("Паскаль", "Заголовок 1", "Язык Turbo Pascal - основной язык, изучаемый первоначально теми, кто еще не умеет программировать. Он относительно прост в изучении, после его изучения проще переходить к более эффективным языкам, таким, например, как С или С++, нежели первым делом изучать сразу С++. Предназначен Паскаль для операционной системы DOS. Изобретен данный язык был в 1970 году, шейцарским ученым Никлаус Виртом. Название \"Паскаль\" было дано языку в честь великого французкого математика XV|| века Блеза Паскаля."));
            list.add(new PostModel("C", "Заголовок 2", "Язык Си был создан в начале 70-х годов ХХ века опытными программистами Деннисом Ритчи и Кенном Томпсоном. Предназначен Си под операционную систему DOS. Си считается трудным для изучения. Но в то же время и одним из самых популярных. После его изучения, дорога к современным языкам, таким как C++, Perl, Java, становится проще."));
            list.add(new PostModel("Delphi", "Заголовок 3", "Borland Delphi можно назвать наследником Паскаля, так как этот язык имеет синтаксис, схожий с синтаксисом языка Паскаль, но предназначен Дельфи для написание программ под Windows. Так же Delphi называют Object Pascal."));
            list.add(new PostModel("C++", "Заголовок 4", "В 70-80-х годах в норвежских вооруженных силах использовался язык Simula, являющийся одним из первых языков, основанных на понятии класс (класс - подмножество, состоящее из данных и связанных с ним функций). Примерно в то же время был создан эффективнейший язык Си. В 1978 году были сделанны первые попытки объединить достоинства этих двух языков, так появился язык \"Си с классами\", спустя несколько лет он стал тем С++, который так широко применяется сегодня. Сейчас существует множество различных платформ и версий С++, например: Borland C++ - под операцоинные системы DOS и Windows, Visual C++ - под ОС windows (один и самых популярных языков, на котором работают современные программисты), GNU C++ - под ОС Linux."));
            list.add(new PostModel("Assembler", "Заголовок 5", "С того самого момента как появились первые компьютеры, программировали на машинных кодах, это была жуткая путанница, и не каждому было под силу такое программирование, именно для этого и был создан Ассемблер - язык где команды были более менее похожи на человеческие. Как уже можно заметить, Ассемблер не легок для понимания, но зато он является родным языком компьютера, и его понимание не будет лищнем для программистов. Вставка кодов Ассемблера часто необходима для других языков программирования, например для включения курсора мыши в языках программирования под дос. "));
            list.add(new PostModel("HTML", "Заголовок 6", "Собственно язык, на котором писался данный сайт. HTML (HyperText Markup Language) - язык гипертекстовой разметки. Овладеть HTML достаточно просто. Основное приемущество в этом языке (как мне кажется) то, что для него не требуется никаких нудных компиляторов, как для сложных языков программирования. Достаточно в любом текстовом редакторе (например в блокноте) набрать HTML код, сохранить файл с расширением .html, и страница готова."));
            list.add(new PostModel("Java Script", "Заголовок 7", "Язык вставляющийся в HTML код между тегами <script> и </script>. Синтаксис Java Script немного схож с языком Си. Данный язык так же как и HTML предназначен для написания web-страниц, но в нем гораздо больше возможностей. Я бы назвал Java Script - языком программирования, не требующего специального компилятора."));
            list.add(new PostModel("Visual Basic", "Заголовок 8", "Visual Basic – разработка компании Microsoft, включающая язык программирования и среду разработки. Язык основан на диалекте Basic’а, однако включает поддержку ООП. Visual Basic хорош как средство быстрой разработки прототипов больших программ или небольших пользовательских приложений."));
            list.add(new PostModel("Python", "Заголовок 9", "Python – интерпретируемый, объектно-ориентированный язык программирования. Относится к классу языков с динамической типизацией (тип переменной не объявляется заранее), поддерживает высокоуровневые структуры данных (словари, списки), имеет ясный синтаксис. Интерпретатор Питона распространяется под свободной лицензией."));
            list.add(new PostModel("PHP", "Заголовок 10", "это распространенный язык программирования общего назначения с открытым исходным кодом. PHP сконструирован специально для ведения Web-разработок и его код может внедряться непосредственно в HTML."));
            return list;
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu)
        {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.main_menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item)
        {
            // Операции для выбранного пункта меню
            switch (item.getItemId()) {
                case R.id.addValue:
                    startActivity(new Intent(ProgramLanguagesActivity.this, MainActivity.class));
                    return true;
                case R.id.questions:
                    startActivity(new Intent(ProgramLanguagesActivity.this, QuestionsActivity.class));
                    return true;
                case R.id.recycler:
                    startActivity(new Intent(ProgramLanguagesActivity.this, CountriesActivity.class));
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }
    }
