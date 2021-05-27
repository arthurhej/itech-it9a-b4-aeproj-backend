package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend;

import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.api.RestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RestService.class)
public class RestServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestService restService;

}
