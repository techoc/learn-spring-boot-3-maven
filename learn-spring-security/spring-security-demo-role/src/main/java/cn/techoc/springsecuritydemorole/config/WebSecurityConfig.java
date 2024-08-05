package cn.techoc.springsecuritydemorole.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthorityAuthorizationManager;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

@EnableWebSecurity  // 开启 WebSecurity
@EnableMethodSecurity   // 开启方法权限控制（注解）
@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 禁用 CSRF 保护
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        // 允许访问 OpenAPI 文档
                        .requestMatchers("/openapi/openapi.yml").permitAll()
                        .requestMatchers("/test/echo").permitAll()
                        .requestMatchers("/test/admin").access(authorizationManager())
                        .requestMatchers("/test/normal").hasRole("NORMAL")
                        // 其他请求需要认证
                        .anyRequest().authenticated()
                )
                // 默认登录
                .formLogin(Customizer.withDefaults())
//                .formLogin((formLogin) ->
//                        formLogin
//                                .usernameParameter("username")
//                                .passwordParameter("password")
//                                .loginPage("/authentication/login")
//                                .failureUrl("/authentication/login?failed")
//                                .loginProcessingUrl("/authentication/login/process")
//                )
                // 默认注销
                .logout(Customizer.withDefaults())
                // 使用基本认证
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }


    @Bean
    @ConditionalOnMissingBean(UserDetailsService.class)
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("normal").password("normal").roles("NORMAL").build());
        return manager;
    }

    @Bean
    public AuthorizationManager<RequestAuthorizationContext> authorizationManager() {
        return AuthorityAuthorizationManager.hasRole("ADMIN");
    }
}
