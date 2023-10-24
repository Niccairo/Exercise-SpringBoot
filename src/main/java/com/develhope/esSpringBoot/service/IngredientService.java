package com.develhope.esSpringBoot.service;

import com.develhope.esSpringBoot.dao.IngredientDao;
import com.develhope.esSpringBoot.entity.Ingredient;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientService {
    private IngredientDao ingredientDao;
    public IngredientService(IngredientDao ingredientDao){
        this.ingredientDao = ingredientDao;
    }
    public Optional<Ingredient> getIngredient(Long id){
        return ingredientDao.findById(id);
    }
    public void createIngredient(Ingredient ingredient){
        ingredientDao.save(ingredient);
    }
    public void deleteIngredient(Long id){
        ingredientDao.deleteById(id);
    }
    public void updateIngredient(Ingredient ingredient, Long id){
        ingredientDao.deleteById(id);
        ingredientDao.save(ingredient);
    }
}
