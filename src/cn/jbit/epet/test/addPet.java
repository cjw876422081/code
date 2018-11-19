package cn.jbit.epet.test;

import cn.jbit.epet.dao.PetDao;
import cn.jbit.epet.daoimpl.PetDaoSQLSever;
import cn.jbit.epet.entity.Pet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addPet extends JFrame implements ActionListener {
    public Pet pet;
    private JButton complete_b ;
    private JTextField id_t ,name_t ,health_t , love_t;
    private JLabel id , name , health , love ;

    public addPet(){
        this.setLayout(null);
        Init();
        id = new JLabel("请输入宠物ID：");
        id.setBounds(0 , 100 , 120 , 30 );
        this.add(id) ;
        name = new JLabel("请输入宠物名称：") ;
        name.setBounds(0, 200 , 120 , 30 );
        this.add(name) ;
        health = new JLabel("请输入宠物健康值：");
        health.setBounds(0 , 300 , 120 , 30 );
        this.add(health) ;
        love = new JLabel("请输入宠物亲密值：") ;
        love.setBounds(0 , 400 , 120 , 30 );
        this.add(love) ;

        id_t = new JTextField() ;
        id_t.setBounds(140 , 100 , 80 , 30 );
        this.add(id_t);
        name_t = new JTextField() ;
        name_t.setBounds(140 , 200 , 80 , 30 );
        this.add(name_t);
        health_t = new JTextField() ;
        health_t.setBounds(140 , 300 , 80 , 30 );
        this.add(health_t);
        love_t = new JTextField() ;
        love_t.setBounds(140 , 400 , 80 , 30 );
        this.add(love_t);

        complete_b = new JButton("完成");
        complete_b.setBounds(250 , 500, 60 , 30 );
        this.add(complete_b) ;
        complete_b.addActionListener(this);
        this.setVisible(true);


    }
    public void Init(){
        this.setTitle("添加宠物");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);
        this.setSize(400 , 600);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == complete_b){
            pet = new Pet() ;
            pet.setId(id_t.getText().trim());
            pet.setName(name_t.getText().trim());
            pet.setHealth(Integer.parseInt(health_t.getText().trim()));
            pet.setLove(Integer.parseInt(love_t.getText().trim()));
            PetDao petDao = new PetDaoSQLSever();
            String message = "插入不成功";
            if(petDao.insert(pet) ){
                message = "插入成功";
            }
            JOptionPane.showMessageDialog(null ,message );
            //  message = "插入成功";
            //JOptionPane.showMessageDialog(null ,message );
        }
    }
}
