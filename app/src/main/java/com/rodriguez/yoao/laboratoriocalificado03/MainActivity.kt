package com.rodriguez.yoao.laboratoriocalificado03

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var teacherAdapter: TeacherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch {
            val teachers = RetrofitInstance.api.getTeachers()
            teacherAdapter = TeacherAdapter(
                teachers,
                onItemClick = { teacher ->
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${teacher.phoneNumber}"))
                    startActivity(intent)
                },
                onItemLongClick = { teacher ->
                    val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:${teacher.email}"))
                    startActivity(intent)
                }
            )
            recyclerView.adapter = teacherAdapter
        }
    }
}
