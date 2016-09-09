package activitytest.example.com.pangbo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView ;

    private EditText editText;

    private AlertDialog.Builder dialog ;

    private Button income, outcome;

    private int money = 10000 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new AlertDialog.Builder(MainActivity.this);

        editText = new EditText(this);

        textView = (TextView) findViewById(R.id.asset);
        textView.setText(Integer.toString(money));

        income = (Button) findViewById(R.id.income);
        income.setOnClickListener(this);

        outcome = (Button) findViewById(R.id.outcome);
        outcome.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.income:
                dialog = new AlertDialog.Builder(MainActivity.this);
                editText = new EditText(this);
                dialog.setTitle("请输入收入金额")
                        .setView(editText)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String str = editText.getText().toString();
                                int ic = Integer.parseInt(str);
                                money += ic;
                                textView.setText(Integer.toString(money));
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
                break;
            case R.id.outcome:
                dialog = new AlertDialog.Builder(MainActivity.this);
                editText = new EditText(this);
                dialog.setTitle("请输入支出金额")
                        .setView(editText)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String str = editText.getText().toString();
                                int ic = Integer.parseInt(str);
                                money -= ic;
                                textView.setText(Integer.toString(money));
                            }
                        }).setNegativeButton("取消", null).show();
                break;
        }
    }

}
