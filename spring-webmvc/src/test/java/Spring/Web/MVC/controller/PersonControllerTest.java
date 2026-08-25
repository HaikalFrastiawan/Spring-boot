package Spring.Web.MVC.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPerson() throws Exception{
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("firstName" , "haikal")
                        .param("middlleName", "fras")
                        .param("lastName", "tiawan")
                        .param("email", "haikal@example.com")
                        .param("phone", "123456789")
                        .param("address.street", "jalan belum jadi")
                        .param("address.city", "jakarta")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "12345")
                        .param("hobbies[0]", "Coding")
                        .param("hobbies[1]", "Reading")
                        .param("hobbies[2]", "Gaming")
                        .param("socialMedias[0].name", "Facebook")
                        .param("socialMedias[0].location", "facebook.com")
                        .param("socialMedias[1].name", "Instagram")
                        .param("socialMedias[1].location", "Instagram.com")

        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success create Person haikal fras tiawan " +
                        "with email haikal@example.com and phone 123456789 " +
                        "with address jalan belum jadi, jakarta, Indonesia, 12345"
                        ))
        );

    }
}