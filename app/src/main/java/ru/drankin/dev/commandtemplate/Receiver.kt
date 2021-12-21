package ru.drankin.dev.commandtemplate

import android.widget.TextView

class Receiver(val textView : TextView) {
    fun setOn(){
        textView.setText("Light is On")
    }

    fun setOff(){
        textView.setText("Light is Off")
    }

    fun setOnHalf(){
        textView.setText("Light is 50%")
    }
}