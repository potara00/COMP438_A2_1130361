package com.example.lenovo.assginment_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int ADD=0,SUB=1,MULT=2,DIV=3;

    TextView txtNumber;

    double memoryValue;
    double result = 0.0;
    double readValue;
    int currentOperation = -1;
    boolean initalized = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber = (TextView) findViewById(R.id.txtNumber);


    }


    /**
     *	These methods are action listeners for appending numbers from 0-9 to the readValue text view
     */
//#####################################################################################################
    public void numberZero(View view) {                                                                //#
        if (!emptyEntry())
            txtNumber.append(0 + "");

    }
    //#
    //#
    public void numberOne(View view) {																//#
        if (emptyEntry()) 																			//#
            txtNumber.setText(1 + "");																//#
        else 																						//#
            txtNumber.append(1 + "");																//#
        //#
    }																								//#
    //#
    public void numberTwo(View view) {																//#
        if (emptyEntry()) 																			//#
            txtNumber.setText(2 + "");																//#
        else																						//#
            txtNumber.append(2 + "");																//#
    }																								//#
    //#
    public void numberThree(View view) {															//#
        if (emptyEntry()) 																			//#
            txtNumber.setText(3 + "");																//#
        else																						//#
            txtNumber.append(3 + "");																//#
    }																								//#
    //#
    public void numberFour(View view) {																//#
        if (emptyEntry()) 																			//#
            txtNumber.setText(4 + "");																//#
        else																						//#
            txtNumber.append(4 + "");																//#
    }																								//#
    //#
    public void numberFive(View view) {																//#
        if (emptyEntry()) 																			//#
            txtNumber.setText(5 + "");																//#
        else																						//#
            txtNumber.append(5 + "");																//#
    }																								//#
    //#
    public void numberSix(View view) {																//#
        if (emptyEntry()) 																			//#
            txtNumber.setText(6 + "");																//#
        else																						//#
            txtNumber.append(6 + "");																//#
    }																								//#
    //#
    public void numberSeven(View view) {															//#
        if (emptyEntry()) 																			//#
            txtNumber.setText(7 + "");																//#
        else																						//#
            txtNumber.append(7 + "");																//#
    }																								//#
    //#
    public void numberEight(View view) {															//#
        if (emptyEntry()) 																			//#
            txtNumber.setText(8 + "");																//#
        else																						//#
            txtNumber.append(8 + "");																//#
    }																								//#
    //#
    public void numberNine(View view) {																//#
        if (emptyEntry()) 																			//#
            txtNumber.setText(9 + "");																//#
        else																						//#
            txtNumber.append(9 + "");																//#
    }																							    //#
//#####################################################################################################

    public void sum(View view) {
        if (validateEntry()) {
            readValue = Double.parseDouble(txtNumber.getText() + "");
            if (initalized)
                calculate();
            else
                initalize();

            currentOperation = ADD;
            txtNumber.setText("");
        }
    }

    public void sub(View view) {
        if (validateEntry()) {
            readValue = Double.parseDouble(txtNumber.getText() + "");
            if (initalized)
                calculate();
            else
                initalize();

        }

        currentOperation = SUB;
        txtNumber.setText("");
    }

    public void div(View view) {
        if (validateEntry()) {
            readValue = Double.parseDouble(txtNumber.getText() + "");
            if (initalized)
                calculate();
            else
                initalize();

            currentOperation = DIV;
            txtNumber.setText("");
        }
    }

    public void multiply(View view) {
        if (validateEntry()) {
            readValue = Double.parseDouble(txtNumber.getText() + "");
            if (initalized)
                calculate();
            else
                initalize();

            currentOperation = MULT;
            txtNumber.setText("");
        }
    }


    /**
     *shits to the right, removing a readValue from the text view
     */
    public void back(View view) {
        if (validateEntry()) {
            txtNumber.setText(txtNumber.getText().subSequence(0, txtNumber.getText().length() - 1));
        }
    }

    /**
     *negatives the value if it's positive
     */
    public void negative(View view) {
        Double value = Double.parseDouble(txtNumber.getText()+"");
        txtNumber.setText((value*-1)+ "");
    }

    /**
     *saves value to memory
     */
    public void saveToMemo(View view) {
        if(!txtNumber.getText().equals("") && txtNumber.getText().equals(null))
            this.memoryValue = Double.parseDouble(txtNumber.getText() + "");
        txtNumber.setText("");
        result = 0.0;
        initalized = false;
        currentOperation = -1;
    }

    /**
     *calls value from memory
     */
    public void recordToMemo(View view) {
        txtNumber.setText(memoryValue + "");

    }

    /**
     *clears memory
     */
    public void clearToMemo(View view) {
        this.memoryValue = 0;
    }

    /**
     *clears everything
     */
    public void clear(View view) {
        txtNumber.setText("");
        result = 0.0;
        initalized = false;
        currentOperation = -1;

    }

    /**
     *initalizes the program (first input submitted)
     */
    private void initalize(){
        result = readValue;
        initalized = true;
    }

    /**
     *checks if data in text is valid
     */
    private boolean validateEntry(){
        if(txtNumber.getText().equals(null) || txtNumber.getText().equals(""))
            return false;
        return true;
    }

    /**
     *checks if the data in text is empty (nullified, equals zero)
     */
    private boolean emptyEntry(){
        if (txtNumber.getText().equals("0") || txtNumber.getText().equals("0.0"))
            return true;
        else
            return false;
    }

    /**
     *assigns new value to result based on last read readValue and current operation
     */
    private void calculate() {

        if (currentOperation == ADD) {
            result += readValue;
            txtNumber.setText(result + "");
        } else if (currentOperation == MULT) {
            result *= readValue;
            txtNumber.setText(result + "");

        } else if (currentOperation == SUB) {
            result -= readValue;
            txtNumber.setText(result + "");


        } else if (currentOperation == DIV) {
            result /= readValue;
            txtNumber.setText(result + "");

        } else {
            result = result;
            txtNumber.setText(result + "");

        }
    }

    /**
     *equals button AS, prints the final result
     *
     */
    public void result(View view) {
        readValue = Double.parseDouble(txtNumber.getText() + "");
        calculate();
        txtNumber.setText(result + "");
        currentOperation = -1;
    }

}
