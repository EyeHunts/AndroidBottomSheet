package `in`.eyehunt.androidbottomsheet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.main_content.*


class MainActivity : AppCompatActivity() {

    private lateinit var sheetBehavior: BottomSheetBehavior<LinearLayout>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sheetBehavior = BottomSheetBehavior.from<LinearLayout>(bottom_sheet)


        /**
         * bottom sheet state change listener
         * we are changing button text when sheet changed state
         * */
        sheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                    }
                    BottomSheetBehavior.STATE_EXPANDED ->
                        btBottomSheet.text = "Close Bottom Sheet"
                    BottomSheetBehavior.STATE_COLLAPSED ->
                        btBottomSheet.text = "Expand Bottom Sheet"
                    BottomSheetBehavior.STATE_DRAGGING -> {
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
        })

        btBottomSheet.setOnClickListener(View.OnClickListener {
            expandCloseSheet()
        })

        btBottomSheetDialog.setOnClickListener(View.OnClickListener {
            val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()
        })
    }

    private fun expandCloseSheet() {
        if (sheetBehavior!!.state != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior!!.state = BottomSheetBehavior.STATE_EXPANDED
            btBottomSheet.text = "Close Bottom Sheet"
        } else {
            sheetBehavior!!.state = BottomSheetBehavior.STATE_COLLAPSED
            btBottomSheet.text = "Expand Bottom Sheet"
        }
    }
}

