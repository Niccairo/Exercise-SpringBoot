package com.develhope.esSpringBoot.service;

import com.develhope.esSpringBoot.entity.Meal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@Service
public class MealService {
    private List<Meal> mealList = new ArrayList<>();
    public boolean addMeal(Meal meal) {
        return mealList.add(meal);
    }
    public boolean updateMeal(@RequestBody Meal updatedMeal, @PathVariable String name){
        for (Meal meal : mealList) {
            if(meal.getName().equals(name)){
                meal.setName(updatedMeal.getName());
                meal.setDescription(updatedMeal.getDescription());
                meal.setPrice(updatedMeal.getPrice());
                return true;
            }
        }
        return false;
    }
    public boolean deleteMealByName(String name){
        for (Meal meal : mealList) {
            if(meal.getName().equals(name)){
                return mealList.remove(meal);
            }
        }
        return false;
    }
    public void deleteMealAboveCertainPrice(Double price){
        for (Meal meal : mealList) {
            if(meal.getPrice() > price){
                mealList.remove(meal);
            }
        }
    }
    public boolean updatePriceOfMealByName(String name, Meal meal){
        for (Meal meeal : mealList) {
            if(meeal.getName().equals(name)){
                meeal.setPrice(meal.getPrice());
                return true;
            }
        }
        return false;
    }
}
