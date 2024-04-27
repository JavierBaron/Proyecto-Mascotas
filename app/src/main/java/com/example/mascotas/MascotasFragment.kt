package com.example.mascotas

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MascotasFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el diseño del fragmento
        val view = inflater.inflate(R.layout.fragment_mascotas, container, false)

        // Encontrar la vista recyclerView dentro del diseño inflado
        recyclerView = view.findViewById(R.id.recyclerView)

        // Crear la lista de imágenes
        val images = listOf(
            Image(R.drawable.chow_chow, "Este es un chow chow"),
            Image(R.drawable.border_collie, "Este es un Border collie")
        )

        // Configurar el RecyclerView y el adaptador
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ImageAdapter(images)

        return view
    }

    class ImageAdapter(private val images: List<Image>) :
        RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

        class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView = itemView.findViewById(R.id.profile_pets)
            val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
            val clickMeTextView: TextView = itemView.findViewById(R.id.clickMe)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.image_item, parent, false)
            return ImageViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
            val image = images[position]
            holder.imageView.setImageResource(image.image)
            holder.descriptionTextView.text = image.description

            holder.descriptionTextView.visibility = View.GONE

            // Cambiar la visibilidad de la descripción al hacer clic en la imagen
            holder.imageView.setOnClickListener {
                holder.descriptionTextView.visibility = if (holder.descriptionTextView.visibility == View.VISIBLE) {
                    View.GONE
                } else {
                    View.VISIBLE
                }
                holder.clickMeTextView.visibility = if (holder.descriptionTextView.visibility == View.VISIBLE) {
                    View.GONE
                } else {
                    View.VISIBLE
                }
            }
        }

        override fun getItemCount(): Int {
            return images.size
        }
    }


}
