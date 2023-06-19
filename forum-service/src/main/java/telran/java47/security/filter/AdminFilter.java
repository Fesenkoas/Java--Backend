package telran.java47.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import telran.java47.accounting.dao.UserAccountRepository;
import telran.java47.accounting.model.UserAccount;

@Component
@Order(20)
@RequiredArgsConstructor
public class AdminFilter implements Filter {

	final UserAccountRepository userAccountRepository;

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// System.out.println(request.getUserPrincipal().getName());
		boolean isAdmin;
		UserAccount userAccount = userAccountRepository.findById(request.getUserPrincipal().getName()).orElse(null);
		if (checkPathRoles(request.getMethod(), request.getServletPath())) {
			isAdmin = userAccount.getRoles().stream().anyMatch(r -> r.equals("Administrator"));
			if (isAdmin)
				chain.doFilter(request, response);

			else
				response.sendError(401);
		}
		if (checkPathUpdateAndDelete(request.getMethod(), request.getServletPath())) {
			isAdmin = userAccount.getRoles().stream().anyMatch(r -> r.equals("Administrator"));

			if (isAdmin || userAccount.getLogin().equals(request.getUserPrincipal().getName()))
				chain.doFilter(request, response);
			else
				response.sendError(401);
		}

	}

	private boolean checkPathRoles(String method, String path) {
		return (("DELETE".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method))
				&& path.matches("/account/user/\\w+/role/\\w+"));
	}

	private boolean checkPathUpdateAndDelete(String method, String path) {
		return (("DELETE".equalsIgnoreCase(method) || "PUT".equalsIgnoreCase(method))
				&& path.matches("/account/user/\\w+"));
	}
}