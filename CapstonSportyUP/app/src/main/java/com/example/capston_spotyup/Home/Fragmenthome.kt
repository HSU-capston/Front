package com.example.sportyup

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.capston_spotyup.R
import com.example.capston_spotyup.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private val handler = Handler(Looper.getMainLooper())

    private val autoScrollRunnable = object : Runnable {
        override fun run() {
            val viewPager = binding.viewpager
            val nextItem = (viewPager.currentItem + 1) % 4 // 4개의 페이지 사용
            viewPager.setCurrentItem(nextItem, true)
            handler.postDelayed(this, 3000) // 3초마다 변경
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ViewPager2 어댑터 설정 (4개의 개별 XML 사용)
        val layoutList = listOf(
            R.layout.viewpager1,
            R.layout.viewpager2,
            R.layout.viewpager3,
            R.layout.viewpager4
        )

        viewPagerAdapter = ViewPagerAdapter(layoutList)
        binding.viewpager.adapter = viewPagerAdapter
        binding.viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // Indicator 연결
        binding.indicator.setViewPager(binding.viewpager)

        // 자동 슬라이드 시작
        handler.postDelayed(autoScrollRunnable, 3000)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(autoScrollRunnable)
        _binding = null
    }
}
