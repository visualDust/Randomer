package studio.visualdust.product.Randomer.resource;

import javax.swing.*;
import java.awt.*;

public class Resource {
    public JDialog aboutDialog = new JDialog();
    public static String softName = "Randomer";
    public static String version = "2019.1 Release";
    public static String author = "Studio.VisualDust";
    public JLabel achiLabel = new JLabel("手速评级：普通用户", JLabel.CENTER);

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
        textArea.append(
                "当前版本特性：\n" +
                        "支持传参列表路径直接打开列表\n" +
                        "增加了文字过长自动缩小字号功能\n" +
                        "优化了老爷机显示\n" +
                        "优化了操作习惯\n" +
                        "完善了文件错误处理\n" +
                        "\n" +
                        "历史版本：\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n" +
                        "更新记录太长了我懒得写\n");
        aboutDialog.add(scrollPane);

        JLabel authorLabel = new JLabel("Author : " + author, JLabel.CENTER);
        authorLabel.setFont(new Font("微软雅黑", 0, 15));
        authorLabel.setSize(WIDTH, 15);
        authorLabel.setLocation(0, scrollPane.getY() + scrollPane.getHeight() + 20);
        authorLabel.setForeground(new Color(0, 160, 203));
        aboutDialog.add(authorLabel);

        JLabel addressLabel = new JLabel("github.com/VisualDust", JLabel.CENTER);
        addressLabel.setSize(WIDTH, 12);
        addressLabel.setLocation(0, authorLabel.getHeight() + authorLabel.getY() + 5);
        addressLabel.setFont(new Font("微软雅黑", 0, 12));
        addressLabel.setForeground(new Color(167, 167, 167));
        aboutDialog.add(addressLabel);

        JLabel aimLabel = new JLabel("最初为了上奥赛课点名而写", JLabel.CENTER);
        aimLabel.setSize(WIDTH, 12);
        aimLabel.setLocation(0, addressLabel.getHeight() + addressLabel.getY() + 5);
        aimLabel.setFont(new Font("微软雅黑", 0, 12));
        aimLabel.setForeground(new Color(167, 167, 167));
        aboutDialog.add(aimLabel);

        JLabel toReportLabel = new JLabel("报告错误,你可以:", JLabel.CENTER);
        toReportLabel.setSize(WIDTH, 12);
        toReportLabel.setLocation(0, aimLabel.getHeight() + aimLabel.getY() + 5);
        toReportLabel.setFont(new Font("微软雅黑", 0, 12));
        toReportLabel.setForeground(new Color(167, 167, 167));
        aboutDialog.add(toReportLabel);

        JLabel way1Label = new JLabel("1.发送一个issue", JLabel.CENTER);
        way1Label.setSize(WIDTH, 12);
        way1Label.setLocation(0, toReportLabel.getHeight() + toReportLabel.getY() + 5);
        way1Label.setFont(new Font("微软雅黑", 0, 12));
        way1Label.setForeground(new Color(167, 167, 167));
        aboutDialog.add(way1Label);

        JLabel way2Label = new JLabel("2.发邮件给VisualDust@outlook.com", JLabel.CENTER);
        way2Label.setSize(WIDTH, 12);
        way2Label.setLocation(0, way1Label.getHeight() + way1Label.getY() + 5);
        way2Label.setFont(new Font("微软雅黑", 0, 12));
        way2Label.setForeground(new Color(167, 167, 167));
        aboutDialog.add(way2Label);

        achiLabel.setSize(WIDTH, 15);
        achiLabel.setLocation(0, way2Label.getHeight() + way2Label.getY() + 10);
        achiLabel.setFont(new Font("微软雅黑", 0, 15));
        achiLabel.setForeground(new Color(167, 167, 167));
        aboutDialog.add(achiLabel);

        JLabel noteLabel1 = new JLabel("通过更快地点\"Next\"按钮击发现奇葩功能", JLabel.CENTER);
        noteLabel1.setSize(WIDTH, 12);
        noteLabel1.setLocation(0, achiLabel.getHeight() + achiLabel.getY() + 10);
        noteLabel1.setFont(new Font("微软雅黑", 0, 12));
        noteLabel1.setForeground(new Color(167, 167, 167));
        aboutDialog.add(noteLabel1);

        JLabel noteLabel2 = new JLabel("从外部批处理启动支持传参列表路径直接打开列表", JLabel.CENTER);
        noteLabel2.setSize(WIDTH, 12);
        noteLabel2.setLocation(0, noteLabel1.getHeight() + noteLabel1.getY() + 10);
        noteLabel2.setFont(new Font("微软雅黑", 0, 12));
        noteLabel2.setForeground(new Color(167, 167, 167));
        aboutDialog.add(noteLabel2);

    }

    public static void main(String[] args) {
        Resource resource = new Resource();
        resource.aboutDialog.setVisible(true);
    }
}
