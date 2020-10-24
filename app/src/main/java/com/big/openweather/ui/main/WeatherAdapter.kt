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
        private val date: TextView = view.findViewById(R.id.date)
        private val wind: TextView = view.findViewById(R.id.wind)
        private val temperature: TextView = view.findViewById(R.id.temperature)
        private val visibility: TextView = view.findViewById(R.id.visibility)
        private val description: TextView = view.findViewById(R.id.status)

        fun bind(searchResult: list) {
            temperature.text = "Temp: ${searchResult.main.temp}"
            date.text = searchResult.dt_txt
            wind.text = "Wind: ${searchResult.wind.speed}"
            description.text = "Description: ${searchResult.weather[0].description}"
            visibility.text = "Visibility: ${searchResult.visibility}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_poster_card, parent, false)
    )

}