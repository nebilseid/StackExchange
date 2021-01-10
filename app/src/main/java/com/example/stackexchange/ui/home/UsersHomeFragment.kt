package com.example.stackexchange.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stackexchange.R
import com.example.stackexchange.util.setVisibility
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class UsersHomeFragment : Fragment(R.layout.fragment_home) {

    private val usersViewModel: UsersViewModel by viewModel()
    private val usersAdapter = UsersAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        initializeView()

        usersViewModel.loadingLiveData.observe(viewLifecycleOwner, { loading(it) })
        usersViewModel.errorLiveData.observe(viewLifecycleOwner, { showError(it) })
        usersViewModel.jokesContentLiveData.observe(viewLifecycleOwner, { usersAdapter.setData(it) })

        usersViewModel.fetchJokes()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu,menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object :  SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
            }

        })
    }

    private fun initializeView() {
        val mLayoutManager = LinearLayoutManager(requireContext())
        rv_users.apply {
            layoutManager = mLayoutManager
            adapter = usersAdapter
        }
    }

    private fun loading(isInProgress: Boolean) {
        pb_loading.setVisibility(isInProgress)
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}