package dev.baseio.slackclone.domain.usecases

import dev.baseio.slackclone.domain.model.localkeyvalue.KeyValueRequest
import dev.baseio.slackclone.domain.repository.LocalKeyValRepository

class UseCaseFetchKeyValData(private val localKeyValRepository: LocalKeyValRepository) :
  BaseUseCase<Any, String> {

  override suspend fun perform(params: String): Any {
    return localKeyValRepository.get(params)
  }
}


class UseCaseSaveKeyValData(private val localKeyValRepository: LocalKeyValRepository) :
  BaseUseCase<Boolean, KeyValueRequest<Any?>> {

  override suspend fun perform(params: KeyValueRequest<Any?>): Boolean {
    return localKeyValRepository.put(params)
  }
}