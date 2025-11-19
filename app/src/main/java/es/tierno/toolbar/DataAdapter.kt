package es.tierno.toolbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.tierno.toolbar.ItemViewModel

class DataAdapter (private val mList: List<ItemViewModel>) : RecyclerView.Adapter<DataAdapter.ViewHolder>()  {

    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemViewModel = mList[position]

        // Cargamos la imagen y descripción de una posición
        holder.txtOption.text = itemViewModel.option

        // Seteamos el evento para el elemento
        holder.itemView.setOnClickListener {
            onClickListener?.onClick(position, itemViewModel)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    // Interfaz para el click listener
    interface OnClickListener {
        fun onClick(position: Int, model: ItemViewModel)
    }


    // Set para el atributo
    fun setOnClickListener(listener: OnClickListener?) {
        this.onClickListener = listener
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val txtOption: TextView = itemView.findViewById(R.id.txtOption)
    }
}