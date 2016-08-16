package rancheros.com.infrastructure.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import rancheros.com.domain.pet.Pet;
import rancheros.com.domain.pet.PetRepository;
import rx.Observable;

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
    public Observable<Pet> findAll(String offset, String limit) {
        String query = "select * from pet LIMIT %d OFFSET %d";
        String queryResult = String.format(query, Integer.parseInt(limit), Integer.parseInt(offset));
        List<Map<String, Object>> result = jdbcTemplate.queryForList(queryResult);
        List<Pet> pets = new ArrayList<>();
        result.forEach(row ->{
            Pet pet = new Pet();
            pet.setId((String)(row.get("id")));
            pet.setName((String)(row.get("name")));
            pet.setType((String)(row.get("type")));
            pets.add(pet);
        });
        return Observable.from(pets);
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

    @Override
    public Pet update(Pet pet) {
        String updateStatement = "UPDATE pet"
                + " SET name=?, type=?"
                + " WHERE id=?";
        jdbcTemplate.update(updateStatement, pet.getName(), pet.getType(), pet.getId());
        return pet;
    }

    @Override
    public void delete(String id) {
        String deleteStatement = "DELETE FROM pet WHERE id=?";
        jdbcTemplate.update(deleteStatement, id);
    }
}
