package com.lizhizhao.bizBug.entity;

public class PointWrong {

    private int x;
    private int y;
    private final String desc;

    public PointWrong(int x, int y, String desc){
        this.x = x;
        this.y = y;
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o){
        PointWrong that = (PointWrong) o;
        return x == that.x && y == that.y;
    }

//    // 更完整的equals
//    @Override
//    public boolean equals(Object o){
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PointWrong that = (PointWrong) o;
//        return x == that.x && y == that.y;
//    }
}