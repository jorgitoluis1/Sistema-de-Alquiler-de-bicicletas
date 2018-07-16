package utpl.proyectos.bisicletas.filter;

import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"*.html", "*.xhtml"})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Get the loginBean from session attribute
        HttpSession sesion = ((HttpServletRequest) request).getSession(true);
        // For the first application request there is no loginBean in the session so user needs to log in
        // For other requests loginBean is present but we need to check if user has logged in successfully
        String contextPath = ((HttpServletRequest) request).getContextPath();
        String url = ((HttpServletRequest) request).getRequestURL().toString();
        if (sesion.getAttribute("usuario") == null && !url.contains("index.html") && !url.contains("javax.faces.resource")) {
            ((HttpServletResponse) response).sendRedirect(contextPath + "/index.html");
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
