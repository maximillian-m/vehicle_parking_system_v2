package com.Maximillian.vehicleparkingsystem.service.impl;

import com.Maximillian.vehicleparkingsystem.dto.request.CategoryRequestDto;
import com.Maximillian.vehicleparkingsystem.dto.request.UpdateRequestDto;
import com.Maximillian.vehicleparkingsystem.dto.response.CategoryResponseDto;
import com.Maximillian.vehicleparkingsystem.entity.Category;
import com.Maximillian.vehicleparkingsystem.exception.ResourceCreationException;
import com.Maximillian.vehicleparkingsystem.exception.ResourceNotFoundException;
import com.Maximillian.vehicleparkingsystem.repository.CategoryRepository;
import com.Maximillian.vehicleparkingsystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ReentrantLock lock = new ReentrantLock(true);

    @Override
    @Transactional
    public CategoryResponseDto addCategory(CategoryRequestDto request) {
        lock.lock();
        log.info("create a new category");
        try{
            if (categoryExist(request.getCategoryName())) {
                throw new ResourceCreationException("Category Already Exist");
            }
            Category category = new Category();
            category.setCategoryName(request.getCategoryName());
            Category savedCategory = categoryRepository.save(category);
            return mapToDto(savedCategory);
        } finally {
            lock.unlock();
        }

    }

    @Override
    public CategoryResponseDto editCategory(UpdateRequestDto request, String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category does not exist"));

        if(StringUtils.isNoneBlank(request.getCategoryName())) {
            category.setCategoryName(request.getCategoryName());
        }
        Category savedCategory = categoryRepository.save(category);
        return mapToDto(savedCategory);
    }

    @Override
    public void deleteCategory(String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category does not exist"));

        if(category != null) {
            categoryRepository.delete(category);
        }
    }

    boolean categoryExist(String categoryName) {
        return categoryRepository.existsByCategoryName(categoryName);
    }

    public CategoryResponseDto mapToDto(Category category) {
        return CategoryResponseDto.builder()
                .categoryName(category.getCategoryName())
                .build();
    }
}
