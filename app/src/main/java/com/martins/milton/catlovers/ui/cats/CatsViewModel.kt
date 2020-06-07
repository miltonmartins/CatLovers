package com.martins.milton.catlovers.ui.cats

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.martins.milton.catlovers.data.models.Cat
import com.martins.milton.catlovers.data.models.Result
import com.martins.milton.catlovers.data.source.remote.CatApi
import com.martins.milton.catlovers.di.DaggerApplicationComponent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class CatsViewModel : ViewModel() {
    @Inject
    lateinit var catApi: CatApi

    private var _cats = MutableLiveData<List<Cat>>().apply { value = mutableListOf() }
    val cats: LiveData<List<Cat>> = _cats
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    init {
        DaggerApplicationComponent.create().inject(this)
        loadCats()
    }

    fun refresh() {
        _loading.value = true
        loadCats()
        _loading.value = false
    }

    private fun loadCats() {
        catApi.getCats()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError {
                Log.e("Error", it.toString())
            }
            .onErrorReturn{ Result(cats = mutableListOf()) }
            .subscribe {
                _cats.value = it?.cats
            }
    }
}