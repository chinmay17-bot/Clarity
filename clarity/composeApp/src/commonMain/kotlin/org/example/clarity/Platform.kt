package org.example.clarity

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform