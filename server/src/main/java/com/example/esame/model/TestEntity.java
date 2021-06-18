package com.example.esame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private Integer num1;
    private Integer num2;
    private Integer result;

    public TestEntity() {
    }

    public TestEntity(Integer num1, Integer num2, Integer result) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TestEntity{" + "id=" + id + ", num1=" + num1 + ", num2=" + num2 + ", result=" + result + '}';
    }

}
