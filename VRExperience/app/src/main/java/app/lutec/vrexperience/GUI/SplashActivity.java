package app.lutec.vrexperience.GUI;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import app.lutec.vrexperience.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;
    private ImageView background;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context = this;

        Animation animLogo = AnimationUtils.loadAnimation(this, R.anim.logo_slide_down);
        Animation animBackground = AnimationUtils.loadAnimation(this,R.anim.background_effect);

        logo = (ImageView)findViewById(R.id.lutec_logo);
        logo.setImageResource(R.drawable.logo_lutec);
        logo.startAnimation(animLogo);

        background = (ImageView)findViewById(R.id.background);
        background.startAnimation(animBackground);

        animLogo.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d("anim", "onAnimationEnd: ");
                Intent intent  = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }
}
