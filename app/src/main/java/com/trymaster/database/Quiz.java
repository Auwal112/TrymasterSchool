package com.trymaster.database;


import java.util.List;

public class Quiz {
    private long id;
    private String title;
    private String description; // NEW FIELD
    private String category;
    private int totalQuestions;
    private List<Question> questions;

    // ---------------- Constructors ----------------

    // Full constructor with questions
    public Quiz(long id, String title, String description, String category, int totalQuestions, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.totalQuestions = totalQuestions;
        this.questions = questions;
    }

    // Constructor without questions
    public Quiz(long id, String title, String description, String category, int totalQuestions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.totalQuestions = totalQuestions;
    }

    // ---------------- Getters & Setters ----------------

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getTotalQuestions() { return totalQuestions; }
    public void setTotalQuestions(int totalQuestions) { this.totalQuestions = totalQuestions; }

    public List<Question> getQuestions() { return questions; }
    public void setQuestions(List<Question> questions) { this.questions = questions; }
}
