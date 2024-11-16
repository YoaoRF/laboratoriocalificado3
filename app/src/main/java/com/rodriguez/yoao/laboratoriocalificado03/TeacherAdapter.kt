package com.rodriguez.yoao.laboratoriocalificado03

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TeacherAdapter(
    private val teachers: List<Teacher>,
    private val onItemClick: (Teacher) -> Unit,
    private val onItemLongClick: (Teacher) -> Unit
) : RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>() {

    inner class TeacherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.teacherName)
        val emailTextView: TextView = itemView.findViewById(R.id.teacherEmail)
        val imageView: ImageView = itemView.findViewById(R.id.teacherImage)

        fun bind(teacher: Teacher) {
            nameTextView.text = "${teacher.name} ${teacher.lastName}"
            emailTextView.text = teacher.email
            Glide.with(itemView.context).load(teacher.imageUrl).into(imageView)

            itemView.setOnClickListener { onItemClick(teacher) }
            itemView.setOnLongClickListener {
                onItemLongClick(teacher)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_teacher, parent, false)
        return TeacherViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        holder.bind(teachers[position])
    }

    override fun getItemCount(): Int = teachers.size
}
