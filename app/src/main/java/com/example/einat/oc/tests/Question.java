package com.example.einat.oc.tests;

import com.example.einat.oc.wordsDB.Word;

import java.util.Random;

/**
 * Created by Einat on 03/04/2016.
 */
public class Question {

    Word word;
    String randomQuestion;
    String shapeQ = "Which character means " + word.getMeaning() + " in chinese?";
    String soundQ = "How to write " + word.getCharacter() + " in pinyin?";
    String meaningQ = "What does " + word.getCharacter() + " means?";

    public String setQuestion(Word word){
        String[] questions = {shapeQ, soundQ, meaningQ};
        Random randomQuests = new Random();
        randomQuestion = questions[randomQuests.nextInt(3)];
        return randomQuestion;
    }

//    public void setAnsweres(Word word, String question){
//        getRandomWord();
//    }

//    private Word getRandomWord() {
//        //opens db gets random word
//       Word gotword = "random word from db";
//        if (gotword != word) {
//            return gotword;
//        }else
//        {
//            getRandomWord();
//        }
//    }

}
