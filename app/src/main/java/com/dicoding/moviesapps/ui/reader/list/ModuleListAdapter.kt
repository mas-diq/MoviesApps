package com.dicoding.moviesapps.ui.reader.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.moviesapps.data.model.DescEntity
import com.dicoding.moviesapps.databinding.ItemsModuleListCustomBinding

class ModuleListAdapter internal constructor(private val listener: MyAdapterClickListener) :
    RecyclerView.Adapter<ModuleListAdapter.ModuleViewHolder>() {
    private val listModules = ArrayList<DescEntity>()

    internal fun setModules(descs: List<DescEntity>?) {
        if (descs == null) return
        this.listModules.clear()
        this.listModules.addAll(descs)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val binding =
            ItemsModuleListCustomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModuleViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ModuleViewHolder, position: Int) {
        val module = listModules[position]
        viewHolder.bind(module)
        viewHolder.itemView.setOnClickListener {
            listener.onItemClicked(
                viewHolder.absoluteAdapterPosition,
                listModules[viewHolder.absoluteAdapterPosition].descId
            )
        }
    }

    override fun getItemCount(): Int = listModules.size

    inner class ModuleViewHolder(private val binding: ItemsModuleListCustomBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(desc: DescEntity) {
            binding.textModuleTitle.text = desc.title
        }
    }
}

internal interface MyAdapterClickListener {
    fun onItemClicked(position: Int, moduleId: String)
}