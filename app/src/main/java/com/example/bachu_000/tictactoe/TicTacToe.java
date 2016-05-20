package com.example.bachu_000.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TicTacToe extends AppCompatActivity implements View.OnClickListener {
    Button a1,a2,a3,b1,b2,b3,c1,c2,c3,restart;
    Button[] array;
    TextView tv1,tv2;
    Boolean turn=true;
    int count=0,xcount=0,ycount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        a1=(Button)findViewById(R.id.x1);
        a2=(Button)findViewById(R.id.x2);
        a3=(Button)findViewById(R.id.x3);
        b1=(Button)findViewById(R.id.y1);
        b2=(Button)findViewById(R.id.y2);
        b3=(Button)findViewById(R.id.y3);
        c1=(Button)findViewById(R.id.z1);
        c2=(Button)findViewById(R.id.z2);
        c3=(Button)findViewById(R.id.z3);
        tv1=(TextView)findViewById(R.id.score1);
        tv2=(TextView)findViewById(R.id.score2);
        restart=(Button)findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn=true;
                count=0;
                enabledisableAllButtons(true);
            }
        });
        array=new Button[]{a1,a2,a3,b1,b2,b3,c1,c2,c3};

        for(Button x:array){
            x.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Button b=(Button)v;
        buttonClicked(b);

    }
    public void buttonClicked(Button b)
    {
        if(turn){
            b.setText("X");
        }
        else
        {
            b.setText("O");
        }
        count++;
        b.setClickable(false);
        turn=!(turn);
        winner();
    }
    public void winner()
    {
        int win=0;
        if(a1.getText()==a2.getText()&&a2.getText()==a3.getText()&&!a1.isClickable())
        {
            win=1;
        }
        else if(b1.getText()==b2.getText()&&b2.getText()==b3.getText()&&!b1.isClickable())
        {
            win=1;
        }
        else if(c1.getText()==c2.getText()&&c2.getText()==c3.getText()&&!c1.isClickable())
        {
            win=1;
        }
        //vertical
        else if(a1.getText()==b1.getText()&&b1.getText()==c1.getText()&&!a1.isClickable())
        {
            win=1;
        }
        else if(a2.getText()==b2.getText()&&b2.getText()==c2.getText()&&!b2.isClickable())
        {
            win=1;
        }
        else if(a3.getText()==b3.getText()&&b3.getText()==c3.getText()&&!c3.isClickable())
        {
            win=1;
        }
        //diagonal
        else if(a1.getText()==b2.getText()&&b2.getText()==c3.getText()&&!a1.isClickable())
        {
            win=1;
        }
        else if(a3.getText()==b2.getText()&&b2.getText()==c1.getText()&&!b2.isClickable())
        {
            win=1;
        }
        if(win==1)
        {
            if(!turn){
                xcount++;
                toast("X wins");
            }
            else
            {
                ycount++;
                toast("O wins");
            }
            enabledisableAllButtons(false);
            tv1.setText(Integer.toString(xcount));
            tv2.setText(Integer.toString(ycount));

        }
        else if(count==9)
        {
            toast("Draw");
        }
    }
    private void enabledisableAllButtons(boolean f){
        for(Button bt:array){
            bt.setClickable(f);
            if(f)
            {
                bt.setText("");
            }

        }
    }
    public void toast(String mg){
        Toast.makeText(getApplicationContext(),mg,Toast.LENGTH_SHORT).show();
    }
}
