package com.lizhizhao.bizBug.entity;

import java.util.Objects;

public class PointRight {

    private int x;
    private int y;
    private String desc;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointRight that = (PointRight) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }
}