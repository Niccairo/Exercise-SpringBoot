package com.develhope.esSpringBoot.controller;

import com.develhope.esSpringBoot.entity.Meal;
import com.develhope.esSpringBoot.service.MealService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController4 {
    private MealService2 mealService2;
    @Autowired
    public MealController4(MealService2 mealService){
        this.mealService2  = mealService;
    }
    @GetMapping("/get/meals")
    public ResponseEntity<List<Meal>> getMeals(){
        return ResponseEntity.ok(mealService2.getMeals());
    }

    @PutMapping("/put/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal){
        try {
            mealService2.addMeal(meal);
            return ResponseEntity.ok("Meal added");
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/meal/{mealName}")
    public ResponseEntity<String> deleteMeal(@PathVariable String mealName){
        mealService2.deleteMeal(mealName);
        return ResponseEntity.ok("Meal deleted");
    }
}