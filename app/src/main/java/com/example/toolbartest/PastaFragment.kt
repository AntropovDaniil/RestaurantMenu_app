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
class PastaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pastaRecycler = inflater.inflate(R.layout.fragment_pasta, container, false) as RecyclerView
        val pastaNames = Array<String>(Pasta.pasta.size, {it -> Pasta.pasta.get(it).name})
        val pastaImages = Array<Int>(Pasta.pasta.size, {it -> Pasta.pasta.get(it).resourceId})

        val adapter = CaptionedImagesAdapter(pastaNames, pastaImages)
        pastaRecycler.setAdapter(adapter)
        val gridLayoutManager = GridLayoutManager(getActivity(), 2)
        pastaRecycler.setLayoutManager(gridLayoutManager)


        adapter.setListener(object : CaptionedImagesAdapter.Listener{
            override fun onClick(position: Int) {
                val intent = Intent(getActivity(), PastaDetailActivity::class.java)
                intent.putExtra(PastaDetailActivity.EXTRA_PASTA_ID, position)
                getActivity()!!.startActivity(intent)
            }
        })

        return pastaRecycler
    }


}
