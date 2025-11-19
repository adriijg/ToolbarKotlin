package es.tierno.toolbar

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OptionsActivity : AppCompatActivity() {
    var txtSelect = "Has elegido %s"
    val options = arrayOf("Editar perfil",
        "Cambiar contraseña",
        "Administrar cuenta",
        "Vincular redes sociales",
        "Notificaciones push",
        "Alertas por correo electrónico",
        "Sonidos y vibraciones",
        "Control de privacidad",
        "Bloqueo de aplicaciones o contenido",
        "Autenticación en dos pasos",
        "Idioma",
        "Tema (claro/oscuro/automático)",
        "Tamaño de fuente / accesibilidad",
        "Sincronización y copias de seguridad",
        "Versión de la aplicación / actualizaciones")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_options)

        val toolbar = findViewById<Toolbar>(R.id.toolbarOptions)
        toolbar.setTitle(R.string.opt_menu)

        setSupportActionBar(toolbar)

        // RecyclerView Lógica

        val data = ArrayList<ItemViewModel>()
        for (i in options.indices) {
            val option:String = (options[i])

            data.add(ItemViewModel(option))
        }

        val adapter = DataAdapter(data)

        val recyclerview = findViewById<RecyclerView>(R.id.optionsList)

        recyclerview.layoutManager = LinearLayoutManager(this)

        recyclerview.adapter = adapter

        adapter.setOnClickListener(object :
            DataAdapter.OnClickListener {
            override fun onClick(position: Int, model: ItemViewModel) {
                val msg:String = String.format(txtSelect, model.option)
                Toast.makeText(this@OptionsActivity, msg, Toast.LENGTH_SHORT).show()
            }
        })
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
        Toast.makeText(this@OptionsActivity, "Pronto podrás navegar", Toast.LENGTH_SHORT).show()
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