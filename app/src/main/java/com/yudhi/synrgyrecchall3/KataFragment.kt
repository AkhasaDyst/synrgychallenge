package com.yudhi.synrgyrecchall3

import KataAdapter
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.yudhi.synrgyrecchall3.databinding.FragmentKataBinding

class KataFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var kataAdapter: KataAdapter
    private var layout = "vertical"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_kata, container, false)
        recyclerView = view.findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }

    fun setKataList(kataList: List<String>) {
        kataAdapter = KataAdapter(kataList)
        recyclerView.adapter = kataAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutbtn : MaterialToolbar = view.findViewById(R.id.appbarlayout)

        // menu item click listener for topappbar
        layoutbtn.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.list -> {
                    when(layout) {
                        "vertical" -> {
                            recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
                            layout = "grid"
                            menuItem.setIcon(R.drawable.ic_grid) // set icon to grid
                        }
                        "grid" -> {
                            recyclerView.layoutManager = LinearLayoutManager(requireContext())
                            layout = "vertical"
                            menuItem.setIcon(R.drawable.ic_list) // set icon to vertical
                        }
                        else -> false
                    }

                    true
                }
                else -> false
            }
        }
    }
}