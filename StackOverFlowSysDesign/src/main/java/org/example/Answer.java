package org.example;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private int answer_id;
    private int question_id;
    private int user_id;
    private String content;
    private int votes;
    private List<Comment> comments;

    public Answer(int question_id, int user_id, String content) {
        this.answer_id = generateId();
        this.question_id = question_id;
        this.user_id = user_id;
        this.content = content;
        this.votes = 0;
        this.comments = new ArrayList<>();
    }

    public void addComment(String content, int commenter_id) {
        Comment newComment = new Comment(this.answer_id, commenter_id, content);
        this.comments.add(newComment);
    }

    public void upVote() {
        this.votes += 1;
    }

    public void downVote() {
        this.votes -= 1;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }
}
