package ru.drankin.dev.commandtemplate.commands

import android.util.Log
import ru.drankin.dev.commandtemplate.Receiver

class SwitchLightOn(private val receiver : Receiver) : Command {
    override fun execute() {
        receiver.setOn()
    }

    override fun toString(): String {
        return "on"
    }
}