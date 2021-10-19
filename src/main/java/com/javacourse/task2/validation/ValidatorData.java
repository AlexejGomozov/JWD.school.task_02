package com.javacourse.task2.validation;

import com.javacourse.task2.entity.Triangle;

public interface ValidatorData {
    boolean validData (String list);
    boolean validTriangle(Triangle triangle);
}
