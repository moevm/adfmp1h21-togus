package com.example.toguz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupWindow
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class PvcFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pvc_lay, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val popupView: View =
            LayoutInflater.from(activity).inflate(R.layout.pop_up_lay, null)
        val popupWindow = PopupWindow(
            popupView,

            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )

        (popupView.findViewById<TextView>(R.id.titleText)).setText("Выбор хода с ботом.");
            val buttonEdit = popupView.findViewById<Button>(R.id.messageButton)
            buttonEdit.setText("Первым")
            buttonEdit.setOnClickListener {
                popupWindow.dismiss()
            }

            popupView.findViewById<Button>(R.id.button).setText("Вторым")
            popupView.findViewById<Button>(R.id.button).setOnClickListener {
                    popupWindow.dismiss()
                }
        popupWindow.showAsDropDown(popupView, 0, 0)

        view.findViewById<ImageButton>(R.id.imageButton4).setOnClickListener {
            view.findViewById<ImageButton>(R.id.imageButton4).isFocusable = false
            view.findViewById<ImageButton>(R.id.imageButton5).isFocusable = false
            view.findViewById<ImageButton>(R.id.imageButton6).isFocusable = false
            tt("Вы действительно, хотите выйти в меню?",1,view);
        }
        view.findViewById<ImageButton>(R.id.imageButton5).setOnClickListener {
            view.findViewById<ImageButton>(R.id.imageButton4).isFocusable = false
            view.findViewById<ImageButton>(R.id.imageButton5).isFocusable = false
            view.findViewById<ImageButton>(R.id.imageButton6).isFocusable = false
            tt("Вы действительно, хотите начать заново?",2,view);
        }
        view.findViewById<ImageButton>(R.id.imageButton6).setOnClickListener {
            view.findViewById<ImageButton>(R.id.imageButton4).isFocusable = false
            view.findViewById<ImageButton>(R.id.imageButton5).isFocusable = false
            view.findViewById<ImageButton>(R.id.imageButton6).isFocusable = false
            tt("Пауза",3, view);
        }
    }

    fun tt(title_text: String, type: Int, view_back: View){
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
                view_back.findViewById<ImageButton>(R.id.imageButton4).isFocusable = true
                view_back.findViewById<ImageButton>(R.id.imageButton5).isFocusable = true
                view_back.findViewById<ImageButton>(R.id.imageButton6).isFocusable = true
                findNavController().navigate(R.id.action_pvcFrag_to_menuFrag)
                popupWindow.dismiss()
            }

            popupView.findViewById<Button>(R.id.button)
                .setOnClickListener {
                    view_back.findViewById<ImageButton>(R.id.imageButton4).isFocusable = true
                    view_back.findViewById<ImageButton>(R.id.imageButton5).isFocusable = true
                    view_back.findViewById<ImageButton>(R.id.imageButton6).isFocusable = true
                    popupWindow.dismiss()
                }
        }
        if (type ==2) {
            val buttonEdit = popupView.findViewById<Button>(R.id.messageButton)
            buttonEdit.setOnClickListener { //As an example, display the message
                view_back.findViewById<ImageButton>(R.id.imageButton4).isFocusable = true
                view_back.findViewById<ImageButton>(R.id.imageButton5).isFocusable = true
                view_back.findViewById<ImageButton>(R.id.imageButton6).isFocusable = true
                popupWindow.dismiss()
            }
            popupView.findViewById<Button>(R.id.button)
                .setOnClickListener {
                    view_back.findViewById<ImageButton>(R.id.imageButton4).isFocusable = true
                    view_back.findViewById<ImageButton>(R.id.imageButton5).isFocusable = true
                    view_back.findViewById<ImageButton>(R.id.imageButton6).isFocusable = true
                    popupWindow.dismiss()
                }
        }
        if (type ==3) {
            val buttonEdit = popupView.findViewById<Button>(R.id.messageButton)
            buttonEdit.setText("Возобновить")
            buttonEdit.setOnClickListener {
                view_back.findViewById<ImageButton>(R.id.imageButton4).isFocusable = true
                view_back.findViewById<ImageButton>(R.id.imageButton5).isFocusable = true
                view_back.findViewById<ImageButton>(R.id.imageButton6).isFocusable = true
                popupWindow.dismiss()
            }

            popupView.findViewById<Button>(R.id.button).isVisible = false
        }
        popupWindow.showAsDropDown(popupView, 0, 0)
    }
}