package com.develhope.esSpringBoot.dao;

import com.develhope.esSpringBoot.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDao extends JpaRepository<Ingredient,Long> {
}
