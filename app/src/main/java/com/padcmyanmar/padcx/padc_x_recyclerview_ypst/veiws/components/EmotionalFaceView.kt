package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class EmotionalFaceView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    // for path smooth
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    // for some color
    private var faceColor = Color.YELLOW
    private var eyeColor = Color.BLACK
    private var mouthColor = Color.BLACK
    private var borderColor = Color.BLACK

    // border width
    private var borderWidth = 4.0f

    // View Size in pixels
    private var size = 320

    private val mouthPath = Path()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawFaceBackground(canvas)
        drawEye(canvas)
        drawMouth(canvas)


    }

    private fun drawFaceBackground(canvas: Canvas){
        paint.color = faceColor
        paint.style = Paint.Style.FILL

        val radius = size/2f

        canvas.drawCircle(size/2f,size/2f,radius,paint)

        paint.color = borderColor
        paint.style = Paint.Style.STROKE

        canvas.drawCircle(size/2f,size/2f,radius-borderWidth/2f,paint)
    }

    private fun drawEye(canvas: Canvas){
        paint.color = eyeColor
        paint.style = Paint.Style.FILL

        val leftEyeRect = RectF(size*0.32f,size*0.23f,size*0.43f , size *0.50f)
        canvas.drawOval(leftEyeRect,paint)

        val rightEyeRect = RectF(size * 0.57f, size * 0.23f, size * 0.68f, size * 0.50f)
        canvas.drawOval(rightEyeRect,paint)

    }

    private fun drawMouth(canvas: Canvas){
        mouthPath.moveTo(size*0.22f, size*0.7f)

        mouthPath.quadTo(size*0.50f,size*0.80f,size* 0.78f, size *0.70f)

        mouthPath.quadTo(size*0.50f,size*0.90f,size* 0.22f, size *0.70f)

        paint.color = mouthColor
        paint.style = Paint.Style.FILL
        canvas.drawPath(mouthPath,paint)
    }
}