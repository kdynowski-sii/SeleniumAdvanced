package models;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Random;

public class UserFactory {
    public User getUser(boolean alreadyRegistered){
        if(alreadyRegistered)
            return getAlreadyRegisteredUser();
        return getRandomUser(true);
    }

    private User getRandomUser(boolean shouldPass) {
        Faker faker = new Faker();
        Random rand = new Random();
        User user = new User.UserBuilder()
                .setSocialTitle(rand.nextBoolean() ? "Mr" : "Mrs")
                .setPassword(RandomStringUtils.random(14, true, true))
                .setOwu(shouldPass) // Has to be true to pass
                .setOffersFromPartners(rand.nextBoolean())
                .setNewsletter(rand.nextBoolean())
                .setLastName(faker.name().lastName())
                .setFirstName(faker.name().firstName())
                .setEmail(faker.name().username()+"@test.test")
                .setDataPrivacy(shouldPass)
                .setBirthDate(new SimpleDateFormat("MM/dd/yyyy")
                        .format(faker.date().birthday(18,100)))
                .build();
        return null;
    }

    private User getAlreadyRegisteredUser() {
        User user = new User.UserBuilder()
                .setBirthDate("05/23/1968")
                .setDataPrivacy(true)
                .setEmail("john.ortiz@avp.test")
                .setFirstName("John")
                .setLastName("Ortiz")
                .setNewsletter(false)
                .setOffersFromPartners(false)
                .setOwu(true)
                .setPassword("SuperSecretPassword^^12")
                .setSocialTitle("Mr")
                .build();
        return user;
    }
}
