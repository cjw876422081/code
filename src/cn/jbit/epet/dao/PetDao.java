package cn.jbit.epet.dao;

import cn.jbit.epet.entity.Pet;

import java.util.HashMap;
import java.util.List;

public interface PetDao {
    public boolean insert(Pet pet ) ;
    public int del(Pet pet ) ;
    public boolean findPet( Pet pet ) ;
    public  int update( Pet pet ) ;
    Pet geBYtName( String  name ) ;
    public List<Pet> findByName(String name ) ;
    public List<HashMap> findById( String ID ) ;
}
