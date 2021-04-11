package com.example.androidseminar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidseminar.databinding.FragmentFollowingListBinding


class FollowingListFragment : Fragment() {

    private var _binding : FragmentFollowingListBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기 위해 binding이 초기화 되지 않았습니다. ")

    private lateinit var followingListAdapter: FollowingListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFollowingListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        followingListAdapter = FollowingListAdapter()

        binding.rvUserList.adapter = followingListAdapter

        followingListAdapter.userList.addAll(
                listOf<FollowingUserInfo>(
                        FollowingUserInfo(
                                userImage = "지금은 빈칸! 4회차",
                                userName = "a1"
                        ),
                        FollowingUserInfo(
                                userImage = "지금은 빈칸! 4회차",
                                userName = "b2"
                        ),
                        FollowingUserInfo(
                                userImage = "지금은 빈칸! 4회차",
                                userName = "c3"
                        ),
                        FollowingUserInfo(
                                userImage = "지금은 빈칸! 4회차",
                                userName = "d4"
                        )
                )
        )

        followingListAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}