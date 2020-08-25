package com.example.demo.service;


import com.example.demo.entity.Members;


public interface MembersService {
    public void signup(Members members) throws Exception;
    public boolean login(Members members) throws Exception;
    public boolean idcheck(Members members) throws Exception;
    public String idsearch(Members members) throws Exception;
    public String pwsearch(Members members) throws Exception;
}
