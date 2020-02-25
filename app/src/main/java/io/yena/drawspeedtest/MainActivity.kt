package io.yena.drawspeedtest

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    lateinit var colorList: ArrayList<Int>

    // This is a test

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lm = GridLayoutManager(this, 3)
        val adapter = MyAdapter()

        rvMain.layoutManager = lm
        rvMain.adapter = adapter
    }
}
