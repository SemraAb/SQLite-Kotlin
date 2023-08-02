package com.samra.sqlitekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        try {
            var myDatabase = this.openOrCreateDatabase("Musicians" , MODE_PRIVATE, null)
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians(id INTEGER PRIMARY KEY,name VARCHAR , age INT)")
//            myDatabase.execSQL("INSERT INTO musicians (name , age) values ('James' , 50)")
//            myDatabase.execSQL("INSERT INTO musicians (name , age) values ('Semra' , 21)")
//            myDatabase.execSQL("INSERT INTO musicians (name , age) values ('Ceyhun' , 20)")
 //           myDatabase.execSQL("UPDATE musicians SET age = 22 WHERE name='Semra'")
   //         myDatabase.execSQL("DELETE FROM musicians WHERE id=3")

            //var cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE name LIKE 's%'" , null)
            var cursor = myDatabase.rawQuery("SELECT * FROM musicians " , null)
            val nameIx = cursor.getColumnIndex("name")
            val ageIx = cursor.getColumnIndex("age")
            val idIx = cursor.getColumnIndex("id")

            while(cursor.moveToNext()){
                println("Name " + cursor.getString(nameIx))
                println("Age " + cursor.getInt(ageIx))
                println("ID  " + cursor.getInt(idIx))
            }

        }catch (e: Exception){
            e.printStackTrace() // exception haqqindaki her seyi log cata yazdirir
        }
    }
}