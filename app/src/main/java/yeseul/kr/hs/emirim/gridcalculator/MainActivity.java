package yeseul.kr.hs.emirim.gridcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    TextView result;
    Button zero, one, two, three, four, five, six, seven, eight, nine, plus, minus, multiply, division;
    Button[] butNums = new Button[10];
    Button[] butOps = new Button[4];
    public static final int SELECT_EDIT1 = 0;
    public static final int SELECT_EDIT2 = 1;
    int selectEdit = SELECT_EDIT1;
    int num1, num2;
    String numStr = "";
    /* int[] ids = { R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine};*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1=(EditText)findViewById(R.id.text1);
        edit2=(EditText)findViewById(R.id.text2);
        edit1.setOnTouchListener(EditHandler);
        edit2.setOnTouchListener(EditHandler);
        result = (TextView)findViewById(R.id.result);
        /*text1 = (EditText)findViewById(R.id.text1);
        text2 = (EditText)findViewById(R.id.text2);
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
        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        multiply = (Button)findViewById(R.id.multiply);
        division = (Button)findViewById(R.id.division);*/

        for(int i = 0; i < butNums.length; i++){
            // butNums[i] = (Button)findViewById(ids[i]);
            butNums[i] = (Button)findViewById(R.id.but0 + i);
            butNums[i].setOnClickListener(butNumHandler);
        }

        for(int i = 0; i < butOps.length; i++){
            // butNums[i] = (Button)findViewById(ids[i]);
            butOps[i] = (Button)findViewById(R.id.but0 + i);
            butOps[i].setOnClickListener(butOpHandler);
        }


    }
    View.OnClickListener butNumHandler = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            Button but = (Button)view;
            numStr+=but.getText();
            switch(selectEdit)
            {
                case SELECT_EDIT1:
                    edit1.setText(numStr);
                    break;
                case SELECT_EDIT2:
                    edit2.setText(numStr);
                    break;
            }
        }
    };

    View.OnClickListener butOpHandler = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            num1 = Integer.parseInt(edit1.getText().toString());
            num2 = Integer.parseInt(edit2.getText().toString());
            int res = 0;
            switch(view.getId()){
                case R.id.but1:
                    res = num1 + num2;
                    break;
                case R.id.but2:
                    res = num1 - num2;
                    break;
                case R.id.but3:
                    res = num1 / num2;
                    break;
                case R.id.but4:
                    res = num1 * num2;
                    break;
            }
            result.setText(""+res);
        }
    };
    View.OnTouchListener EditHandler = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            numStr = "";
            switch(view.getId()){
                case R.id.text1:
                    selectEdit = SELECT_EDIT1;
                    break;
                case R.id.text2:
                    selectEdit = SELECT_EDIT2;
                    break;
            }
            return true;
        }
    };
}
