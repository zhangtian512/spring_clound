package com.zt.ms.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RouteFilter extends ZuulFilter {

    @Override
    public String filterType(){
        System.out.println("++++++Zuul filterType+++++++");
        return "pre";
    }

    @Override
    public int filterOrder(){
        System.out.println("++++++Zuul filterOrder+++++++");
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        System.out.println("++++++Zuul shouldFilter+++++++");
        return true;
    }

    @Override
    public Object run() {
        System.out.println("++++++Zuul run+++++++");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            System.out.println("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        System.out.println("ok token:"+accessToken);
        return null;
    }
}
