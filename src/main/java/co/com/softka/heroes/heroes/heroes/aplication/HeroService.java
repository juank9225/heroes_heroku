package co.com.softka.heroes.heroes.heroes.aplication;

import co.com.softka.heroes.heroes.heroes.domain.Hero;
import co.com.softka.heroes.heroes.heroes.domain.repository.HeroRepository;
import co.com.softka.heroes.heroes.heroes.heroDTO.HeroDTO;
import co.com.softka.heroes.heroes.heroes.mappers.HeroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    @Autowired
    HeroRepository heroRepository;

    HeroMapper mapper = new HeroMapper();

    public HeroDTO crear(HeroDTO heroDTO){
        Hero hero = mapper.fromHeroDTOToHero(heroDTO);
        return mapper.fromHeroToHeroDTO(heroRepository.save(hero));
    }

    public List<HeroDTO> obternerTodos(){
        List<Hero> heroes = heroRepository.findAll();
        return mapper.fromCollectionList(heroes);
    }

}
