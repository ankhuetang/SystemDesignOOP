package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
    private int question_id;
    private int user_id;
    private List<Tag> tags;
    private String content;
    private List<Comment> comments;
    private List<Answer> answers;
    private int votes;

    public Question(int user_id, List<Tag> tags, String content) {
        this.question_id = generateId();
        this.user_id = user_id;
        this.tags = tags;
        this.content = content;
        this.votes = 0;
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void upVote() {
        this.votes += 1;
    }

    public void downVote() {
        this.votes -= 1;
    }

    public void addTags(Tag... tags) {
        this.tags.addAll(Arrays.asList(tags));
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public Answer addAnswer(Answer answer) {
        this.answers.add(answer);
        return answer;
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
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
