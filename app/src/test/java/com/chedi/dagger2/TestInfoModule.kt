package com.chedi.dagger2

class TestInfoModule: InfoModule() {

    override fun providesInfo(): Info {
        return Info("Chedi")
    }
}