package com.example.airquality

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.airquality.databinding.FragmentSecondBinding
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class SecondFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        myView.background = layerDrawable
    }
}
/*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.airquality.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
 */