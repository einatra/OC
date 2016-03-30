package com.example.einat.oc.utils;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.TextView;

import com.example.einat.oc.R;
import com.example.einat.oc.tests.TestFragment;

import java.util.concurrent.TimeUnit;

/**
 * Created by Einat on 22/03/2016.
 */
public class QuizCountDownTimer extends CountDownTimer {

    private final Context context;
    TextView counter;
    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public QuizCountDownTimer(long millisInFuture, long countDownInterval, TextView counter, Context context) {
        super(millisInFuture, countDownInterval);
        this.counter = counter;
        this.context = context;
    }

    @Override
    public void onTick(long millisUntilFinished) {

        String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
        counter.setText(hms);
    }


    @Override
    public void onFinish() {
//TODO: call a quiz & notification
        NotificationHelper.scheduleNotification(0, context);
        try {
            switchToQuizFragment();
        } catch (ClassCastException e) {
            Log.e("QuizE", "Can't get fragment manager");
        }

    }

    public void switchToQuizFragment(){
        TestFragment testFragment = new TestFragment();
        FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_cointainer, testFragment, "testFragment").commit();
    }

}
