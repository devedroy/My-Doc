package com.devedroy.mydoc.views.homepage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devedroy.mydoc.R
import com.devedroy.mydoc.data.local.Department

class DepartmentAdapter(
    private val dataset: List<Department>
) : RecyclerView.Adapter<DepartmentAdapter.DepartmentViewHolder>() {
    class DepartmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.depttv)
        val imageView = itemView.findViewById<ImageView>(R.id.ivDept)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepartmentViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_dept, parent, false)
        return DepartmentViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: DepartmentViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = item.name
        holder.imageView.setImageResource(R.drawable.dept)
    }
}