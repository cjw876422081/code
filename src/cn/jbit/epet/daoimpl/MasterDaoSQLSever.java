package cn.jbit.epet.daoimpl;

import cn.jbit.epet.dao.JDBCUtil;
import cn.jbit.epet.dao.MasterDao;
import cn.jbit.epet.entity.Master;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MasterDaoSQLSever extends JDBCUtil implements MasterDao {

    @Override
    public boolean findMaster(Master master) {
        boolean flag = false ;
        String sql = "select * from master where loginId = ?  and  password= ? " ;
        Object[] params = {master.getLoginid() , master.getPassword()} ;
        List<HashMap> listmaster = new ArrayList<>() ;
        listmaster  = this.executeQuery(sql , params) ;
        if ( listmaster.size() >  0 ){
            flag = true ;
        }
        return flag;
    }
}
