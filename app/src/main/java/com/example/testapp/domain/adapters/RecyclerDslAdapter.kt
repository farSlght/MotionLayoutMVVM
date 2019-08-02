package com.example.testapp.domain.adapters

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.testapp.domain.interfaces.IListItem

class RecyclerDslAdapter(
    val binder: (RecyclerView.ViewHolder,  IListItem) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items = mutableListOf<IListItem>()

    var isPagingEnabled: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        object : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        ) {}

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        binder(holder, items[holder.adapterPosition])
    }

    fun addItems(items: List<IListItem>) {
        val endIndex = this.items.lastIndex
        this.items.addAll(items)
        notifyItemRangeInserted(endIndex, items.count())
    }


    fun dispatchItems(newList: List<IListItem>){
        if (isPagingEnabled) hideLoader()
        val diffUtilCallback = object : DiffUtil.Callback(){
            override fun areItemsTheSame(oldListPosition: Int, newListPosition: Int): Boolean =
                    items[oldListPosition].id == newList[newListPosition].id

            override fun getOldListSize(): Int = itemCount

            override fun getNewListSize(): Int = newList.count()

            override fun areContentsTheSame(oldListPosition: Int, newListPosition: Int): Boolean =
                    items[oldListPosition].id == newList[newListPosition].id
        }
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(diffUtilCallback)
        items.clear()
        items.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
        if (isPagingEnabled) showLoader()
    }


    private fun showLoader() {
        if (items.isEmpty() || items.last() !is LoaderItem) {
            items.add(LoaderItem())
            notifyItemInserted(items.size - 1)
        }
    }

    fun hideLoader() {
        if (items.isNotEmpty() && items.last() is LoaderItem) {
            items.removeAt(items.size - 1)
            notifyDataSetChanged()
        }
    }

    fun deleteItems(){
        items.clear()
        notifyDataSetChanged()
    }

    class LoaderItem : IListItem {
        override val id = "loader"
    }
}