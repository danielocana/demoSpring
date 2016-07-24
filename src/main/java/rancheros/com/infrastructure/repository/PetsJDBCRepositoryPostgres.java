package rancheros.com.infrastructure.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import rancheros.com.domain.pet.Pet;
import rancheros.com.domain.pet.PetRepository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Transactional
public class PetsJDBCRepositoryPostgres implements PetRepository{

    JdbcTemplate jdbcTemplate;

    public PetsJDBCRepositoryPostgres(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pet> findAll() {
        String query = "select * from pet";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);
        List<Pet> pets = new ArrayList<>();
        result.forEach(row ->{
            Pet pet = new Pet();
            pet.setId((String)(row.get("id")));
            pet.setName((String)(row.get("name")));
            pet.setType((String)(row.get("type")));
            pets.add(pet);
        });
        return pets;
    }

    @Override
    public Pet findById(String id) {
        String sql = "SELECT * FROM pet WHERE id = ?";
        Pet pet = (Pet)jdbcTemplate.queryForObject(
                sql, new Object[] { id },
                new BeanPropertyRowMapper(Pet.class));
        return pet;
    }

    @Override
    public Pet create(Pet pet) {
        String id = UUID.randomUUID().toString();
        pet.setId(id);
        String sql = "INSERT INTO pet " +
                "(id, name, type) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[] { pet.getId(),
                pet.getName(),pet.getType()
        });
        return pet;
    }
}
