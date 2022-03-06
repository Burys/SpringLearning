package com.springbootdata.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author longxiang
 * @Description
 * @create 2022/3/3 16:14
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
    //没有权限默认到登陆页面
        //定制登录页
        http.formLogin().loginPage("/toLogin").defaultSuccessUrl("/level3/3");

    //开启注销   注销成功回到首页
        http.logout().logoutSuccessUrl("/");
        http.csrf().disable();      //如果不能注销可能是因为这个原因
    //开启记住密码 cookie 默认保存两周，自定义保存参数
        http.rememberMe().rememberMeParameter("remember");
    }



    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //此处模拟从内存中获取，正常应该从数据库获取
        //密码编码：There is no PasswordEncoder mapped for the id "null"
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("root").password(new BCryptPasswordEncoder().encode("root")).roles("vip1","vip2","vip3")
                .and()
                .withUser("test").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}

