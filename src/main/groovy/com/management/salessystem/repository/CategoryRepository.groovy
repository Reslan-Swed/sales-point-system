package com.management.salessystem.repository

import com.management.salessystem.domain.Category
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository extends CrudRepository<Category, Long> {

}