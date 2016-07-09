package com.example.arciniega.proyecto12_sqlitedb;

/**
 * Created by arciniega on 08/07/16.
 */

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
//Paqueres para el manejo de las operacines con la base de datos
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

// Clase para la manipulacion de la información en la BD
// Select, Insert, Update, Delete
public class DataSource {

    //Atributos de la clase
    private SQLiteDatabase dataBase;
    private MySQLiteHelper dbHelper;
    private String[] columnas = {
            MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_NOMBRE,
            MySQLiteHelper.COLUMN_TELEFONO
    };

    // Constructor de la clase
    public DataSource(Context context){
        // Se instancia un objeto de la clase MySQLiteHelper para utilizar sus métodos
        dbHelper = new MySQLiteHelper(context);
    }

    // Abrir la conexión
    public void open() throws SQLException{
        dataBase = dbHelper.getWritableDatabase();
    }

    // Terminar de utilizar la base de datos
    public void close(){
        dbHelper.close();
    }

    //
    public Contacto crearContacto(String nombre, String telefono){
       ContentValues values = new ContentValues();

        // Se agregan los datos conforme a las columnas de la tabla
        values.put(MySQLiteHelper.COLUMN_NOMBRE, nombre);
        values.put(MySQLiteHelper.COLUMN_TELEFONO, telefono);

        // Insertar datos en la tabla
        long insertId = dataBase.insert(MySQLiteHelper.TABLE_CONTACTO, null, values);

        // Se utiliza un objeto de la clase cursos para contener el 'ResultSet'
        Cursor cursor = dataBase.query(MySQLiteHelper.TABLE_CONTACTO,
                columnas,
                MySQLiteHelper.COLUMN_ID + " = " + insertId,
                null,
                null,
                null,
                null
        );

        cursor.moveToFirst();

        Contacto contacto = cursorToContacto(cursor);
        cursor.close();

        return contacto;
    }

    private Contacto cursorToContacto(Cursor cursor){
        // Instancia de la clase Contacto
        Contacto contacto = new Contacto();
        contacto.setId(cursor.getInt(0));
        contacto.setNombre(cursor.getString(1));
        contacto.setTelefono(cursor.getString(2));

        return contacto;
    }

}
