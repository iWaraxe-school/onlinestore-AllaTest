package by.issoft.store;

import by.issoft.domain.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InMemoryStoreFiller implements Filler {
    private Store store;

    public InMemoryStoreFiller() {
    }

    public InMemoryStoreFiller(Store store) {
        this.store = store;
    }

    @Override
    public List<Category> getListOfCategories() {
        List<Category> categories = new ArrayList<>();
        Set<Map.Entry<Category, Integer>> entries = StoreFiller.createCategoryToIntegerMap().entrySet();
        for (Map.Entry<Category, Integer> entry : entries) {
            categories.add(entry.getKey());
        }
        return categories;
    }
}
