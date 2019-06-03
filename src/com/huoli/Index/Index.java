package com.huoli.Index;

import com.huoli.BaseCharacter.BaseCharacter;
import com.huoli.BaseCharacter.HanShengShuaiGe.HanShengShuaiGe;
import com.huoli.BaseCharacter.ZhangWuJi.ZhangWuJi;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Index extends JFrame implements Runnable, ActionListener {

    private HashMap<String, BaseCharacter> own = new HashMap<>();
    private List<String> own1 = new ArrayList<>();
    private List<JButton> button = new ArrayList<>();
    private JPanel jp;
    private JLabel jlAttend;
    private JLabel jlShow;
    private JLabel jlInformation;
    private int width;
    private int height;
    private JScrollPane jsp;
    private JTextArea textInformation;
    private int page = 0;

    public Index() {
        super();
        textInformation = new JTextArea();
        jsp = new JScrollPane();
        jp = new JPanel();
        jlShow = new JLabel();
        jlInformation = new JLabel();
        jlAttend = new JLabel();
        button.add(new JButton("上一页"));
        button.add(new JButton("下一页"));
        button.add(new JButton("全部加入"));
        button.add(new JButton("新增人物"));
        button.add(new JButton("退出"));
        addOwn("汉生帅神");
        addOwn("汉生衰神");
        addOwn("汉生本体");
        button.add(new JButton("张无忌"));
        BaseCharacter zhangWuJi = new ZhangWuJi("张无忌", 10000, 10, 5);
        own.put("张无忌", zhangWuJi);
        for (int i = 0; i < button.size(); i++) {
            button.get(i).addActionListener(this);
        }
        width = 1200;
        height = 900;
        create();

    }

    private void addOwn(String state) {
        button.add(new JButton(state));
        BaseCharacter hanSheng = new HanShengShuaiGe(state, 10000, 10, 5);
        hanSheng.setSkill("帅帅帅衰衰衰最强大招");
        own.put(state, hanSheng);
    }

    private void create() {
        textInformation.setLayout(null);
        textInformation.setEditable(false);
        textInformation.setText("展示：\n");
        textInformation.setLineWrap(true);
        textInformation.setFont(new Font("楷体", Font.BOLD, 24));
        textInformation.setOpaque(false);
        textInformation.setVisible(true);
        jsp.setViewportView(textInformation);
        jsp.setBackground(new Color(46, 89, 100));
        jsp.setOpaque(true);
        jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setSize(width, height / 2 - height / 100);
        jsp.setLocation(0, 0);
        jsp.setVisible(true);
        this.setLayout(new GridLayout(2, 1));
        this.setSize(width, height);
        this.setLocation(400, 100);
        this.setBackground(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        jp.setLayout(new GridLayout(1, 2));
        jlAttend.setLayout(new GridLayout(3, 8));
        jlAttend.setBackground(Color.lightGray);
        jlAttend.setOpaque(true);
        for (int i = 0; i < button.size() && i < 9; i++) {
            jlAttend.add(button.get(i));
        }
        jp.add(jlAttend);
        jlShow.setLayout(new GridLayout(1, 1));
        jlShow.setBackground(new Color(45, 85, 100));
        jlShow.setOpaque(true);
        jp.add(jlShow);
        jp.setLocation(0, 0);
        jp.setBackground(null);
        jp.setOpaque(false);
        this.add(jp);
        jlInformation.setLocation(0, 0);
        jlInformation.setSize(width, height / 2);
        jlInformation.setBackground(null);
        jlInformation.setOpaque(false);
        jlInformation.add(jsp, BorderLayout.CENTER);
        jlInformation.setVisible(true);
        this.add(jlInformation);
        jlAttend.setVisible(true);
        jlShow.setVisible(true);
        jp.setVisible(true);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String state = e.getActionCommand();
        if (state.equals("退出")) {
            System.exit(0);
        }
        if (state.equals("下一页")) {
            page++;
            if (page * 4 + 8 < button.size()) {
                jlAttend.setVisible(false);
                jlAttend.removeAll();
                jlAttend.add(button.get(0));
                jlAttend.add(button.get(1));
                jlAttend.add(button.get(2));
                jlAttend.add(button.get(3));
                jlAttend.add(button.get(4));
                jlAttend.add(button.get(page * 4 + 5));
                jlAttend.add(button.get(page * 4 + 6));
                jlAttend.add(button.get(page * 4 + 7));
                jlAttend.add(button.get(page * 4 + 8));
                jlAttend.setVisible(true);
            } else if(page * 4 + 4 < button.size()){
                jlAttend.setVisible(false);
                jlAttend.removeAll();
                jlAttend.add(button.get(0));
                jlAttend.add(button.get(1));
                jlAttend.add(button.get(2));
                jlAttend.add(button.get(3));
                jlAttend.add(button.get(4));
                int j = 0;
                for (int i = page * 4 + 5; i < button.size(); i++) {
                    jlAttend.add(button.get(i));
                    j++;
                }
                for (int i = j; j < 4; j++) {
                    jlAttend.add(new JButton(""));
                }
                jlAttend.setVisible(true);
            } else {
                page--;
            }
        }
        if (state.equals("上一页")) {
            page--;
            if (page >= 0) {
                jlAttend.setVisible(false);
                jlAttend.removeAll();
                jlAttend.add(button.get(0));
                jlAttend.add(button.get(1));
                jlAttend.add(button.get(2));
                jlAttend.add(button.get(3));
                jlAttend.add(button.get(4));
                jlAttend.add(button.get(page * 4 + 5));
                jlAttend.add(button.get(page * 4 + 6));
                jlAttend.add(button.get(page * 4 + 7));
                jlAttend.add(button.get(page * 4 + 8));
                jlAttend.setVisible(true);
            } else {
                page++;
            }
        }
        if (state.equals("全部加入")) {
            own1.clear();
            Set<String> mapSet = own.keySet();
            Iterator<String> itor = mapSet.iterator();
            for (; itor.hasNext(); ) {
                own1.add(itor.next());
            }
        }
        if (state.equals("新增人物")) {
            JDialog dialog = new JDialog();
            dialog.setTitle("创建框");
            dialog.setModal(true);
            dialog.setSize(300, 200);
            dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            dialog.setLocationRelativeTo(null);
            //输入框
            JTextField jtf1 = new JTextField(10);
            JTextField jtf2 = new JTextField(10);
            JTextField jtf3 = new JTextField(10);
            JTextField jtf5 = new JTextField(10);
            JLabel jl1 = new JLabel("名(0-10字符):");
            JLabel jl2 = new JLabel("血量:");
            JLabel jl3 = new JLabel("护甲:");
            JLabel jl5 = new JLabel("伤害:");
            JPanel jp = new JPanel(new GridLayout(4, 2));
            jp.add(jl1);
            jp.add(jtf1);
            jp.add(jl2);
            jp.add(jtf2);
            jp.add(jl3);
            jp.add(jtf3);
            jp.add(jl5);
            jp.add(jtf5);
            JButton jb = new JButton("确定");
            JLabel jl4 = new JLabel("不超过10个字符:", JLabel.CENTER);
            jb.addActionListener(new ActionListener() {
                private int bl;
                private int ar;
                private int at;
                private boolean boolJudge = false;

                public void actionPerformed(ActionEvent e) {
                    if (jtf1.getText().length() > 10) {
                        String info = "请正确输入名！名不超过10个字符！";
                        jl4.setText(info);
                        return;
                    }
                    if (own.containsKey(jtf1.getText())) {
                        String info = "名已被占用！";
                        jl4.setText(info);
                        return;
                    }
                    if (jtf1.getText().equals("新增人物") || jtf1.getText().equals("上一页") || jtf1.getText().equals("下一页") || jtf1.getText().equals("全部加入") || jtf1.getText().equals("退出")) {
                        String info = "请勿与操作名相同！";
                        jl4.setText(info);
                        return;
                    }
                    if (jtf1.getText().length() == 0) {
                        String info = "请输入名！";
                        jl4.setText(info);
                        return;
                    }
                    bl = judge(jtf2.getText());
                    if (boolJudge) {
                        return;
                    }
                    ar = judge(jtf3.getText());
                    if (boolJudge) {
                        return;
                    }
                    at = judge(jtf5.getText());
                    if (boolJudge) {
                        return;
                    }
                    String sss = jtf1.getText();
                    own.put(sss, new HanShengShuaiGe(sss, bl, ar, at));
                    button.add(new JButton(sss));
                    dialog.setVisible(false);
                }

                private int judge(String str) {
                    int num = 0;
                    if (str.length() > 10 || str.length() == 0) {
                        String info = "请正确输入数字！";
                        jl4.setText(info);
                        boolJudge = true;
                        return 0;
                    }
                    for (int i = 0; i < str.length(); i++) {
                        if (str.charAt(i) < 48 || str.charAt(i) > 57) {
                            String info = "请正确输入数字！";
                            jl4.setText(info);
                            boolJudge = true;
                            return 0;
                        }
                        num = num * 10 + str.charAt(i) - 48;
                    }
                    boolJudge = false;
                    return num;
                }
            });
            dialog.add(jp);
            dialog.add(jl4, BorderLayout.NORTH);
            dialog.add(jb, BorderLayout.SOUTH);
            dialog.setVisible(true);
            // 监听新加入的角色
            button.get(button.size() - 1).addActionListener(this);
        }
        if (own.size() == 0) {
            addCharacter(state);
            return;
        }
        for (int i = 0; i < own1.size(); i++) {
            if (own1.get(i).equals(state)) {
                return;
            }
        }
        if (state.equals("张无忌")) {
            own1.add(state);
            textInformation.append(state + "加入战团！\r\n");
            textInformation.append("张无忌：乾坤大挪移天下无敌\r\n");
        }
        if (state.equals("汉生帅神")) {
            addCharacter(state);
            textInformation.append("帅神：我是世界第一帅!\r\n");
        }
        if (state.equals("汉生衰神")) {
            addCharacter(state);
            textInformation.append("衰神：天下武功，为衰不破！\r\n");
        }
        if (state.equals("汉生本体")) {
            addCharacter(state);
            textInformation.append("本体：我就是主宰\r\n");
        }
        if (own.containsKey(state)) {
            addCharacter(state);
        }
        Point p = new Point();
        p.setLocation(0, textInformation.getLineCount() * 100);
        jsp.getViewport().setViewPosition(p);
    }

    private void addCharacter(String state) {
        own1.add(state);
        textInformation.append(state + "加入战团！\r\n");
    }

    @Override
    public void run() {
        for (; true; ) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (own1.size() <= 1) {
                continue;
            }
            fight();
        }
    }

    private void fight() {
        int num0 = (int) (Math.random() * own1.size());
        int num1;
        do {
            num1 = (int) (Math.random() * own1.size());
        } while (num0 == num1);
        int numSkill = (int) (Math.random() * 2);
        String state = own1.get(num1);
        if (numSkill == 0) {
            textInformation.append(own.get(own1.get(num0)).getName() + "攻击" + own.get(state).getName() + "!\n");
            textInformation.append(own.get(state).getName() + "受到100点伤害！\n");
            own.get(state).setBoold(100);
        } else {
            textInformation.append(own.get(own1.get(num0)).getName() + "发动技能攻击" + own.get(state).getName() + "!\n");
            textInformation.append(own.get(state).getName() + "受到1000点伤害！\n");
            own.get(state).setBoold(1000);
        }
        if (own.get(state).getBoold() <= 0) {
            textInformation.append(own.get(state).getName() + "受到重伤退下战场！\n");
            own.get(own1.get(num1)).setBoold(10000);
            own1.remove(num1);
        } else {
            textInformation.append(own.get(state).getName() + "当前血量为：" + own.get(state).getBoold() + "!\n");
        }
        Point p = new Point();
        p.setLocation(0, textInformation.getLineCount() * 100);
        jsp.getViewport().setViewPosition(p);
    }
}
