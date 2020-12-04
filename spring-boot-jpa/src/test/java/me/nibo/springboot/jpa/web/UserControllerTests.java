package me.nibo.springboot.jpa.web;

import me.nibo.springboot.jpa.dto.UserQueryParamDto;
import me.nibo.springboot.jpa.dto.UserRoleDto;
import me.nibo.springboot.jpa.service.UserService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * UserControllerTests
 *
 * @author NiBo
 */
@WebMvcTest(controllers = UserController.class)
public class UserControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @Test
    void findUserRoleTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/users/roles")
                .contentType(MediaType.APPLICATION_JSON)
                .param("username", "小明")
                .param("age", "20")
                )
            .andExpect(status().isOk())
            .andReturn();

        mvcResult.getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
        String result = mvcResult.getResponse().getContentAsString();

        List<UserRoleDto> list = objectMapper.readValue(result,
                new TypeReference<List<UserRoleDto>>(){});
        assertNotNull(list);
        assertEquals(1, list.size());
        assertEquals("dwsdfsdf12222312", list.get(0).getUserId());
        assertEquals("张三", list.get(0).getUsername());
        assertEquals(25, list.get(0).getAge());

        ArgumentCaptor<UserQueryParamDto> userQueryCaptor =
            ArgumentCaptor.forClass(UserQueryParamDto.class);
        verify(userService, times(1)).findUserRoleList(userQueryCaptor.capture());
        assertEquals("小明", userQueryCaptor.getValue().getUsername());
        assertEquals(20, userQueryCaptor.getValue().getAge());
    }

}
