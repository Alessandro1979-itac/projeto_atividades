package com.alessandromuniz.questaosixtest

import android.content.*
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import androidx.core.content.ContextCompat
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var myServico: Messenger? = null
    var isLimite: Boolean = false
    var contEmail = 0

    companion object {
        const val TAG = "MainActivity"
    }

    private val receiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val responseJson = intent?.getStringExtra("result")
            val node = Gson().fromJson(responseJson, Node::class.java)
            result.text = getStringList(node)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.isEnabled = false
        button.setOnClickListener({ processEmail() })

        connectToService()
    }

    override fun onResume() {

        val filter = IntentFilter()
        filter.addAction("emailProcessorFinished")
        registerReceiver(receiver, filter)
        super.onResume()
    }

    override fun onStop() {
        unregisterReceiver(receiver)
        super.onStop()
    }

    override fun onDestroy() {
        unbindService(mConnection)
        super.onDestroy()
    }

    fun getStringList(head: Node?) : String {

        var headAux = head
        val builder = StringBuilder()
        while (headAux != null) {
            builder.append("${headAux.value}, ")
            headAux = headAux.next
        }
        return builder.toString()
    }

    private val mConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            myServico = Messenger(service)
            isLimite = true
            button.isEnabled = true
            Log.i(TAG, "Serviço conectado")
            serverStatus.text = getString(R.string.server_status_online)
            serverStatus.setTextColor(ContextCompat.getColor(this@MainActivity, android.R.color.holo_green_light))
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            myServico = null
            isLimite = false
            button.isEnabled = false
            Log.i(TAG, "Serviço desconectado")
            serverStatus.text = getString(R.string.server_status_offline)
            serverStatus.setTextColor(ContextCompat.getColor(this@MainActivity, android.R.color.holo_red_light))
        }
    }

    private fun connectToService() {
        val intent = Intent()
        intent.`package` = "com.alessandromuniz.questaosix"
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
        intent.putExtra("clientName", "QuestionSixTest")
        intent.component = ComponentName("com.alessandromuniz.questaosix", "com.alessandromuniz.questaosix.EmailProcessorService")
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
    }

    private fun processEmail() {

        if (isLimite && myServico != null) {
            val msg = Message.obtain()
            val bundle = Bundle()
            val head = Node("msg-1")
            head.next = Node("msg-2")
            head.next!!.next = Node("msg-3")
            head.next!!.next!!.next = Node("msg-2")
            head.next!!.next!!.next!!.next = Node("msg-4")
            head.next!!.next!!.next!!.next!!.next = Node("msg-2")

            email.text = "Email original: ${getStringList(head)}"
            val emailJson = Gson().toJson(head)
            bundle.putString("email", emailJson)
            msg.data = bundle

            try {
                this.myServico!!.send(msg)
                contEmail++
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
        }
    }

    data class Node(val value: String) {
        var next: Node? = null
    }
}
