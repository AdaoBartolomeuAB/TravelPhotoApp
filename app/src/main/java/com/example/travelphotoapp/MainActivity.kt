package com.example.travelphotoapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var  currentImage = 0
    lateinit var image : ImageView
    lateinit var tvName: TextView
    var places = arrayOf("Times Square ","Eiffel Tower","Yosemite park","Yucatán","Havana","Santorini")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  next = findViewById<ImageButton>(R.id.btn_next)
        val  prev = findViewById<ImageButton>(R.id.btn_prev)
        tvName = findViewById(R.id.tvName)

        next.setOnClickListener{
            var idCurrentImageString = "pic$currentImage"

            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha =0f

            currentImage= (5+currentImage+1)%5

            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha =1f

            tvName.text =places.get(currentImage)
        }

        prev.setOnClickListener{
            var idCurrentImageString = "pic$currentImage"
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha =0f

            currentImage= (5+currentImage-1)%5

            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha =1f
            tvName.text =places.get(currentImage)
        }
    }
}