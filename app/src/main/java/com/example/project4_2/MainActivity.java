package com.example.project4_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView text1,text2;
    Switch chkAgree;
    RadioGroup rGroup1;
    RadioButton pie, qq, rr;
    Button btnExit, btnFirst;
    ImageView imgand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        chkAgree = (Switch) findViewById(R.id.ChkAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        pie = (RadioButton) findViewById(R.id.pie);
        qq = (RadioButton) findViewById(R.id.qq);
        rr = (RadioButton) findViewById(R.id.rr);

        btnExit = (Button) findViewById(R.id.BtnExit);
        btnFirst = (Button) findViewById(R.id.BtnFirst);
        imgand = (ImageView) findViewById(R.id.ImgAnd);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(chkAgree.isChecked() == true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnExit.setVisibility(View.VISIBLE);
                    btnFirst.setVisibility(View.VISIBLE);
                    imgand.setVisibility(View.VISIBLE);
                } else {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnExit.setVisibility(View.INVISIBLE);
                    btnFirst.setVisibility(View.INVISIBLE);
                    imgand.setVisibility(View.INVISIBLE);
                }
            }
        });

        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int checkedRadio = rGroup1.getCheckedRadioButtonId();
                if(checkedRadio == R.id.pie){
                    imgand.setImageResource(R.drawable.one);
                } else if (checkedRadio == R.id.qq){
                    imgand.setImageResource(R.drawable.two);
                } else if (checkedRadio == R.id.rr){
                    imgand.setImageResource(R.drawable.three);
                } else {
                    Toast.makeText(getApplicationContext(), "버전 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkAgree.setChecked(false);
                pie.setChecked(false);
                qq.setChecked(false);
                rr.setChecked(false);
                imgand.setImageResource(0);
            }
        });

        //
    }
}