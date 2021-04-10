package com.example.toguz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class MenuFrag : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_lay, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_to_instruct).setOnClickListener {
            findNavController().navigate(R.id.action_menuFrag_to_instructFrag)
        }
        view.findViewById<Button>(R.id.button__to_pvc).setOnClickListener {
            findNavController().navigate(R.id.action_menuFrag_to_pvcFrag)
        }
        view.findViewById<Button>(R.id.button_to_pvp).setOnClickListener {
            findNavController().navigate(R.id.action_menuFrag_to_pvpFrag)
        }
        view.findViewById<Button>(R.id.button_to_stat).setOnClickListener {
            findNavController().navigate(R.id.action_menuFrag_to_statFrag)
        }
    }
}