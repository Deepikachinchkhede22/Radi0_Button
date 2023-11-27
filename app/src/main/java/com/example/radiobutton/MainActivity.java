package com.example.radiobutton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button btnSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();


        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextConvert textConvert = new TextConvert(MainActivity.this, editText.getText().toString());
                textConvert.setOnOkListener(new MyOnOkClickListener());
                textConvert.show();


            }
        });
    }
    public void mt(String text) {

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    private class MyOnOkClickListener implements TextConvert.OnOkListener{
        @Override
        public void forTextChange(String text, TextConvert textConvert) {
            textConvert.dismiss();
            editText.setText(text);
        }
    }

    public void initViews(){
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        btnSet = findViewById(R.id.btnSet);
    }
}




