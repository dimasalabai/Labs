package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.media.MediaPlayer
import android.widget.ImageButton
import android.media.AudioManager
import android.os.Bundle
import com.example.myapplication.R
import android.media.MediaPlayer.OnCompletionListener
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var mPlayerwater: MediaPlayer? = null
    var mPlayerleaf: MediaPlayer? = null
    var mPlayerfire: MediaPlayer? = null
    var waterbutton: ImageButton? = null
    var leafbutton: ImageButton? = null
    var firebutton: ImageButton? = null
    var audioManager: AudioManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPlayerwater = MediaPlayer.create(this, R.raw.water)
        mPlayerleaf = MediaPlayer.create(this, R.raw.leaf)
        mPlayerfire = MediaPlayer.create(this, R.raw.fire)
        mPlayerwater!!.setOnCompletionListener(OnCompletionListener { stopPlay() })
        mPlayerleaf!!.setOnCompletionListener(OnCompletionListener { stopPlay() })
        mPlayerfire!!.setOnCompletionListener(OnCompletionListener { stopPlay() })
        waterbutton = findViewById(R.id.waterbutton)
        leafbutton = findViewById(R.id.leafbutton)
        firebutton = findViewById(R.id.firebutton)
        waterbutton!!.setEnabled(true)
        leafbutton!!.setEnabled(true)
        firebutton!!.setEnabled(true)
        audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
    }
//functions
    private fun stopPlay() {
        mPlayerwater!!.stop()
        mPlayerleaf!!.stop()
        mPlayerfire!!.stop()
        try {
            mPlayerwater!!.prepare()
            mPlayerleaf!!.prepare()
            mPlayerfire!!.prepare()
            mPlayerwater!!.seekTo(0)
            mPlayerleaf!!.seekTo(0)
            mPlayerfire!!.seekTo(0)
        } catch (t: Throwable) {
            Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun playleaf(view: View?) {
        leafbutton!!.isEnabled = true
        mPlayerleaf!!.start()
    }

    fun playwater(view: View?) {
        waterbutton!!.isEnabled = true
        mPlayerwater!!.start()
    }

    fun playfire(view: View?) {
        firebutton!!.isEnabled = true
        mPlayerfire!!.start()
    }
}