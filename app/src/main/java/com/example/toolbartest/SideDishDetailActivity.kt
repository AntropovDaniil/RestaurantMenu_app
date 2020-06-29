package com.example.toolbartest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_side_dish_detail.*

class SideDishDetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_DISH_ID = "dishId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_side_dish_detail)

        setSupportActionBar(toolbar as androidx.appcompat.widget.Toolbar)
        val actionBar = getSupportActionBar()
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        val dishId = getIntent().getExtras().get(EXTRA_DISH_ID) as Int
        val dishName = SideDish.dishes.get(dishId).name
        val dishImage = SideDish.dishes.get(dishId).resourceId
        dish_text.setText(dishName)
        dish_image.setImageDrawable(ContextCompat.getDrawable(this, dishImage))
        dish_image.setContentDescription(dishName)
    }
}
