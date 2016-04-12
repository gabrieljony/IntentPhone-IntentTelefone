package com.example.gabriel.intenttelefone;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtNum;
    private Button btnLigar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtNum = (EditText) findViewById(R.id.edtNum);
        btnLigar = (Button) findViewById(R.id.btnLigar);

        btnLigar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String telefone = edtNum.getText().toString();

        Uri uri = Uri.parse("tel: " + telefone);
        //Intent i = new Intent(Intent.ACTION_DIAL, uri);//criamos um Intent passando no seu construtor o tipo de ligação,  ACTION_DIAL, que abre a janela com a opção de alterar o telefone
        Intent i = new Intent(Intent.ACTION_CALL, uri);//faz a ligação direta, na contagem da ligação
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(i);

    }
}
