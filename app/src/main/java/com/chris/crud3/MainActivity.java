package com.chris.crud3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chris.crud3.Dao.UsuarioDao;
import com.chris.crud3.helper.Usuario;
import com.chris.crud3.sqlite.Conexao;

public class MainActivity extends AppCompatActivity {
    EditText txtNome, txtSenha, txtLogin;
    Button btnFloat;

    public void salvar(View view){
        txtNome = findViewById(R.id.txtNome);
        txtLogin = findViewById(R.id.txtLogin);
        txtSenha = findViewById(R.id.txtSenha);
        btnFloat = findViewById(R.id.btnFloat);

        Usuario usuario = new Usuario();
        usuario.setNome(txtNome.getText().toString());
        usuario.setLogin(txtLogin.getText().toString());
        usuario.setSenha(txtSenha.getText().toString());

        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.salvar(usuario);

        Toast.makeText(getApplicationContext(),"Usuario Salvo", Toast.LENGTH_SHORT).show();


    }
    public void lista(View view){
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Conexao(getApplicationContext(),"crud.db",null,1);
    }
}