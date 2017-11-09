package app.lutec.vrexperience.GUI.custom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

import app.lutec.vrexperience.R;

/**
 * Created by josea on 12/12/2016.
 */

public class CustomTableLayout extends TableLayout {

    private Context context = null;
    private int numOfButtons = 0;
    private ArrayList<String[][]> buttons = null;

    public CustomTableLayout(Context context) {
        super(context);
        this.context = context;
        this.buttons = new ArrayList<>();
    }

    public CustomTableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.buttons = new ArrayList<>();
    }

    public void addButton(String[] newButton, final Class<? extends Activity> ActivityToOpen){

        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View table_row_view = inflater.inflate(R.layout.custom_tablerow,null,false);
        View button_view = inflater.inflate(R.layout.custom_menu_button,null,false);

        TableRow.LayoutParams lp = new TableRow.LayoutParams(0,TableRow.LayoutParams.WRAP_CONTENT, 1.0f);
        lp.rightMargin = 5;
        lp.topMargin = 10;
        Button btn = (Button)button_view.findViewById(R.id.main_menu_button);
        btn.setText(newButton[0]);
        // Capture button clicks
        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                //startActivity(new Intent(getBaseContext(), ActivityToOpen));
                // Start NewActivity.class
                Intent myIntent = new Intent(context, ActivityToOpen);
                context.startActivity(myIntent);
            }
        });
        btn.setLayoutParams(lp);

        if(this.numOfButtons %2 == 0 ){
            TableRow tableRow = (TableRow)table_row_view.findViewById(R.id.main_menu_tablerow);
            tableRow.setWeightSum(2.2f);
            tableRow.setGravity(Gravity.CENTER);
            tableRow.addView(btn);
            this.addView(tableRow);
            this.numOfButtons++;
        }else{
            View view = this.getChildAt(this.getChildCount()-1);
            if(view instanceof TableRow){
                TableRow row = (TableRow)view;
                row.addView(btn);
            }
            this.numOfButtons++;
        }

    }

}
