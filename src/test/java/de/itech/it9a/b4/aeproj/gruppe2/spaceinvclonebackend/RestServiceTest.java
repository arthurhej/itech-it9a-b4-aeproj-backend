package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.api.RestService;

@WebMvcTest(RestService.class)
public class RestServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestService restService;

}
