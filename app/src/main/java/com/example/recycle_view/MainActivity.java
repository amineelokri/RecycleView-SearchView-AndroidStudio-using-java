package com.example.recycle_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String names[],Desc[];
    int images[]={R.drawable.ensias,R.drawable.fmp,R.drawable.inpt,R.drawable.insea,R.drawable.enim,R.drawable.ensem};
    RecyclerView rv;
    SearchView searchView;

    List<School> schools=new ArrayList<>();

    MyClassAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recycle);

        schools.add(new School("ENSIAS","Ecole Nationale Superieur dinformatique et dAnalyse des Systemes",R.drawable.ensias));
        schools.add(new School("ENIM","École nationale de lindustrie minérale",R.drawable.enim));
        schools.add(new School("INPT","Institut National des Postes et Télécommunications",R.drawable.inpt));
        schools.add(new School("ENSEM","Ecole Nationale Supérieure dElectricité et de Mécanique",R.drawable.ensem));
        schools.add(new School("INSEA","Institut National de Statistique et dEconomie Appliquée",R.drawable.insea));
        schools.add(new School("FMP","Faculte de Medecine et pharmacie",R.drawable.fmp));
        adapter=new MyClassAdapter(this,schools);
        rv.setAdapter(adapter);
        searchView=findViewById(R.id.serachview);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return false;
            }
        });
        rv.setLayoutManager(new LinearLayoutManager(this));


    }

    private void filterList(String text) {
        List<School>namesf=new ArrayList<>();

        for(School school :schools){
            if(school.getName().toLowerCase().contains(text.toLowerCase())){
                namesf.add(school);
            }
        }
        if(namesf.isEmpty()){
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
        else {

            adapter.setFiltredList(namesf);

        }


    }
}