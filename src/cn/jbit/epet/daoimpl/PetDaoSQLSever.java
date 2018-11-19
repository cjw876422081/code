package cn.jbit.epet.daoimpl;

import cn.jbit.epet.dao.JDBCUtil;
import cn.jbit.epet.dao.PetDao;
import cn.jbit.epet.entity.Pet;

import java.util.HashMap;
import java.util.List;

public class PetDaoSQLSever extends JDBCUtil implements PetDao {
    @Override
    public boolean insert(Pet pet) {
        boolean flag =false ;
        String sql = "insert into pet ( id , name ,  health , love ) values" +
                "(? , ? , ? , ? )" ;
        Object[] params = {pet.getId() , pet.getName() , pet.getHealth() , pet.getLove()};
        if (this.executeUpdate(sql , params) >0 ){
            flag = true ;
        }
        return flag ;
    }

    @Override
    public int del(Pet pet) {
        return 0;
    }

    @Override
    public boolean findPet(Pet pet) {
        return false;
    }

    @Override
    public int update(Pet pet) {
        return 0;
    }

    @Override
    public Pet geBYtName(String name) {
        return null;
    }

    @Override
    public List<Pet> findByName(String name) {
        return null;
    }

    @Override
    public List<HashMap> findById(String ID) {
        return null;
    }
}
