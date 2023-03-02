package com.devedroy.mydoc.views.homepage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devedroy.mydoc.R
import com.devedroy.mydoc.data.local.Surgery

class SurgeryAdapter(
    private val context: Context,
    private val dataSet:List<Surgery>?
) : RecyclerView.Adapter<SurgeryAdapter.SurgeryViewHolder>(){

    class SurgeryViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textViewName:TextView = itemView.findViewById(R.id.name)
        val textViewCost:TextView = itemView.findViewById(R.id.cost)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurgeryViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_view_surgeries,parent,false)
        return  SurgeryViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataSet?.size ?: 0
    }

    override fun onBindViewHolder(holder: SurgeryViewHolder, position: Int) {
        val item = dataSet?.get(position)
        if (item != null) {
            holder.textViewName.text= item.name
        }
        if(item != null){
            holder.textViewCost.text=item.cost.toString()
        }
    }
}