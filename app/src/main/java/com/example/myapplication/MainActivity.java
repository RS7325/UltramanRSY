package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button point;
    Button clear;
    Button add;
    Button substraction;
    Button mulitipliction;
    Button division;
    Button surplus;
    Button equal;
    Button delete;
    Button e;
    TextView theFirstView;
    TextView theOptionView;
    TextView theSecondView;
    TextView theEqualView;
    TextView theAnswerView ;
    String option = "";
    String str1 = "",str2 = "";
    double number1 ,number2;
    int answerFlag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();  //初始化布局
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
                if(answerFlag == 0){
                    if(option == ""){
                        str1 = str1+((Button) view).getText().toString();
                        theFirstView.setText(str1);
                    }
                    else{
                        str2 = str2+((Button) view).getText().toString();
                        theSecondView.setText(str2);
                    }
                }

                if(answerFlag == 1){
                    clear();
                    answerFlag = 0;
                    str1 = str1+((Button) view).getText().toString();
                    theFirstView.setText(str1);
                }

                break;

            case R.id.e:
                if(answerFlag == 0){
                    if(option == ""){
                        str1 = str1+"2.718281828459";
                        theFirstView.setText(str1);
                    }
                    else{
                        str2 = str2+"2.718281828459";
                        theSecondView.setText(str2);
                    }
                }

                if(answerFlag == 1){
                    clear();
                    answerFlag = 0;
                    str1 = str1+"2.718281828459";
                    theFirstView.setText(str1);
                }
                break;

            case R.id.point:
                if(str1 != "" && option == ""){
                    str1 = str1+((Button) view).getText().toString();
                    theFirstView.setText(str1);
                }
                if(option != "" && str2 != ""){
                    str2 = str2+((Button) view).getText().toString();
                    theSecondView.setText(str2);
                }
                else{
                    //什么都不执行
                }
                break;

            case R.id.add:
                option = "+";
                theOptionView.setText("+");
                break;

            case R.id.substraction:
                option = "-";
                theOptionView.setText("-");
                break;

            case R.id.mulitipliction:
                option = "×";
                theOptionView.setText("×");
                break;

            case R.id.division:
                option = "÷";
                theOptionView.setText("÷");
                break;

            case R.id.surplus:
                option = "%";
                theOptionView.setText("%");
                break;



            case R.id.clear:
                clear();
                break;

            case R.id.delete:
                if(theAnswerView.getText().toString() == ""){
                    if((theSecondView.getText().toString())!= ""){
                        int length = str2.length();
                        if(length == 1){
                            theSecondView.setText("");
                        }
                        else{
                            str2 = str2.substring(0,length-1);
                            theSecondView.setText(str2);
                        }
                        break;
                    }
                    if((theSecondView.getText().toString()) == "" && (theOptionView.getText().toString()) != ""){
                        theOptionView.setText("");
                        break;
                    }
                    if((theSecondView.getText().toString()) == "" && (theAnswerView.getText().toString()) == "" && (theFirstView.getText().toString()) != ""){
                        int length = str1.length();
                        if(length == 1){
                            theFirstView.setText("");
                        }
                        else{
                            str1 = str1.substring(0,length-1);
                            theFirstView.setText(str1);
                        }
                        break;
                    }
                }
                break;


            case R.id.equal:
                DecimalFormat df = new DecimalFormat("#.0000");
                theEqualView.setText("=");
                answerFlag = 1;

                if(option == "+"){
                    number1 = Double.parseDouble(theFirstView.getText().toString());
                    number2 = Double.parseDouble(theSecondView.getText().toString());
                    theAnswerView.setText( df.format(number1+number2)+"");
                }
                if(option == "-"){
                    number1 = Double.parseDouble(theFirstView.getText().toString());
                    number2 = Double.parseDouble(theSecondView.getText().toString());
                    theAnswerView.setText( df.format(number1-number2)+"");
                }
                if(option == "×"){
                    number1 = Double.parseDouble(theFirstView.getText().toString());
                    number2 = Double.parseDouble(theSecondView.getText().toString());
                    theAnswerView.setText( df.format(number1*number2)+"");
                }
                if(option == "÷"){
                    number1 = Double.parseDouble(theFirstView.getText().toString());
                    number2 = Double.parseDouble(theSecondView.getText().toString());
                    if(number2 == 0){
                        theAnswerView.setText("错误");
                    }
                    else{
                        theAnswerView.setText( df.format(number1/number2)+"");
                    }
                }
                if(option == "%"){
                    number1 = Double.parseDouble(theFirstView.getText().toString());
                    number2 = Double.parseDouble(theSecondView.getText().toString());
                    theAnswerView.setText(df.format(number1%number2)+"");
                }
                break;

        }
    }


    public void initView(){
        zero = (Button)findViewById(R.id.zero);
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        point = (Button)findViewById(R.id.point);
        clear = (Button)findViewById(R.id.clear);
        add = (Button)findViewById(R.id.add);
        substraction = (Button)findViewById(R.id.substraction);
        mulitipliction = (Button)findViewById(R.id.mulitipliction);
        division = (Button)findViewById(R.id.division);
        surplus = (Button)findViewById(R.id.surplus);
        equal = (Button)findViewById(R.id.equal);
        delete = (Button)findViewById(R.id.delete);
        theFirstView = (TextView)findViewById(R.id.the_first_number);
        theOptionView = (TextView)findViewById(R.id.the_option);
        theSecondView = (TextView)findViewById(R.id.the_second_number);
        theEqualView = (TextView)findViewById(R.id.the_equal);
        theAnswerView = (TextView)findViewById(R.id.the_answer);
        e = (Button)findViewById(R.id.e);

        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        point.setOnClickListener(this);
        clear.setOnClickListener(this);
        add.setOnClickListener(this);
        substraction.setOnClickListener(this);
        mulitipliction.setOnClickListener(this);
        division.setOnClickListener(this);
        e.setOnClickListener(this);
        surplus.setOnClickListener(this);
        equal.setOnClickListener(this);
        delete.setOnClickListener(this);
        theFirstView.setOnClickListener(this);
        theOptionView.setOnClickListener(this);
        theEqualView.setOnClickListener(this);
        theSecondView.setOnClickListener(this);
        theAnswerView.setOnClickListener(this);
    }

    public void clear(){
        str1 = "";
        str2 = "";
        theFirstView.setText("");
        theSecondView.setText("");
        theOptionView.setText("");
        theEqualView.setText("");
        theAnswerView.setText("");
        option = "";
    }


}