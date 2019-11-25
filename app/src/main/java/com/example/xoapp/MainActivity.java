package com.example.xoapp;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    TextView textView , textView2 ,score;
    int player = 1 ,nowin = 0 ,score1=0,score2=0;
    int [] buttonStates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();
        addListenersToButtons();
        buttonStates = new int[]{0,0,0,0,0,0,0,0,0};


    }


    private void setUp(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        textView = findViewById(R.id.text);
        textView2 = findViewById(R.id.text2);
        score = findViewById(R.id.score);
    }

    private void addListenersToButtons() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn1 :
                checWiner(0,v);
                break;
            case R.id.btn2 :
                checWiner(1,v);
                break;
            case R.id.btn3 :
                checWiner(2,v);
                break;
            case R.id.btn4 :
                checWiner(3,v);
                break;
            case R.id.btn5 :
                checWiner(4,v);
                break;
            case R.id.btn6 :
                checWiner(5,v);
                break;
            case R.id.btn7 :
                checWiner(6,v);
                break;
            case R.id.btn8 :
                checWiner(7,v);
                break;
            case R.id.btn9 :
                checWiner(8,v);
                break;
        }

    }

    private void checWiner(int i,View v){
        changeText(v,i);
        if (buttonStates[i] == 0) {
            buttonStates[i] = player;
        }
        if (buttonStates[0] == player && buttonStates[1] == player && buttonStates[2] == player
                || buttonStates[0] == player && buttonStates[3] == player && buttonStates[6] == player
                || buttonStates[0] == player && buttonStates[4] == player && buttonStates[8] == player
                || buttonStates[2] == player && buttonStates[5] == player && buttonStates[8] == player
                || buttonStates[6] == player && buttonStates[7] == player && buttonStates[8] == player
                || buttonStates[1] == player && buttonStates[4] == player && buttonStates[7] == player
                || buttonStates[3] == player && buttonStates[4] == player && buttonStates[5] == player
                || buttonStates[2] == player && buttonStates[4] == player && buttonStates[6] == player) {
            int x = (player==2)?1:2;
            showAlertDialog("player "+x+" won");
            if(x==1)
                score1++;
            else
                score2++;
        }
        else if(nowin == 9 )
            showAlertDialog("no one is winner");
    }

    private void showAlertDialog(String title) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage("do you want to play agine ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        score.setText(score1+" : "+score2);
                        for(int i=0 ; i<9 ; ++i)
                            buttonStates[i]=0;
                        player = 1 ;nowin = 0;
                        btn1.setText("");
                        btn2.setText("");
                        btn3.setText("");
                        btn4.setText("");
                        btn5.setText("");
                        btn6.setText("");
                        btn7.setText("");
                        btn8.setText("");
                        btn9.setText("");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void changeText(View v, int i) {
        Button selectedButton = (Button) v;
        nowin ++;

        if (buttonStates[i] == 0) {
            if (player == 1) {
                selectedButton.setText("X");
                selectedButton.setTextColor(Color.parseColor("black"));
                player = 2;
            } else if (player == 2) {
                selectedButton.setText("O");
                selectedButton.setTextColor(Color.parseColor("red"));
                player = 1;
            }
            if ((player == 1)) {
                textView.setTextColor(Color.parseColor("red"));
                textView2.setTextColor(Color.parseColor("black"));
            } else {
                textView2.setTextColor(Color.parseColor("red"));
                textView.setTextColor(Color.parseColor("black"));
            }
        }

    }
}
