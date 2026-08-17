    package Haikal.spring.core;

    import Haikal.spring.core.Listener.LoginAgainSuccessListener;
    import Haikal.spring.core.Listener.LoginSuccessListener;
    import Haikal.spring.core.service.UserService;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import org.springframework.context.ConfigurableApplicationContext;
    import org.springframework.context.annotation.AnnotationConfigApplicationContext;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.Import;

    public class EventListenerTest  {
        @Configuration
        @Import({
                UserService.class,
                LoginSuccessListener.class,
                LoginAgainSuccessListener.class
        })
        public static class TestConfiguration{

        }

        private ConfigurableApplicationContext applicationContext;

        @BeforeEach
        void setUp() {
            applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
            applicationContext.registerShutdownHook();
        }

        @Test
        void testEventListener() {
            UserService userService =  applicationContext.getBean(UserService.class);
            userService.login("Haikal","Haikal");
            userService.login("Haikal","salah");
            userService.login("salah","Haikal");
        }
    }
