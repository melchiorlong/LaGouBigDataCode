package com.study.Stage1.Section4.Task5;

//import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@MyAnnotation
public class Student<T,E> extends Person implements Comparable<String>, Serializable {

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
