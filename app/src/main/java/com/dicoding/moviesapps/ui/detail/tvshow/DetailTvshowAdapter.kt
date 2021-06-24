package com.dicoding.moviesapps.ui.detail.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.moviesapps.data.model.DescEntity
import com.dicoding.moviesapps.databinding.ItemsModuleListBinding

class DetailTvshowAdapter : RecyclerView.Adapter<DetailTvshowAdapter.ModuleViewHolder>() {
    private val listModules = ArrayList<DescEntity>()

    fun setModules(descs: List<DescEntity>?) {
        if (descs == null) return
        this.listModules.clear()
        this.listModules.addAll(descs)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val itemModuleListBinding =
            ItemsModuleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModuleViewHolder(itemModuleListBinding)
    }

    override fun onBindViewHolder(viewHolder: ModuleViewHolder, position: Int) {
        val module = listModules[position]
        viewHolder.bind(module)
    }

    override fun getItemCount(): Int = listModules.size

    inner class ModuleViewHolder(private val binding: ItemsModuleListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(desc: DescEntity) {
            binding.textModuleTitle.text = desc.title
        }
    }
}