package com.example.mt_lab5_android_exercise

import android.opengl.GLSurfaceView
import android.opengl.GLU
import java.nio.ByteBuffer
import java.nio.ByteOrder
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class MyRenderer : GLSurfaceView.Renderer {
    private var kat: Float = 0.0F

    override fun onSurfaceCreated(p0: GL10?, p1: EGLConfig?) {

    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        if (gl != null){
            gl.glViewport(0,0,width, height)
            gl.glMatrixMode(GL10.GL_PROJECTION)
            gl.glLoadIdentity()
            GLU.gluPerspective(gl, 45.0f, (width.toFloat() / height.toFloat()), -1.0f, -10.0f)
            gl.glClearColor(0.0f, 0.0f,1.0f,1.0f)
        }
    }

    override fun onDrawFrame(gl: GL10?) {
        if (gl != null){
            val vertices = floatArrayOf(
                -1.0f, 0.0f, -1.0f,
                0.0f, 1.0f, -1.0f,
                1.0f, 0.0f, -1.0f
            )
            val buffer = ByteBuffer.allocateDirect(48)
            buffer.order(ByteOrder.nativeOrder())
            val verticesBuffer = buffer.asFloatBuffer()
            verticesBuffer.put(vertices)
            verticesBuffer.position(0)

            gl.glClear(GL10.GL_COLOR_BUFFER_BIT or  GL10.GL_DEPTH_BUFFER_BIT)
            gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f)
            gl.glLoadIdentity()
            gl.glRotatef(kat++, 0.0f, 0.0f, 1.0f)
            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY)
            gl.glVertexPointer(3, GL10.GL_FLOAT, 0, verticesBuffer)
            gl.glDrawArrays(GL10.GL_TRIANGLES, 0,3)
            gl.glDisableClientState(GL10.GL_VERTEX_ARRAY)
        }
    }
}