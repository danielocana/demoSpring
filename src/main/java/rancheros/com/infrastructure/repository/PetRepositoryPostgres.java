package rancheros.com.infrastructure.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import rancheros.com.domain.pet.Pet;
import rancheros.com.domain.pet.PetRepository;
import rx.Observable;

import java.util.Optional;

@Transactional
public class PetRepositoryPostgres implements PetRepository {

    private PetDAO petDAO;

    public PetRepositoryPostgres(PetDAO petDAO) {
        this.petDAO = petDAO;
    }

    @Override
    public Observable<Pet> findAll(String offset, String limit) {
        return Observable.from(petDAO.findAll(new PageRequest(Integer.valueOf(offset),
                Integer.valueOf(limit))).getContent());
    }

    @Override
    public Optional<Pet> findById(String id) {
        return Optional.ofNullable(petDAO.findOne(id));
    }

    @Override
    public void delete(String id) {
        petDAO.delete(id);
    }

    @Override
    public Pet createOrUpdate(Pet pet) {
        return petDAO.save(pet);
    }
}
