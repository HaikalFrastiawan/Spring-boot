package Spring.Web.MVC;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMVC;

    @Test
    void helloGuest() throws Exception {
        mockMVC.perform(
                get("/hello")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Guest"))
        );
    }

    @Test
    void helloName() throws Exception {
        mockMVC.perform(
                get("/hello").param("name", "Haikal")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Haikal"))
        );
    }

    @Test
    void helloPost() throws Exception {
        mockMVC.perform(
                post("/hello").queryParam("name", "Haikal")
        ).andExpectAll(
                status().isMethodNotAllowed()
        );
    }

    void helloView() throws Exception {
        mockMVC.perform(
                get("/web/hello").queryParam("name", "Haikal")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Belajar view")),
                content().string(Matchers.containsString("Hello Haikal"))
        );
    }

    void helloViewRedirect() throws Exception {
        mockMVC.perform(
                get("/web/hello")
        ).andExpectAll(
                status().is3xxRedirection()
        );
    }
}