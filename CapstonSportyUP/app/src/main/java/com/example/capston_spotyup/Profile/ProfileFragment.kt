import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.capston_spotyup.databinding.FragmentMypageBinding

import com.example.capston_spotyup.Profile.SettingsFragment
import com.example.capston_spotyup.Profile.FriendsFragment
import com.example.capston_spotyup.Profile.StorageFragment
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
        }

        binding.tabFriends.setOnClickListener {
            replaceFragment(FriendsFragment())
        }

        binding.tabSettings.setOnClickListener {
            replaceFragment(SettingsFragment())
        }

        return binding.root
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
