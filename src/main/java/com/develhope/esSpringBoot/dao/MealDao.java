package com.develhope.esSpringBoot.dao;

import com.develhope.esSpringBoot.entity.Meal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MealDao {
    private List<Meal> meals = new ArrayList<>();

    public void addMeal(Meal meal){
        meals.add(meal);
    }
    public void deleteMeal(String mealName){
        meals.removeIf(meal -> meal.getName().equals(mealName));
    }

    public void updateMeal(Meal meal){
        meals.removeIf(m -> m.getName().equals(meal.getName()));
        meals.add(meal);
    }
    public List<Meal> getMeals(){
        return meals;
    }
}