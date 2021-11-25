package com.sms.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("SecurityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactory = new ShiroFilterFactoryBean();
        shiroFilterFactory.setSecurityManager(securityManager);
        /*
            anon : 无需认证，就可以访问
            authc : 必须认证，才能访问
            user : 必须拥有 “记住我”功能才能用
            perms : 拥有对某个资源的权限才能访问
            role : 拥有某个角色权限才能访问
         */
        //存放自定义Filter
        LinkedHashMap<String, Filter> filterMap = new LinkedHashMap<>();
        //配置自定义权限认证
        filterMap.put("perms",new PermissionsFilter());
        shiroFilterFactory.setFilters(filterMap);

        Map<String, String> map = new LinkedHashMap<>();
        //放行静态资源
        map.put("/static/**","anon");
        // 设置 请求,只有认证过才能访问
        map.put("/allScore","perms[admin]");
        map.put("/updateScore","authc");
        map.put( "/queryScoreByTeacherID","perms[\"admin,teacher\"]");
        map.put( "/queryScoreByStudentID","perms[\"admin,student,teacher\"]");
        map.put("/logout","logout");
        shiroFilterFactory.setFilterChainDefinitionMap(map);

        // 设置登录的请求
        shiroFilterFactory.setLoginUrl("/");
        shiroFilterFactory.setUnauthorizedUrl("/noauth");

        return shiroFilterFactory;
    }

    //2. securityManager -> DefaultWebSecurityManager
    // @Qualifier("userRealm") 指定 Bean 的名字为 userRealm
    // spring 默认的 BeanName 就是方法名
    // name 属性 指定 BeanName
    @Bean(name = "SecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurity(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //需要关联自定义的 Realm，通过参数把 Realm 对象传递过来
        securityManager.setRealm(userRealm);

        return securityManager;
    }

    //3.让 spring 托管自定义的 realm 类
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
