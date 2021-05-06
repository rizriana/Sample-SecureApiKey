package id.rrlab.samplesecureapikey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.rrlab.samplesecureapikey.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    init {
        System.loadLibrary("keys")
    }

    private external fun apiKey(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowApiKey.setOnClickListener {
            binding.tvShowApiKey.text = apiKey()
        }
    }
}