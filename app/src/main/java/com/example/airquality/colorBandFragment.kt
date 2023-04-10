package com.example.airquality

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.airquality.databinding.FragmentColorBandBinding

class ColorBandFragment : Fragment() {

    private var _binding: FragmentColorBandBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentColorBandBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // spécifier les couleurs pour chaque case
        val colors = listOf(
            Color.parseColor("#00FF00"),  // vert
            Color.parseColor("#FFFF00"),  // jaune
            Color.parseColor("#FFA500"),  // orange
            Color.parseColor("#FF4500")   // rouge
        )

        // créer des formes de GradientDrawable pour chaque case avec une couleur solide
        val drawables = colors.map { color ->
            GradientDrawable().apply {
                setColor(color)
            }
        }

        // créer une couche de forme pour combiner les formes
        val layerDrawable = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = 0F
            drawables.forEach { drawable ->
                addLayer(drawable)
            }
        }

        // appliquer la forme à la vue
        binding.colorBandView.background = layerDrawable
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
