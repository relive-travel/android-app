package com.hamzzirabbit.relivetravel.ui.profile

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hamzzirabbit.relivetravel.R
import com.hamzzirabbit.relivetravel.datas.profile.Profile
import com.hamzzirabbit.relivetravel.datas.profile.ProfileDataSource
import java.lang.IllegalArgumentException
import kotlin.random.Random

class ProfileListViewModel(val profileDataSource: ProfileDataSource): ViewModel() {
    val profileLiveData = profileDataSource.getProfileList()

    fun insertProfile(profileName: String?, profileDescription: String?) {
        if (profileName == null || profileDescription == null) {
            return
        }
        val image = R.drawable.mypage
        val newProfile = Profile(
            Random.nextLong(),
            profileName,
            image,
            profileDescription
        )
        profileDataSource.addProfile(newProfile)
    }
}

class ProfileListViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProfileListViewModel(profileDataSource = ProfileDataSource.getProfileDataSource(context.resources)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}