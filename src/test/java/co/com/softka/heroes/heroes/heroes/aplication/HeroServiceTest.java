package co.com.softka.heroes.heroes.heroes.aplication;

import co.com.softka.heroes.heroes.heroes.domain.Hero;
import co.com.softka.heroes.heroes.heroes.domain.repository.HeroRepository;
import co.com.softka.heroes.heroes.heroes.heroDTO.HeroDTO;
import co.com.softka.heroes.heroes.heroes.mappers.HeroMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.ArgumentMatchers.any;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class HeroServiceTest {

    @MockBean
    private HeroRepository heroRepository;

    @Autowired
    private HeroService heroService;

    @DisplayName("POST/ Test Crear Heroe ")
    @Test
    public void crearHeroeTest(){

        List<String> skill = new ArrayList<>();
        skill.add("fuerza");
        skill.add("valocidad");

        var heroe = new Hero();
        heroe.setId("xxxx");
        heroe.setName("superman");
        heroe.setRace("kricton");
        heroe.setSkill(skill);
        heroe.setPowerLevel(10000);
        heroe.setImageURL("zzzzzzz");

        var heroDTO = new HeroDTO();
        heroDTO.setId("xxxx");
        heroDTO.setNombre("superman");
        heroDTO.setRaza("kricton");
        heroDTO.setHabilidad(skill);
        heroDTO.setNivelDePoder(10000);
        heroDTO.setUrlImagen("zzzzzzz");

       Mockito.when(heroRepository.save(any())).thenReturn(heroe);
        var respuesta = heroService.crear(heroDTO);

        Assertions.assertEquals("xxxx",respuesta.getId());
        Assertions.assertEquals("superman",respuesta.getNombre());
    }

    @DisplayName("GET/ Test Obtener Heroes")
    @Test
    public void listarHeroesTest(){

        List<String> skill = new ArrayList<>();
        skill.add("fuerza");
        skill.add("valocidad");

        var heroe1 = new Hero();
        heroe1.setId("xxxx");
        heroe1.setName("superman");
        heroe1.setRace("kricton");
        heroe1.setSkill(skill);
        heroe1.setPowerLevel(10000);
        heroe1.setImageURL("zzzzzzz");

        var heroe2 = new Hero();
        heroe2.setId("ffff");
        heroe2.setName("flash");
        heroe2.setRace("humano");
        heroe2.setSkill(skill);
        heroe2.setPowerLevel(5000);
        heroe2.setImageURL("wwwww");

        var lista = new ArrayList<Hero>();
        lista.add(heroe1);
        lista.add(heroe2);

        Mockito.when(heroRepository.findAll()).thenReturn(lista);

        var respuesta = heroService.obternerTodos();

        Assertions.assertEquals(2,respuesta.size());
        Assertions.assertEquals(heroe1.getId(),respuesta.get(0).getId());
        Assertions.assertEquals(heroe2.getName(),respuesta.get(1).getNombre());
    }

}