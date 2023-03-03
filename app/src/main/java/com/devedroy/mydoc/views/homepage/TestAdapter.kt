package com.devedroy.mydoc.views.homepage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devedroy.mydoc.R
import com.devedroy.mydoc.data.local.Test

class TestAdapter(
    private val dataset: List<Test>
) : RecyclerView.Adapter<TestAdapter.TestViewModel>() {
    class TestViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.name)
        val textViewCost: TextView = itemView.findViewById(R.id.cost)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewModel {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_tests, parent, false)
        return TestViewModel(adapterLayout)
    }

    override fun onBindViewHolder(holder: TestViewModel, position: Int) {
        val item = dataset[position]
        holder.textViewName.text = item.name
        holder.textViewCost.text = item.cost.toString()
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}