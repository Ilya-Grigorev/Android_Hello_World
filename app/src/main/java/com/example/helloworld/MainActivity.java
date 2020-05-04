package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private static final int KolVoElem = 4;

    // private LinearLayout MasEl[] = new LinearLayout[KolVoElem];
    private Button MasEl[] = new Button[KolVoElem];

    private int MasCv[] = new int[KolVoElem];
    private boolean start_stop = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MasEl[0] = findViewById(R.id.lamp1);
        MasEl[1] = findViewById(R.id.lamp2);
        MasEl[2] = findViewById(R.id.lamp3);
        MasEl[3] = findViewById(R.id.lamp4);

        MasCv[0] = getResources().getColor(R.color.kr);
        MasCv[1] = getResources().getColor(R.color.zo);
        MasCv[2] = getResources().getColor(R.color.ze);
        MasCv[3] = getResources().getColor(R.color.si);

//        for (int i = 0; i < KolVoElem; i++) {
//            MasEl[i].setBackgroundColor(MasCv[i]);
//        }

    }


    public void onClickStart(View view) {

        Button myButton = findViewById(R.id.bStart);

        if (myButton.getText().equals("Start")) {
            myButton.setText("Stop");
            start_stop = true;
        } else {
            myButton.setText("Start");
            start_stop = false;
        }



        new Thread(new Runnable() {
            @Override
            public void run() {

                int ind_pr;

                while (start_stop) {

                    for (int i = 0; i < KolVoElem; i++) {

                        if (i == 0) {
                            ind_pr = KolVoElem - 1;
                        } else {
                            ind_pr=i-1;
                        }

                        MasEl[ind_pr].setBackgroundColor(getResources().getColor(R.color.grey));
                        MasEl[i].setBackgroundColor(MasCv[i]);

                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                }


            }
        }).start();


    }


    @Override
    protected void onDestroy() {

        super.onDestroy();
        start_stop = false;

    }
}
