//package nl.hoogervorst.hc.adapter.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.csrf()
//                .disable()
//                .authorizeHttpRequests()
//                .anyRequest()
//                .authenticated();
//
//        http.oauth2ResourceServer()
//                .jwt();
//
//        http
//                .sessionManagement()
//                .sessionCreationPolicy(STATELESS);
//
//        return http.build();
//    }
//}
//
//package nl.hoogervorst.hc.adapter.config;
//
//        import org.springframework.context.annotation.Bean;
//        import org.springframework.context.annotation.Configuration;
//        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//        import org.springframework.security.web.SecurityFilterChain;
//
//        import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(authz -> authz
//                        .anyRequest().authenticated())
//                .oauth2ResourceServer(oauth2 -> oauth2
//                        .jwt())
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(STATELESS));
//
//        return http.build();
//    }
//}
