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
 * admin����uri����Ա Ȩ�� ������
 * @author 46098
 *	��Ҫ����Ϊ���ù���Ա�Ƿ���Է��ʸ�ҳ��
 */
public class PermitFilter extends OncePerRequestFilter {
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
        String[] notFilter = new String[] {"login", "signin", "index","success" };
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
                // ��session�л�ȡȨ��uri����  
            	List<String> urlList =(List<String>) request.getSession().getAttribute("urlList");
                if (urlList != null) {
                	// ���session�в����ڼ��� 
                    // ����request��response���ַ�������ֹ���� 
                	request.setCharacterEncoding("UTF-8");  
                    response.setCharacterEncoding("UTF-8");
                	for(String url:urlList){
                		//�����ǰ·�������в��ܷ��ʵ�����ת
                		if(uri.indexOf(url) != -1){
                			response.sendRedirect("/dipper_img/authority_error.jsp");
                		}else{
                			chain.doFilter(request, response); 
                		}
                	}
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
