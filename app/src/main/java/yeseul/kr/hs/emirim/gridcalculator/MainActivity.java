package yeseul.kr.hs.emirim.gridcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static yeseul.kr.hs.emirim.gridcalculator.R.id.but0;

public class MainActivity extends AppCompatActivity{
    Button[] butNums=new Button[10];
    Button[] butOps=new Button[4];
    //int[] ids={R.id.but0, R.id.but1, R.id.but2, R.id.but3, R.id.but4, R.id.but5, R.id.but6, R.id.but7, R.id.but8, R.id.but9}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i < butNums.length; i++){
            //butNums[i]=(Button)findViewById(ids[i]);
            butNums[i]=(Button)findViewById(R.id.but0+i);
            butNums[i].setOnClickListener(butNumHandler);
        }

        for(int i = 0; i < butOps.length; i++){
            butOps[i] = (Button)findViewById(R.id.but0+i);
            butOps[i].setOnClickListener(butOpsHandler);
        }
    }

    View.OnClickListener butNumHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    View.OnClickListener butOpsHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    }; //익명클래스로 참조값 할당하기 때문에 ; 써줘야함
}
