package com.develhope.esSpringBoot.controller;

import com.develhope.esSpringBoot.entity.Meal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
public class MealByPriceRangeController {
    private List<Meal> chefSpecials = Arrays.asList(
            new Meal("Chicken Tikka Masala", "Chicken tikka masala is made with chicken pieces marinated in spices and yogurt immersed in a tasty creamy orange sauce.", 10.5),
            new Meal("Chicken and Dumplings", "Chicken and dumplings is a chicken dish to which vegetables and pasta may be added and is prepared by mixing flour, water, milk, buttermilk and sometimes butter or other edible fats, some chicken broth and/or spices.", 10.5),
            new Meal("Chicken Parmesan", "The chicken breast is first fried in plenty of boiling oil, then it is dipped in tomato sauce, garnished with mozzarella, and returned to the oven until the cheese becomes stringy and the tomato becomes dense and tasty.", 10.5),
            new Meal("Chicken Fired Strak", "Chicken fried steak is a dish based on chicken meat which, after being breaded and fried, is seasoned with beef gravy and onions[7] and served with mashed potatoes, vegetables, Texas toast or biscuits.", 10.5),
            new Meal("Chicken Pot Pie", "chicken pot pie is a chicken and vegetable pie entirely covered in a layer of savory dough.", 10.5),
            new Meal("Chicken Cordon Bleu", "Cordon bleu is a fillet stuffed with cooked ham and melted cheese, which is breaded and then fried or baked.", 10.5),
            new Meal("Chicken Noodle Soup", "The base is a chicken broth to which garden vegetables, pasta and boiled chicken are added. Traditionally tortellini are used", 10.5)
    );

    @GetMapping("/meal/price")
    public List<Meal> blabla(@RequestParam int min, @RequestParam int max){
        List<Meal> mealsPriceRange = new ArrayList<>();
        for(Meal meal : chefSpecials){
            if(meal.getPrice() > min && meal.getPrice() < max){
                mealsPriceRange.add(meal);
            }
        }
        return mealsPriceRange;
    }
}
