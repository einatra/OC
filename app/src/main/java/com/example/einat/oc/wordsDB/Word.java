package com.example.einat.oc.wordsDB;

/**
 * Created by Einat on 20/03/2016.
 */
public class Word {

    String character;
    String pinyin;
    String meaning;

    public Word() {
    }

    public Word(String character, String pinyin, String meaning) {
        this.character = character;
        this.pinyin = pinyin;
        this.meaning = meaning;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
