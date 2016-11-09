package com.example.maimanhduy.calculatorproject;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import nguyenvanquan7826.com.Balan;

import static com.example.maimanhduy.calculatorproject.R.id.cong;

public class MainActivity extends Activity implements View.OnClickListener {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, btNhan, btChia, btCong, btTru, btBang, btCham, btPhanTram, btC;
    TextView ketqua, bieuthuc;
    String bieutThucSo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        if (savedInstanceState != null) {
            ketqua.setText(savedInstanceState.getString("ketqua"));
            bieuthuc.setText(savedInstanceState.getString("bieuthuc"));
        }
        ketqua.setMovementMethod(new ScrollingMovementMethod());
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        btNhan.setOnClickListener(this);
        btChia.setOnClickListener(this);
        btCong.setOnClickListener(this);
        btTru.setOnClickListener(this);
        btBang.setOnClickListener(this);
        btCham.setOnClickListener(this);
        btPhanTram.setOnClickListener(this);
        btC.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.so0:
                bieutThucSo = bieutThucSo + "0";
                ketqua.setText(bieutThucSo);
                break;
            case R.id.so1:
                bieutThucSo = bieutThucSo + "1";
                ketqua.setText(bieutThucSo);
                break;
            case R.id.so2:
                bieutThucSo = bieutThucSo + "2";
                ketqua.setText(bieutThucSo);
                break;
            case R.id.so3:
                bieutThucSo = bieutThucSo + "3";
                ketqua.setText(bieutThucSo);
                break;
            case R.id.so4:
                bieutThucSo = bieutThucSo + "4";
                ketqua.setText(bieutThucSo);
                break;
            case R.id.so5:
                bieutThucSo = bieutThucSo + "5";
                ketqua.setText(bieutThucSo);
                break;
            case R.id.so6:
                bieutThucSo = bieutThucSo + "6";
                ketqua.setText(bieutThucSo);
                break;
            case R.id.so7:
                bieutThucSo = bieutThucSo + "7";
                ketqua.setText(bieutThucSo);
                break;
            case R.id.so8:
                bieutThucSo = bieutThucSo + "8";
                ketqua.setText(bieutThucSo);
                break;
            case R.id.so9:
                bieutThucSo = bieutThucSo + "9";
                ketqua.setText(bieutThucSo);
                break;
            case R.id.nhan:
                bieutThucSo = bieutThucSo + "*";
                ketqua.setText(bieutThucSo);
                break;
            case R.id.chia:
                bieutThucSo = bieutThucSo + "/";
                ketqua.setText(bieutThucSo);
                break;
            case cong:
                bieutThucSo = bieutThucSo + "+";
                ketqua.setText(bieutThucSo);
                break;
            case R.id.tru:
                bieutThucSo = bieutThucSo + "-";
                ketqua.setText(bieutThucSo);
                break;
            case R.id.bang:
                bieuthuc.setText(bieutThucSo);
                cal();
                break;
            case R.id.cham:
                bieutThucSo = bieutThucSo + ".";
                ketqua.setText(bieutThucSo);
                break;
            case R.id.phantram:
                // do stuff;
                break;
            case R.id.idC:
                bieuthuc.setText("0");
                ketqua.setText("0");
                bieutThucSo = "";
                break;
        }
    }

    public void Anhxa() {
        button0 = (Button) findViewById(R.id.so0);
        button1 = (Button) findViewById(R.id.so1);
        button2 = (Button) findViewById(R.id.so2);
        button3 = (Button) findViewById(R.id.so3);
        button4 = (Button) findViewById(R.id.so4);
        button5 = (Button) findViewById(R.id.so5);
        button6 = (Button) findViewById(R.id.so6);
        button7 = (Button) findViewById(R.id.so7);
        button8 = (Button) findViewById(R.id.so8);
        button9 = (Button) findViewById(R.id.so9);
        btNhan = (Button) findViewById(R.id.nhan);
        btChia = (Button) findViewById(R.id.chia);
        btCong = (Button) findViewById(cong);
        btTru = (Button) findViewById(R.id.tru);
        btBang = (Button) findViewById(R.id.bang);
        btCham = (Button) findViewById(R.id.cham);
        btPhanTram = (Button) findViewById(R.id.phantram);
        bieuthuc = (TextView) findViewById(R.id.bieuthuc);
        ketqua = (TextView) findViewById(R.id.ketqua);
        btC = (Button) findViewById(R.id.idC);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("ketqua", ketqua.getText().toString());
        outState.putString("bieuthuc", bieuthuc.getText().toString());
        super.onSaveInstanceState(outState);
    }

    public void cal() {
        if (bieutThucSo.length() > 0) {
            Balan balan = new Balan();
            String result = balan.valueMath(bieutThucSo) + "";
            String error = balan.getError();
            // check error
            if (error != null) {
                ketqua.setText(error);
            } else { // show result
                ketqua.setText(result);
            }
        }
    }
}
