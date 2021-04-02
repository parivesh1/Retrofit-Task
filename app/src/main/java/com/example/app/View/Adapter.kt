package com.example.app.View

import android.content.Context
import android.icu.text.IDNA
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.Model.Info
import com.example.app.R
import kotlin.collections.ArrayList

class Adapter(
    private val context: Context,
    private var listItems: ArrayList<Info>
) : RecyclerView.Adapter<Adapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = listItems.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val post = listItems[position]
        holder.textView.text = post.title
        holder.textView1.text = post.body
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
        val textView1: TextView = itemView.findViewById(R.id.textView1)
    }

    fun setData(plist: ArrayList<Info>) {
        this.listItems = plist
        notifyDataSetChanged()
    }
}