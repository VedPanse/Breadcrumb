package org.breadcrumb

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform