package com.application.wisataapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.wisataapp.db.DatabaseHandler

class MainActivity : AppCompatActivity() {
    private lateinit var rvWisata: RecyclerView
    private var list: ArrayList<Wisata> = arrayListOf()

    private var listWisata = mutableListOf<Wisata>()

    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sessionManager = SessionManager(this)

        val db = DatabaseHandler(this)
        val listWisataFavorit: List<Wisata> = db.allWisata

        if (listWisataFavorit.isEmpty()){
            for (i in WisataData.listData){
                db.addListWisata(i)
            }

            val listWisataFavorit: List<Wisata> = db.allWisata
            listWisata = listWisataFavorit as MutableList<Wisata>
        } else {
            val listWisataFavorit: List<Wisata> = db.allWisata
            listWisata = listWisataFavorit as MutableList<Wisata>
        }

        rvWisata = findViewById(R.id.rv_wisata)
        rvWisata.setHasFixedSize(true)
        list.addAll(listWisata)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvWisata.layoutManager = LinearLayoutManager(this)
        val listWisataAdapter = ListWisataAdapter(list)
        rvWisata.adapter = listWisataAdapter

        listWisataAdapter.setOnItemClickCallback(object:ListWisataAdapter.OnItemClickCallback{
            override fun onItemClickedData(data: Wisata) {
                showSelectedWisata(data)
            }
        })
    }

    private fun showSelectedWisata(data: Wisata) {
        val detailWisataActivity = Intent(this@MainActivity, DetailWisataActivity::class.java).apply {
            putExtra(DetailWisataActivity.EXTRA_PHOTO, data.photo)
            putExtra(DetailWisataActivity.EXTRA_PLACE, data.place)
            putExtra(DetailWisataActivity.EXTRA_LOCATION, data.location)
            putExtra(DetailWisataActivity.EXTRA_PRICE, data.price)
            putExtra(DetailWisataActivity.EXTRA_DETAIL, data.detail)
        }
        startActivity(detailWisataActivity)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(SelectedMode: Int){
        R.id.action_user;run {
            val builder1: AlertDialog.Builder = AlertDialog.Builder(this)
            builder1.setMessage("Yakin ingin keluar dari Akun?")
            builder1.setCancelable(true)
            builder1.setPositiveButton(
                "Ya"
            ) { dialog, id ->

                sessionManager.isLogin(false)
                sessionManager.dataUser = null

                val moveIntent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(moveIntent)
                finish()
            }
            builder1.setNegativeButton(
                "Tidak"
            ) { dialog, id -> dialog.cancel() }
            val alert11: AlertDialog = builder1.create()
            alert11.show()
        }
    }

}