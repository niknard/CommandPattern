package ru.drankin.dev.commandtemplate.commands

import android.util.Log
import ru.drankin.dev.commandtemplate.Receiver

class SwitchLightOff(private val receiver : Receiver) : Command {
    override fun execute() {
        receiver.setOff()
    }

    override fun toString(): String {
        return "off"
    }
}