package Haikal.spring.core.service;

import Haikal.spring.core.Event.LoginSuccessEvent;
import Haikal.spring.core.data.User;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware; // Interface yang benar
import org.springframework.stereotype.Component;

@Component
public class UserService implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher; // Mengisi publisher dari parameter Spring
    }

    public boolean login(String username, String password) {
        if (isLoginSuccess(username, password)) {
            applicationEventPublisher.publishEvent(new LoginSuccessEvent(new User(username)));
            return true;
        } else {
            return false;
        }
    }

    private boolean isLoginSuccess(String username, String password) {
        return "Haikal".equals(username) && "Haikal".equals(password);
    }
}