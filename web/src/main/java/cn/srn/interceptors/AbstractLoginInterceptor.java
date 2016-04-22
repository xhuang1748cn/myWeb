package cn.srn.interceptors;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Winter on 2016/4/19.
 */
public class AbstractLoginInterceptor extends AbstractInterceptor {

    protected void ajaxRequestReturn(HttpServletResponse response, String content) throws Exception {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write(content);
        out.flush();
        out.close();
    }
}
