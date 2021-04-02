package com.example.app.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.Model.Info
import com.example.app.Repo.Repository
import kotlinx.coroutines.launch
import java.lang.Exception

class viewModel(private val Repository: Repository) : ViewModel() {
    val itemMutable: MutableLiveData<List<Info>> = MutableLiveData()
    fun getItem() {
        viewModelScope.launch {
            try {
                val response: List<Info> = Repository.getItem()
                itemMutable.value = response
            }
            catch (e: Exception){
                Log.d("main", "getPost: ${e.message}")
            }
        }
    }
}