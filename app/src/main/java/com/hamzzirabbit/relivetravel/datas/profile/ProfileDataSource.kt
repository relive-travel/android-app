package com.hamzzirabbit.relivetravel.datas.profile

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ProfileDataSource(resources: Resources) {
    private val initialProfileList = profileList(resources)
    private val profileLiveData = MutableLiveData(initialProfileList)

    fun addProfile(newProfile: Profile) {

    }
    fun removeProfile() {

    }
    fun modifyProfile() {

    }
    fun getProfileId() {

    }
    fun getProfileList(): LiveData<List<Profile>> {
        return profileLiveData
    }
    companion object {
        private var INSTANCE: ProfileDataSource? = null

        fun getProfileDataSource(resources: Resources): ProfileDataSource {
            return synchronized(ProfileDataSource::class) {
                val newInstance = INSTANCE?: ProfileDataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}