package com.Maximillian.vehicleparkingsystem.repository;

import com.Maximillian.vehicleparkingsystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{

    boolean existsByCategoryName (String categoryName);

    Category findCategoriesByCategoryName(String category);
}
