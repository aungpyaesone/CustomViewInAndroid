package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.data.vos.NewsVO
import kotlinx.android.synthetic.main.view_pod_reactions.view.*

class ReactionViewPods @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr)
{
    private var mDelegate : Delegate? = null
    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setUpDelegate(delegate: Delegate){
        mDelegate = delegate
    }

    private fun setUpListener(){
        tvLike.setOnClickListener {
            mDelegate?.onTapLike()
        }
        tvComment.setOnClickListener {
            mDelegate?.onTapComment()
        }
        tvShare.setOnClickListener {
            mDelegate?.onTapShare()
        }
    }

    fun bindData(news : NewsVO){
        tvLikedUser.text = news.likedUsers.count().toString()
        tvCommentUser.text = news.comments.count().toString()
    }

    interface Delegate{
        fun onTapLike()
        fun onTapComment()
        fun onTapShare()
    }
}