package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * admin页面登陆过滤器
 * @author 46098
 *	主要作用为后台页面检查管理员是否为登陆状态
 */
public class LoginFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain chain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 不过滤的uri
		 * login:login.action
		 * admin_signin:登陆界面
		 * index：主页
		 * succes：测试
		 */
        String[] notFilter = new String[] {"error","login", "signin","success" };
        // 请求的uri
        String uri = request.getRequestURI();
        // uri中包含admin时才进行过滤  
        if (uri.indexOf("admin") != -1) {  
            // 是否过滤  
            boolean doFilter = true;
            //判断不过滤的uri
            for (String s : notFilter) {  
                if (uri.indexOf(s) != -1) {  
                    // 如果uri中包含不过滤的uri，则不进行过滤  
                    doFilter = false;  
                    break;  
                }  
            }
            if (doFilter) {  
                // 执行过滤 
                // 从session中获取登录者实体  
                Object obj = request.getSession().getAttribute("username");  
                if (obj == null) {
                    // 如果session中不存在登录者实体，则弹出框提示重新登录  
                    // 设置request和response的字符集，防止乱码  
                    request.setCharacterEncoding("UTF-8");  
                    response.setCharacterEncoding("UTF-8");
                    response.sendRedirect("/dipper_img/admin_signin.jsp");
                } else {  
                    // 如果session中存在登录者实体，则继续  
                    chain.doFilter(request, response);  
                }  
            } else {  
                // 如果不执行过滤，则继续  
            	chain.doFilter(request, response);  
            }  
        } else {
            // 如果uri中不包含admin，则继续  
        	chain.doFilter(request, response);  
        } 
	}
}
