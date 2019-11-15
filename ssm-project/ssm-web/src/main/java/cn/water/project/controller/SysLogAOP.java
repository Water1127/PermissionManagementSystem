package cn.water.project.controller;

import cn.water.project.dao.SysLogDao;
import cn.water.project.domain.SysLog;
import cn.water.project.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author Water
 * @date 2019/11/8 - 8:54
 * @description
 */
@Component
@Aspect
public class SysLogAOP {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysLogService logService;

    private Date visitTime; // 访问时间
    private Class clazz; // 访问的类
    private Method method; // 访问的方法

    /** 前置通知 */
    @Before("execution(* cn.water.project.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        /** 记录 开始访问的时间点 */
        visitTime = new Date();
        /** 获取 访问的类 */
        clazz = joinPoint.getTarget().getClass();
        /** 获取 访问的方法 */
        /* 获取 方法名 */
        String methodName = joinPoint.getSignature().getName();
        /* 获取 参数列表 */
        Object[] args = joinPoint.getArgs();
        /* 获取 无参的方法 */
        if (args==null||args.length==0){
            method = clazz.getMethod(methodName);
        /* 获取 带参的方法 */
        }else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, classArgs);
        }
    }

    /** 后置通知 */
    @After("execution(* cn.water.project.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception{
        /** 获取 访问的时长 */
        long time = new Date().getTime() - visitTime.getTime();
        if (clazz!=null && method!=null && clazz!=SysLogAOP.class){
            /* 获取 类上的@RequestMapping("/orders") */
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation!=null) {
                /* 获取 方法上的@RequestMapping(xxx) */
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation!=null) {
                    /** 获取 URL */
                    String[] classValues = classAnnotation.value();
                    String[] methodValues = methodAnnotation.value();
                    String url = classValues[0] + methodValues[0];
                    /** 获取 IP地址 */
                    String ip = request.getRemoteAddr();
                    /** 获取 用户名 */
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();
                    /** 设值 */
                    SysLog log = new SysLog();
                    log.setVisitTime(visitTime);
                    log.setMethod("[类名]"+clazz.getName()+"[方法名]"+method.getName());
                    log.setExecutionTime(time);
                    log.setIp(ip);
                    log.setUrl(url);
                    log.setUsername(username);
                    /** 调用 业务层方法 */
                    logService.save(log);
                }
            }

        }

    }




}
