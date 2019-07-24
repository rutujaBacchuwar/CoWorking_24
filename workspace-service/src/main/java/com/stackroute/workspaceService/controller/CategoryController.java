package com.stackroute.workspaceService.controller;

import com.stackroute.workspaceService.domain.*;
import com.stackroute.workspaceService.exception.CategoryAlreadyExists;
import com.stackroute.workspaceService.exception.CategoryNotFoundException;
import com.stackroute.workspaceService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1")
public class CategoryController {

    CategoryService categoryService;
    MySpace mySpace = new MySpace();
    MyAddress address = new MyAddress();
    MyDimension myDimension = new MyDimension();
    MyLocation mylocation = new MyLocation();



    @Autowired
    public CategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    @PostMapping("category")
    public ResponseEntity<?> saveCategory(@RequestBody MyCategory mycategory) throws CategoryAlreadyExists {
        System.out.println("Category Object:" + mycategory.toString());
        ResponseEntity responseEntity;
        mySpace = mycategory.getMySpace();
        mycategory.setMySpace(mySpace);
        address = mycategory.getMyAddress();
        mycategory.setMyAddress(address);
        myDimension = mycategory.getMyDimension();
        mycategory.setMyDimension(myDimension);
        mylocation = mycategory.getLocation();


        mycategory.setLocation(mylocation);
        try {
            categoryService.saveCategory(mycategory);
            responseEntity = new ResponseEntity<String>(" Category Successfully Saved", HttpStatus.CREATED);
        } catch (CategoryAlreadyExists ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;


    }


    @GetMapping("category")
    public ResponseEntity<?> getAllCategories() {
        return new ResponseEntity<List<MyCategory>>(categoryService.getAllCategories(), HttpStatus.OK);
    }


    @PatchMapping("category")
    public ResponseEntity<?> updateCategory(@RequestBody MyCategory mycategory) throws CategoryNotFoundException {
        ResponseEntity responseEntity;
        try {
            categoryService.updateCategory(mycategory);
            responseEntity = new ResponseEntity<String>(" category Updated Successfully", HttpStatus.CREATED);
        } catch (CategoryNotFoundException exception) {
            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @DeleteMapping("category")
    public ResponseEntity<String> deleteCategory(@RequestBody MyCategory mycategory) {
        ResponseEntity responseEntity;
        try {
            boolean answer = categoryService.deleteCategory(mycategory);
            return new ResponseEntity<String>(" Category Successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @GetMapping("category/{categoryName}")
    public ResponseEntity<?>getByCategory(@PathVariable String categoryName)
    {
        System.out.println("ofdyfey");
        List<MyCategory> list = new ArrayList<MyCategory>();
        list= categoryService.findByCategory(categoryName);
        System.out.println("st9t98dsa"+list.toString());
        ResponseEntity responseEntity=new ResponseEntity(list,HttpStatus.OK);
        System.out.println(responseEntity);
        return responseEntity;
    }
}



