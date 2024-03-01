package com.example.travelphotoapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    var  currentImage = 0
    lateinit var image : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  next = findViewById<ImageButton>(R.id.btn_next)
        val  prev = findViewById<ImageButton>(R.id.btn_prev)

        next.setOnClickListener{
            var idCurrentImageString = "pic$currentImage"
            
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha =0f

            currentImage= (5+currentImage+1)%5

            var idImageToShowString = "pic$currentImage"

            println("NEXT "+idImageToShowString)
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha =1f
        }

        prev.setOnClickListener{
            var idCurrentImageString = "pic$currentImage"
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha =0f

            currentImage= (5+currentImage-1)%5


            var idImageToShowString = "pic$currentImage"
            println("PREV "+idImageToShowString)
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha =1f
        }
    }
}