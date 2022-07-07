package by.issoft.store;

import com.github.javafaker.Faker;

public class RandomStorePopulator {
    Faker faker = new Faker();

    public double getPrice() {

        return faker.number().randomDouble(2, 1, 90);
    }

    public String getName(String categoryName) {
        switch (categoryName) {
            case "Bike":
                return faker.backToTheFuture().character();

            case "Milk":
                return faker.food().ingredient();

            case "Phone":
                return faker.harryPotter().spell();

            default:
                return "No such category";
        }

    }

    public double getRate() {

        return faker.number().randomDouble(1, 0, 5);
    }


}









