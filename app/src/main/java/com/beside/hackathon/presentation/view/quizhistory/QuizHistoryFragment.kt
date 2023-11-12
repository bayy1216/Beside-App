package com.beside.hackathon.presentation.view.quizhistory

import com.beside.hackathon.databinding.FragmentQuizHistoryBinding


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuizHistoryFragment : Fragment() {
    private var _binding: FragmentQuizHistoryBinding? = null
    private lateinit var navController: NavController
    private val binding get() = _binding!!

    private val quizHistoryViewModel: QuizHistoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // navController 초기화
        navController = findNavController()
        _binding = FragmentQuizHistoryBinding.inflate(inflater, container, false)
        val root = binding.root
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    QuizHistoryScreen(navController, quizHistoryViewModel)
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