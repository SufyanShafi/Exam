package com.example.scientificcalculater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.scientificcalculater.R;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    Button btnClear, btnEqual,btnshift,btnred,btnms,btndot;
    Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix,
            btnSeven, btnEight, btnNine, btnZero, btnDecimal,
            btnDoubleZero, btnPercentage;
    Button btnans,btnexp;
    Button btnAdd, btnMinus, btnMultiply, btnDivide,btnm_plus,btnhys,btnsin,btncos,btntan;
    Button btnnatural_log,btnlog,btnx_power_y,btnsquare,btnsquareroot,btnx_square,btnopn_bracket,btnclose_bracket;

    TextView tvExpression1, tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnClear = (Button) findViewById(R.id.clear);
        btnEqual = findViewById(R.id.equal);

        btnOne = findViewById(R.id.One);
        btnTwo = findViewById(R.id.Two);
        btnThree = findViewById(R.id.Three);
        btnFour = findViewById(R.id.Four);
        btnFive = findViewById(R.id.Five);
        btnSix = findViewById(R.id.Six);
        btnSeven = findViewById(R.id.seven);
        btnEight = findViewById(R.id.eight);
        btnNine = findViewById(R.id.nine);

        btnZero = findViewById(R.id.zero);

        btnPercentage = findViewById(R.id.percent);


        btnAdd = findViewById(R.id.Add);
        btnMinus = findViewById(R.id.Minus);
        btnMultiply = findViewById(R.id.multiply);
        btnDivide = findViewById(R.id.Divide);
        btnclose_bracket=findViewById(R.id.close_bracket);
        btncos=findViewById(R.id.cos);
        btnans=findViewById(R.id.ans);
        btnx_square=findViewById(R.id.x_square);
        btnopn_bracket=findViewById(R.id.open_bracket);
        btnshift=findViewById(R.id.shift);
        btnlog=findViewById(R.id.log);
        btnsquareroot=findViewById(R.id.square_root);
        btnexp=findViewById(R.id.exp);
        btnms=findViewById(R.id.ms);
        btndot=findViewById(R.id.dot);
        btnred=findViewById(R.id.rad);
        btnhys=findViewById(R.id.hys);
        btnsin=findViewById(R.id.sin);
        btntan=findViewById(R.id.tan);
        btnnatural_log=findViewById(R.id.natural_log);
        btnm_plus=findViewById(R.id.m_plus);
        btnx_power_y=findViewById(R.id.x_power_y);
        btnsquare=findViewById(R.id.x_square);



        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearScreen();
            }
        });


        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("1");
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("2");
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("3");
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("4");
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("5");
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("6");
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("7");
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("8");
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("9");
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("0");
            }
        });
        btnDoubleZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("00");
            }
        });
        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression(".");
            }
        });



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("+");
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("-");
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("*");
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("/");
            }
        });
        btnPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("/100");
            }
        });
        btnclose_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression("(");

            }
        });
        btnclose_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeExpression(")");

            }
        });

        tvExpression1 = findViewById(R.id.tvExpression1);
        tvResult = findViewById(R.id.tvResult);

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String exp = tvExpression1.getText().toString();
                Expression e = new Expression(exp);
                String Result = String.valueOf(e.calculate());
                tvResult.setText(Result);
            }
        });


    }


    void clearScreen(){
        tvExpression1.setText("");
        tvResult.setText("0");
    }


    void writeExpression(String text){
        String oldExpression = tvExpression1.getText().toString();
        String newExpressin = oldExpression + text;
        tvExpression1.setText(newExpressin);
    }

}
