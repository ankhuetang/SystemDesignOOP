package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int MAX_RAW_REPUTATION_SCORE = 100;
    private int user_id;
    private String name;
    private List<Question> questions;
    private List<Answer> answers;
    private List<Comment> comments;
    private double reputation;

    public User(String name) {
        this.name = name;
        this.user_id = generateId();
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.reputation = 0;
    }

    public double calculateUserReputation() {
        //( num_questions + num_answer*2 + num_votes*3) / 5
        int numQuestions = this.getQuestions().size();
        int questionVotes = this.getQuestions().stream().mapToInt(Question::getVotes).sum();
        int numAnswers = this.getAnswers().size();
        int answerVotes = this.getAnswers().stream().mapToInt(Answer::getVotes).sum();
        int numComments = this.getComments().size();

        double rawScore = numQuestions + numComments + numAnswers*2 + (questionVotes + answerVotes)*3;
//        return Math.log(1 + rawScore) / Math.log(1 + MAX_RAW_REPUTATION_SCORE);
        this.setReputation(rawScore);
        return rawScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public double getReputation() {
        return reputation;
    }

    public void setReputation(double reputation) {
        this.reputation = reputation;
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
