package com.stackroute.workspaceService.repository;



import com.stackroute.workspaceService.domain.MyCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CategoryRepository extends MongoRepository<MyCategory, Integer> {
    boolean existsByCategoryId(int categoryId);

    void deleteByCategoryId(int categoryId);

    @Query("{ 'categoryName': '?0' }")
    List<MyCategory> findByCategoryName(String categoryName);


}
