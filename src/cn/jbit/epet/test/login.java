package cn.jbit.epet.test;

import cn.jbit.epet.dao.MasterDao;
import cn.jbit.epet.daoimpl.MasterDaoSQLSever;
import cn.jbit.epet.entity.Master;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame implements ActionListener {

    private Master master ;
    private JButton loginbuttton ;
    private JTextField name_t , password_t ;
    private JLabel name_label , password_label ;

    public login(){
        this.setLayout(null);
        Init();
        master = new Master() ;
        loginbuttton= new JButton("登录");
        loginbuttton.setBounds(180, 170, 60 , 30 );
        loginbuttton.addActionListener(this);
        this.add(loginbuttton);

        name_t = new JTextField() ;
        name_t.setBounds(180,100,80,25);
        name_t.addActionListener(this);
        this.add(name_t);
        password_t = new JTextField() ;
        password_t.setBounds(180,130,80,25);
        password_t.addActionListener(this);
        this.add(password_t);



        name_label = new JLabel("用户名：");
        name_label.setBounds(100 , 100 ,80 , 30 );
        this.add(name_label);
        password_label = new JLabel("密码:");
        password_label.setBounds(100 , 130 , 80 , 30 );
        this.add(password_label) ;
        this.setVisible(true);
    }
    public void Init(){
        this.setTitle("宠物系统");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Color.CYAN);
        this.setSize(400 , 300);
    }


    public static void main(String[] args){
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginbuttton){
            String login = name_t.getText();
            String password = password_t.getText() ;
            master.setLoginid(login.trim());
            master.setPassword(password.trim());
            MasterDao masterDao = new MasterDaoSQLSever() ;
            if(masterDao.findMaster(master)){
                // JOptionPane.showMessageDialog(null , "欢迎使用"+login);
                new mainMenu();
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null , "用户名或密码错误,请重新输入。");
            }
        }
    }

}
