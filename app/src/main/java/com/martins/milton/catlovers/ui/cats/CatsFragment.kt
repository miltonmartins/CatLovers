package com.martins.milton.catlovers.ui.cats

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.martins.milton.catlovers.R
import com.martins.milton.catlovers.databinding.FragmentCatsBinding

class CatsFragment : Fragment() {
    private lateinit var viewDataBinding: FragmentCatsBinding

    private lateinit var catsAdapter: CatsAdapter
    private lateinit var viewModel: CatsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = CatsViewModel()
        viewDataBinding = FragmentCatsBinding.inflate(inflater, container, false).apply {
            viewmodel = viewModel
        }

        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        setupListAdapter()
    }

    private fun setupListAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            catsAdapter = CatsAdapter(viewModel)
            viewDataBinding.rvCats.adapter = catsAdapter
            viewDataBinding.rvCats.layoutManager = GridLayoutManager(context, 4)
        } else {
            Log.e("ViewModel", "ViewModel not initialized when attempting to set up adapter.")
        }
    }
}