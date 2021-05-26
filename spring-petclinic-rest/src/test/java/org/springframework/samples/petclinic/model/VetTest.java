package org.springframework.samples.petclinic.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;



public class VetTest {
    Vet vetTest = new Vet();
    Specialty surgery = new Specialty();

    @Test
    public void getNrOfSpec() {
        surgery.setName("Surgery");
        Assertions.assertEquals(0, vetTest.getNrOfSpecialties());
        vetTest.addSpecialty(surgery);
        Assertions.assertEquals(1, vetTest.getNrOfSpecialties());
    }
    @Test
    public void addSpec() {
        surgery.setName("Surgery");
        vetTest.addSpecialty(surgery);
        Assertions.assertEquals(1, vetTest.getNrOfSpecialties());
    }
    @Test
    public void clearSpec() {
        surgery.setName("Surgery");
        vetTest.addSpecialty(surgery);
        Assertions.assertEquals(1, vetTest.getNrOfSpecialties());
        vetTest.clearSpecialties();
        Assertions.assertEquals(0, vetTest.getNrOfSpecialties());
    }

}
