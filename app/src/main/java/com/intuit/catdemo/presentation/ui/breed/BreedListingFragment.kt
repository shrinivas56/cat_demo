package com.intuit.catdemo.presentation.ui.breed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.intuit.catdemo.R
import com.intuit.catdemo.databinding.FragmentBreedListingBinding
import com.intuit.catdemo.presentation.ui.breed.adapter.BreedAdapter
import com.intuit.catdemo.presentation.ui.breed.listener.BreedItemClickListener
import com.intuit.catdemo.presentation.viewmodel.breed.BreedListingViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.net.ConnectException


@AndroidEntryPoint
class BreedListingFragment : Fragment(), BreedItemClickListener{

    private val viewModel : BreedListingViewModel by viewModels()
    private lateinit var binding: FragmentBreedListingBinding
    private lateinit var scrollListener: RecyclerView.OnScrollListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_breed_listing, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        initView()
        return binding.root
    }

    private fun initView() {
        setRecyclerViewScrollListener()
        binding.bFetchCatBreedData.setOnClickListener{
            viewModel.getCatBreeds()
        }
        val adapter = BreedAdapter(ArrayList())

        adapter.setListener(this)
        binding.rvCatBreed.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(activity)
            this.addOnScrollListener(scrollListener)
        }
        viewModel.catBreeds.observe(viewLifecycleOwner){
            adapter.updateList(it)
            if(it.isNotEmpty())
                binding.isDataAvailable = true
        }
        viewModel.getIsError.observe(viewLifecycleOwner){
            if(it is ConnectException){
                viewModel.showMessage.value = getString(R.string.no_internet_connection)
            } else {
                viewModel.showMessage.value = getString(R.string.something_went_wrong)
            }
        }
        viewModel.showMessage.observe(viewLifecycleOwner){
            Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
        }
    }

    private fun setRecyclerViewScrollListener() {
        scrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(binding.rvCatBreed, newState)
                if(!viewModel.isPaginationDataAvailable || viewModel.getIsLoading.value == true)
                    return
                val totalItemCount = recyclerView.layoutManager?.itemCount ?: 0
                val lastVisibleItemPosition: Int = (recyclerView.layoutManager as LinearLayoutManager)?.findLastVisibleItemPosition()
                if (totalItemCount == lastVisibleItemPosition + 1) {
                    viewModel.getCatBreeds()
                }
            }
        }
    }

    override fun onItemClick(position: Int) {
        val bundle = Bundle()
        bundle.putParcelable(getString(R.string.key_cat_breed), viewModel.catBreeds.value!![position])
        findNavController().navigate(R.id.action_breedListingFragment_to_breedDetailFragment, bundle)
    }

}