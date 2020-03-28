package ui;

import model.Message;
import model.Type;
import service.MessageService;
import service.MessageServiceImpl;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.util.List;
import java.util.regex.Pattern;

public class Update {
    private JFrame jFrame;
    private JTextField nameText;
    private JButton search;
    private JPanel message;
    private JPanel mainPanel;
    private JTable resultTable;
    private JScrollPane jsp;
    private JButton back;
    MessageService messageService = new MessageServiceImpl();
    private static final String PHONENUMBER = "^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\\d{8})$";

    Update() {
        if (jFrame == null) {
            jFrame = new JFrame("更新信息");
        }
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[][] objects = {};
                String[] titles = {"编号", "姓名", "手机号码", "分组", "邮箱", "QQ号码", "备注"};
                String name = nameText.getText();
                DefaultTableModel defaultTableModel = new DefaultTableModel(objects, titles);
                List<Message> messageList = messageService.getMessageByName(name);
                for (Message m : messageList) {
                    defaultTableModel.addRow(new String[]{
                            String.valueOf(m.getId()), m.getName(), m.getPhoneNum(),
                            m.getType().getMessage(), m.getEmail(), m.getQqNum(), m.getRemark()
                    });
                }
                resultTable.setModel(defaultTableModel);
                TableColumn typeColumn = resultTable.getColumnModel().getColumn(3);

                JComboBox comboBox = new JComboBox();
                comboBox.addItem("办公");
                comboBox.addItem("个人");
                comboBox.addItem("商务");
                typeColumn.setCellEditor(new DefaultCellEditor(comboBox));
                resultTable.getModel().addTableModelListener(new TableModelListener() {
                    @Override
                    public void tableChanged(TableModelEvent e) {
                        int col = e.getColumn();
                        int row = resultTable.getSelectedRow();
                        String value = (String) resultTable.getValueAt(row, col);
                        if (col == 2) {
                            if (Pattern.matches(PHONENUMBER, value)) {
                                boolean result = messageService.updateMessage(name, col, value);
                                if (result) {
                                    JOptionPane.showMessageDialog(null, "修改成功！");
                                } else {
                                    JOptionPane.showMessageDialog(null, "修改失败！");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "手机号码不符合规则", "修改失败", 0);
                            }
                        } else {
                            if (value.equals(Type.PERSONAGE.getMessage())) {
                                value = String.valueOf(Type.PERSONAGE.getCode());
                            } else if (value.equals(Type.WORK.getMessage())) {
                                value = String.valueOf(Type.PERSONAGE.getCode());
                            } else if (value.equals(Type.BUSINESS.getMessage())) {
                                value = String.valueOf(Type.PERSONAGE.getCode());
                            }
                            boolean result = messageService.updateMessage(name, col, value);
                            if (result) {
                                JOptionPane.showMessageDialog(null, "修改成功！");
                            } else {
                                JOptionPane.showMessageDialog(null, "修改失败！");
                            }
                        }
                    }
                });
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PhoneBook phoneBook = new PhoneBook();
                ShowMenu.show("电话簿主页", phoneBook.getMainPanel());
            }
        });
    }

    public JPanel getMessage() {
        return message;
    }

    public JPanel getMainPanel() {
        return mainPanel;
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
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(10, 20, 10, 20), -1, -1));
        nameText = new JTextField();
        Font nameTextFont = this.$$$getFont$$$(null, -1, 18, nameText.getFont());
        if (nameTextFont != null) nameText.setFont(nameTextFont);
        mainPanel.add(nameText, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 40), null, 0, false));
        search = new JButton();
        search.setEnabled(true);
        Font searchFont = this.$$$getFont$$$(null, -1, 18, search.getFont());
        if (searchFont != null) search.setFont(searchFont);
        search.setText("查询");
        mainPanel.add(search, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 40), null, 0, false));
        message = new JPanel();
        message.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(10, 0, 0, 0), -1, -1));
        mainPanel.add(message, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        jsp = new JScrollPane();
        message.add(jsp, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        jsp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), null));
        resultTable = new JTable();
        resultTable.setAutoResizeMode(4);
        resultTable.setEnabled(true);
        Font resultTableFont = this.$$$getFont$$$(null, -1, 18, resultTable.getFont());
        if (resultTableFont != null) resultTable.setFont(resultTableFont);
        jsp.setViewportView(resultTable);
        back = new JButton();
        Font backFont = this.$$$getFont$$$(null, -1, 16, back.getFont());
        if (backFont != null) back.setFont(backFont);
        back.setText("返回主页");
        mainPanel.add(back, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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