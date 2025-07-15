package org.glue.glue_be.chat.entity.group;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.glue.glue_be.common.BaseEntity;
import org.glue.glue_be.meeting.entity.Meeting;
import org.glue.glue_be.user.entity.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "group_message")
@Getter
@NoArgsConstructor
public class GroupMessage extends BaseEntity {

    public static final int UNREAD_COUNT_DEFAULT = 1;

    public static final int TEXT = 1;
    public static final int JOIN = 2;
    public static final int LEAVE = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupMessageId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_chatroom_id")
    private GroupChatRoom groupChatroom;

    @ManyToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @Column(name = "message_content")
    private String message;

    @Column(name = "message_type", nullable = false)
    private Integer messageType = TEXT;

    // Constructor with required fields
    public GroupMessage(User user, GroupChatRoom groupChatroom, Meeting meeting, String message, Integer messageType) {
        this.user = user;
        this.groupChatroom = groupChatroom;
        this.meeting = meeting;
        this.message = message;
        this.messageType = messageType;
    }

}