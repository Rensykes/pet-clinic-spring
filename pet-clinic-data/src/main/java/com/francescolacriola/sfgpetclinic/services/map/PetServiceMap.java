package com.francescolacriola.sfgpetclinic.services.map;

import com.francescolacriola.sfgpetclinic.model.Pet;
import com.francescolacriola.sfgpetclinic.services.CrudService;
import com.francescolacriola.sfgpetclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }
}
