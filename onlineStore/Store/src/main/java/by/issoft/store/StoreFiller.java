package by.issoft.store;

import by.issoft.domain.Category;
import by.issoft.domain.categories.BikeCategory;
import by.issoft.domain.categories.MilkCategory;
import by.issoft.domain.categories.PhoneCategory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public interface StoreFiller {
    void fillStoreRandomly() throws SQLException;
    public static Map<Category, Integer> createCategoryToIntegerMap() {
        Map<Category, Integer> newCategoryIntegerMap = new HashMap<>();

        newCategoryIntegerMap.put(new BikeCategory(), 10);
        newCategoryIntegerMap.put(new MilkCategory(), 10);
        newCategoryIntegerMap.put(new PhoneCategory(), 10);
        return newCategoryIntegerMap;
    }
}
