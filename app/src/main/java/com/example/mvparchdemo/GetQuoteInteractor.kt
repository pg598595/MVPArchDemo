package com.example.mvparchdemo

interface GetQuoteInteractor {

    interface OnFinishedListener {
        fun onFinished(string: String)
    }

    fun getNextQuote(listener: OnFinishedListener)
}