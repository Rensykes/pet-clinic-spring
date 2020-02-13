package com.francescolacriola.sfgpetclinic.services;

import com.francescolacriola.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet owner);
    Set<Vet> findAll();
}
