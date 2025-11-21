package es.tierno.toolbar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OptionsActivity : BaseActivity() {
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
        for (i in options.indices) {4444444444
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
}