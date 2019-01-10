package br.com.caelum.middleware.fj22.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by matheusbrandino on 6/9/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class OmdbControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void deveRepassarRequisicao() throws Exception {

        mvc.perform(get("/movie").param("title", "Rogue+One"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Title", is("Rogue One: A Star Wars Story")))
                .andExpect(jsonPath("$.Year", is("2016")))
                .andExpect(jsonPath("$.Genre", containsString("Sci-Fi")));
    }
}
