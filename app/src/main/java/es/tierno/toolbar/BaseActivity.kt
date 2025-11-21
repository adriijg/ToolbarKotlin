package es.tierno.toolbar

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    open fun navegar() {
        Toast.makeText(this@BaseActivity,"Pronto podrás navegar", Toast.LENGTH_SHORT).show()
    }

    open fun opciones() {
        val intent = Intent(this, OptionsActivity::class.java)
        startActivity(intent)
    }

    open fun salir() {
        if (this !is MainActivity) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}