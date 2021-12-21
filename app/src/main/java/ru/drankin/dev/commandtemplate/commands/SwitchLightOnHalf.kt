package ru.drankin.dev.commandtemplate.commands

import android.util.Log
import ru.drankin.dev.commandtemplate.Receiver

class SwitchLightOnHalf(private val receiver : Receiver) : Command {
    override fun execute() {
        receiver.setOnHalf()
    }

    override fun toString(): String {
        return "half"
    }
}