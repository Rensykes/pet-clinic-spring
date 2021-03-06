package com.francescolacriola.sfgpetclinic.services.map;

import com.francescolacriola.sfgpetclinic.model.Specialty;
import com.francescolacriola.sfgpetclinic.model.Vet;
import com.francescolacriola.sfgpetclinic.services.CrudService;
import com.francescolacriola.sfgpetclinic.services.SpecialtyService;
import com.francescolacriola.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size() >0){
            object.getSpecialities().forEach(specialty -> {
                if(specialty.getId() == null){
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());

                }
            });
        }
        return super.save(object);
    }
}
