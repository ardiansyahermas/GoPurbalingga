package com.application.wisataapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DetailWisataActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_PLACE = "extra_place"
        const val EXTRA_LOCATION = "extra_location"
        const val EXTRA_PRICE = "extra_price"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_detail_wisata)

        var actionBar = getSupportActionBar()
        actionBar?.setDisplayHomeAsUpEnabled(true)

        showWisataDetail()
    }

    private fun showWisataDetail(){

        val tvImageReceived: ImageView = findViewById(R.id.img_item_photo)
        val tvPlaceReceived: TextView = findViewById(R.id.tv_item_place)
        val tvLocationReceived: TextView = findViewById(R.id.tv_item_location)
        val tvPriceReceived: TextView = findViewById(R.id.tv_item_price)
        val tvDetailReceived: TextView = findViewById(R.id.tv_item_detail)

        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val place = intent.getStringExtra(EXTRA_PLACE)
        val location = intent.getStringExtra(EXTRA_LOCATION)
        val price = intent.getStringExtra(EXTRA_PRICE)
        val detail = intent.getStringExtra(EXTRA_DETAIL)

        tvImageReceived.setImageResource(photo)
        tvPlaceReceived.setText("$place")
        tvLocationReceived.setText("Location: $location")
        tvPriceReceived.setText("Harga Tiket Masuk: $price")
        tvDetailReceived.setText("$detail")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}