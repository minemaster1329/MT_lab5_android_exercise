package com.example.mt_lab5_android_exercise

import android.content.Context
import android.opengl.GLSurfaceView

class MyGLSSurfaceView(context: Context) : GLSurfaceView(context) {
    init {
        setRenderer(MyRenderer())
    }
}