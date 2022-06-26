import bean.Student;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/a","/b","/c"})
public class StuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String meth=request.getServletPath();
        HttpSession hs= request.getSession(false);
        if(hs!=null&&hs.getAttribute("user")!=null){
            if("/a".equals(meth)){
                doList(request,response);
            }else if("/b".equals(meth)){

            }else if("/c".equals(meth)){

            }
        }

    }

    private void doList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Cookie c=new Cookie("sfd","sdfd");
        String sql=null;
        List<Student> stus=new ArrayList<>();
        try{
            conn=DbTool.connect();
            sql="select Sno,Sname from student";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                String no=rs.getString("Sno");
                String name=rs.getString("Sname");
                Student stu=new Student(no,name);
                stus.add(stu);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        request.setAttribute("stus",stus);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

}
