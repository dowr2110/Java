import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import oracle.jdbc.pool.OracleDataSource;

public class Rrr1 extends HttpServlet implements Servlet {
    static String SqlPersonNumber = "select * from orders where fuelid=?";



    protected void doPost(HttpServletRequest rq,
                         HttpServletResponse rs)
            throws ServletException, IOException {
        //rs.setCharacterEncoding("CP1251");
        PrintWriter pw = rs.getWriter();
        String fuelid= rq.getParameter("fuelid");
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@172.20.10.4:1521:orcl");
            ods.setUser("system");
            ods.setPassword("Password123");
            Connection conn = ods.getConnection();



            PreparedStatement stm =
                    conn.prepareStatement(SqlPersonNumber);
            stm.setInt(1, Integer.parseInt(fuelid));
            ResultSet rss = stm.executeQuery();
            pw.println("<table>");
            int columns = rss.getMetaData().getColumnCount();
            // Перебор строк с данными
            while(rss.next()){
                for (int i = 1; i <= columns; i++){
                    pw.println(rss.getString(i)+" ");
                    // System.out.print(rss.getString(i) + "\t");
                }
                pw.println("<br>");
                // System.out.println();
            }
            pw.println("</table>");
            conn.close();
        }catch (SQLException e) {
            System.out.println("Rrr1:doGet:SQLException:" + e);
        }
    }

}