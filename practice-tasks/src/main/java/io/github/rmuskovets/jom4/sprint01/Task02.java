package io.github.rmuskovets.jom4.sprint01;

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

interface DrinkReceipt_02 {
    String getName();
    DrinkReceipt_02 addComponent(String componentName, int componentCount);
}
interface DrinkPreparation_02 {
    Map<String, Integer> makeDrink();
}
interface Rating_02 {
    int getRating();
}
class Caffee_02 implements DrinkReceipt_02, DrinkPreparation_02, Rating_02 {
    private String name;
    private int rating;
    private Map<String, Integer> ingredients = new HashMap<String, Integer>() {{
        put("Water", 100);
        put("Arabica", 20);
    }};

    public Map<String, Integer> makeDrink() {
        return ingredients;
    }

    public DrinkReceipt_02 addComponent(String componentName, int componentCount) {
        ingredients.put(componentName, componentCount);
        return this;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public Caffee_02(String name, int rating) {
        this.rating = rating;
        this.name = name;
    }
}
class Espresso_02 extends Caffee_02 {
    public Espresso_02(String s, int rating) {
        super(s, rating);
        addComponent("Water", 50);
    }

    public Map<String, Integer> makeDrink() {
        return super.makeDrink();
    }
}
class Cappuccino_02 extends Caffee_02 {
    public Cappuccino_02(String s, int rating) {
        super(s, rating);
        addComponent("Milk", 50);
    }

    public Map<String, Integer> makeDrink() {
        return super.makeDrink();
    }
}
class MyUtils_02 {

    public static <T> T get(Iterator<T> iter) {
        return iter.hasNext() ? null : iter.next();
    }

    public static <T> List<T> makeList(Iterator<T> iter) {
        List<T> l = new ArrayList<>();
        iter.forEachRemaining(l::add);
        return l;
    }

    public Map<String, Double> averageRating(List<Caffee_02> coffees) {
        Map<Class<? extends Caffee_02>, List<Caffee_02>> drinks = new HashMap<>();
        coffees.forEach(coffee -> drinks.compute(coffee.getClass(), (typ, old) -> old == null
                ? new ArrayList<>()
                : Stream.concat(old.stream(), Stream.of(coffee)).collect(Collectors.toList())));
        return drinks.keySet().stream()
                .map(drinks::get)
                .map(lst -> new AbstractMap.SimpleEntry<>(
                        lst.get(0).getName(),
                        lst.stream().mapToInt(Caffee_02::getRating).average().orElse(0)
                ))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
