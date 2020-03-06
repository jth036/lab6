package com.example.lab61;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class QuestionAdapter extends ArrayAdapter<Questions> implements View.OnClickListener {
    private ArrayList<Questions> questions;
    private Context ctx;

    public QuestionAdapter(ArrayList<Questions> questions, Context ctx) {
        super(ctx, R.layout.listview_question, questions);
        this.questions = questions;
        this.ctx = ctx;
    }

    /**
     *
     * @param questions - Nye brukere legges til.
     */
    public void setQuestions(ArrayList<Questions> questions) {
        this.questions.addAll(questions); // Legger til nye User-objekter (obs: fjerner ikke gamle)
        this.notifyDataSetChanged(); // Si fra til observatører (her: ListView) at data er endret
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Questions userToDraw = this.questions.get(position); // Hent data om riktig bruker
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.listview_question, parent, false);
        TextView questionTextView = convertView.findViewById(R.id.question);
        questionTextView.setText(userToDraw.getQuestion()); // Fyll ut brukernavn
        return convertView; // Returnér den ferdig utfylte raden (her: Til ListView)
    }

    @Override
    public void onClick(View v) {
        // TODO: F.eks. åpne Toast eller ny Activity med detaljer.
    }
}
