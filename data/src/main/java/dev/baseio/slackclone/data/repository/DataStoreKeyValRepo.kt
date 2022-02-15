package dev.baseio.slackclone.data.repository

import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import dev.baseio.slackclone.domain.model.localkeyvalue.KeyValueRequest
import dev.baseio.slackclone.domain.repository.LocalKeyValRepository

class DataStoreKeyValRepo : LocalKeyValRepository {

  val dataStoreManager = remember { DataStoreManager(dataStore) }

  override fun <T> get(key: String): T {

  }

  override fun <T> put(keyValueRequest: KeyValueRequest<T>): Boolean {
  }
}