package com.rollingstone.spring.dao;

import com.rollingstone.spring.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CategoryDaoRepository extends PagingAndSortingRepository<Category, Long> {

    Page<Category> findAll(Pageable pageable);

}
