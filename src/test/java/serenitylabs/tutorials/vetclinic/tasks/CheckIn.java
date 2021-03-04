package serenitylabs.tutorials.vetclinic.tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;

public class CheckIn implements Performable {
    private Pet pet;
    private PetHotel petHotel;

    public CheckIn(Pet pet, PetHotel petHotel) {
        this.pet = pet;
        this.petHotel = petHotel;
    }

    public CheckIn(){}

    public static CheckinBuilder aPet(Pet pet) {
        return new CheckinBuilder(pet);
    }

    @Step("{0} check in #pet to the hotel")
    @Override
    public <T extends Actor> void performAs(T t) {
        petHotel.checkIn(pet);

    }

    public static class CheckinBuilder {
        private Pet pet;

        public CheckinBuilder(Pet pet){

            this.pet = pet;
        }

        public Performable into(PetHotel petHotel) {
            return new CheckIn(pet, petHotel);
        }
    }
}
