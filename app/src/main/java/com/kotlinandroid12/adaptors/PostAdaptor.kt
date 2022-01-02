package com.kotlinandroid12.adaptors

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlinandroid12.R
import com.kotlinandroid12.data_layer.network.model.jsonholder.PostResponseData


class PostAdaptor :
    RecyclerView.Adapter<PostAdaptor.PostViewHolder>() {

    private lateinit var postList: List<PostResponseData>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(
                parent.context
            )
                .inflate(
                    R.layout.post_item_view,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(
        holder: PostViewHolder,
        position: Int
    ) {

        // holder.tv_post_id.setText()

    }

    override fun getItemCount(): Int {
        if (postList.isEmpty())
            return 0
        return postList.size
    }

    class PostViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(
        itemView
    ) {
        var tv_post_id: TextureView =
            itemView.findViewById(
                R.id.tv_post_id
            )
        var tv_title: TextureView =
            itemView.findViewById(
                R.id.tv_title
            )
        var tv_body: TextureView =
            itemView.findViewById(
                R.id.tv_body
            )


    }
}