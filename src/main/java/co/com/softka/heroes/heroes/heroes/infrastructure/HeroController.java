package co.com.softka.heroes.heroes.heroes.infrastructure;

import co.com.softka.heroes.heroes.heroes.aplication.HeroService;
import co.com.softka.heroes.heroes.heroes.heroDTO.HeroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroes")
class HeroController {

    @Autowired
    HeroService heroService;

    @GetMapping()
    public ResponseEntity<List<HeroDTO>> findAll() {
        return new ResponseEntity(heroService.obternerTodos(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<HeroDTO> create(@RequestBody HeroDTO heroDTO) {
        return new ResponseEntity(heroService.crear(heroDTO), HttpStatus.CREATED);
    }
}
