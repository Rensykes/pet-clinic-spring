package com.francescolacriola.sfgpetclinic.services;

import com.francescolacriola.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet owner);
    Set<Pet> findAll();
}
