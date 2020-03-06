package com.example.lab61;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private QuestionViewModel questionViewModel;
    ArrayList<Questions> questionList = new ArrayList<Questions>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView2 = findViewById(R.id.textView);
        textView2.setText("hei hei");
        this.hookUpLiveData();
        questionViewModel.requestDownload(getApplicationContext());
    }


    private void hookUpLiveData() {
        final Observer<ArrayList<Questions>> userDataObserver = new Observer<ArrayList<Questions>>() {
            @Override
            public void onChanged(ArrayList<Questions> questionData) {
                ListView questionListView = (ListView)findViewById(R.id.listView);
                QuestionAdapter questionAdapter = (QuestionAdapter)questionListView.getAdapter();
                questionAdapter.setQuestions(questionData);
            }
        };
        questionViewModel = new ViewModelProvider(this).get(QuestionViewModel.class);
        questionViewModel.getUserData().observe(this, userDataObserver);








}}