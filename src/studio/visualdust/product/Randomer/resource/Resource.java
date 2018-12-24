package studio.visualdust.product.Randomer.resource;

import javax.swing.*;
import java.awt.*;

public class Resource {
    public JDialog aboutDialog = new JDialog();
    public static String softName = "Randomer";
    public static String version = "2019.1 Release";
    public static String author = "Studio.VisualDust";

    public Resource() {
        int WIDTH = 400;
        aboutDialog.setTitle("About");
        aboutDialog.setResizable(false);
        aboutDialog.setSize(WIDTH, 600);
        aboutDialog.setLayout(null);

        JLabel softNameLabel = new JLabel(softName, JLabel.CENTER);
        softNameLabel.setFont(new Font("微软雅黑", 0, 40));
        softNameLabel.setLocation(0, 30);
        softNameLabel.setSize(WIDTH, 40);
        softNameLabel.setForeground(new Color(0, 133, 255));
        aboutDialog.add(softNameLabel);

        JLabel versionLabel = new JLabel(version, JLabel.CENTER);
        versionLabel.setFont(new Font("微软雅黑", 0, 10));
        versionLabel.setLocation(0, softNameLabel.getY() + softNameLabel.getHeight());
        versionLabel.setSize(WIDTH, 10);
        versionLabel.setForeground(new Color(166, 166, 166));
        aboutDialog.add(versionLabel);

        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("微软雅黑", 0, 15));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setLocation(20, versionLabel.getY() + versionLabel.getHeight() + 50);
        scrollPane.setSize(WIDTH - 40, 200);
        textArea.append("Author : " + author + "\n" +
                "该项目地址:github.com/VisualDust/Randomer\n" +
                "最初为了上奥赛课点名而写\n" +
                "报告错误,你可以:\n"+
                "   1 发送一个issue\n"+
                "   2 发邮件给VisualDust@outlook.com\n\n"+
                "通过更快地点\"Next\"按钮击发现奇葩功能");
        aboutDialog.add(scrollPane);

    }

    public static void main(String[] args) {
        Resource resource = new Resource();
        resource.aboutDialog.setVisible(true);
    }
}
