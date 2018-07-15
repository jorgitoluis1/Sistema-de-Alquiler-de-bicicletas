
package utpl.proyectos.bisicletas.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utpl.proyectos.bisicletas.controlador.LoginController;

public class LoginFilter  implements Filter {
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Get the loginBean from session attribute
        LoginController loginBean = (LoginController)((HttpServletRequest)request).getSession().getAttribute("loginController");
         
        // For the first application request there is no loginBean in the session so user needs to log in
        // For other requests loginBean is present but we need to check if user has logged in successfully
        if (loginBean == null || loginBean.getUsuario()==null) {
            String contextPath = ((HttpServletRequest)request).getContextPath();
            ((HttpServletResponse)response).sendRedirect(contextPath + "/index.xhtml");
        }
         
        chain.doFilter(request, response);
             
    }
 
    @Override
    public void init(FilterConfig config) throws ServletException {
        // Nothing to do here!
    }
 
    @Override
    public void destroy() {
        // Nothing to do here!
    }  
}