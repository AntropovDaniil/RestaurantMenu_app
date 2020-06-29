package com.example.toolbartest


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class SideDishFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dishRecycler = inflater.inflate(R.layout.fragment_dish, container, false) as RecyclerView
        val dishNames = Array<String>(SideDish.dishes.size, {it -> SideDish.dishes.get(it).name})
        val dishImages = Array<Int>(SideDish.dishes.size, {it -> SideDish.dishes.get(it).resourceId})


        val adapter = CaptionedImagesAdapter(dishNames, dishImages)
        dishRecycler.setAdapter(adapter)
        val gridLayoutManager = GridLayoutManager(getActivity(), 2)
        dishRecycler.setLayoutManager(gridLayoutManager)

        adapter.setListener(object : CaptionedImagesAdapter.Listener{
            override fun onClick(position: Int) {
                val intent = Intent(getActivity(), SideDishDetailActivity::class.java)
                intent.putExtra(SideDishDetailActivity.EXTRA_DISH_ID, position)
                getActivity()!!.startActivity(intent)
            }
        })

        return dishRecycler
    }


}
