package com.dialnumber.mvvm_kotlin.helpers

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import com.dialnumber.mvvm_kotlin.helpers.custom_component.progress_dialog.ArcConfiguration
import com.dialnumber.mvvm_kotlin.helpers.custom_component.progress_dialog.SimpleArcDialog
import com.dialnumber.mvvm_kotlin.helpers.custom_component.progress_dialog.SimpleArcLoader


@Suppress("DEPRECATION")
class ProgressUtils {
    @SuppressLint("StaticFieldLeak")

    companion object
    {
        private var progressDialog: SimpleArcDialog? = null
        private val colors = intArrayOf(
            Color.parseColor("#343C85"),  // RED
            Color.parseColor("#800000ff")
        )

        fun ShowProgressDialog(context: Context?) {

            progressDialog = SimpleArcDialog(context)
            val configuration = ArcConfiguration(context)
            configuration.setLoaderStyle(
                SimpleArcLoader.STYLE.COMPLETE_ARC
            )
            configuration.setText("Please wait..")
            configuration.setColors(colors)
            progressDialog!!.setConfiguration(configuration)
            progressDialog!!.setCancelable(false)
            progressDialog!!.show()

            /*progressDialog = ProgressDialog(context)
            progressDialog!!.setMessage("Please wait..")
            progressDialog!!.setIndeterminate(true)
            progressDialog!!.setCancelable(false)
            progressDialog!!.show()*/
        }

        fun DismissProgressDialog(context: Context?) {
            progressDialog!!.dismiss()
        }
    }

}