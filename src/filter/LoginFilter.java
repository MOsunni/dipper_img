package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * adminҳ���½������
 * @author 46098
 *	��Ҫ����Ϊ��̨ҳ�������Ա�Ƿ�Ϊ��½״̬
 */
public class LoginFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain chain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * �����˵�uri
		 * login:login.action
		 * admin_signin:��½����
		 * index����ҳ
		 * succes������
		 */
        String[] notFilter = new String[] {"error","login", "signin","success" };
        // �����uri
        String uri = request.getRequestURI();
        // uri�а���adminʱ�Ž��й���  
        if (uri.indexOf("admin") != -1) {  
            // �Ƿ����  
            boolean doFilter = true;
            //�жϲ����˵�uri
            for (String s : notFilter) {  
                if (uri.indexOf(s) != -1) {  
                    // ���uri�а��������˵�uri���򲻽��й���  
                    doFilter = false;  
                    break;  
                }  
            }
            if (doFilter) {  
                // ִ�й��� 
                // ��session�л�ȡ��¼��ʵ��  
                Object obj = request.getSession().getAttribute("username");  
                if (obj == null) {
                    // ���session�в����ڵ�¼��ʵ�壬�򵯳�����ʾ���µ�¼  
                    // ����request��response���ַ�������ֹ����  
                    request.setCharacterEncoding("UTF-8");  
                    response.setCharacterEncoding("UTF-8");
                    response.sendRedirect("/dipper_img/admin_signin.jsp");
                } else {  
                    // ���session�д��ڵ�¼��ʵ�壬�����  
                    chain.doFilter(request, response);  
                }  
            } else {  
                // �����ִ�й��ˣ������  
            	chain.doFilter(request, response);  
            }  
        } else {
            // ���uri�в�����admin�������  
        	chain.doFilter(request, response);  
        } 
	}
}
