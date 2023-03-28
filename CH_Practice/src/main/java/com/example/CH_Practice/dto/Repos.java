package com.example.CH_Practice.dto;

import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repos {
    private Map<Long, UserDto> store=new HashMap<>();
    private static long sequence=0L;

    private static final Repos instance=new Repos();

    public static Repos getInstance(){
        return instance;
    }

    private Repos(){

    }

    public UserDto save(UserDto user){
        user.setId(++sequence);
        store.put(user.getId(), user);
        return user;
    }

    public UserDto findById(Long id){
        return store.get(id);
    }

    public List<UserDto> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
