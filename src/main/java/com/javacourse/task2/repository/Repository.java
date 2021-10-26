package com.javacourse.task2.repository;

import com.javacourse.task2.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Repository {
    static final Logger logger = LogManager.getLogger();
    private static Repository instance; 
    List<Triangle> triangles ;

  private Repository(){
    triangles = new ArrayList<>();
}
    public static Repository getInstance(){
        if (instance == null) instance =  new Repository();
      logger.info("New repository is ready");
    return instance;
    }

    public List<Triangle> getTriangles(){
      return triangles;
    }
    public Triangle getTriangleByIndex(int index){
      return triangles.get(index);
    }
    public Triangle set(int index, Triangle triangle){
      return triangles.set(index,triangle);
    }
    public boolean add(Triangle triangle){
      return triangles.add(triangle);
    }
    public boolean addAll(List<Triangle> trianglesList){
        return triangles.addAll(trianglesList);
    }
    public boolean remove(Triangle triangle){
      return triangles.remove(triangle);
    }
    public boolean removeAll(List<Triangle> triangleList){
        return triangles.removeAll(triangleList);
    }

  public void addToRep(Triangle triangle){ triangles.add(triangle);
  }

    public List<Triangle> query(Specification specification){
      return triangles
              .stream()
              .filter(specification::specify)
              .collect(Collectors.toList());
    }
    public List<Triangle> sort (Comparator<? super Triangle> comparator) {
    return triangles
            .stream()
            .sorted(comparator)
            .collect(Collectors.toList());
  }
}

