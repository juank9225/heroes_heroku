package co.com.softka.heroes.heroes.heroes.mappers;

import co.com.softka.heroes.heroes.heroes.domain.Hero;
import co.com.softka.heroes.heroes.heroes.heroDTO.HeroDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class HeroMapper {

    public Hero fromHeroDTOToHero(HeroDTO heroDTO){
        Hero hero = new Hero();
        hero.setId(heroDTO.getId());
        hero.setName(heroDTO.getNombre());
        hero.setRace(heroDTO.getRaza());
        hero.setSkill(heroDTO.getHabilidad());
        hero.setPowerLevel(heroDTO.getNivelDePoder());
        hero.setImageURL(heroDTO.getUrlImagen());

        return hero;
    }

    public HeroDTO fromHeroToHeroDTO(Hero hero){
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setId(hero.getId());
        heroDTO.setNombre(hero.getName());
        heroDTO.setRaza(hero.getRace());
        heroDTO.setHabilidad(hero.getSkill());
        heroDTO.setNivelDePoder(hero.getPowerLevel());
        heroDTO.setUrlImagen(hero.getImageURL());

        return heroDTO;
    }

    public List<HeroDTO> fromCollectionList(List<Hero> collection) {
        if (collection == null) {
            return null;

        }
        List<HeroDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while(listTracks.hasNext()) {
            Hero hero = (Hero) listTracks.next();
            list.add(fromHeroToHeroDTO(hero));
        }

        return list;
    }

}
