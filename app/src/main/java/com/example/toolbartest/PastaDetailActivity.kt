package com.example.toolbartest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_pasta_detail.*

class PastaDetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_PASTA_ID = "pastaId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pasta_detail)

        //val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar as androidx.appcompat.widget.Toolbar)
        val actionBar = getSupportActionBar()
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        val pastaId = getIntent().getExtras().get(EXTRA_PASTA_ID) as Int
        val pastaName = Pasta.pasta.get(pastaId).name
        val pastaImage = Pasta.pasta.get(pastaId).resourceId
        pasta_text.setText(pastaName)
        pasta_image.setImageDrawable(ContextCompat.getDrawable(this, pastaImage))
        pasta_image.setContentDescription(pastaName)

    }
}
