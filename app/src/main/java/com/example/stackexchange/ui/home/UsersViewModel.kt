package com.example.stackexchange.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stackexchange.data.repository.StackExchangeRepository
import com.example.stackexchange.model.Item
import com.example.stackexchange.util.AppSchedulers
import com.example.stackexchange.util.asLiveData
import io.reactivex.disposables.CompositeDisposable

class UsersViewModel(private val repository: StackExchangeRepository) : ViewModel() {

    private val disposable = CompositeDisposable()
    private val _loadingLiveData = MutableLiveData<Boolean>()
    private val _usersContentLiveData = MutableLiveData<List<Item>>()
    private val _errorLiveData: MutableLiveData<String> = MutableLiveData()

    val loadingLiveData = _loadingLiveData.asLiveData()
    val jokesContentLiveData = _usersContentLiveData.asLiveData()
    val errorLiveData = _errorLiveData.asLiveData()

    fun fetchJokes() {
        disposable.add(
            repository.fetchUsers()
                .subscribeOn(AppSchedulers.io)
                .observeOn(AppSchedulers.ui)
                .doOnSubscribe { _loadingLiveData.value = true }
                .doOnEvent { _, _ -> _loadingLiveData.value = false }
                .subscribe(
                    { _usersContentLiveData.value = it.items },
                    { handleError(it) }
                )
        )
    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }


    private fun handleError(error: Throwable) {
        error.printStackTrace()
        _errorLiveData.value = error.message
    }
}