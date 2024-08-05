package com.spinner.cryptocurrencies.presentation.common

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.request.CachePolicy
import coil.request.ImageRequest

@Composable
fun AsyncCachedImage(url: String) {
    val context = LocalContext.current

    val request = ImageRequest.Builder(context)
        .data(url)
        .crossfade(true)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .diskCachePolicy(CachePolicy.ENABLED)
        .build()

    val imageLoader = ImageLoader.Builder(context)
        .memoryCache {
            MemoryCache.Builder(context)
                .maxSizePercent(0.25)
                .build()
        }
        .diskCache {
            DiskCache.Builder()
                .directory(context.cacheDir.resolve("image_cache"))
                .maxSizePercent(0.02)
                .build()
        }
        .respectCacheHeaders(false)
        .build()

    AsyncImage(
        modifier = Modifier.size(128.dp),
        model = request,
        imageLoader = imageLoader,
        contentDescription = "img_coin",
    )
}