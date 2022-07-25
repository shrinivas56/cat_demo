package com.intuit.catdemo.presentation.ui.breed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.intuit.catdemo.R
import com.intuit.catdemo.databinding.FragmentBreedDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreedDetailFragment : Fragment() {

    private lateinit var binding : FragmentBreedDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_breed_details, container, false)
        binding.lifecycleOwner = this
        initView()
        return binding.root
    }

    private fun initView() {
        if (arguments != null) {
            binding.catBreed = requireArguments().getParcelable(getString(R.string.key_cat_breed))
        }
    }


}