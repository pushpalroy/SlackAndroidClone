package dev.baseio.slackclone.chatcore.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.baseio.slackclone.chatcore.data.UiLayerChannels
import dev.baseio.slackclone.commonui.reusable.SlackListItem
import dev.baseio.slackclone.commonui.reusable.SlackOnlineBox
import dev.baseio.slackclone.commonui.theme.SlackCloneColorProvider
import dev.baseio.slackclone.commonui.theme.SlackCloneTypography

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SlackChannelItem(
  slackChannel: UiLayerChannels.SlackChannel,
  textColor:Color = SlackCloneColorProvider.colors.textPrimary,
  onItemClick: (UiLayerChannels.SlackChannel) -> Unit
) {
  when (slackChannel.isOneToOne) {
    true -> {
      DirectMessageChannel(onItemClick, slackChannel, textColor)
    }
    else -> {
      GroupChannelItem(slackChannel, onItemClick)
    }
  }
}

@Composable
private fun GroupChannelItem(
  slackChannel: UiLayerChannels.SlackChannel,
  onItemClick: (UiLayerChannels.SlackChannel) -> Unit
) {
  SlackListItem(
    icon = if (slackChannel.isPrivate == true) Icons.Default.Lock else Icons.Default.MailOutline,
    title = "${slackChannel.name}",
    onItemClick = {
      onItemClick(slackChannel)
    }
  )
}

@Composable
private fun DirectMessageChannel(
  onItemClick: (UiLayerChannels.SlackChannel) -> Unit,
  slackChannel: UiLayerChannels.SlackChannel,
  textColor: Color
) {
  Row(
    modifier = Modifier
      .padding(8.dp)
      .fillMaxWidth()
      .clickable {
        onItemClick(slackChannel)
      }, verticalAlignment = Alignment.CenterVertically
  ) {
    SlackOnlineBox(imageUrl = slackChannel.pictureUrl ?: "")
    ChannelText(slackChannel, textColor)
  }
}

@Composable
private fun ChannelText(
  slackChannel: UiLayerChannels.SlackChannel,
  textColor: Color
) {
  Text(
    text = "${slackChannel.name}",
    style = SlackCloneTypography.subtitle1.copy(
      color = textColor.copy(
        alpha = 0.8f
      )
    ), modifier = Modifier
      .padding(8.dp)
  )
}