package com.alessandromuniz.questao_four

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.AdapterView
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        searchViewModel.minhaLista.observe(this, Observer { list ->
            updateList(list)
        })
        searchViewModel.getAll()
        my_Lista.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val item = my_Lista.adapter.getItem(position) as String
            Toast.makeText(this, item, Toast.LENGTH_LONG).show()
        }
    }

    private fun updateList(list: List<String>?) {
        var adapter = my_Lista.adapter
        if (adapter == null) {
            adapter = SearchListAdapter(list, this@MainActivity)
            my_Lista.adapter = adapter
        } else {
            (adapter as SearchListAdapter).lista = list
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)

        //Obtenha o SearchView e defina a configuração pesquisável
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.search)?.actionView as SearchView

        //Assume que a atividade atual é a atividade pesquisável
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setIconifiedByDefault(false)
        searchView.isSubmitButtonEnabled = true

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query.isNullOrBlank()) {
                    searchViewModel.getAll()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        return true
    }

    override fun onNewIntent(intent: Intent?) {
        if (intent != null) {
            handleIntent(intent)
        }
        super.onNewIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            if (query.isNullOrBlank()) {
                searchViewModel.getAll()
            } else {
                searchViewModel.pesquisar(query)
            }
        }
    }
}
