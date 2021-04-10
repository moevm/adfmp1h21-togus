package com.example.toguz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupWindow
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController

class PvpFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pvp_lay, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ImageButton>(R.id.imageButton4).setOnClickListener {
            tt("Вы действительно, хотите выйти в меню?",1);
        }
        view.findViewById<ImageButton>(R.id.imageButton5).setOnClickListener {
            tt("Вы действительно, хотите начать заново?",2);
        }
        view.findViewById<ImageButton>(R.id.imageButton6).setOnClickListener {
            tt("Пауза",3);
        }
    }

    fun tt(title_text: String, type: Int){
        val popupView: View =
            LayoutInflater.from(activity).inflate(R.layout.pop_up_lay, null)
        val popupWindow = PopupWindow(
            popupView,

            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )

        (popupView.findViewById<TextView>(R.id.titleText)).setText(title_text);
        if (type ==1) {
            val buttonEdit = popupView.findViewById<Button>(R.id.messageButton)
            buttonEdit.setOnClickListener {
                popupWindow.dismiss()
                findNavController().navigate(R.id.action_pvpFrag_to_menuFrag)
            }

            popupView.findViewById<Button>(R.id.button)
                .setOnClickListener {
                    popupWindow.dismiss()
                }
        }
        if (type ==2) {
            val buttonEdit = popupView.findViewById<Button>(R.id.messageButton)
            buttonEdit.setOnClickListener {
                popupWindow.dismiss()
            }
            popupView.findViewById<Button>(R.id.button)
                .setOnClickListener {
                    popupWindow.dismiss()
                }
        }
        if (type ==3) {
            val buttonEdit = popupView.findViewById<Button>(R.id.messageButton)
            buttonEdit.setText("Возобновить")
            buttonEdit.setOnClickListener {
                popupWindow.dismiss()
            }

            popupView.findViewById<Button>(R.id.button).isVisible = false
        }
        popupView.setOnTouchListener { _, _ ->
            popupWindow.dismiss()
            true
        }
        popupWindow.showAsDropDown(popupView, 0, 0)
    }
}