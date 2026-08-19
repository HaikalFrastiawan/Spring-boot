package Haikal.spring.core.Listener;

import Haikal.spring.core.Event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserListener {
    @EventListener(classes = LoginSuccessEvent.class)
    public void OnLoginSuccessEvent(LoginSuccessEvent event){
        log.info("Success Login event listner For user {}", event.getUser());

    }
}
