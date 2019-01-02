package com.example.controller;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shipengfish
 * @version 1.0
 * @date 2018/11/22
 * @description
 * @since 1.0
 */
public class ListWrapper<E> {

    private List<E> list;

    public ListWrapper() {
        list = new ArrayList<>();
    }

    public ListWrapper(List<E> list) {
        this.list = list;
    }

    @Valid
    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public boolean add(E e) {
        return list.add(e);
    }

    public void clear() {
        list.clear();
    }

}
