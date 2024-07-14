package com.vn.restdemo.service;

import com.vn.restdemo.model.JustString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {

    private List<String> js= new ArrayList<>();

    public List<String> getNames(){
        return js;
    }

    public boolean postName(String s){
        js=new ArrayList<>();
        return js.add(s);
    }

    public boolean putName(String s){
        return js.add(s);
    }

    public boolean deleteName(String s){

        return js.remove(s);



    }
}
