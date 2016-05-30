package com.example.einat.oc;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.einat.oc.tests.TestFragment;
import com.example.einat.oc.utils.NotificationHelper;
import com.example.einat.oc.utils.QuizCountDownTimer;
import com.example.einat.oc.wordsDB.DbAccess;


/**
 * A simple {@link Fragment} subclass.
 */
public class DailyWordFragment extends Fragment implements View.OnClickListener {


    private Button quizNowBtn;
    private Button reviewBtn;
    private View countDownLayout;
    private View wordLayout;
    private TextView counter;
    private Button btnGotIt;
    private Context context;
    private QuizCountDownTimer quizCountDownTimer;
    DbAccess dbAccess = DbAccess.getInstance(context);

    public DailyWordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_daily_word, container, false);
        initializeViews(root);
        wordLayout.setVisibility(View.GONE);
        quizCountDownTimer = new QuizCountDownTimer(10000, 1000, counter, getContext());

        context = getContext();
        DbAccess dbAccess = DbAccess.getInstance(context);
        dbAccess.open();

        return root;
    }

    private void initializeViews(View root) {
        counter = (TextView) root.findViewById(R.id.countDownText);
        wordLayout = root.findViewById(R.id.wordLayout);
        countDownLayout = root.findViewById(R.id.countDownLayout);
        btnGotIt = (Button) root.findViewById(R.id.btnGotIt);
        btnGotIt.setOnClickListener(this);
        quizNowBtn = (Button) root.findViewById(R.id.btnQuizNow);
        quizNowBtn.setOnClickListener(this);
        reviewBtn = (Button) root.findViewById(R.id.btnReview);
        reviewBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGotIt:
                wordLayout.setVisibility(View.GONE);
                countDownLayout.setVisibility(View.VISIBLE);
                quizCountDownTimer.start();
                //TODO: scheduled by user - sharedprefs
                NotificationHelper.scheduleNotification(5000, getContext());
            case R.id.btnQuizNow:
                switchToQuizFragment();
                break;
            case R.id.btnReview:
                countDownLayout.setVisibility(View.GONE);
                wordLayout.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void switchToQuizFragment(){
        TestFragment testFragment = new TestFragment();
        FragmentManager fragmentManager = ((FragmentActivity) getContext()).getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_cointainer, testFragment, "testFragment").commit();
    }

}
