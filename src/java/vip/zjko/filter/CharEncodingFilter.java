package vip.zjko.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@WebFilter(filterName = "CharEncodingFilter", urlPatterns = {"/*"})
public class CharEncodingFilter implements Filter {

    private FilterConfig config = null;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)  throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if ("get".equalsIgnoreCase(httpRequest.getMethod())) {
            GetHttpServletRequest wrapper = new GetHttpServletRequest(httpRequest, "UTF-8");
            chain.doFilter(wrapper, response);
        } else {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            //执行下一个过滤器（如果有的话,否则执行目标servlet）  
            chain.doFilter(request, response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void destroy() {
        System.out.println(this.config.getFilterName() + "被销毁");
        this.config = null;
    }

    class GetHttpServletRequest extends HttpServletRequestWrapper {

        private String encoding;

        public GetHttpServletRequest(HttpServletRequest request) {
            super(request);
        }

        public GetHttpServletRequest(HttpServletRequest request, String encoding) {
            super(request);
            this.encoding = encoding;
        }

        @Override
        public String getParameter(String name) {
            String value = super.getParameter(name);
            if (null != value) {
                try {
                    // tomcat默认以ISO8859-1处理GET传来的参数。把tomcat上的值用ISO8859-1获取字节流，再转换成UTF-8字符串 
                    value = new String(value.getBytes("ISO8859-1"), encoding);
                } catch (UnsupportedEncodingException e) {
                }
            }
            return value;
        }
    }
}
