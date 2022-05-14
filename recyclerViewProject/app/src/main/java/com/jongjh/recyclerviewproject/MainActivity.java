package com.jongjh.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*main Recyclerview 에 대한 코드*/
        //리사이클러뷰에 표시할 데이터 리스트
        ArrayList<String> imgList = new ArrayList<>();
        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<String> countList = new ArrayList<>();
        for(int i=0; i<10;i++){
            if(i%2==0){ imgList.add(String.format("tackplus")); }
            else{imgList.add(String.format("orcam"));}

            nameList.add(String.format("Name list %d",i));
            countList.add(String.format("%d",i));
        }

        //리사이클러뷰에 LinearLayoutManager 객체 생성
        RecyclerView recyclerView = findViewById(R.id.mainRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //리사이클러뷰에 Adapter 객체 지정
        mainAdapter adapter = new mainAdapter(imgList,nameList,countList);
        recyclerView.setAdapter(adapter);



    }
}