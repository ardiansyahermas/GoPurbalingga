package com.application.wisataapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.application.wisataapp.DataUser
import com.application.wisataapp.Wisata
import java.lang.String
import kotlin.Int
import kotlin.arrayOf


class DatabaseHandler(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    //Create table
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_WISATA_TABLE = ("CREATE TABLE " + TABLE_WISATA + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_PLACE + " TEXT," + KEY_LOCATION + " TEXT," + KEY_PRICE + " TEXT," + KEY_DESC + " TEXT,"
                + KEY_IMAGE + " INTEGER" + ")")

        db.execSQL(CREATE_WISATA_TABLE)

        val CREATE_USER_TABLE = ("CREATE TABLE " + TABLE_USER + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_EMAIL + " TEXT," +
                KEY_PASSWORD + " TEXT" + ")")

        db.execSQL(CREATE_USER_TABLE)
    }

    // on Upgrade database
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WISATA)
        onCreate(db)
    }

    fun addListWisata(dataWisata: Wisata) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(KEY_ID, dataWisata.id)
        values.put(KEY_PLACE, dataWisata.place)
        values.put(KEY_LOCATION, dataWisata.location)
        values.put(KEY_PRICE, dataWisata.price)
        values.put(KEY_DESC, dataWisata.detail)
        values.put(KEY_IMAGE, dataWisata.photo)

        db.insert(TABLE_WISATA, null, values)
        db.close()
    }

    fun register(dataUser: DataUser) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(KEY_EMAIL, dataUser.email)
        values.put(KEY_PASSWORD, dataUser.password)

        db.insert(TABLE_USER, null, values)
        db.close()
    }

    fun getWisata(id: Int): Wisata {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_WISATA,
            arrayOf(
                KEY_ID,
                KEY_PLACE,
                KEY_LOCATION,
                KEY_PRICE,
                KEY_DESC,
                KEY_IMAGE
            ),
            KEY_ID + "=?",
            arrayOf(id.toString()),
            null,
            null,
            null,
            null
        )
        cursor?.moveToFirst()
        // return contact
        return Wisata(
            cursor!!.getString(0).toInt(),
            cursor.getString(1),
            cursor.getString(2),
            cursor.getString(3),
            cursor.getString(4),
            cursor.getString(5).toInt()
        )
    }// Select All Query

    // return contact list
    // get All Record
    val allWisata: List<Wisata>
        get() {
            val contactList: MutableList<Wisata> = ArrayList<Wisata>()
            // Select All Query
            val selectQuery = "SELECT  * FROM " + TABLE_WISATA
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)
            if (cursor.moveToFirst()) {
                do {
                    val dataWisata = Wisata()
                    dataWisata.id = (cursor.getString(0).toInt())
                    dataWisata.place = (cursor.getString(1))
                    dataWisata.location = (cursor.getString(2))
                    dataWisata.price = (cursor.getString(3))
                    dataWisata.detail = (cursor.getString(4))
                    dataWisata.photo = (cursor.getString(5).toInt())

                    contactList.add(dataWisata)
                } while (cursor.moveToNext())
            }

            // return contact list
            return contactList
        }

    val allUser: List<DataUser>
        get() {
            val contactList: MutableList<DataUser> = ArrayList<DataUser>()
            // Select All Query
            val selectQuery = "SELECT  * FROM " + TABLE_USER
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)
            if (cursor.moveToFirst()) {
                do {
                    val dataWisata = DataUser()
                    dataWisata.id = (cursor.getString(0).toInt())
                    dataWisata.email = (cursor.getString(1))
                    dataWisata.password = (cursor.getString(2))

                    contactList.add(dataWisata)
                } while (cursor.moveToNext())
            }

            // return contact list
            return contactList
        }

    // return count
    val dataWisataCount: Int
        get() {
            val countQuery = "SELECT  * FROM " + TABLE_WISATA
            val db = this.readableDatabase
            val cursor = db.rawQuery(countQuery, null)
            cursor.close()

            // return count
            return cursor.count
        }

    fun updateWisata(contact: Wisata): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_ID, contact.id)
        values.put(KEY_PLACE, contact.place)
        values.put(KEY_LOCATION, contact.location)
        values.put(KEY_PRICE, contact.price)
        values.put(KEY_DESC, contact.detail)

        values.put(KEY_IMAGE, contact.photo)

        // updating row
        return db.update(
            TABLE_WISATA,
            values,
            KEY_ID + " = ?",
            arrayOf(String.valueOf(contact.id))
        )
    }

    fun deleteWisataFavorite(contact: Wisata) {
        val db = this.writableDatabase
        db.delete(TABLE_WISATA, KEY_ID + " = ?", arrayOf(String.valueOf(contact.id)))
        db.close()
    }

    companion object {
        // static variable
        private const val DATABASE_VERSION = 3

        // Database name
        private const val DATABASE_NAME = "Wisata"

        // table name
        private const val TABLE_WISATA = "tbWisata"
        private const val TABLE_USER = "tbUser"

        // column tables
        private const val KEY_ID = "id"
        private const val KEY_PLACE = "place"
        private const val KEY_LOCATION = "location"
        private const val KEY_DESC = "deskripsi"
        private const val KEY_PRICE = "price"
        private const val KEY_IMAGE = "image"

        private const val KEY_EMAIL = "email"
        private const val KEY_PASSWORD = "password"
    }
}
