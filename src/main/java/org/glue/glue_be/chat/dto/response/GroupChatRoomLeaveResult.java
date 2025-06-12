package org.glue.glue_be.chat.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GroupChatRoomLeaveResult(
        List<ActionResponse> status,
        ActionResponse leaveMessage
) {}