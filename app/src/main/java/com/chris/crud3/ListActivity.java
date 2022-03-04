package com.chris.crud3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.chris.crud3.Dao.UsuarioDao;
import com.chris.crud3.helper.Usuario;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    ListView listViewUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listViewUsuario = findViewById(R.id.listViewUsuario);

        ArrayAdapter<Usuario>arrayAdapter= new ArrayAdapter<Usuario>(getApplicationContext(), android.R.layout.simple_list_item_1);

        UsuarioDao usuarioDao = new UsuarioDao();
        List<Usuario>usuarios = usuarioDao.listar();

        arrayAdapter.addAll(usuarios);
        listViewUsuario.setAdapter(arrayAdapter);

    }
}