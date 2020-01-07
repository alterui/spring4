package com.lr.coding.collection;

import lombok.AllArgsConstructor;

import java.util.Objects;

/**
 * @author liurui
 * @date 2020/1/7 14:08
 */

@AllArgsConstructor
public class Man {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Man man = (Man) o;
        return age == man.age &&
                Objects.equals(name, man.name);
    }


}
