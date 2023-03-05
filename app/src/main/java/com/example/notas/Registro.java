package com.example.notas;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;

import java.util.ArrayList;
import java.util.Random;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> list = new ArrayList<String>();
    EditText txt_user,txtPassword;
    Button btn_nota,btn_volver;
    private static final String NOTA = nota();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        btn_nota = (Button) findViewById(R.id.btn_nota);
        btn_volver = (Button) findViewById(R.id.btn_volver);
        txt_user = (EditText) findViewById(R.id.txt_user);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        btn_nota.setOnClickListener(this);
    }

    private static String nota() {
        Random nota = new Random();
        nota.setSeed(System.currentTimeMillis());
        int n = nota.nextInt(6), f=nota.nextInt(10);
        if(n==5) f=0;
        if(n==0) n+=1;
        return n+"."+f+"";
    }

    @Override
    public void onClick(View view) {
        list.clear();
        if((txt_user.getText().toString().isEmpty()) || (txtPassword.getText().toString().isEmpty())) {
            Toast.makeText(this,"Error en el usuario o contraseña",Toast.LENGTH_LONG).show();
        }else {
            list.add("Usuario: "+txt_user.getText().toString());
            list.add("Nota: "+NOTA);
            Intent class3 = new Intent(Registro.this, Lista.class);
            class3.putStringArrayListExtra("list", list);
            startActivity(class3);
        }
    }

    public void volver(View view) {
        Intent intent = new Intent(Registro.this, MainActivity.class);
        startActivity(intent);
    }
}