package com.example.mvparchdemo



import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

import android.view.View.GONE

class MainActivity : AppCompatActivity(), MainView {

    private var textView: TextView? = null
    private var button: Button? = null
    private var progressBar: ProgressBar? = null
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<TextView>(R.id.textView)
        button = findViewById<Button>(R.id.button)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        presenter = MainPresenterImpl(this, GetQuoteInteractorImpl())

        button!!.setOnClickListener { presenter.onButtonClick() }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
        textView!!.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = GONE
        textView!!.visibility = View.VISIBLE
    }

    override fun setQuote(string: String) {
        textView!!.text = string
    }
}
