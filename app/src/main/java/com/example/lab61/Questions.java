package com.example.lab61;

public class Questions {
    int id;
    String category,type,difficulty, question,createdBy,correctAnswer,incorrectAnswer;

    public Questions(int id, String category, String type, String difficulty, String question, String createdBy) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.createdBy = createdBy;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Questions(){
    }

}
