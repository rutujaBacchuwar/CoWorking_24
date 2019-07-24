package com.stackroute.recommendation.service;


import com.stackroute.recommendation.domain.Space;
import com.stackroute.recommendation.repository.ContainsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContainsServiceImpl implements ContainsService {

    ContainsRepository containsRepository;

    @Autowired
    public ContainsServiceImpl(ContainsRepository containsRepository) {
        this.containsRepository = containsRepository;
    }

    @Override
    public Collection<Space> getRelationship() {
        return containsRepository.getRelationship();
    }

    @Override
    public Space createRelationship(long spaceId) {
        return containsRepository.createRelationship(spaceId);
    }

    @Override
    public Space createRelationshipAll() {
        return containsRepository.createRelationshipAll();
    }

    @Override
    public Space deleteRelationship() {
        return containsRepository.deleteRelationship();
    }

    @Override
    public Collection<Space> recommendationprice(String name) throws ArrayIndexOutOfBoundsException {
        ArrayList<Double> list =containsRepository.getPrice(name);
        ArrayList<String> list1=containsRepository.getCategoryName(name);
        System.out.println(list);
        System.out.println(list1);
        Collection<Space> collection=new ArrayList<>();
        Collection<Space> finalList=new ArrayList<>();

        Collection newList=new ArrayList<>();


        for(int i=0;i<list1.size();i++){
            System.out.println("@@@@"+list1.get(i));
            for(int j=0;j<list.size();j++){
                if(i==j){
                    System.out.println("****"+ list.get(j));
                    if (list.get(j) >= 500 && list.get(j) <= 1000) {
                        System.out.println("1");
                        collection = containsRepository.recommendationPriceRange0(list1.get(i),name);
                        for (Space s:collection){
                            finalList.add(s);
                        }
                    } else if (list.get(j) > 1000 && list.get(j) <= 2000) {
                        System.out.println("2");
                        collection = containsRepository.recommendationPriceRange1(list1.get(i),name);
                        for (Space s:collection){
                            finalList.add(s);
                        }
                    } else if (list.get(j) > 2000 && list.get(j) <= 3000) {
                        System.out.println("3");
                        collection= containsRepository.recommendationPriceRange2(list1.get(i),name);
                        System.out.println(collection+""+list1.get(i));
                        for (Space s:collection){
                            finalList.add(s);
                        }
                       //String[] s= collection.toArray();
                    } else if (list.get(j) > 3000 && list.get(j) <= 4000) {
                        System.out.println("4");
                        collection= containsRepository.recommendationPriceRange3(list1.get(i),name);
                        for (Space s:collection){
                            finalList.add(s);
                        }
                    } else if (list.get(j) > 4000 && list.get(j) <= 5000) {
                        System.out.println("5");
                       collection= containsRepository.recommendationPriceRange4(list1.get(i),name);
                        for (Space s:collection){
                            finalList.add(s);
                        }
                    } else if (list.get(j) > 5000 && list.get(j) <= 6000) {
                        System.out.println("6");
                       collection= containsRepository.recommendationPriceRange5(list1.get(i),name);
                        for (Space s:collection){
                            finalList.add(s);
                        }
                    } else if (list.get(j) > 6000 && list.get(j) <= 7000) {
                        System.out.println("7");
                      collection=  containsRepository.recommendationPriceRange6(list1.get(i),name);
                        for (Space s:collection){
                            finalList.add(s);
                        }

                    } else if (list.get(j) > 7000 && list.get(j) <= 8000) {
                        System.out.println("8");
                       collection= containsRepository.recommendationPriceRange7(list1.get(i),name);
                        for (Space s:collection){
                            finalList.add(s);
                        }
                    } else if (list.get(j) > 8000 && list.get(j) <= 9000) {
                        System.out.println("9");
                       collection=containsRepository.recommendationPriceRange8(list1.get(i),name);
                        for (Space s:collection){
                            finalList.add(s);
                        }
                    }
                 else {
                        collection = containsRepository.recommendationPriceRange9(list1.get(i),name);
                        for (Space s : collection) {
                            finalList.add(s);
                        }
                    }
                }

            }
        }
        System.out.println(finalList);
            return finalList;
    }
}
