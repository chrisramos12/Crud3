package com.chris.crud3.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class Conexao extends SQLiteOpenHelper {

    private static SQLiteDatabase instance;
    public static SQLiteDatabase getInstance(){
        return instance;

    }

    public Conexao( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        instance = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tabelaUsuario="";
        tabelaUsuario +="create table usuario( ";
        tabelaUsuario += "id integer primary key autoincrement, ";
        tabelaUsuario += "nome varchar(255), ";
        tabelaUsuario += "login varchar(255), ";
        tabelaUsuario += "senha varchar(255) ";
        tabelaUsuario += "); ";
        db.execSQL(tabelaUsuario);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
