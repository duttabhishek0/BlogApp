package com.abhishek.blogapp.screens.home

import com.abhishek.domain.model.Blog

data class HomeState(
    var isLoading:Boolean=false,
    var data:List<Blog>?=null,
    var error:String?=""
)