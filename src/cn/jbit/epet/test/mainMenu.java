package cn.jbit.epet.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainMenu extends JFrame implements ActionListener {
    private JMenuBar menuBar1 ;
    private JMenu baseManagerMenu ;
    private JMenu searchMenu ;
    private JMenuItem baseadd , basedel , basealter ;
    private JMenuItem searchWithName , searchWithId ;

    public mainMenu(){
        this.setLayout(null);
        Init() ;
        this.setSize(800 , 600 );
        this.getContentPane().setBackground(Color.cyan);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    public void Init(){
        baseadd = new JMenuItem("购买宠物");
        baseadd.addActionListener(this);
        basealter = new JMenuItem("更改宠物");
        basealter.addActionListener(this);
        basedel = new JMenuItem("删除宠物");
        basedel.addActionListener(this);
        searchWithId = new JMenuItem("ID查询");
        searchWithId.addActionListener(this);
        searchWithName = new JMenuItem("名称查询");
        searchWithName.addActionListener(this);

        baseManagerMenu = new JMenu("宠物管理");
        searchMenu = new JMenu("宠物查询") ;

        baseManagerMenu.add(baseadd);
        baseManagerMenu.add(basealter);
        baseManagerMenu.add(basedel);

        searchMenu.add(searchWithId);
        searchMenu.add(searchWithName) ;

        menuBar1 = new JMenuBar() ;
        menuBar1.add(baseManagerMenu) ;
        menuBar1.add(searchMenu) ;
        setJMenuBar(menuBar1);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == baseadd ) {
            new addPet();
            this.dispose();
        }
        if (e.getSource() == basedel){
            new deletePet() ;
            this.dispose();
        }
        if (e.getSource() == basealter ) {
            new  updatePet() ;
            this.dispose();
        }
        if (e.getSource() == searchWithId){
            new searchById() ;
            this.dispose();
        }
        if (e.getSource() == searchWithName){
            new searchByName() ;
            this.dispose();
        }
    }
}
