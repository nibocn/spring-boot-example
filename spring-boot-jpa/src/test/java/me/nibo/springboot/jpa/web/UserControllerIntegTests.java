package me.nibo.springboot.jpa.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * UserControllerITTests
 *
 * @author NiBo
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void findUserRolesTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/users/roles")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
        resultActions.andReturn().getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
        resultActions.andDo(print());
    }
}
