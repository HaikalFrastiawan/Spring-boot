package Spring.Web.MVC.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HeaderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void headerOk() throws Exception {
        mockMvc.perform(
                get("/header/token").header("X-TOKEN", "Haikal")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("ok"))
        );
    }


    @Test
    void headerko() throws Exception {
        mockMvc.perform(
                get("/header/token").header("X-TOKEN", "Salah")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("ko"))
        );
    }
}