package com.example.mascotas

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MascotasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mascotas, container, false)

        // Lista de identificadores de recursos de imágenes
        val imageList = mutableListOf<Int>()
        imageList.add(R.drawable.mascotas)
        imageList.add(R.drawable.ic_launcher_background)
        imageList.add(R.drawable.cats)
        // Agrega más imágenes según sea necesario

        // RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ImageAdapter(requireContext(), imageList)

        return view
    }

    class ImageAdapter(private val context: Context, private val imageList: List<Int>) :
        RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_image, parent, false)
            return ImageViewHolder(view)
        }

        override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
            val imageResource = imageList[position]
            holder.imageView.setImageResource(imageResource)
            holder.itemView.setOnClickListener {
                // Aquí puedes implementar la lógica para mostrar la imagen en pantalla completa
                // cuando se hace clic en un elemento de la lista
            }
        }

        override fun getItemCount(): Int {
            return imageList.size
        }

        inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView = itemView.findViewById(R.id.imageView)
        }
    }
}