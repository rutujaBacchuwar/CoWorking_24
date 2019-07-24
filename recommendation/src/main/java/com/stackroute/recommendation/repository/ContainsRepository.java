package com.stackroute.recommendation.repository;

import com.stackroute.recommendation.domain.Space;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.ArrayList;
import java.util.Collection;

public  interface ContainsRepository extends Neo4jRepository<Space,Long> {

    @Query("MATCH (u:Space)-[r:Contains]->(m:Category) RETURN u,r,m")
    public Collection<Space> getRelationship();

   // MATCH (Booked)<-[:Contains]-(s:Space) RETURN s;

    @Query("MATCH (a:Space),(b:Category) WHERE a.spaceId = {spaceId} AND b.space={spaceId} CREATE (a)-[r:Contains]->(b) RETURN r")
    public Space createRelationship(long spaceId);

    @Query( "MATCH (u:Space),(m:Category)  CREATE (u)-[:Contains]->(m);")
    public Space createRelationshipAll();


    //MATCH (p:User),(t:Game) WHERE p.name={userName} and t.id={gameName} CREATE (p)-[q:LikesGame]->(t) RETURN p,q,t

    @Query( "MATCH (Space)-[r:Contains]->(Category) DELETE r;")
    public Space deleteRelationship();



    @Query("MATCH (n:Category) RETURN n.categoryName")
    public ArrayList<String> allCategory();

    @Query("MATCH (u:User)-[b:Booked]->(c:Category)<-[:Contains]-(m:Space) WHERE u.name={name} RETURN c.price")
    public ArrayList<Double> getPrice(String name);

    @Query("MATCH (u:User)-[b:Booked]->(c:Category)<-[:Contains]-(m:Space) WHERE u.name={name} RETURN c.categoryName")
    public ArrayList<String> getCategoryName(String name);

    @Query("MATCH (u:User)-[b:Booked]->(c:Category)<-[:Contains]-(m:Space) WITH distinct c as c MATCH (l:Category)<-[:Contains]-(s:Space) WHERE  l.price>=500 and l.price<=1000 and l.categoryName={categoryName} and s.spaceId<>c.space RETURN l,s")
    public Collection<Space> recommendationPriceRange0(String categoryName);

    @Query("MATCH (u:User)-[b:Booked]->(c:Category)<-[:Contains]-(m:Space) WITH distinct c as c MATCH (l:Category)<-[:Contains]-(s:Space) WHERE l.price>1000 and l.price<=2000 and l.categoryName={categoryName} and s.spaceId<>c.space RETURN l,s")
    public Collection<Space> recommendationPriceRange1(String categoryName);

    @Query("MATCH (u:User)-[b:Booked]->(c:Category)<-[:Contains]-(m:Space) WITH distinct c as c MATCH (l:Category)<-[:Contains]-(s:Space) WHERE l.price>2000 and l.price<=3000 and l.categoryName={categoryName} and s.spaceId<>c.space RETURN l,s")
    public Collection<Space> recommendationPriceRange2(String categoryName);

    @Query("MATCH (u:User)-[b:Booked]->(c:Category)<-[:Contains]-(m:Space) WITH distinct c as c MATCH (l:Category)<-[:Contains]-(s:Space) WHERE l.price>3000 and l.price<=4000 and l.categoryName={categoryName} and s.spaceId<>c.space RETURN l,s")
    public Collection<Space> recommendationPriceRange3(String categoryName);

    @Query("MATCH (u:User)-[b:Booked]->(c:Category)<-[:Contains]-(m:Space) WITH distinct c as c MATCH (l:Category)<-[:Contains]-(s:Space) WHERE l.price>4000 and l.price<=5000 and l.categoryName={categoryName} and s.spaceId<>c.space RETURN l,s")
    public Collection<Space> recommendationPriceRange4(String categoryName);

    @Query("MATCH (u:User)-[b:Booked]->(c:Category)<-[:Contains]-(m:Space) WITH distinct c as c MATCH (l:Category)<-[:Contains]-(s:Space) WHERE l.price>5000 and l.price<=6000 and l.categoryName={categoryName} and s.spaceId<>c.space RETURN l,s")
    public Collection<Space> recommendationPriceRange5(String categoryName);

    @Query("MATCH (u:User)-[b:Booked]->(c:Category)<-[:Contains]-(m:Space) WITH distinct c as c MATCH (l:Category)<-[:Contains]-(s:Space) WHERE l.price>6000 and l.price<=7000 and l.categoryName={categoryName} and s.spaceId<>c.space RETURN l,s")
    public Collection<Space> recommendationPriceRange6(String categoryName);

    @Query("MATCH (u:User)-[b:Booked]->(c:Category)<-[:Contains]-(m:Space) WITH distinct c as c MATCH (l:Category)<-[:Contains]-(s:Space) WHERE l.price>7000 and l.price<=8000 and l.categoryName={categoryName} and s.spaceId<>c.space RETURN l,s")
    public Collection<Space> recommendationPriceRange7(String categoryName);

    @Query("MATCH (u:User)-[b:Booked]->(c:Category)<-[:Contains]-(m:Space) WITH distinct c as c MATCH (l:Category)<-[:Contains]-(s:Space) WHERE l.price>8000 and l.price<=9000 and l.categoryName={categoryName} and s.spaceId<>c.space RETURN l,s")
    public Collection<Space> recommendationPriceRange8(String categoryName);

    @Query("MATCH (u:User)-[b:Booked]->(c:Category)<-[:Contains]-(m:Space) WITH distinct c as c MATCH (l:Category)<-[:Contains]-(s:Space) WHERE l.price>9000 and l.categoryName={categoryName} and s.spaceId<>c.space RETURN l,s")
    public Collection<Space> recommendationPriceRange9(String categoryName);

}
