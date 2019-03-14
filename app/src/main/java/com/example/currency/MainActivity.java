package com.example.currency;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Snackbar mysnackbar = Snackbar.make(findViewById(R.id.myCoordinatorLayout),R.string.hello,Snackbar.LENGTH_SHORT);
        mysnackbar.setAction(R.string.hello, new UndoListener());
        Button click_me_button = findViewById(R.id.click_me);

        TextView lefttext = findViewById(R.id.left_result);
        TextView righttext = findViewById(R.id.right_result);




        click_me_button.setOnClickListener((view -> {
            mysnackbar.show();

            Context context = getApplicationContext();
            CharSequence text = "Hello TOaSt";
            int duration = Toast.LENGTH_SHORT;

            //Toast toast = Toast.makeText(context,text,duration);
            //toast.show();

            Toast.makeText(context,"" + Integer.parseInt(lefttext.getText().toString()) * 7.5f,duration).show();






        }));

        Spinner left = findViewById(R.id.spinner_left);
        Spinner right = findViewById(R.id.spinner_right);

        String[] items = new String[]{"DKK", "GPB", "EUR"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item);
        adapter.createFromResource(this,R.array.currency_array, R.layout.support_simple_spinner_dropdown_item);

        left.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = "";

                switch (position)
                {
                    case 0:

                        if(right.getSelectedItemPosition() == 1)
                        {
                            Log.d("debug", "onItemSelected: GPB");

                        }



                        if(!lefttext.getText().equals(""))
                        {
                            righttext.setText( lefttext.getText().toString());
                        }

                        item = parent.getItemAtPosition(position).toString();
                        Log.d("debug",item);

                        break;
                    case 1:

                        //this is euro

                        item = parent.getItemAtPosition(position).toString();
                        Log.d("debug",item);
                        break;
                    case 2:

                        item = parent.getItemAtPosition(position).toString();
                        Log.d("debug",item);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String item = parent.getItemAtPosition(0).toString();

            }
        });

        right.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = "";

                switch (position)
                {
                    case 0:
                        item = parent.getItemAtPosition(position).toString();
                        Log.d("debug",item);

                        break;
                    case 1:
                        item = parent.getItemAtPosition(position).toString();
                        Log.d("debug",item);
                        break;
                    case 2:

                        item = parent.getItemAtPosition(position).toString();
                        Log.d("debug",item);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
