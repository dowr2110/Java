package servlet;


import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Sss extends HttpServlet implements Servlet {
    public void init() throws ServletException {
        super.init();
    }

    protected void service(HttpServletRequest rq, HttpServletResponse rs)//получение параметров инициации
            throws ServletException, IOException {
        rs.setCharacterEncoding("CP1251");
        System.out.println("Servlet:servlet.Sss");
        String dir=rq.getServletContext().getInitParameter("doc-dir");
        File file=new File(dir+"/"+rq.getParameter("file"));
        OutputDoc(file,rs);
//        PrintWriter pw=rs.getWriter();
//        pw.println(dir);
//        pw.close();
    }

    protected void OutputDoc(File doc, HttpServletResponse rs)//Функция пересылающая клиенту Word
            throws IOException {
        rs.setContentType("application/msword");
        rs.addHeader("Content-Disposition", "attachment; filename="+
                doc.getName());
        rs.setContentLength((int) doc.length());

        FileInputStream in = new FileInputStream(doc);
        BufferedInputStream buf = new BufferedInputStream(in);
        ServletOutputStream out = rs.getOutputStream();
        int readBytes = 0;
        while ((readBytes = buf.read()) != -1)
            out.write(readBytes);
    }
}

