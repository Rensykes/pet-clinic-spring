package com.francescolacriola.sfgpetclinic.bootstrap;

import com.francescolacriola.sfgpetclinic.model.Owner;
import com.francescolacriola.sfgpetclinic.model.PetType;
import com.francescolacriola.sfgpetclinic.model.Vet;
import com.francescolacriola.sfgpetclinic.services.OwnerService;
import com.francescolacriola.sfgpetclinic.services.PetTypeService;
import com.francescolacriola.sfgpetclinic.services.VetService;
import com.francescolacriola.sfgpetclinic.services.map.OwnerServiceMap;
import com.francescolacriola.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/*
    CommandLineRunner is a Spring Boot class.
    Declaring it as a Component it will be registered in the Spring Context as a Spring Bean and
    at the start of the application the method run will be executed
 */

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded Pet Types");

        Owner owner1 = new Owner();
        //owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        //owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gleanne");

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        //owner2.setId(2L);
        owner3.setFirstName("Rick");
        owner3.setLastName("Sanchez");

        ownerService.save(owner3);

        Owner owner4 = new Owner();
        //owner2.setId(2L);
        owner4.setFirstName("Jerry");
        owner4.setLastName("Smith");

        ownerService.save(owner4);

        System.out.println("Loaded Owners.");

        Vet vet1 = new Vet();
        //vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        //vet2.setId(2L);
        vet2.setFirstName("Pino");
        vet2.setLastName("La Lavatrice");

        vetService.save(vet2);

        System.out.println("Loaded Vets.");


    }
}
