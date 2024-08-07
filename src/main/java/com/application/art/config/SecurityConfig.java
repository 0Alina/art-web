//package com.application.art.config;
//
////import com.application.art.security.CustomUserDetailsService;
////import com.application.art.service.UserService;
////import com.application.art.service.UserServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeHttpRequests((authorize) ->
//                        authorize
//                                .requestMatchers("/css/**", "/js/**", "/img/**", "/fonts/**", "/lib/**", "/contactform/**").permitAll()
//                                .requestMatchers("/index", "/blog", "/**").permitAll()
//                                .requestMatchers("/users").hasRole("ADMIN")
//                                .requestMatchers("/login").permitAll().anyRequest().authenticated()
//                );
//        return http.build();
//    }
//
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth
////                .userDetailsService(userDetailsService)
////                .passwordEncoder(passwordEncoder());
////    }
//
//}