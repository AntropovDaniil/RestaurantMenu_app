package com.example.toolbartest

class SideDish(val name: String, val resourceId: Int) {
    companion object{
        val dishes: Array<SideDish> = arrayOf(
            SideDish("Greek salad", R.drawable.greek_salad),
            SideDish("Caesar salad", R.drawable.caesar),
            SideDish("Caprese salad", R.drawable.caprese)
        )
    }
}