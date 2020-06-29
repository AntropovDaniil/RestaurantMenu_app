package com.example.toolbartest

class Pizza(val name: String, val resourceId: Int) {

    companion object {
        val pizzas: Array<Pizza> = arrayOf(
            Pizza("Diavolo", R.drawable.diavolo),
            Pizza("Funghi", R.drawable.funghi)
        )
    }
}