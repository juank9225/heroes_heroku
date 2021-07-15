package co.com.softka.heroes.heroes.heroes.infrastructure;

import co.com.softka.heroes.heroes.heroes.aplication.HeroService;
import co.com.softka.heroes.heroes.heroes.heroDTO.HeroDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class HeroControllerTest {

    @MockBean
    private HeroService heroService;

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Test Obtener Heroes")
    @Test
    public void getHeroes() throws Exception{
        //Arrange
        List<String> skill = new ArrayList<>();
        skill.add("fuerza");
        skill.add("valocidad");

        var heroDTO1 = new HeroDTO();
        heroDTO1.setId("xxxx");
        heroDTO1.setNombre("superman");
        heroDTO1.setRaza("kricton");
        heroDTO1.setHabilidad(skill);
        heroDTO1.setNivelDePoder(10000);
        heroDTO1.setUrlImagen("zzzzzzz");

        var heroDTO2 = new HeroDTO();
        heroDTO2.setId("yyyy");
        heroDTO2.setNombre("flash");
        heroDTO2.setRaza("humano");
        heroDTO2.setHabilidad(skill);
        heroDTO2.setNivelDePoder(10000);
        heroDTO2.setUrlImagen("mmmmm");


        doReturn(Lists.newArrayList(heroDTO1,heroDTO2)).when(heroService).obternerTodos(); //creamos el mock

        //Act && Assert
        mockMvc.perform(get("/heroes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is("xxxx")))
                .andExpect(jsonPath("$[0].nombre", is("superman")))
                .andExpect(jsonPath("$[1].id", is("yyyy")))
                .andExpect(jsonPath("$[1].nombre", is("flash")));

    }

    @DisplayName("Test Crear Heroes")
    @Test
    public void postHeroes() throws Exception{
        //Arrange
        List<String> skill = new ArrayList<>();
        skill.add("fuerza");
        skill.add("valocidad");

        var heroDTO = new HeroDTO();
        heroDTO.setId("xxxx");
        heroDTO.setNombre("superman");
        heroDTO.setRaza("kricton");
        heroDTO.setHabilidad(skill);
        heroDTO.setNivelDePoder(10000);
        heroDTO.setUrlImagen("zzzzzzz");

        doReturn(heroDTO).when(heroService).crear(any());

        //Act && Assert
        mockMvc.perform(post("/heroes/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(heroDTO)))

                // Validate the response code and content type
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate the returned fields
                .andExpect(jsonPath("$.nombre", is("superman")))
                .andExpect(jsonPath("$.raza", is("kricton")))
                .andExpect(jsonPath("$.id", is("xxxx")));
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}