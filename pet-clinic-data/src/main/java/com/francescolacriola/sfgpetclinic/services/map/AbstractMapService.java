package com.francescolacriola.sfgpetclinic.services.map;

import com.francescolacriola.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract  class AbstractMapService<T extends BaseEntity, ID extends Long> { //T = BaseEntity or something that extends it
    protected Map<Long, T> map = new HashMap<>(); // ID = Long or something that extends it

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object){
        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){
        Long nextId = null;
        try{
            nextId = Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException e ){
            //if an Id doesn't exist -> set it as 1L
            nextId = 1L;
        }
        return nextId;
    }
}
