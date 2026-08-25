package Spring.Web.MVC.controller;

import Spring.Web.MVC.model.CreatePersonRequest;
import Spring.Web.MVC.model.CreateSocialMediaRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPerson() throws Exception {
        CreatePersonRequest request = new CreatePersonRequest();
        request.setFirstName("haikal");
        request.setMiddlleName("fras");
        request.setLastName("tiawan");
        request.setEmail("haikal@example.com");
        request.setPhone("123456789");
        request.setHobbies(List.of("Coding", "Gaming", "Reading"));
        request.setSocialMedias(new ArrayList<>());
        request.getSocialMedias().add(new CreateSocialMediaRequest("Facebook", "facebook.com"));
        request.getSocialMedias().add(new CreateSocialMediaRequest("Instagram", "instagram.com"));

        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andExpectAll(
                status().isOk(),
                content().json(jsonRequest)
        );
    }

    @Test
    void createPersonValidationError() throws Exception {
        CreatePersonRequest request = new CreatePersonRequest();
        request.setMiddlleName("fras");
        request.setLastName("tiawan");
        request.setPhone("123456789");
        request.setHobbies(List.of("Coding", "Gaming", "Reading"));
        request.setSocialMedias(new ArrayList<>());
        request.getSocialMedias().add(new CreateSocialMediaRequest("Facebook", "facebook.com"));
        request.getSocialMedias().add(new CreateSocialMediaRequest("Instagram", "instagram.com"));

        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonRequest)
        ).andExpectAll(
                status().isBadRequest()
        );
    }
}