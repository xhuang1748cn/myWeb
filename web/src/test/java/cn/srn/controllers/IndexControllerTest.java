package cn.srn.controllers;

import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by SRn on 2016/4/23.
 */
public class IndexControllerTest extends BaseControllerTest {

    @Test
    public void testIndex() throws Exception {
        mockMvc.perform((post("/").param("userId", "1"))).andExpect(status().isOk())
                .andDo(print());
    }
}