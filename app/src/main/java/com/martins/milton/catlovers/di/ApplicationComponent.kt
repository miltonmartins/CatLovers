package com.martins.milton.catlovers.di

import com.martins.milton.catlovers.ui.cats.CatsViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    RetrofitModule::class
])
interface ApplicationComponent {
    fun inject(viewModel: CatsViewModel)
}
