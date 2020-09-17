package com.machnv.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.machnv.databinding.data.User
import com.machnv.databinding.databinding.ActivityMainBinding
import com.machnv.databinding.viewModel.MainViewModel
import com.machnv.databinding.viewModel.UserAdapter

class MainActivity : AppCompatActivity(), UserAdapter.ItemUserClickListener {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private val userAdapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        userAdapter.userList = createUser()
        binding.rvListUser.setHasFixedSize(true)
        binding.rvListUser.layoutManager = LinearLayoutManager(this)
        binding.rvListUser.adapter = userAdapter

        userAdapter.setItemUserClickListener(this)

    }

    private fun createUser(): MutableList<User> {
        val user = mutableListOf<User>()

        for (i in 1..15) {
            user.add(User("John $i", i + 20))
        }
        user.shuffle()
        return user
    }

    override fun onItemUserClick(position: Int) {
        Toast.makeText(this, "onItemUserClick $position", Toast.LENGTH_SHORT).show()
    }
}