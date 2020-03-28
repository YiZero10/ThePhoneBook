package ui;

import model.Message;
import service.MessageService;
import service.MessageServiceImpl;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PhoneBook {
    private JFrame frame;
    private JPanel mainPanel;
    private JButton getByType;
    private JButton getByName;
    private JButton delete;
    private JButton update;
    private JButton add;
    private JLabel title;
    private JPanel menuPanel;
    private JTable listTable;
    private JScrollPane tablePanel;
    private JButton 更多功能Button;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public PhoneBook() {
        MessageService messageService = new MessageServiceImpl();
        String[][] objects = {};
        String[] titles = {"编号", "姓名", "手机号码", "分组", "邮箱", "QQ号码", "备注"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(objects, titles) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        List<Message> messageList = messageService.getAllMessage();
        if (messageList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "暂无数据！");
        } else {
            for (Message m : messageList) {
                defaultTableModel.addRow(new String[]{
                        String.valueOf(m.getId()), m.getName(), m.getPhoneNum(),
                        m.getType().getMessage(), m.getEmail(), m.getQqNum(), m.getRemark()
                });
            }
            listTable.setModel(defaultTableModel);
        }

        getByType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Search searchView = new Search();
                ShowMenu.show("分类查询", searchView.getSearchPanel());
                if (frame != null)
                    frame.dispose();
            }
        });
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add addView = new Add();
                ShowMenu.show("添加信息", addView.getAddPanel());
                if (frame != null)
                    frame.dispose();
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete deleteView = new Delete();
                ShowMenu.show("修改信息", deleteView.getDeletePanel());
                if (frame != null)
                    frame.dispose();
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Update updateView = new Update();
                ShowMenu.show("修改信息", updateView.getMainPanel());
                if (frame != null)
                    frame.dispose();
//                menuPanel.setVisible(false);
//                frame.setTitle("修改信息");
//                frame.setContentPane(updateView.getMainPanel());
//                updateView.getMainPanel().setVisible(true);
            }
        });
        getByName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NameSearch nameSearch = new NameSearch();
                ShowMenu.show("查询", nameSearch.getNameSearchPanel());
                if (frame != null)
                    frame.dispose();
            }
        });

//        back.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("back");
//                JPanel panel = (JPanel) frame.getContentPane();
//                panel.setVisible(false);
//                menuPanel.setVisible(true);
//            }
//        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("手机簿主页");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.frame = frame;
        frame.setContentPane(phoneBook.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(900, 700);
        frame.setLocation(500, 60);
        frame.setVisible(true);
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.setBorder(BorderFactory.createTitledBorder(""));
        menuPanel = new JPanel();
        menuPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 6, new Insets(5, 28, 5, 28), -1, -1));
        mainPanel.add(menuPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        getByType = new JButton();
        Font getByTypeFont = this.$$$getFont$$$(null, -1, 20, getByType.getFont());
        if (getByTypeFont != null) getByType.setFont(getByTypeFont);
        getByType.setText("类别查询");
        menuPanel.add(getByType, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(763, 60), null, 0, false));
        tablePanel = new JScrollPane();
        tablePanel.setEnabled(true);
        Font tablePanelFont = this.$$$getFont$$$(null, -1, 16, tablePanel.getFont());
        if (tablePanelFont != null) tablePanel.setFont(tablePanelFont);
        tablePanel.setToolTipText("");
        menuPanel.add(tablePanel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tablePanel.setBorder(BorderFactory.createTitledBorder(null, "全部联系人", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, -1, 16, tablePanel.getFont())));
        listTable = new JTable();
        tablePanel.setViewportView(listTable);
        title = new JLabel();
        Font titleFont = this.$$$getFont$$$("Fira Code Retina", -1, 36, title.getFont());
        if (titleFont != null) title.setFont(titleFont);
        title.setHorizontalAlignment(0);
        title.setHorizontalTextPosition(0);
        title.setText("电话簿");
        menuPanel.add(title, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(65, 29), null, 0, false));
        getByName = new JButton();
        Font getByNameFont = this.$$$getFont$$$(null, -1, 20, getByName.getFont());
        if (getByNameFont != null) getByName.setFont(getByNameFont);
        getByName.setText("查询信息");
        menuPanel.add(getByName, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(763, 60), null, 0, false));
        delete = new JButton();
        Font deleteFont = this.$$$getFont$$$(null, -1, 20, delete.getFont());
        if (deleteFont != null) delete.setFont(deleteFont);
        delete.setText("删除信息");
        menuPanel.add(delete, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(763, 60), null, 0, false));
        add = new JButton();
        Font addFont = this.$$$getFont$$$(null, -1, 20, add.getFont());
        if (addFont != null) add.setFont(addFont);
        add.setText("添加信息");
        menuPanel.add(add, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(763, 60), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        menuPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        update = new JButton();
        Font updateFont = this.$$$getFont$$$(null, -1, 20, update.getFont());
        if (updateFont != null) update.setFont(updateFont);
        update.setText("修改信息");
        menuPanel.add(update, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(630, 60), null, 0, false));
        更多功能Button = new JButton();
        Font 更多功能ButtonFont = this.$$$getFont$$$(null, -1, 20, 更多功能Button.getFont());
        if (更多功能ButtonFont != null) 更多功能Button.setFont(更多功能ButtonFont);
        更多功能Button.setText("更多功能");
        menuPanel.add(更多功能Button, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(630, 60), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}