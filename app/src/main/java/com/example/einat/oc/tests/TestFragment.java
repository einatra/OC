package com.example.einat.oc.tests;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;

import com.example.einat.oc.R;

import java.util.Random;

/**
 * Created by Einat on 20/03/2016.
 */
public class TestFragment extends Fragment {

    TextView mQuestion;

    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_multi_choice_test, container, false);

        mQuestion = (TextView) root.findViewById(R.id.Qtext);
        setQuestion("我");

        return root;
    }

    private void inflateLayoutForStub(ViewStub stub, boolean open) {
        if (open) {
            setQuestion("我");
            stub.setLayoutResource(R.layout.fragment_open_end_test);
        } else {
            stub.setLayoutResource(R.layout.fragment_multi_choice_test);
        }
        stub.inflate();
    }

    boolean change = true;

    public void setQuestion(String word) {
        String question;
        String meaning = "Write the meaning of " + word + " in English:";
        String pinyin = "Write " + word + " in pinyin:";
        String shape = "Which character means \"me\"in chinese?";
        String sound = "How to write " + word + " in pinyin?";
        String means = "What does " + word + " means?";

        String[] questions = {shape, sound, means};
        Random randomQuests = new Random();
        String randomQuestion = questions[randomQuests.nextInt(3)];



        mQuestion.setText(randomQuestion);
    }
}
