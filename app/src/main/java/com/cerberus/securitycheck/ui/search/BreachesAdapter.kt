package com.cerberus.securitycheck.ui.search

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cerberus.securitycheck.R
import com.cerberus.securitycheck.models.Breaches
import com.ms.square.android.expandabletextview.ExpandableTextView
import kotlinx.android.synthetic.main.breach_row.view.*

class BreachesAdapter(private val breaches: List<Breaches>) :
    RecyclerView.Adapter<BreachesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.breach_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = breaches.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val breaches = breaches[position]
        //holder.breachLogo.text = breaches.LogoPath
        holder.breachName.text = breaches.Name
        holder.breachDomain.text = breaches.Domain
        holder.breachCount.text = breaches.PwnCount.toString()
        holder.breachDate.text = breaches.BreachDate
        holder.breachDescription.text = breaches.Description
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //val breachLogo: ImageView = itemView.breachLogo
        val breachName: TextView = itemView.breachName
        val breachDomain: TextView = itemView.breachDomain
        val breachCount: TextView = itemView.breachCount
        val breachDate: TextView = itemView.breachDate
        val breachDescription: TextView = itemView.breachDescription
    }

}
