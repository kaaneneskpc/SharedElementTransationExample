package com.kaaneneskpc.sharedelementtransation.model

data class UnsplashImage(
    val id: Int,
    val photo: String,
    val author: String,
    val location: String
)


val images = listOf(
    UnsplashImage(
        id = 1,
        photo = "https://images.unsplash.com/photo-1579724435699-334f2e01a496?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        author = "Tolga ****",
        location = "Turkey"
    ),
    UnsplashImage(
        id = 2,
        photo = "https://images.unsplash.com/photo-1683663095626-95000d1ea544?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        author = "Turhan *****",
        location = "Germany"
    ),
    UnsplashImage(
        id = 3,
        photo = "https://images.unsplash.com/photo-1599372176030-53774ea659c3?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        author = "Chan ***",
        location = "Italy"
    )


)
