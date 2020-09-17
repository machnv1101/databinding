package com.machnv.databinding.viewModel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.machnv.databinding.data.User
import com.machnv.databinding.databinding.ItemUserBinding

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var itemUserClickListener: ItemUserClickListener? = null

    inner class UserViewHolder(private val userItemUserBinding: ItemUserBinding) : RecyclerView.ViewHolder(userItemUserBinding.root) {
        fun onBind(position: Int){
            userItemUserBinding.user = userList[position]
            userItemUserBinding.llItemUser.setOnClickListener {
                this@UserAdapter.itemUserClickListener?.onItemUserClick(position)
            }
        }
    }

    var userList: List<User> = listOf()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val userItemBinding = ItemUserBinding.inflate(inflater, parent, false)
        return UserViewHolder(userItemBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = userList.size

    interface ItemUserClickListener{
        fun onItemUserClick(position: Int)
    }

    fun setItemUserClickListener(itemUserClickListener: ItemUserClickListener) {
        this.itemUserClickListener = itemUserClickListener
    }
}