package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StackOverflowSystem {
    private Map<Integer, Question> questions;
    private Map<Integer, Answer> answers;
    private Map<Integer, Comment> commentsToQuestion;
    private Map<Integer, Comment> commentsToAnswers;
    private Map<Integer, User> users;

    public StackOverflowSystem() {
        this.questions = new HashMap<>();
        this.answers = new HashMap<>();
        this.commentsToQuestion = new HashMap<>();
        this.commentsToAnswers = new HashMap<>();
        this.users = new HashMap<>();
    }

    public User createUserAccount(String name) {
        User user = new User(name);
        users.put(user.getUser_id(), user);
        return user;
    }

    public double calculateUserReputation(User user) {
        return user.calculateUserReputation();
    }

    public void createMultipleUserAccounts(List<User> users) {
        users.forEach(user -> this.users.put(user.getUser_id(), user));
    }

    public List<String> searchQuestionsByUser(User user) {
        return questions.values().stream()
                .filter(question -> question.getUser_id() == user.getUser_id())
                .map(question -> question.getContent())
                .collect(Collectors.toList());
    }

    public List<String> searchQuestionsByKeyWords(String keywords) {
        return questions.values().stream()
                .filter(question -> question.getContent().contains(keywords))
                .map(question -> question.getContent())
                .collect(Collectors.toList());
    }

    public List<String> searchQuestionsByTags(Tag tag) {
        return questions.values().stream()
                .filter(question -> question.getTags().stream()
                        .anyMatch(t -> t.getName().equals(tag.getName())))
                .map(question -> question.getContent())
                .collect(Collectors.toList());
    }

    public void upvoteQuestion(Question question, User voter) {
        question.upVote();
    }

    public void downvoteQuestion(Question question, User voter) {
        question.downVote();
    }

    public void upvoteAnswer(Answer answer, User voter) {
        answer.upVote();
    }

    public void downvoteAnswer(Answer answer, User voter) {
        answer.downVote();
    }

    public Question postQuestion(User user, List<Tag> tags, String content) {
        Question newQuestion = new Question(user.getUser_id(), tags, content);
        user.addQuestion(newQuestion);
        this.questions.put(newQuestion.getQuestion_id(), newQuestion);
        return newQuestion;
    }

    public void postCommentToQuestion(Question question, User commenter, String content) {
        Comment newComment = new Comment(question.getQuestion_id(), commenter, content);
        question.addComment(newComment);
        commenter.addComment(newComment);
    }

    public void postCommentToAnswer(Answer answer, User commenter, String content) {
        answer.addComment(content, commenter);
    }

    public Answer postAnswer(Question question, User answerer, String content) {
        Answer answer = new Answer(question.getQuestion_id(), answerer.getUser_id(), content);
        question.addAnswer(answer);
        answerer.addAnswer(answer);
        return answer;
    }

    public Map<Integer, Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<Integer, Question> questions) {
        this.questions = questions;
    }

    public Map<Integer, Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, Answer> answers) {
        this.answers = answers;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }
}
