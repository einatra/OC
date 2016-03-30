package com.example.einat.oc.tests;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;

import com.example.einat.oc.R;

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
        View root = inflater.inflate(R.layout.fragment_test, container, false);
        ViewStub stub = (ViewStub) root.findViewById(R.id.answerStub);
        mQuestion = (TextView) root.findViewById(R.id.questionText);
        inflateLayoutForStub(stub, true);

        return root;
    }

    private void inflateLayoutForStub(ViewStub stub, Boolean open) {
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
        String pinyin = "How do you write" + word + " in pinyin?";
        if (change) {
            question = meaning;
            change = false;
        } else {
            question = pinyin;
            change = true;
        }
        mQuestion.setText(question);
    }
}
