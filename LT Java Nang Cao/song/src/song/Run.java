package song;

import java.sql.SQLException;

/**
 *
 * @author dvson
 */
public class Run {
    public static void main(String[] args) throws SQLException {
        MainFrame frame = new MainFrame();
        frame.loadData();
    }
}
