package servlet;

import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;


@WebServlet(name = "WebDav", urlPatterns = "/WebDav")
@MultipartConfig
public class Sss extends HttpServlet implements Servlet {
    public void init() throws ServletException {
        super.init();
    }

    protected void service(HttpServletRequest rq,  HttpServletResponse rs)
            throws ServletException, IOException {

        rs.setCharacterEncoding("CP1251");
        PrintWriter pw = rs.getWriter();

        Sardine sardine=SardineFactory.begin("user", "password");

        String type=rq.getParameter("type");
        String URL=getServletContext().getInitParameter("url");

        if(type.equals("Create Directory")) {
            sardine.createDirectory(URL+"/"+rq.getParameter("dir-name"));
            pw.println("Directory was successfully created");
            pw.close();
        }
        else if(type.equals("Upload"))
        {
            Part partFile = rq.getPart("file");
            InputStream fileStream=partFile.getInputStream();
            sardine.put(URL+"/"+getFileName(partFile),fileStream);
            pw.println("Successfully uploaded");
            pw.close();
        }
        else if(type.equals("Download")) {
            pw.println(URL+"/"+rq.getParameter("file"));
            InputStream fileStream= sardine.get(URL+"/"+rq.getParameter("file"));
            byte[] buffer=new byte[fileStream.available()];
            fileStream.read(buffer);

            File createFile=new File(getServletContext().getInitParameter("disk-dir")+rq.getParameter("file"));
            OutputStream outputStream=new FileOutputStream(createFile);
            outputStream.write(buffer);

            pw.println("Successfully downloaded");
            pw.close();
        }
        else if(type.equals("Copy"))
        {
            String dir1=rq.getParameter("dir1")==null?"":rq.getParameter("dir1");
            String dir2=rq.getParameter("dir2")==null?"":rq.getParameter("dir2");

            sardine.copy(URL+"/"+dir1+"/"+rq.getParameter("file"),URL+"/"+dir2+"/"+rq.getParameter("file"));
            pw.println("Successfully copy");
            pw.close();
        }
        else if(type.equals("Delete File"))
        {
            sardine.delete(URL+"/"+rq.getParameter("file"));
            pw.println("Successfully delete file");
            pw.close();
        }
    }
    private static String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
}
