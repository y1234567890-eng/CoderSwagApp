package com.yousufjamil.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yousufjamil.coderswag.Model.Product
import com.yousufjamil.coderswag.R
import com.yousufjamil.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_display_data.*

class DisplayDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_data)

        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        val resourceId = resources.getIdentifier(product?.image, "drawable", packageName)
        detailImageView.setImageResource(resourceId)
        detailProductName.text = product?.title
        detailProductPrice.text = product?.price

    }
}