package com.huangxw.zk;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

public class MyTest extends JFrame implements ActionListener {
    
    private JButton btBlue,btDialog;
    
    public MyTest() {
        this.setTitle("Java GUI 事件监听处理！");
        this.setBounds(100,100,500,350);
        this.setLayout(new FlowLayout());
        btBlue = new JButton("蓝色");
        btDialog = new JButton("弹窗");
        
        //将按钮添加事件监听器
        btBlue.addActionListener(this);
        btDialog.addActionListener(this);
        
        this.add(btBlue);
        this.add(btDialog);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btBlue) {
            Container c = getContentPane();
            c.setBackground(Color.BLUE);
        } else if( e.getSource() == btDialog) {
            JDialog dialog = new JDialog();
            dialog.setBounds(300,200,400,300);
            dialog.setVisible(true);
        }
    }
    
    public static void main(String[] args) throws IOException {
        //MyTest my = new MyTest();
        ClassPathResource resource = new ClassPathResource("ContextLoader.properties", ContextLoader.class);
        Properties defaultStrategies = PropertiesLoaderUtils.loadProperties(resource);
        
        String contextClassName = defaultStrategies.getProperty(WebApplicationContext.class.getName());
    }
}
