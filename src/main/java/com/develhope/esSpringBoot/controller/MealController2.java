package com.develhope.esSpringBoot.controller;

import com.develhope.esSpringBoot.entity.Meal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController2 {
    List<Meal>  mealList = new ArrayList<>();
    @PutMapping("/add-meal")
    public void addMeal(@RequestBody Meal meal){
        mealList.add(meal);
    }
    @PostMapping("/update-meal/{meal}")
    public void updateMeal(String name,@RequestBody Meal meal){
        for (Meal meal1 : mealList) {
            if(meal1.getName().equals(meal.getName())){
                meal1 = meal;
            }
        }
    }
}
