package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.R
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.components.StateProgressViewPod
import kotlinx.android.synthetic.main.activity_rounded_image.*

class RoundedImageActivity : BaseActivity() {

    companion object{
        fun newIntent(context: Context): Intent{
            return Intent(context,RoundedImageActivity::class.java)
        }
    }

    private lateinit var viewPodProgressState: StateProgressViewPod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rounded_image)


        setupViewPod()
        setupListener()

    }

    fun setupViewPod(){
        viewPodProgressState = viewPodStateProgress as StateProgressViewPod
        viewPodProgressState.apply {
            setStepDescription("Survey","Cabling","Splicing","Activate")
        }
    }
    fun setupListener(){

        btn1.setOnClickListener {
            viewPodProgressState.onTapStep1()
        }
        btn2.setOnClickListener {
            viewPodProgressState.onTapStep2()
        }
        btn3.setOnClickListener {
            viewPodProgressState.onTapStep3()
        }
        btn4.setOnClickListener {
            viewPodProgressState.onTapStep4()
            viewPodProgressState.completeAllSteps()
        }

        navigateToCustomComponent.setOnClickListener {
            startActivity(CustomComponentActivity.newIntent(this))
        }
    }


}