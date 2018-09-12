package com.chedi.dagger2

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

class TestMainActivity {

    @Inject
    @field:Choose(DAGGER) lateinit var mFirstInfo: Info
    @Inject
    @field:Choose(CHEDI) lateinit var mSecondInfo: Info

    @Before
    fun setup() {
         DaggerTestInfoComponent.builder().infoModule(TestInfoModule()).build().inject(this)
    }

    @Test
    fun simpleTest() {
        assertEquals("Dagger2 by", mFirstInfo.text)
        assertEquals("Chedi", mSecondInfo.text)
    }
}