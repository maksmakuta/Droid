package ua.mstudio.droid.data

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.mstudio.droid.R
import ua.mstudio.droid.models.DroidVersion

class DroidAdapter(list: ArrayList<DroidVersion>, context: Context) : RecyclerView.Adapter<DroidHolder>(){
    val data = list
    val ctx = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DroidHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.list_view, parent, false)
        return DroidHolder(ctx,view)
    }

    override fun onBindViewHolder(holder: DroidHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}