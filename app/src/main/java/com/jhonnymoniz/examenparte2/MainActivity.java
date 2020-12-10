package com.jhonnymoniz.examenparte2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView sol;
    long animationDuration = 3500;
    private Button iniciar;
    public FrameLayout fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);

        sol = findViewById(R.id.sol);



        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        iniciar = findViewById(R.id.moon);
        /*android:layout_width="92dp"
        android:layout_height="84dp"*/
        /*iniciar.setOnClickListener(animationBAck(););*/

        fondo = findViewById(R.id.fondo);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        animation();
       /* changeColors();*/

        System.out.println("le has dado");
       return true;
    }

    public void animation(){
        ObjectAnimator animatory = ObjectAnimator.ofFloat(sol,"translationY",1000f);
        animatory.reverse();
        animatory.setDuration(animationDuration);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatory);
        animatorSet.start();

    }

    public void animationBAck(){
        ObjectAnimator animatory = ObjectAnimator.ofFloat(sol,"translationY",1000f);
        animatory.setDuration(animationDuration);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatory);
        animatorSet.start();

    }

    public void changeColors(){

        final int from = ContextCompat.getColor(this, R.color.colorIncio);
        final int to   = ContextCompat.getColor(this, R.color.colorFinal);

        ValueAnimator anim = new ValueAnimator();
        anim.setIntValues(from, to);
        anim.setEvaluator(new ArgbEvaluator());
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                fondo.setBackgroundColor((Integer)valueAnimator.getAnimatedValue());
            }
        });

        anim.setDuration(animationDuration);
        anim.start();

    }

    public void again(){
    }
}