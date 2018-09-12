package com.chedi.dagger2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    // Get the TextView from xml by id "text_view"
    // mTextView will be initialized at first call
    // This approach will cause a crash if nameTextView is accessed before setContentView in MainActivity
    val mTextView by lazy {
        text_view
    }

    // we don't have to initialize now so we used lateinit
    //So to inform Dagger 2 which member variable I want it to inject, we use @Inject annotation
    @Inject @field:Choose(DAGGER) lateinit var mFirstInfo: Info
    @Inject @field:Choose(CHEDI) lateinit var mSecondInfo: Info


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // the injection of MainActivity could be done by adding the below line
        DaggerInfoComponent.create().inject(this)

        // Set text info in our textView
        mTextView.text = "${mFirstInfo.text} ${mSecondInfo.text}"
    }
}
