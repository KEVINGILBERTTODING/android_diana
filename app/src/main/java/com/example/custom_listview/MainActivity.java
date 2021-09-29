package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import com.example.custom_listview.databinding.ActivityMainBinding;
import com.example.custom_listview.databinding.ActivityUserBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {
                R.drawable.indah,
                R.drawable.yerin,
                R.drawable.umji,
                R.drawable.eunha,
                R.drawable.jeniie,
                R.drawable.joy

        };

        String[] name = {
                "Indah",
                "Yerin",
                "Umji",
                "Eunha",
                "Jennie",
                "Joy"
        };

        String[] phoneNo = {
                "0812345678",
                "0822228888",
                "0899229929",
                "08712112289",
                "08233278121",
                "08518967842"
        };

        ArrayList<User> userArrayList = new ArrayList<>();

        for (int i = 0; i < imageId.length; i++) {

            User user = new User(name[i], phoneNo[i], imageId[i]);
            userArrayList.add(user);

        }


        ListAdapter listAdapter = new ListAdapter(MainActivity.this, userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this, UserActivity.class);
                i.putExtra("name", name[position]);
                i.putExtra("phone", phoneNo[position]);
                i.putExtra("imageid", imageId[position]);
                startActivity(i);

            }
        });


    }
}
