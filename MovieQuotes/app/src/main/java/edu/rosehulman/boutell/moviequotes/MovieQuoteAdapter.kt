package edu.rosehulman.boutell.moviequotes

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup

class MovieQuoteAdapter: RecyclerView.Adapter<MovieQuoteViewHolder> {
    val movieQuotes = ArrayList<MovieQuote>()
    var context: Context
    constructor(context: Context) {
        Log.d(Constants.TAG, "Constructing adapter")
        this.context = context
    }

    override fun getItemCount(): Int {
        Log.d(Constants.TAG, "Getting count" + movieQuotes.size)
        return movieQuotes.size
    }

    override fun onBindViewHolder(
        viewHolder: MovieQuoteViewHolder,
        index: Int) {
        viewHolder.quoteTextView.text = movieQuotes[index].quote
        viewHolder.movieTextView.text = movieQuotes[index].movie
        Log.d(Constants.TAG, "Binding VH")

    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        index: Int): MovieQuoteViewHolder {
        Log.d(Constants.TAG, "Creating VH1")
        val view = LayoutInflater.from(context).inflate(R.layout.row_view, viewGroup, false)
        Log.d(Constants.TAG, "Creating VH2")
        return MovieQuoteViewHolder(view)
    }

    fun add(movieQuote: MovieQuote) {
        movieQuotes.add(0, movieQuote)
        Log.d(Constants.TAG, "MQ: $movieQuotes")
        notifyItemInserted(0)
        notifyDataSetChanged()
        Log.d(Constants.TAG, "Done Adding ")
    }
}