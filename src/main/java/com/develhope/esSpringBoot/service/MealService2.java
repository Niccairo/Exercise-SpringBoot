package com.develhope.esSpringBoot.service;

import com.develhope.esSpringBoot.dao.MealDao;
import com.develhope.esSpringBoot.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Premesso che non so se è una buona pratica ma ho creato una nuovo Service (MealService2) perchè altrimenti mi si incasinava tutto il progetto
@Service
public class MealService2 {
    private MealDao mealDao;
    @Autowired
    public MealService2(MealDao mealDao){
        this.mealDao = mealDao;
    }
    public void addMeal(Meal meal){
        if (meal == null){throw new IllegalArgumentException("Meal cannot be null");}
        if(meal.getName() == null || meal.getName().isEmpty()) throw new IllegalArgumentException("Meal name cannot be null or empty");
        if(meal.getDescription() == null || meal.getDescription().isEmpty()) throw new IllegalArgumentException("Meal description cannot be null or empty");
        if(meal.getPrice() <=  0)  throw new IllegalArgumentException("Meal price cannot be less than or equal to 0");
        if(meal.getPrice() > 100) throw new IllegalArgumentException("Meal price cannot be more than 100");
        mealDao.addMeal(meal);
    }
    public void deleteMeal(String mealName){
        mealDao.deleteMeal(mealName);
    }
    public void updateMeal(Meal meal){
        mealDao.updateMeal(meal);
    }
    public List<Meal> getMeals(){
        return mealDao.getMeals();
    }
}
