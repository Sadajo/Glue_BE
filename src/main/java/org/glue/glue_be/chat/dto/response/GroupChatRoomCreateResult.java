package org.glue.glue_be.chat.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record GroupChatRoomCreateResult(
        GroupChatRoomDetailResponse chatroom,
        ActionResponse status,
        ActionResponse joinLeaveMessage
) {}