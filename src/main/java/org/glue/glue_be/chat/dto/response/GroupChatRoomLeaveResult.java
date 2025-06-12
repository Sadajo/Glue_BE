package org.glue.glue_be.chat.dto.response;

import java.util.List;

public record GroupChatRoomLeaveResult(
        List<ActionResponse> status,
        ActionResponse leaveMessage
) {}