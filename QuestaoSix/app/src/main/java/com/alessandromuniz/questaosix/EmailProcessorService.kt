package com.alessandromuniz.questaosix

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.google.gson.Gson
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class EmailProcessorService : Service() {

    private var myMessenger = Messenger(IncomingHandler())
    private lateinit var executorService: ExecutorService

    companion object {
        const val TAG = "EmailProcessorService"
    }

    override fun onBind(intent: Intent) : IBinder? {
        Log.i(TAG, "Service onBind, appName: ${intent.extras?.getString("clientName")}")
        return myMessenger.binder
    }

    override fun onCreate() {
        executorService = Executors.newSingleThreadExecutor()
        Log.i(TAG, "Service onCreate")
        super.onCreate()
    }

    override fun onDestroy() {
        Log.i(TAG, "Service onDestroy")
    }

    private fun sendBroadcast(response: String) {

        val intent = Intent("emailProcessorFinished")
        val extras = Bundle()
        extras.putString("result", response)
        intent.putExtras(extras)
        sendBroadcast(intent)
    }

    @SuppressLint("HandlerLeak")
    internal inner class IncomingHandler : Handler() {
        override fun handleMessage(msg: Message) {

            val data = msg.data
            val dataString = data.getString("email")
            val hearNode = Gson().fromJson(dataString, Node::class.java)
            executorService.submit(MyTask(hearNode))
        }
    }

    internal inner class MyTask(private val email: Node) : Runnable {
        override fun run() {
            deleteDuplicates(email)
            val responseJson = Gson().toJson(email)
            sendBroadcast(responseJson)
        }
    }

    fun deleteDuplicates(head: Node?) {

        val hashSet = hashSetOf<String>()
        var atual = head
        var prev: Node? = null

        while (atual != null) {
            val value = atual.value

            if (hashSet.contains(value)) {
                prev!!.next = atual.next
            } else {
                hashSet.add(value)
                prev = atual
            }
            atual = atual.next!!
        }
    }

    data class Node(val value: String) {
        var next: Node? = null
    }
}
