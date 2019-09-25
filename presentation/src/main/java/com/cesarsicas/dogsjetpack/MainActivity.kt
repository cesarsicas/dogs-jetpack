package com.cesarsicas.dogsjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cesarsicas.data.database.AppDatabase
import com.cesarsicas.data.database.DatabaseBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
