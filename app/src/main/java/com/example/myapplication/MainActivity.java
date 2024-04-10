package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spnMenu;
    private Button btnSearch;
    private ListView lstitems;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupViews();
        populateSpinner();
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseItems dp=new DataBaseItems();
                String cat=spnMenu.getSelectedItem().toString();
                List<MenueItem> result=dp.getMenueItems(cat);
                MenueItem[] arr=result.toArray(new MenueItem[result.size()]);
                ArrayAdapter<MenueItem> adapter=new ArrayAdapter<MenueItem>(MainActivity.this,
                        android.R.layout.simple_list_item_1,arr);

               lstitems.setAdapter(adapter);

            }
        });
        
    }

    private void populateSpinner() {
       DataBaseItems dp=new DataBaseItems();
       String[] cats=dp.getCategories();
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this
        , android.R.layout.simple_spinner_item,cats);
        spnMenu.setAdapter(adapter);
    }

    private void setupViews() {
        spnMenu=findViewById(R.id.spnMenu);
        btnSearch=findViewById(R.id.btnSearch);
        lstitems=findViewById(R.id.listViewItems);

    }
}