package com.alessandromuniz.questao_four

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class SearchListAdapter(var lista: List<String>?, private val activity: Activity) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = activity.layoutInflater.inflate(R.layout.list_line, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }
        viewHolder.tvWord?.text = lista?.get(position)
        return view;
    }

    override fun getItem(position: Int): Any? {

        if (lista != null) {
            return lista!!.get(position)
        }
        return null
    }

    override fun getItemId(position: Int): Long {

        return position.toLong();
    }

    override fun getCount(): Int {

        if (lista != null) {
            return lista!!.size
        }
        return 0
    }

    private class ViewHolder(row: View) {
        var tvWord: TextView? = null

        init {
            this.tvWord = row.findViewById(R.id.tvWord)
        }
    }
}