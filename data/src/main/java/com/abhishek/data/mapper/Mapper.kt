package com.abhishek.data.mapper

import com.abhishek.data.network.model.BlogDTO
import com.abhishek.data.network.model.OwnerDTO
import com.abhishek.domain.model.Blog
import com.abhishek.domain.model.Owner

fun List<BlogDTO>.toDomain():List<Blog>{

    return map{
        Blog(
            id = it.id?:"",
            image = it.image?:"",
            likes = it.likes?:0,
            owner = it.owner?.toDomain()?:Owner("","","","",""),
            publishDate = it.publishDate?:"",
            tags =  it.tags?: emptyList(),
            text = it.text?:""
        )
    }

}


fun OwnerDTO.toDomain() : Owner {
    return Owner(
        firstName = firstName ?: "",
        id = id ?: "",
        lastName = lastName ?: "",
        picture = picture ?: "",
        title = title ?: ""
    )
}