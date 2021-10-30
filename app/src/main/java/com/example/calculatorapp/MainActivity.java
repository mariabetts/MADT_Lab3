package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button Num0, Num1, Num2, Num3, Num4, Num5, Num6, Num7, Num8, Num9;
    Button Clear, Delete, SquareRoot, Add, Subtract, Divide, Multiply, Equal, ChangeSign, Percent;

    TextView CalculatorScreen;
    TextView ResultsScreen;
    boolean leftBracket = true;
    String working = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num0 = findViewById(R.id.num0);
        Num1 = findViewById(R.id.num1);
        Num2 = findViewById(R.id.num2);
        Num3 = findViewById(R.id.num3);
        Num4 = findViewById(R.id.num4);
        Num5 = findViewById(R.id.num5);
        Num6 = findViewById(R.id.num6);
        Num7 = findViewById(R.id.num7);
        Num8 = findViewById(R.id.num8);
        Num9 = findViewById(R.id.num9);

        Clear = findViewById(R.id.clearbtn);

        Add = findViewById(R.id.add);
        Subtract = findViewById(R.id.subtract);
        Divide = findViewById(R.id.division);
        Multiply = findViewById(R.id.multiplication);
        SquareRoot = findViewById(R.id.SquareRoot);
        Percent = findViewById(R.id.precent);
        ChangeSign = findViewById(R.id.plusminus);


        Delete = findViewById(R.id.del);
        Equal = findViewById(R.id.equal);

        CalculatorScreen = findViewById(R.id.calculatorScreen);
        ResultsScreen = findViewById(R.id.resultscreen);


        //initiate listeners for Numbers
        Num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                CalculatorScreen.setText(val + Num0.getText().toString());
            }
        });
        Num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                CalculatorScreen.setText(val + Num1.getText().toString());
            }
        });
        Num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                CalculatorScreen.setText(val + Num2.getText().toString());
            }
        });
        Num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                CalculatorScreen.setText(val + Num3.getText().toString());
            }
        });
        Num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                CalculatorScreen.setText(val + Num4.getText().toString());
            }
        });
        Num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                CalculatorScreen.setText(val + Num5.getText().toString());
            }
        });
        Num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                CalculatorScreen.setText(val + Num6.getText().toString());
            }
        });
        Num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                CalculatorScreen.setText(val + Num7.getText().toString());
            }
        });
        Num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                CalculatorScreen.setText(val + Num8.getText().toString());
            }
        });
        Num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                CalculatorScreen.setText(val + Num9.getText().toString());
            }
        });

        //listeners for functions
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                if (!val.equals("")) {
                    CalculatorScreen.setText(val + Add.getText().toString());
                }
            }
        });
        Divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                if (!val.equals("")) {
                    CalculatorScreen.setText(val + Divide.getText().toString());
                }
            }
        });
        Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                char last = val.charAt(val.length() - 1);
                if (!val.equals("")) {
                    CalculatorScreen.setText(val + Multiply.getText().toString());
                }
            }
        });
        Subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                char last = val.charAt(val.length() - 1);
                if (last != '-') {
                    CalculatorScreen.setText(val + Subtract.getText().toString());
                }
            }
        });
        //this one is calculated in loop, all set
        Percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double d = Double.parseDouble(CalculatorScreen.getText().toString());
                double percent = d / 100;
                CalculatorScreen.setText(String.valueOf(percent));
                ResultsScreen.setText("%" + d);
            }
        });
        // this one is calculated in loop, all set
        SquareRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                double r = Math.sqrt(Double.parseDouble(val));
                String result = String.valueOf(r);
                CalculatorScreen.setText(result);
                ResultsScreen.setText("√" + val);
            }
        });

        //set listener for equal and bring up the eval function for later
        Equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                String replacedString = val.replace('÷','/').replace('×', '*');
                double result = eval(replacedString);
                String value = String.valueOf(result);
                CalculatorScreen.setText(value);
                ResultsScreen.setText(val);
            }
        });

        //set, and all in loop
        ChangeSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double d = Double.parseDouble(CalculatorScreen.getText().toString());
                if (d < 0)
                    d = Math.abs(d);
                else
                    d = -(d);
                CalculatorScreen.setText(String.valueOf(d));
                ResultsScreen.setText("");
            }
        });

        //initiate calc functions, use of boolean
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculatorScreen.setText("");
                ResultsScreen.setText("");
                leftBracket = true;
            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = CalculatorScreen.getText().toString();
                val = val.substring(0, val.length() - 1);
                CalculatorScreen.setText(val);
            }
        });

    }

    //final eval for functions

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean replace(int ChartoReplace) {
                while (ch == ' ') nextChar();
                if (ch == ChartoReplace) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() { // error messages
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            double parseExpression() { // eval add and subtract
                double x = parseTerm();
                for (;;) {
                    if      (replace('+')) x += parseTerm();
                    else if (replace('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() { // eval multiplication and division
                double x = parseFactor();
                for (;;) {
                    if      (replace('*')) x *= parseFactor();
                    else if (replace('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() { // eval functions and throw error messages
                if (replace('+')) return parseFactor(); //sign change
                if (replace('-')) return -parseFactor();

                double x;
                int startPos = this.pos;
                if ((ch >= '0' && ch <= '9') || ch == '.') { // display num
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // display functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x); // display square root
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                return x;
            }
        }.parse();
    }
}










