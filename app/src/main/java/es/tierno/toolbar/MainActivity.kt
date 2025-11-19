package es.tierno.toolbar

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitle(R.string.app_name)

        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.menu_nav){
            navegar()
        } else if (item.itemId == R.id.menu_opt){
            opciones()
        } else if (item.itemId == R.id.menu_exit){
            salir()
        }

        return super.onOptionsItemSelected(item)
    }

    fun navegar() {
        Toast.makeText(this@MainActivity, "Pronto podrás navegar", Toast.LENGTH_SHORT).show()
    }

    fun opciones() {
        val intent = Intent(this, OptionsActivity::class.java)
        startActivity(intent)
    }

    fun salir() {
        if (this !is MainActivity) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}