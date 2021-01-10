package com.example.stackexchange.ui.home

import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.stackexchange.R
import com.example.stackexchange.model.Item
import com.example.stackexchange.util.inflate
import kotlinx.android.synthetic.main.item_user.view.*

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    private val data = arrayListOf<Item>()

    fun setData(items: List<Item>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UsersViewHolder(parent.inflate(R.layout.item_user))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(viewHolder: UsersViewHolder, position: Int) {
        viewHolder.bind(data[position])
    }

    inner class UsersViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Item) {
            view.tv_name.text = item.displayName
            view.tv_user_reputation.text = item.reputation.toString()
            view.setOnClickListener {
                item.let {
                    val directions =
                        UsersHomeFragmentDirections.actionUsersHomeFragmentToUsersDetailFragment(it)
                    view.findNavController().navigate(directions)
                }
            }
        }
    }
}