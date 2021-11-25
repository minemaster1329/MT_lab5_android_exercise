package com.example.mt_lab5_android_exercise

import android.content.Context
import android.opengl.GLSurfaceView

class MyGLSurfaceView(context: Context) : GLSurfaceView(context) {
    val myGLRenderer: MyGLRenderer
    init {
        setEGLContextClientVersion(2)
        myGLRenderer = MyGLRenderer()
        setRenderer(myGLRenderer)
    }
}