package com.chris.crud3.Dao;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.chris.crud3.helper.Usuario;
import com.chris.crud3.sqlite.Conexao;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    public void salvar(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("login", usuario.getLogin());
        values.put("senha", usuario.getSenha());

        SQLiteDatabase conexao = Conexao.getInstance();
        conexao.insert("usuario", null,values);

    }
    public void alterar(Usuario usuario){

    }
    public List<Usuario> listar(){
        SQLiteDatabase conexao = Conexao.getInstance();

        Cursor c = conexao.query("usuario", new String[]{"id","nome","login","senha"},null,null,null,null,null,null);

        List<Usuario> usuarios = new ArrayList<Usuario>();
        if(c.moveToFirst()) {
            do {
                Usuario usuario = new Usuario();
                usuario.setId(c.getInt(0));
                usuario.setNome(c.getString(1));
                usuario.setLogin(c.getString(2));

                usuarios.add(usuario);




            } while (c.moveToNext());
        }
        return usuarios;

    }
    public void excluir(int id){

    }

}
