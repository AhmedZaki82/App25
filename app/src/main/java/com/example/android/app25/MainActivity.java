package com.example.android.app25;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtArrayDoubleValues = (TextView) findViewById(R.id.txtArrayDoubleValues);
        TextView txtArrayIntegerNumber = (TextView) findViewById(R.id.txtArrayIntegerNumber);
        TextView txtIntArray1 = (TextView) findViewById(R.id.txtIntArray1);
        TextView txtIntArray1Copy = (TextView) findViewById(R.id.txtIntArray1Copy);
        TextView txtLocationArrayElement = (TextView) findViewById(R.id.txtLocationArrayElement);
        Switch swtEqual = (Switch) findViewById(R.id.swtEqual);


        double[] doubleValuesArray = {21.3,4.5,33.6,12.5,44.8,23.5,57.4,89.2,45.1,79.5};

        Arrays.sort(doubleValuesArray);
        for (double sort : doubleValuesArray) {
            String oldDisplay = txtArrayDoubleValues.getText().toString();
            txtArrayDoubleValues.setText(oldDisplay + sort + "        ");
        }

        int[] intNumbersArray = new int[20];

        Arrays.fill(intNumbersArray,1);

        outputTheArrayToTheScreen(intNumbersArray,txtArrayIntegerNumber);


        int[] integerArray1 = {100,200,300,400,500,600,700,800,900,1000};
        int[] integerArray1Copy = new int[integerArray1.length];

        System.arraycopy(integerArray1,0,integerArray1Copy,0,integerArray1.length);

        outputTheArrayToTheScreen(integerArray1,txtIntArray1);
        outputTheArrayToTheScreen(integerArray1Copy,txtIntArray1Copy);

        boolean isEqual = Arrays.equals(integerArray1,integerArray1Copy);
        swtEqual.setChecked(isEqual ? true : false);
        swtEqual.setText(isEqual ? "The values of these Arrays are Equal" :
                "Not Equal");


        int arrayElement = Arrays.binarySearch(doubleValuesArray, 4.5);

        if (arrayElement >= 0) {

            txtLocationArrayElement.setText(String.format("We found 4.5 value at element %d"+
            " in doubleValuesArray", arrayElement));
        }else{
            txtLocationArrayElement.setText("Couldn'tfind the value in that Array.");
        }


    }

    public void outputTheArrayToTheScreen(int[]array,TextView textView) {

        String oldValue;

        for (int value : array) {

            oldValue = textView.getText().toString();
            textView.setText(oldValue + value + "         ");
        }
    }

}
