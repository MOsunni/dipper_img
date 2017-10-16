package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import entity.Authority_url;

/**
 * admin——uri管理员 权限 过滤器
 * @author 46098
 *	主要作用为检查该管理员是否可以访问该页面
 */
public class PermitFilter extends OncePerRequestFilter {
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
        String[] notFilter = new String[] {"login", "signin", "index","success" };
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
                // 从session中获取权限uri集合  
            	List<String> urlList =(List<String>) request.getSession().getAttribute("urlList");
                if (urlList != null) {
                	// 如果session中不存在集合 
                    // 设置request和response的字符集，防止乱码 
                	request.setCharacterEncoding("UTF-8");  
                    response.setCharacterEncoding("UTF-8");
                	for(String url:urlList){
                		//如果当前路径包含有不能访问的则跳转
                		if(uri.indexOf(url) != -1){
                			response.sendRedirect("/dipper_img/authority_error.jsp");
                		}else{
                			chain.doFilter(request, response); 
                		}
                	}
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
