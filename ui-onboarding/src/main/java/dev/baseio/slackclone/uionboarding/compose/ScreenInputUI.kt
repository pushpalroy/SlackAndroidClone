package dev.baseio.slackclone.uionboarding

import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import dev.baseio.slackclone.navigator.ComposeNavigator
import dev.baseio.slackclone.navigator.FragmentNavGraphNavigator
import dev.baseio.slackclone.uionboarding.compose.CommonInputUI
import dev.baseio.slackclone.uionboarding.compose.WorkspaceInputView

@Composable
fun EmailAddressInputUI(
  composeNavigator: ComposeNavigator,
  fragmentNavigator: FragmentNavGraphNavigator
) {
  CommonInputUI(
    composeNavigator = composeNavigator,
    fragmentNavigator = fragmentNavigator,
    { modifier ->
      EmailInputView(modifier)
    }, stringResource(id = R.string.subtitle_this_email_slack)
  )
}

@Composable
fun WorkspaceInputUI(
  composeNavigator: ComposeNavigator,
  fragmentNavigator: FragmentNavGraphNavigator
) {
  CommonInputUI(
    composeNavigator = composeNavigator,
    fragmentNavigator = fragmentNavigator,
    {
      WorkspaceInputView(it)
    },
    stringResource(id = R.string.subtitle_this_address_slack)
  )
}

