package dev.baseio.slackclone.domain.repository

import dev.baseio.slackclone.domain.model.localkeyvalue.KeyValueRequest

interface LocalKeyValRepository {
  fun <T> get(key: String): T
  fun <T> put(keyValueRequest: KeyValueRequest<T>) : Boolean
}