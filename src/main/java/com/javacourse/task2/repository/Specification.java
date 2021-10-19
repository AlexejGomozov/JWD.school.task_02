package com.javacourse.task2.repository;

import com.javacourse.task2.entity.Triangle;

@FunctionalInterface
public interface Specification {
   boolean specify(Triangle triangle);
}
