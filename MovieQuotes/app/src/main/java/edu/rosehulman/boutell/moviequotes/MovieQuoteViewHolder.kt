package edu.rosehulman.boutell.moviequotes

import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView

class MovieQuoteViewHolder : RecyclerView.ViewHolder {
    val quoteTextView: TextView = itemView.findViewById(R.id.quote_text_view)
    val movieTextView: TextView = itemView.findViewById(R.id.movie_text_view)
    var adapter: MovieQuoteAdapter
    var cardView: CardView

    constructor(itemView: View, adapter: MovieQuoteAdapter) : super(itemView) {
        this.adapter = adapter
        itemView.setOnClickListener {
            adapter.showAddEditDialog(adapterPosition)
        }
        itemView.setOnLongClickListener {
            adapter.selectMovieQuote(adapterPosition)
            true
        }
        cardView = itemView.findViewById(R.id.row_card_view)
    }

    fun bind(movieQuote: MovieQuote) {
        Log.d(Constants.TAG, "Binding VH")
        quoteTextView.text = movieQuote.quote
        movieTextView.text = movieQuote.movie

        if (movieQuote.showDark) {
            cardView.setCardBackgroundColor(
                ContextCompat.getColor(adapter.context, R.color.colorAccent)
            )
        } else {
            cardView.setCardBackgroundColor(Color.WHITE)
        }
    }
}