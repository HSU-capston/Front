package com.example.capston_spotyup.Profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.capston_spotyup.databinding.FragmentMypageBinding
import com.example.capston_spotyup.R

class ProfileFragment : Fragment() {

    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMypageBinding.inflate(inflater, container, false)

        // 기본 Fragment 설정 (보관함)
        replaceFragment(StorageFragment())
        setSelectedTab(binding.tabStorage) // 초기 버튼 상태 설정

        // 탭 버튼 클릭 이벤트
        binding.tabStorage.setOnClickListener {
            replaceFragment(StorageFragment())
            setSelectedTab(binding.tabStorage)
        }

        binding.tabFriends.setOnClickListener {
            replaceFragment(FriendsFragment())
            setSelectedTab(binding.tabFriends)
        }

        binding.tabSettings.setOnClickListener {
            replaceFragment(SettingsFragment())
            setSelectedTab(binding.tabSettings)
        }

        return binding.root
    }

    // 현재 선택된 버튼만 회색, 나머지는 하얀색으로 변경
    private fun setSelectedTab(selectedButton: Button) {
        // 모든 버튼의 선택 해제
        binding.tabStorage.isSelected = false
        binding.tabFriends.isSelected = false
        binding.tabSettings.isSelected = false

        // 선택한 버튼만 활성화
        selectedButton.isSelected = true

        // 강제 UI 갱신
        binding.tabStorage.invalidate()
        binding.tabFriends.invalidate()
        binding.tabSettings.invalidate()
    }


    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
