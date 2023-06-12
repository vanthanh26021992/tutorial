//package com.danh.erp.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//
//@Configuration
//@EnableWebMvcSecurity
//public class AuthProviderConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/login").permitAll()
//                .and()
//            .logout()
//                .permitAll();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .authenticationProvider(kerberosAuthenticationProvider());
//    }
//
//    @Bean
//    public KerberosAuthenticationProvider kerberosAuthenticationProvider() {
//        KerberosAuthenticationProvider provider =
//            new KerberosAuthenticationProvider();
//        SunJaasKerberosClient client = new SunJaasKerberosClient();
//        client.setDebug(true);
//        provider.setKerberosClient(client);
//        provider.setUserDetailsService(dummyUserDetailsService());
//        return provider;
//    }
//
//    @Bean
//    public DummyUserDetailsService dummyUserDetailsService() {
//        return new DummyUserDetailsService();
//    }
//
//}