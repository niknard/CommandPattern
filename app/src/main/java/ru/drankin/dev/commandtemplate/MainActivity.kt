package ru.drankin.dev.commandtemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import ru.drankin.dev.commandtemplate.commands.Command
import ru.drankin.dev.commandtemplate.commands.SwitchLightOff
import ru.drankin.dev.commandtemplate.commands.SwitchLightOn
import ru.drankin.dev.commandtemplate.commands.SwitchLightOnHalf

//invoker
class MainActivity : AppCompatActivity() {
    private val commands = HashMap<String, Command>()
    private val history = mutableListOf<Command>()

    fun execute(command: String){
        val execCommand = commands[command]
        if (execCommand!=null){
            history.add(execCommand)
            execCommand.execute()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonOn = findViewById<Button>(R.id.buttonOn)
        val buttonOff = findViewById<Button>(R.id.buttonOff)
        val buttonHalf = findViewById<Button>(R.id.buttonHalf)
        val spinner = findViewById<Spinner>(R.id.spinner1)
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, history)

        buttonOn.setOnClickListener {
            execute("on")
        }
        buttonOff.setOnClickListener {
            execute("off")
        }
        buttonHalf.setOnClickListener {
            execute("half")
        }

        val light = findViewById<TextView>( R.id.textView )
        val receiver = Receiver(light)
        val commandSwitchOn = SwitchLightOn(receiver)
        val commandSwitchOff = SwitchLightOff(receiver)
        val commandSwitchOnHalf = SwitchLightOnHalf(receiver)

        commands.put("on", commandSwitchOn)
        commands.put("off", commandSwitchOff)
        commands.put("half", commandSwitchOnHalf)

        execute("off")
    }
}
