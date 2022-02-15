package dev.baseio.slackclone.domain.model.localkeyvalue

data class KeyValueRequest<T>(val param: String, val data: T?)
