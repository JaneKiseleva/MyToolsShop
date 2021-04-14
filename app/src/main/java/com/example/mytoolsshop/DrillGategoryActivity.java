package com.example.mytoolsshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DrillGategoryActivity extends AppCompatActivity {
    private ListView listViewDrills;
    private ArrayList<Drill> drills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_gategory);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null) {
            actionBar.hide(); //Метод hide() позволяет скрывать объекты
        }

        //Для того, чтобы связать список ListView c каким-либо массивом необходим АДАПТЕР
        //В качестве второго параметра указывается (шрифт, размер, вес и прочее), воспользуемся макетом, встроенным в Android: android.R.layout.simple_list_item_1
        //В качестве третьего параметра - указывается в какую переменную мы хотим передать масссив
        //Устанавливаем адаптер в наш список дрелей
        //В данном случае адаптер не знает какую инфу мы хотим выводить в списке ListView, чтобы показать, какой именно элемент нужно выводить
        // необходимо в нашем классе Drill переопределить метод toString();
        drills = new ArrayList<>();
        //Добавляем имя, описание и картинку. Прописываем путь.
        drills.add(new Drill(getString(R.string.drill_interskol_title),getString(R.string.drill_interskol_info), R.drawable.interskol));
        drills.add(new Drill(getString(R.string.drill_makita_title),getString(R.string.drill_makita_info), R.drawable.makita));
        drills.add(new Drill(getString(R.string.drill_dewalt_title),getString(R.string.drill_dewalt_info), R.drawable.dewalt));
        listViewDrills = findViewById(R.id.listViewDrills);
        ArrayAdapter<Drill> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, drills);
        listViewDrills.setAdapter(adapter);

        listViewDrills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drill drill = drills.get(position);
                Intent intent = new Intent(getApplicationContext(),DrillDetailActivity.class);
                intent.putExtra("title", drill.getTitle());
                intent.putExtra("info", drill.getInfo());
                intent.putExtra("resId", drill.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}
