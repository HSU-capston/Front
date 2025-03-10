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
        childFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, StorageFragment())
            .commit()

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

    private fun setSelectedTab(selectedButton: Button) {
        binding.tabStorage.isSelected = false
        binding.tabFriends.isSelected = false
        binding.tabSettings.isSelected = false
        selectedButton.isSelected = true
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
