package com.example.mvparchdemo

import android.os.Handler
import java.nio.file.Files.size
import android.support.v4.os.HandlerCompat.postDelayed
import java.util.*
import java.util.Arrays.asList


class GetQuoteInteractorImpl : GetQuoteInteractor {

    private val arrayList = Arrays.asList(
        "Be yourself. everyone else is already taken.\uD83D\uDE04",
        "A room without books is like a body without a soul.",
        "You only live once, but if you do it right, once is enough.",
        "Be the change that you wish to see in the world.",
        "If you tell the truth, you don't have to remember anything."
    )

    private val randomString: String
        get() {

            val random = Random()
            val index = random.nextInt(arrayList.size)

            return arrayList[index]
        }

    override fun getNextQuote(listener: GetQuoteInteractor.OnFinishedListener) {
        Handler().postDelayed(Runnable { listener.onFinished(randomString) }, 1200)
    }
}