package com.example.arciniega.proyecto12_sqlitedb;

/**
 * Created by arciniega on 08/07/16.
 */

// Inclusión de paquetes
    import android.content.Context; // Base de datos protegida en este contexto
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;
    import android.util.Log;

// Esta clase deriva de la clase SQLiteOpenHelper
public class MySQLiteHelper extends SQLiteOpenHelper{

    // Atributos para la creación de la base de datos desde la presente clase
    public static final String DATABASE_NAME = "agenda";
    public static final String TABLE_CONTACTO = "contacto";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_TELEFONO = "telefono";
    public static final int DATA_VERSION = 1; // Versión de la base de datos
    private static final String DATABASE_CREATE = "create table " + TABLE_CONTACTO + "(" +
            COLUMN_ID + " integer primary key autoincrement, " +
            COLUMN_NOMBRE + " text not null, " +
            COLUMN_TELEFONO + " text);";

    // Constructor de la clase
    public MySQLiteHelper(Context context) {
        // Este método hace referencia al constructor de la superclase
        super(context,DATABASE_NAME, null, DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Método para crear la tabla 'contacto'
        // create table contacto(id integer primary key autoincrement....
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int j) {
        Log.w(MySQLiteHelper.class.getName(), "Upgrading database from versión " + i + " to " + j + " wich will destroy data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTO);
        onCreate(db);
    }
}
