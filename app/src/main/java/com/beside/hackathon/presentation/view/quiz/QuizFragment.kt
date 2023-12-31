package com.beside.hackathon.presentation.view.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.beside.hackathon.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {
    private var _binding: FragmentQuizBinding? = null
    private lateinit var navController: NavController
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // navController 초기화
        navController = findNavController()
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        val root = binding.root
        //navController.popBackStack()
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    QuizScreen(navController)
                }
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}