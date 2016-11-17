//package co.jp.tagbangers.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.StandardPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
///**
// * Spring Securityの認証フィルタ設定などの基本的な設定が行われる
// */
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	/** 特定のリクエストに対してセキュリティ設定を無視する設定など、全体に関わる設定ができる **/
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/webjars/**", "/css/**");
//	}
//
//	/** 認可の設定、ログイン・ログアウトに関する設定 **/
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers("/login").permitAll()
//				.anyRequest().authenticated()
//				.and()
//				.formLogin().loginProcessingUrl("/login")
//				.loginPage("/login")
//				.failureUrl("/login?error")
//				.defaultSuccessUrl("/", true)
//				.usernameParameter("username")
//				.passwordParameter("password")
//				.and()
//				.logout()
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
//				.logoutSuccessUrl("/login")
//				.and()
//				.csrf().disable();
//	}
//
//	@Configuration
//	static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
//		@Autowired
//		UserDetailsService userDetailsService;
//
//		// パスワードをハッシュ化
//		@Bean
//		PasswordEncoder passwordEncoder() {
//			return new StandardPasswordEncoder();
//		}
//
//		@Override
//		public void init(AuthenticationManagerBuilder auth) throws Exception {
//			auth.userDetailsService(userDetailsService)
//					.passwordEncoder(passwordEncoder());
//		}
//	}
//}
