
import javax.servlet.annotation.WebServlet;import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


@WebServlet(name = "validaRegistro", urlPatterns = {"/servlet/validaRegistro"}, asyncSupported=true)
public class ValidaRegistro extends HttpServlet {
    
    ArrayList newUser = new ArrayList(5);
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ValidaRegistro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidaRegistro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = request.getParameter("user");
        String password1 = request.getParameter("Password1");
        String password2 = request.getParameter("Password2");
        String nombre = request.getParameter("Nombre");
        String apellidos = request.getParameter("Apellidos");
        String email = request.getParameter("e-mail");
        
        boolean b = false;
        ArrayList <ArrayList> dataBase = DataBase.dataBase;
        
        for(int a=0; a<dataBase.size(); a++){
            ArrayList uArray = dataBase.get(a);
            if(uArray.get(0)==user){
                session.setAttribute("USER",user);//que entre
            }else{
                //que no entre (user or pass are wrong)
            }
        }
        
        System.out.println("session = "+session.getAttribute("VALID"));
        response.sendRedirect(request.getContextPath()+"/Welcome.jsp"); // ????
        return;
    }
    
}
