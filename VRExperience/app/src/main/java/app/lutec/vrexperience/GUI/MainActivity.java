package app.lutec.vrexperience.GUI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vuforia.samples.VuforiaSamples.app.ImageTargets.ImageTargets;

import app.lutec.vrexperience.GUI.custom.CustomTableLayout;
import app.lutec.vrexperience.R;

public class MainActivity extends AppCompatActivity {

    private CustomTableLayout customTableLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.customTableLayout = (CustomTableLayout)findViewById(R.id.main_menu_tablelayout);

        String[] button1 = {"Button1"};
        String[] button2 = {"Button2"};
        String[] button3 = {"Button3"};
        String[] button4 = {"Button4"};
        String[] button5 = {"Button5"};
        String[] button6 = {"Button6"};

        customTableLayout.addButton(button1, ImageTargets.class);
    }
}
