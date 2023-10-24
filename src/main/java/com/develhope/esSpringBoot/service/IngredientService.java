package com.develhope.esSpringBoot.service;

import com.develhope.esSpringBoot.controller.EntityNotFoundException;
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
    //PUO ANDARE BENE QUESTO TIPO DI LOGICA?
    public Optional<Ingredient> getIngredient(Long id){
        if(ingredientDao.existsById(id)){
            return ingredientDao.findById(id);
        }else{
            throw new EntityNotFoundException("Ingredient with ID "+ id +" not found");
        }
    }

    public void createIngredient(Ingredient ingredient){
        ingredientDao.save(ingredient);
    }

    public void deleteIngredient(Long id){
        if(ingredientDao.existsById(id)){
            ingredientDao.deleteById(id);
        }else{
            throw new EntityNotFoundException("Ingredient with ID "+ id +" not found");
        }
    }

    public void updateIngredient(Ingredient ingredient, Long id){
        if(ingredientDao.existsById(id)){
            ingredientDao.deleteById(id);
            ingredientDao.save(ingredient);
        }else {
            throw new EntityNotFoundException("Ingredient with ID " + id + " not found");
        }
    }

}