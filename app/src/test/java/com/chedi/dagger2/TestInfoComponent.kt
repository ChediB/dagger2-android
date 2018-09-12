package com.chedi.dagger2

import dagger.Component

@Component(modules = [InfoModule::class])
interface TestInfoComponent : InfoComponent {
    fun inject(app: TestMainActivity)
}