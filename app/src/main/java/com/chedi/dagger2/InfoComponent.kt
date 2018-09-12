package com.chedi.dagger2

import dagger.Component
import javax.inject.Singleton

// I need to tell InfoComponent
// it is there to perform it’s injection on MainActivity.
// So to do that, I create an inject function accepting MainActivity in my InfoComponent.

@CreateOnce
@Component(modules = [InfoModule::class])
interface InfoComponent {

    fun inject(app: MainActivity)
}