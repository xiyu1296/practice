package pingtu_game.ui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class loginui extends JFrame implements MouseListener {


    //text bar
        JTextArea usrname = new JTextArea("input username");
        JPasswordField code = new JPasswordField();
    //loginbt
        JButton loginbt = new JButton("login");


    public loginui(){

        initloginui();

        initloginbt();

        inittext();

        initloginimg();

        this.setVisible(true);
    }

    private void inittext() {

        usrname.setBounds(170, 150, 200, 17);
        usrname.setVisible(true);
        this.getContentPane().add(usrname);

        code.setBounds(170, 180, 200, 17);
        code.setVisible(true);
        this.getContentPane().add(code);
    }

    private void initloginbt() {

        //login buttun
        loginbt.setBounds(100,250,100,50);
        loginbt.setVisible(true);
        loginbt.setIcon(new ImageIcon("E:\\java\\javacode\\xiangmu\\image\\login\\登录按钮.png"));
        loginbt.setBorderPainted(false);
        loginbt.setContentAreaFilled(false);
        loginbt.addMouseListener(this);
        this.getContentPane().add(loginbt);
    }

    private void initloginimg() {


        //username and code
        JLabel nameimg = new JLabel(new ImageIcon("E:\\java\\javacode\\xiangmu\\image\\login\\用户名.png"));
        nameimg.setBounds(100,150,47,17);
        this.getContentPane().add(nameimg);
        JLabel codeimg = new JLabel(new ImageIcon("E:\\java\\javacode\\xiangmu\\image\\login\\密码.png"));
        codeimg.setBounds(100,180,47,17);
        this.getContentPane().add(codeimg);


        //bg
        JLabel loginimg = new JLabel(new ImageIcon("E:\\java\\javacode\\xiangmu\\image\\login\\background.png"));
        loginimg.setBounds(0,0,470,390);
        this.getContentPane().add(loginimg);




    }

    public void initloginui(){
        //登录
        this.setSize(488,430);
        this.setTitle("login");
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

    }

    public void terifyuser(){
        //本处应该是调用数据库来进行检验，但是还没学到，后边再整。
        String username = usrname.getText();
        String usercode = code.getText();

        if ((Objects.equals(username, "xiyu1296"))&&(Objects.equals(usercode, "123456"))){
            this.setVisible(false);
            new gameui();
        }
        else{
            dialogerror();
        }

    }

    private void dialogerror() {
        JDialog dlerror = new JDialog();
        dlerror.setSize(100,100);
        dlerror.setAlwaysOnTop(true);
        dlerror.setModal(true);
        dlerror.setLocationRelativeTo(null);

        JLabel jlerror = new JLabel("error");
        jlerror.setBounds(0,0,80,80);
        dlerror.getContentPane().add(jlerror);

        dlerror.setVisible(true);


    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == loginbt){
            terifyuser();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == loginbt){
            loginbt.setIcon(new ImageIcon("E:\\java\\javacode\\xiangmu\\image\\login\\登录按下.png"));

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == loginbt){
            loginbt.setIcon(new ImageIcon("E:\\java\\javacode\\xiangmu\\image\\login\\登录按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
