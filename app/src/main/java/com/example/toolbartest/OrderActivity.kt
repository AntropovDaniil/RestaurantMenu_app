package com.example.toolbartest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        setSupportActionBar(toolbar as Toolbar)
        val actionBar: ActionBar? = getSupportActionBar()
        actionBar?.setDisplayHomeAsUpEnabled(true)

        floating_action_button.setOnClickListener {
            val snackbar = Snackbar.make(coordinator, "Make an auto-order", Snackbar.LENGTH_LONG)
            snackbar.setAction("MAKE") {
                order_name.setText("My order")
                order_delails.setText("Pizza and 2 burgers")
            }
            snackbar.show()
        }
    }
}
