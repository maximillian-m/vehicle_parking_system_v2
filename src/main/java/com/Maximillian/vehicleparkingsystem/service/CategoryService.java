package com.Maximillian.vehicleparkingsystem.service;

import com.Maximillian.vehicleparkingsystem.dto.request.CategoryRequestDto;
import com.Maximillian.vehicleparkingsystem.dto.request.UpdateRequestDto;
import com.Maximillian.vehicleparkingsystem.dto.response.CategoryResponseDto;

public interface CategoryService {

    CategoryResponseDto addCategory (CategoryRequestDto request);

    CategoryResponseDto editCategory(UpdateRequestDto request, String categoryId);

    void deleteCategory (String categoryId);
}
