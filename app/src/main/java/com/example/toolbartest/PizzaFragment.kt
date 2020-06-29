package com.example.toolbartest


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_pizza.*
import java.text.FieldPosition

/**
 * A simple [Fragment] subclass.
 */
class PizzaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pizzaRecycler = inflater.inflate(R.layout.fragment_pizza, container, false) as RecyclerView
        val pizzaNames = Array<String>(Pizza.pizzas.size, {it -> Pizza.pizzas.get(it).name})
        val pizzaImages = Array<Int>(Pizza.pizzas.size, {it -> Pizza.pizzas.get(it).resourceId})

        val adapter = CaptionedImagesAdapter(pizzaNames, pizzaImages)
        pizzaRecycler.setAdapter(adapter)
        val gridLayoutManager = GridLayoutManager(getActivity(), 2)
        pizzaRecycler.setLayoutManager(gridLayoutManager)


        adapter.setListener(object : CaptionedImagesAdapter.Listener{
            override fun onClick(position: Int) {
                val intent = Intent(getActivity(), PizzaDetailActivity::class.java)
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_ID, position)
                getActivity()!!.startActivity(intent)
            }

        })

        return pizzaRecycler
    }


}
