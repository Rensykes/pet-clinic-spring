package com.francescolacriola.sfgpetclinic.services;

import com.francescolacriola.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
