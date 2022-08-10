package review;

import javax.swing.*;

public class HeightCalc {
    public static void main(String[] args) {
        String height = JOptionPane.showInputDialog("请输入您的身高(cm)");
        String inform = "您的身高为"+ height+"cm." ;
        JOptionPane.showMessageDialog(null,inform);
    }
}
