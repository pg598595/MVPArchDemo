package com.example.mvparchdemo

interface MainView {

    fun showProgress()

    fun hideProgress()

    fun setQuote(string: String)
}