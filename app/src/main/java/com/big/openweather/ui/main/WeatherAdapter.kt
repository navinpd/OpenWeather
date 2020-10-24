package com.big.openweather.ui.main


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.big.openweather.R
import com.big.openweather.data.remote.response.weatherdetails.list

class WeatherAdapter(
    private var mMovieListItem: MutableList<list>,
) : RecyclerView.Adapter<WeatherAdapter.DataViewHolder>() {

    var onClickListener: View.OnClickListener? = null

    override fun getItemCount() = mMovieListItem.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(mMovieListItem[position])
    }

    inner class DataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val weatherDate: TextView = view.findViewById(R.id.date)

        fun bind(searchResult: list) {
            weatherDate.text = searchResult.dt_txt
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_poster_card, parent, false)
    )

}