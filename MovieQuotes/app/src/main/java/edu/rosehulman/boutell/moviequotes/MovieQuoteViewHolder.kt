package edu.rosehulman.boutell.moviequotes

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class MovieQuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val quoteTextView: TextView = itemView.findViewById(R.id.quote_text_view)
    val movieTextView: TextView = itemView.findViewById(R.id.movie_text_view)
}