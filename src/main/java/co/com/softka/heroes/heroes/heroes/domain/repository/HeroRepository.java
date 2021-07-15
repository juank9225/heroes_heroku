package co.com.softka.heroes.heroes.heroes.domain.repository;

import co.com.softka.heroes.heroes.heroes.domain.Hero;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HeroRepository extends MongoRepository<Hero,String> {

}
