/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songnew;

import java.sql.SQLException;

/**
 *
 * @author dvson
 */
public class Run {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        MainFrame fMain = new MainFrame();
        fMain.loadData();
    }
}
