package com.develhope.esSpringBoot.controller;

import com.develhope.esSpringBoot.entity.Meal;
import com.develhope.esSpringBoot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController3 {
    @Autowired
    private MealService mealService;

    @PostMapping("/add-meal")
    public ResponseEntity addMeal(@RequestBody Meal meal){
        boolean addedMeal = mealService.addMeal(meal);
        if(addedMeal){
            return ResponseEntity.ok("Meal added!");
        }
        return ResponseEntity.badRequest().body("Meal not added");
    }
    @PutMapping("/update-meal/{name}")
    public ResponseEntity updateMeal(@RequestBody Meal updatedMeal, @PathVariable String name){
        boolean mealUpdated = mealService.updateMeal(updatedMeal, name);
        if(mealUpdated){
            return ResponseEntity.ok("Meal updated!");
        }
        return ResponseEntity.badRequest().body("Meal not updated");
    }
    @DeleteMapping("/meal/{name}")
    public ResponseEntity deleteMeal(@PathVariable String name){
        boolean mealDeleted = mealService.deleteMealByName(name);
        if(mealDeleted){
            return ResponseEntity.ok("Meal deleted");
        }
        return ResponseEntity.badRequest().body("Meal not deleted");
    }
    @DeleteMapping("/meal/price/{price}")
    public ResponseEntity deleteMealsAbovePRice(@PathVariable Double price){
        mealService.deleteMealAboveCertainPrice(price);
        return ResponseEntity.ok("Meals priced over" + price + " have been eliminated ");
    }
    @PutMapping("/meal/{name}")
    public ResponseEntity updatePriceByMealName(@RequestBody Meal meal, @PathVariable String name){
        boolean priceUpdated = mealService.updatePriceOfMealByName(name,meal);
        if(priceUpdated){
            return ResponseEntity.ok("Price of " + name + " updated");
        }
        return ResponseEntity.badRequest().body("Price not updated");
    }























}
