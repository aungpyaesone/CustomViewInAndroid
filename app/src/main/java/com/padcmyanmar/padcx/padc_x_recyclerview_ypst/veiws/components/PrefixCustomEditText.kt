package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.withStyledAttributes
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.R

class PrefixCustomEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatEditText(context, attrs, defStyleAttr) {

    private val mRec = Rect()
    private var mPrefixText = "+95"
    private var mPrefixColor = Color.BLACK

    init {
        context.withStyledAttributes(attrs, R.styleable.PrefixCustomEditText){
            mPrefixText = getString(R.styleable.PrefixCustomEditText_prefixText) ?: mPrefixText
            mPrefixColor = getColor(R.styleable.PrefixCustomEditText_prefixTextColor,mPrefixColor)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        paint.getTextBounds(mPrefixText,0,mPrefixText.length,mRec)

        mRec.right += paint.measureText(" ").toInt()
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        paint.color = mPrefixColor

        canvas?.drawText(
            mPrefixText,
            super.getCompoundPaddingLeft().toFloat(),
            baseline.toFloat(),
            paint
        )
        super.onDraw(canvas)
    }

    override fun getCompoundPaddingLeft(): Int {
        return super.getCompoundPaddingLeft() + mRec.width()
    }
}