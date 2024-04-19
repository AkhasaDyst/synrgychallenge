package com.yudhi.synrgyrecchall3

import KataAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yudhi.synrgyrecchall3.databinding.FragmentHurufBinding
import android.os.Parcelable
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.parcelize.Parcelize


class HurufFragment : Fragment() {
    private lateinit var binding: FragmentHurufBinding
    private lateinit var recyclerView: RecyclerView
    private var layout = "vertical"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHurufBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        val topappbar : MaterialToolbar = view.findViewById(R.id.appbarlayout)

        // menu item click listener for topappbar
        topappbar.setOnMenuItemClickListener { menuItem ->
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
    fun setupRecyclerView(){
        recyclerView = requireView().findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = AbjadAdapter(alphabets) { huruf ->
            val kata = Abjad.valueOf(huruf).kata
            val kataAdapter = KataAdapter(kata)
            recyclerView.adapter = kataAdapter
        }

        recyclerView.adapter = adapter
    }
}