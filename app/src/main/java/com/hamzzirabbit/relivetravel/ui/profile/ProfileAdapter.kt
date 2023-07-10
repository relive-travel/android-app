package com.hamzzirabbit.relivetravel.ui.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hamzzirabbit.relivetravel.R
import com.hamzzirabbit.relivetravel.datas.profile.Profile

class ProfileAdapter(private val onClick: (Profile) -> Unit) :
    ListAdapter<Profile, ProfileAdapter.ProfileViewHolder>(ProfileDiffCallback) {

    class ProfileViewHolder(itemView: View, val onClick: (Profile) -> Unit): RecyclerView.ViewHolder(itemView) {
        private val ProfileImageView: ImageView = itemView.findViewById(R.id.profile_image)
        private val ProfileTextView: TextView = itemView.findViewById(R.id.profile_name)
        private var currentProfile: Profile? = null

        init {
            itemView.setOnClickListener {
                currentProfile?.let {
                    onClick(it)
                }
            }
        }

        fun bind(Profile: Profile) {
            currentProfile = Profile

            ProfileTextView.text = Profile.profile_name
            if (Profile.profile_image != null) {
                ProfileImageView.setImageResource(Profile.profile_image)
            } else {
                ProfileImageView.setImageResource(R.drawable.mypage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.profile_item, parent, false)
        return ProfileViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val profile = getItem(position)
        holder.bind(profile)
    }
}

object ProfileDiffCallback : DiffUtil.ItemCallback<Profile>() {
    override fun areItemsTheSame(oldItem: Profile, newItem: Profile): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Profile, newItem: Profile): Boolean {
        return oldItem.profile_id == newItem.profile_id
    }
}