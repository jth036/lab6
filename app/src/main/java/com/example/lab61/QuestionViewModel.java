package com.example.lab61;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class QuestionViewModel extends ViewModel {
    private QuestionRepository questionRepository;

    public QuestionViewModel() {
        this.questionRepository = new QuestionRepository();
    }

    /**
     * Merk at denne modellen ikke inneholder noe logikk.
     *
     * Det returneres kun underliggende (også observerbart) objekt fra repository, uten noen form
     * for prosessering av disse dataene.
     *
     * @return Observerbart objekt (liste med brukere)
     */
    public LiveData<ArrayList<Questions>> getUserData() {
        return this.questionRepository.getData();
    }

    /**
     * Forespør nedlasting av data fra repository. Repository gir selv beskjed når data er klare.
     *
     * @param guiContext
     */
    public void requestDownload(Context guiContext) {
        this.questionRepository.testMethod(guiContext);
    }

}
