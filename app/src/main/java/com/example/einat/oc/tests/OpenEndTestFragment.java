package com.example.einat.oc.tests;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.einat.oc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OpenEndTestFragment extends Fragment {
    TextView mQuestion;

    public OpenEndTestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_open_end_test, container, false);
        mQuestion = (TextView) root.findViewById(R.id.questionText);
        setQuestion("我");
        return root;
    }

        boolean change = true;
    public void setQuestion(String word){
        String question;
        String a = "Write the meaning of " + word + " in English:";
        String b = "How do you write" + word + " in pinyin?";
        if (change){
            question = a;
            change = false;
        } else{
            question = b;
            change = true;
        }
        mQuestion.setText(question);

    }


}
