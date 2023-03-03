package com.example.notas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {

    ArrayList<String> lix = new ArrayList<String>();
    TextView view_user,view_nota;
    Button btn_volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        view_user = (TextView) findViewById(R.id.view_user);
        view_nota = (TextView) findViewById(R.id.view_nota);
        btn_volver = (Button) findViewById(R.id.btn_volver);

        lix = getIntent().getStringArrayListExtra("list");
        view_user.setText(lix.get(0));
        view_nota.setText(lix.get(1));


    }

    public void volver(View view) {
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
}
