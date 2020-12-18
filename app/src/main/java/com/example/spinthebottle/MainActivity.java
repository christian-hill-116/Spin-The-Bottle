package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button b_spin;
    ImageView iv_bottle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_spin = (Button) findViewById(R.id.b_spin);
        iv_bottle = (ImageView) findViewById(R.id.iv_bottle);

        b_spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theSpinDegrees;

                Random r = new Random();

                theSpinDegrees = r.nextInt(3600);

                RotateAnimation rotateBottle = new RotateAnimation(0,theSpinDegrees,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                        );

                rotateBottle.setDuration(2000);
                rotateBottle.setFillAfter(true);
                rotateBottle.setInterpolator(new AccelerateDecelerateInterpolator());

                iv_bottle.startAnimation(rotateBottle);

                rotateBottle.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        if (theSpinDegrees % 360 > 0 && theSpinDegrees % 360 <= 90){
                            Toast.makeText(MainActivity.this, "The North East person has been chosen " + theSpinDegrees % 360 + " degrees", Toast.LENGTH_SHORT).show();
                        }
                        if (theSpinDegrees % 360 > 90 && theSpinDegrees % 360 <= 180){
                            Toast.makeText(MainActivity.this, "The South East person has been chosen " + theSpinDegrees % 360 + " degrees", Toast.LENGTH_SHORT).show();
                        }
                        if (theSpinDegrees % 360 > 180 && theSpinDegrees % 360 <= 270){
                            Toast.makeText(MainActivity.this, "The South West person has been chosen " + theSpinDegrees % 360 + " degrees", Toast.LENGTH_SHORT).show();
                        }
                        if (theSpinDegrees % 360 > 270 && theSpinDegrees % 360 <=360){
                            Toast.makeText(MainActivity.this, "The North West person has been chosen " + theSpinDegrees % 360 + " degrees", Toast.LENGTH_SHORT).show();
                        }



                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });



            }
        });
    }
}