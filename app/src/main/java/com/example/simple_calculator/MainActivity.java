package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Class Variables
    private enum Operator {none, add, minus, multiply, divide}
    private double data1, data2;
    private Operator optr = Operator.none;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickNumber(View view){

        int btnID = view.getId();
        TextView display = (TextView)findViewById(R.id.resultEdit);

        switch (btnID){
            case R.id.btn00:
                display.setText(display.getText() + "0");
                break;
            case R.id.btn01:
                display.setText(display.getText() + "1");
                break;
            case R.id.btn02:
                display.setText(display.getText() + "2");
                break;
            case R.id.btn03:
                display.setText(display.getText() + "3");
                break;
            case R.id.btn04:
                display.setText(display.getText() + "4");
                break;
            case R.id.btn05:
                display.setText(display.getText() + "5");
                break;
            case R.id.btn06:
                display.setText(display.getText() + "6");
                break;
            case R.id.btn07:
                display.setText(display.getText() + "7");
                break;
            case R.id.btn08:
                display.setText(display.getText() + "8");
                break;
            case R.id.btn09:
                display.setText(display.getText() + "9");
                break;
            case R.id.btnDEC:
                display.setText(display.getText() + ".");
                break;
            default:
                display.setText("ERR");
                break;
        }

    }

    public void clickOperator(View view){

        int btnID = view.getId();
        TextView display = (TextView)findViewById(R.id.resultEdit);

        switch (btnID) {
            case R.id.btnClear:
                display.setText("");
                break;
            case R.id.btnDivide:
                optr = Operator.divide;
                data1 = Double.parseDouble(display.getText().toString());
                display.setText("");
                break;
            case R.id.btnMinus:
                optr = Operator.minus;
                data1 = Double.parseDouble(display.getText().toString());
                display.setText("");
                break;
            case R.id.btnMultiply:
                optr = Operator.multiply;
                data1 = Double.parseDouble(display.getText().toString());
                display.setText("");
                break;
            case R.id.btnPlus:
                optr = Operator.add;
                data1 = Double.parseDouble(display.getText().toString());
                display.setText("");
                break;
            case R.id.btnResult:
                String eq = (String) display.getText();

                if (optr != Operator.none){
                    data2 = Double.parseDouble(display.getText().toString());
                    double result = 0;
                    if (optr == Operator.add){
                        result = data1 + data2;
                    }else if (optr == Operator.minus){
                        result = data1 - data2;
                    }else if (optr == Operator.multiply){
                        result = data1 * data2;
                    }else if (optr == Operator.divide){
                        result = data1 / data2;
                    }
                    optr = Operator.none;
                    data1 = result;
                    if (result - (int)result != 0){
                        display.setText(String.valueOf(result));
                    }else {
                        display.setText(String.valueOf((int)result));
                    }

                }

                break;
            default:
                display.setText("ERR");
                break;
        }

    }



}