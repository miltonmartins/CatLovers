package com.martins.milton.catlovers.ui.cats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.martins.milton.catlovers.data.models.Cat

class CatsViewModel : ViewModel() {
    private var _cats = MutableLiveData<List<Cat>>()
    val cats: LiveData<List<Cat>> = _cats
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    init {
        loadCats()
    }

    fun refresh() {
        _loading.value = true
        loadCats()
        _loading.value = false
    }

    private fun loadCats() {
        val catsStaticList = mutableListOf<Cat>()

        for (i in 1..50) {
            catsStaticList.add(
                Cat(
                    "Cat $i",
                    photoUrl = "https://images-na.ssl-images-amazon.com/images/I/41y16B5C6rL._SX311_BO1,204,203,200_.jpg"
                )
            )
        }

        _cats.value = catsStaticList
    }
}