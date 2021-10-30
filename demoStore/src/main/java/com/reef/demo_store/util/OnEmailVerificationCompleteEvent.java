package com.reef.demo_store.util;

import com.reef.demo_store.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class OnEmailVerificationCompleteEvent extends ApplicationEvent {
    private User user;
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param user the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public OnEmailVerificationCompleteEvent(User user) {
        super(user);
        this.user = user;
    }
}
