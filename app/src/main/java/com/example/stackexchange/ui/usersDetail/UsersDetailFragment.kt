package com.example.stackexchange.ui.usersDetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.stackexchange.R
import kotlinx.android.synthetic.main.fragment_users_details.*

class UsersDetailFragment : Fragment(R.layout.fragment_users_details) {

    private val args: UsersDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.userItem.let {
            Glide.with(view).load(it.profileImage).into(iv_user_avator)
            tv_user_detail_name.text = getString(R.string.user_datail_name, it.displayName)
            tv_user_detail_reputation.text = getString(R.string.user_detail_reputation, it.reputation.toString())

            tv_badges_label_bronze.text =
                getString(R.string.badge_label_bronze, it.badgeCounts.bronze.toString())
            tv_badges_label_silver.text =
                getString(R.string.badge_label_silver, it.badgeCounts.silver.toString())
            tv_badges_label_gold.text =
                getString(R.string.badge_label_gold, it.badgeCounts.gold.toString())

            tv_user_location.text = getString(R.string.user_location, it.location ?: "Unknown")
            tv_creation_date.text = getString(R.string.creation_date, it.formattedCreationDate)

        }
    }
}