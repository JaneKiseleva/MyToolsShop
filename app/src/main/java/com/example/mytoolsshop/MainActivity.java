package com.example.mytoolsshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    private ListView listViewTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null) {
            actionBar.hide(); //Метод hide() позволяет скрывать объекты
        }
        listViewTools = findViewById(R.id.listViewTools);

        //Метод setOnItemClickListener() - слушатель событий.
        // OnItemClickListener - это интерфейс, поэтому в качестве параметра передаем объект класса, который реализует данный интерфейс.
        //Создадим анонимный класс
        //Класс, который реализует данный интерфейс должен переопределить данный метод onItemClick - что делать при нажатии на элемент списка
        listViewTools.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //просто выведем на экран id.
                // В качестве параметра мы не можем использовать this, потому что мы находимся не в нашей активности
                // а в новом классе, поэтому вызываем метод getApplicationContext()
                //Toast.makeText(getApplicationContext(), "Позиция: " + position, Toast.LENGTH_SHORT).show();

                switch (position) { //условие switch применяется к известному числу возможных ситуаций
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), DrillGategoryActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
