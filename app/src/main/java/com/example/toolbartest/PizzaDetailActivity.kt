package com.example.toolbartest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_pizza_detail.*

class PizzaDetailActivity : AppCompatActivity() {

    companion object{
        val EXTRA_PIZZA_ID = "pizzaId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_detail)

        //val toolbar = findViewById<Toolbar>(R.id.toolbar) //comment
        setSupportActionBar(toolbar as androidx.appcompat.widget.Toolbar)
        val actionBar = getSupportActionBar()
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        //Display pizza's details
        val pizzaId = getIntent().getExtras().get(EXTRA_PIZZA_ID) as Int
        val pizzaName = Pizza.pizzas.get(pizzaId).name
        pizza_text.setText(pizzaName)
        val pizzaImage = Pizza.pizzas.get(pizzaId).resourceId
        pizza_image.setImageDrawable(ContextCompat.getDrawable(this, pizzaImage))
        pizza_image.setContentDescription(pizzaName)
    }
}
