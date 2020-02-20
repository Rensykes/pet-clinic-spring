package com.francescolacriola.sfgpetclinic.bootstrap;

import com.francescolacriola.sfgpetclinic.model.Owner;
import com.francescolacriola.sfgpetclinic.model.Pet;
import com.francescolacriola.sfgpetclinic.model.PetType;
import com.francescolacriola.sfgpetclinic.model.Vet;
import com.francescolacriola.sfgpetclinic.services.OwnerService;
import com.francescolacriola.sfgpetclinic.services.PetTypeService;
import com.francescolacriola.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


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
        owner1.setFirstName("Geralt");
        owner1.setLastName("Di Rivia");
        owner1.setAddress("Via Messenape 23");
        owner1.setCity("Bari");
        owner1.setTelephone("3286144074");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rutilia");
        owner1.getPets().add(mikesPet);


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        //owner2.setId(2L);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gleanne");
        owner2.setAddress("Viale Orazio Flacco 13");
        owner2.setCity("Bari");
        owner2.setTelephone("3401502840");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("JustCat");
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        //owner2.setId(2L);
        owner3.setFirstName("Rick");
        owner3.setLastName("Sanchez");
        owner3.setAddress("Via Fiume 29");
        owner3.setCity("Modugno");
        owner3.setTelephone("3335356545");

        ownerService.save(owner3);

        Owner owner4 = new Owner();
        //owner2.setId(2L);
        owner4.setFirstName("Jerry");
        owner4.setLastName("Smith");
        owner4.setAddress("Via Orfeo Mazzitelli 256");
        owner4.setCity("Bari");
        owner4.setTelephone("0805621040");
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
