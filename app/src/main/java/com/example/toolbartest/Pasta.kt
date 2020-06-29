package com.example.toolbartest

class Pasta(val name: String, val resourceId: Int) {

    companion object{
        val pasta: Array<Pasta> = arrayOf(
            Pasta("Bolognese", R.drawable.bolognese),
            Pasta("Carbonara", R.drawable.carbonara),
            Pasta("Amatriciana", R.drawable.amatriciana),
            Pasta("Boscaiola", R.drawable.boscaiola)
        )
    }
}