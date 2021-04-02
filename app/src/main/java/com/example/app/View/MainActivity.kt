package com.example.app.View

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.Model.Info
import com.example.app.R
import com.example.app.Repo.Repository
import com.example.app.ViewModel.viewModel
import com.example.app.ViewModel.viewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapt: Adapter
    private lateinit var vm: viewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inRecyclerView()
        val repos = Repository()
        val viewModelFactory = viewModelFactory(repos)
        vm = ViewModelProvider(this, viewModelFactory)[viewModel::class.java]
        vm.getItem()
        vm.itemMutable.observe(this, Observer {
            adapt.setData(it as ArrayList<Info>)
        })
    }
    private fun inRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view)
        adapt = Adapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapt
        }
    }
}