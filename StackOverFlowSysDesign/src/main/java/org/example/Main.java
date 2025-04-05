package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Tang StackOverflow!");


        StackOverflowSystem stackOverflowSystem = new StackOverflowSystem();
        User user1 = new User("Khue Tang");
        User user2 = new User("Baby JangJang");
        User user3 = new User("Putput");
        User user4 = new User("Na Nau");
        stackOverflowSystem.createMultipleUserAccounts(new ArrayList<>(List.of(user1, user2, user3)));

        // users1 post question, user2 posts answer, user3 posts comments, user4 votes
        Question question1 = stackOverflowSystem.postQuestion(user1, new ArrayList<>(List.of(new Tag("skrt"))), "What a beautiful day, isn't it?");
        Answer answer1 = stackOverflowSystem.postAnswer(question1, user2, "I don't think it's that beautiful.");
        stackOverflowSystem.postCommentToQuestion(question1, user3, "Honestly, beauty is subjective.");
        stackOverflowSystem.postCommentToAnswer(answer1, user3.getUser_id(), "I respect your opinion.");
        stackOverflowSystem.downvoteQuestion(question1, user4.getUser_id());
        stackOverflowSystem.upvoteAnswer(answer1, user4.getUser_id());

        System.out.println("User1 reputation: " + stackOverflowSystem.calculateUserReputation(user1));
        System.out.println("User2 reputation: " + stackOverflowSystem.calculateUserReputation(user2));



        System.out.println("List of questions by user1: " + stackOverflowSystem.searchQuestionsByUser(user1));
        System.out.println("List of questions with tag 'skrt': " + stackOverflowSystem.searchQuestionsByTags(new Tag("skrt")));
        System.out.println("List of questions with keyword 'beautiful day': " + stackOverflowSystem.searchQuestionsByKeyWords("beautiful day"));
    }
}