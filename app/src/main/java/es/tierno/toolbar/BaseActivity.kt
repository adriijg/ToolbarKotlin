package es.tierno.toolbar

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    open fun navegar() {
        Toast.makeText(this@BaseActivity,"Pronto podrás navegar", Toast.LENGTH_SHORT).show()
    }
}