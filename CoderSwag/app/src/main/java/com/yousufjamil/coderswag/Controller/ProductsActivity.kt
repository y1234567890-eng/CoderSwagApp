package com.yousufjamil.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.yousufjamil.coderswag.Adapters.ProductsAdapter
import com.yousufjamil.coderswag.R
import com.yousufjamil.coderswag.Services.DataService
import com.yousufjamil.coderswag.Utilities.EXTRA_CATEGORY
import com.yousufjamil.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_products.*


class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType.toString())) { product ->
            val productDetailIntent = Intent(this, DisplayDataActivity::class.java)
            productDetailIntent.putExtra(EXTRA_PRODUCT, product)
            startActivity(productDetailIntent)

        }

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(applicationContext, spanCount)
        productsListView.layoutManager = layoutManager
        productsListView.adapter = adapter



        val categorytype = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType)){ product ->
            val productDetailIntent = Intent(this, DisplayDataActivity::class.java)
            productDetailIntent.putExtra(EXTRA_PRODUCT, product)
            startActivity(productDetailIntent)

    }
}

    private fun Intent.putExtra(extraProduct: String, product: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }}
