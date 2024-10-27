package pingtu_game.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;
import java.util.Random;


// 创建游戏界面类，继承自JFrame，并实现了KeyListener和ActionListener接口
public class gameui extends JFrame implements KeyListener, ActionListener {

    // 定义游戏胜利的状态
    int[][] win = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}};
    // 定义游戏的当前状态
    int[][] tm2 = new int[4][4];
    // 定义游戏的当前位置
    int x = 0;
    int y = 0;
    // 定义游戏的当前步数
    int step = 0;

    // 定义游戏的图片选择
    String[] choselist = {"0", "animal", "sport", "girl"};
    String chose = getrandomchose();
    int number = getrandomnum();

    // 初始化菜单选项
    JMenuItem replay = new JMenuItem("replay");
    JMenuItem relogin = new JMenuItem("relogin");
    JMenuItem close = new JMenuItem("close");

    JMenuItem blog = new JMenuItem("blog");

    JMenuItem girl = new JMenuItem("girl");
    JMenuItem animal = new JMenuItem("animal");
    JMenuItem sport = new JMenuItem("sport");


    // 游戏界面的构造函数
    public gameui() {

        initui();

        uimenu();

        ditnum();

        initimage();

        this.setVisible(true);
    }


    // 打乱游戏的状态
    private void ditnum() {
        int[] tm = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};


        Random r = new Random();
        for (int i = 0; i < tm.length; i++) {

            int index = r.nextInt(tm.length);

            int tmp = tm[i];
            tm[i] = tm[index];
            tm[index] = tmp;
        }

        for (int i = 0; i < tm.length; i++) {

            if (tm[i] == 0) {
                x = i / 4;
                y = i % 4;
            }

            tm2[i / 4][i % 4] = tm[i];
        }
    }

    // 初始化游戏的图片
    private void initimage() {

        this.getContentPane().removeAll();

        if (win()) {

            JLabel win = new JLabel(new ImageIcon("xiangmu\\image\\win.png"));
            win.setBounds(83, 134, 197, 73);

            this.getContentPane().add(win);

            this.getContentPane().repaint();


        }

        // 初始化游戏的图片
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {

                int num = tm2[j][i];

                ImageIcon img = new ImageIcon("image\\" + chose + "\\" + chose + number + "\\" + num + ".jpg");

                JLabel imgcn = new JLabel(img);

                imgcn.setBounds(105 * i + 83, 105 * j + 134, 105, 105);
                imgcn.setBorder(new BevelBorder(BevelBorder.LOWERED));

                this.getContentPane().add(imgcn);

            }
        }

        // 初始化游戏的背景图片
        {
            JLabel bg = new JLabel(new ImageIcon("image\\background.png"));
            bg.setBounds(40, 40, 508, 560);
            this.getContentPane().add(bg);
        }

        // 初始化游戏的步数
        JLabel stepc = new JLabel("step:" + step);
        stepc.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepc);

        this.getContentPane().repaint();
    }

    // 初始化游戏界面
    private void initui() {
        // 初始化游戏界面
        this.setSize(603, 680);
        this.setTitle("pingtu-game");
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.addKeyListener(this);
    }

    // 初始化游戏菜单
    private void uimenu() {
        // 初始化游戏菜单
        JMenuBar uibar = new JMenuBar();

        // 初始化游戏菜单表
        JMenu selectui = new JMenu("select");
        JMenu relateui = new JMenu("relate");

        JMenu choseimg = new JMenu("choseimg");

        // 绑定游戏菜单事件
        replay.addActionListener(this);
        relogin.addActionListener(this);
        close.addActionListener(this);

        blog.addActionListener(this);

        girl.addActionListener(this);
        animal.addActionListener(this);
        sport.addActionListener(this);


        // 插入游戏菜单表
        choseimg.add(girl);
        choseimg.add(animal);
        choseimg.add(sport);

        selectui.add(replay);
        selectui.add(relogin);
        selectui.add(close);
        selectui.add(choseimg);

        relateui.add(blog);


        // 插入游戏菜单
        uibar.add(selectui);
        uibar.add(relateui);

        this.setJMenuBar(uibar);

    }

    // 判断游戏是否胜利
    private boolean win() {

        for (int i = 0; i < tm2.length; i++) {
            for (int j = 0; j < tm2[i].length; j++) {

                if (tm2[i][j] != win[i][j]) return false;

            }
        }

        return true;

    }

    // 生成随机数
    private int getrandomnum() {
        int boundn = 8;
        if (Objects.equals(chose, "animal")) boundn = 8;
        else if (Objects.equals(chose, "girl")) boundn = 13;
        else if (Objects.equals(chose, "sport")) boundn = 10;

        Random rd = new Random();
        return rd.nextInt(1,boundn);
    }

    // 生成随机选择
    private String getrandomchose() {
        chose = "";
        Random rd = new Random();
        int r = rd.nextInt(1,3);

        return choselist[r];
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 65) {

            this.getContentPane().removeAll();

            JLabel all = new JLabel(new ImageIcon("image\\" + chose + "\\" + chose + number + "\\all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);


            JLabel bg = new JLabel(new ImageIcon("image\\background.png"));
            bg.setBounds(40, 40, 508, 560);
            this.getContentPane().add(bg);

            this.getContentPane().repaint();


        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int num = e.getKeyCode();

        if (win()) {
            return;
        }

        if (num == 37) {
            if (y == 3) {
                return;
            }
            tm2[x][y] = tm2[x][y + 1];
            tm2[x][y + 1] = 0;
            y += 1;

            step++;
        } else if (num == 38) {

            if (x == 3) {
                return;
            }
            tm2[x][y] = tm2[x + 1][y];
            tm2[x + 1][y] = 0;
            x += 1;

            step++;

        } else if (num == 39) {
            if (y == 0) {
                return;
            }
            tm2[x][y] = tm2[x][y - 1];
            tm2[x][y - 1] = 0;
            y -= 1;

            step++;

        } else if (num == 40) {

            if (x == 0) {
                return;
            }
            tm2[x][y] = tm2[x - 1][y];
            tm2[x - 1][y] = 0;
            x -= 1;

            step++;

        } else if (num == 65) {
            initimage();
        } else if (num == 87) {
            tm2 = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}};

            initimage();
        }

        initimage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == replay) {
            step = 0;

            chose = getrandomchose();
            number = getrandomnum();

            ditnum();

            initimage();
        } else if (obj == relogin) {
            this.setVisible(false);
            new loginui();
        } else if (obj == close) {
            System.exit(0);
        } else if (obj == blog) {
            JDialog dm = new JDialog();


            JLabel dml = new JLabel(new ImageIcon("xiangmu\\image\\damie.jpg"));

            dml.setBounds(0, 0, 99, 100);


            dm.getContentPane().add(dml);

            dm.setSize(500, 500);
            dm.setAlwaysOnTop(true);
            dm.setLocationRelativeTo(null);
            dm.setModal(true);
            dm.setVisible(true);

        } else if (obj == girl) {
            chose = choselist[3];
            number = getrandomnum();
            initimage();
        } else if (obj == animal) {
            chose = choselist[1];
            number = getrandomnum();
            initimage();
        } else if (obj == sport) {
            chose = choselist[2];
            number = getrandomnum();
            initimage();
        }
    }
}
