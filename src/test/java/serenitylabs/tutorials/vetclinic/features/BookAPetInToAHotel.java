package serenitylabs.tutorials.vetclinic.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.assertj.core.api.Assertions;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.tasks.CheckIn;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.*;

@RunWith(SerenityRunner.class)
public class BookAPetInToAHotel {

    @Test
    public void petra_books_cat_in_hotel(){
        //Given
        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = new PetHotel("hotel");

        //When
        petra.attemptsTo(
                CheckIn.aPet(ginger).into(petHotel));

        //Then
        assertThat(petHotel.getPets(), hasItem(ginger));

}
}
