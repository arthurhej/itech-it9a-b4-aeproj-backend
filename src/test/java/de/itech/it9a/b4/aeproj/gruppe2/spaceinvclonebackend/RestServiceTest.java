package de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend;

import com.mongodb.client.MongoClient;
import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.api.RestService;
import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.config.TestConfig;
import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.controller.ScoreController;
import de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.model.Score;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@Import(RestService.class)
//@ExtendWith(SpringExtension.class)
//@ComponentScan(basePackages = "de.itech.it9a.b4.aeproj.gruppe2.spaceinvclonebackend.api")
//@SpringBootTest(classes = TestConfig.class)
//@AutoConfigureMockMvc
@ActiveProfiles({"test"})
@WebMvcTest(RestService.class)
//@TestPropertySource("spring.profiles.active=test")
public class RestServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScoreController scoreController;

    @Test
    public void testFindAllScore() throws Exception {
        List<Score> scoreList = Arrays.asList(new Score("Test1", 1L), new Score("Test2", 2L), new Score("Test3", 3L), new Score("Test4", 4L),
                new Score("Test5", 5L));

        Mockito.when(scoreController.findAll()).thenReturn(scoreList);
        this.mockMvc.perform(get("/api/scores")).andExpect(status().isOk());
    }
}
