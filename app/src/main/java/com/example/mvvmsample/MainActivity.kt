package com.example.mvvmsample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dao = QuoteDatabase.getDatabase(getApplicationContext()).quoteDao()
        val repository = QuoteRepository(dao)

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]

        mainViewModel.getQuotes().observe(
            this
        ) {
            binding.quotes = it.toString()
        }

        binding.btnAddQuote.setOnClickListener {
            val quote = Quote(0, "You know me", "GOD")
            mainViewModel.insertQuote(quote)
        }

    }
}