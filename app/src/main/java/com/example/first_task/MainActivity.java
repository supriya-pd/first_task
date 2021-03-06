package com.example.first_task;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int opr;
    int oprf;
    int opw1;
    int opw2;
    EditText e1 ;
    Button b ;
    Button b1 ;
    Button b2 ;
    Button b3 ;
    TextView t1 ;
    TextView t2 ;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         e1 = findViewById(R.id.num);
         b = findViewById(R.id.btn);
         b1 = findViewById(R.id.option1);
         b2 = findViewById(R.id.option2);
         b3 = findViewById(R.id.option3);
         t1 = findViewById(R.id.textView);
         t2 = findViewById(R.id.textView2);


        int num=Integer.parseInt(e1.getText().toString());
        int[] list = {0}; int q;
        int i=1; int count=0;
        int sqrt=(int)Math.pow(num,0.5);
        for(;i<=sqrt;i++)
        {
            if(num%i==0){

                q=num/i;
                if(q==i) {
                    list[count++] =i;
                }

                else{
                    list[count++]=i;
                    list[count++]=q;
                }
            }
        }

        opr=(int)((Math.ceil(Math.random()*10)%3)+1);
        oprf=(int)(Math.ceil(Math.random()*10)%count);//index of opr
        opw1=(int)((Math.ceil(Math.random()*10)%num)+1);
        opw2=(int)((Math.ceil(Math.random()*10)%num)+1);

        switch(opr) {

            case 1:
                b1.setText(Integer.toString(list[oprf]));
                b2.setText(Integer.toString(opw1));
                b3.setText(Integer.toString(opw2));
                break;
            case 2:
                b2.setText(Integer.toString(list[oprf]));
                b1.setText(Integer.toString(opw1));
                b3.setText(Integer.toString(opw2));
                break;
            case 3:
                b3.setText(Integer.toString(list[oprf]));
                b2.setText(Integer.toString(opw1));
                b1.setText(Integer.toString(opw2));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + opr);
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                b1.setVisibility(View.VISIBLE);
                b2.setVisibility(View.VISIBLE);
                b3.setVisibility(View.VISIBLE);


            }
        });


        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.option1 :
                if(opr==1){
                    t1.setText("Right");
                    t1.setVisibility(View.VISIBLE);
                }
                else{
                    t1.setText("Wrong");
                    t2.setText("Correct Option is option  "+opr);
                    t1.setVisibility(View.VISIBLE);
                    t2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.option2 :
                if(opr==2){
                    t1.setText("Right");
                    t1.setVisibility(View.VISIBLE);
                }
                else{
                    t1.setText("Wrong");
                    t2.setText("Correct Option is option  "+opr);
                    t1.setVisibility(View.VISIBLE);
                    t2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.option3 :
                if(opr==3){
                    t1.setText("Right");
                    t1.setVisibility(View.VISIBLE);
                }
                else{
                    t1.setText("Wrong");
                    t2.setText("Correct Option is option  "+opr);
                    t1.setVisibility(View.VISIBLE);
                    t2.setVisibility(View.VISIBLE);
                }
                break;
        }

    }
}
