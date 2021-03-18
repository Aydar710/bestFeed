package com.aydar.featuremain

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.aydar.featuremain.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: PostsAdapter

    private val binding: FragmentHomeBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
        viewModel.getFeed()

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.postsLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun setupViewPager() {
        adapter = PostsAdapter()
        binding.vpPosts.adapter = adapter
        binding.vpPosts.addItemDecoration(
            VerticalSpaceItemDecorator(
                resources.getDimension(R.dimen.viewpager_space).toInt()
            )
        )
    }
}