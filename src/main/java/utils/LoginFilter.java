package utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter("/*")
public class LoginFilter implements Filter {



	private final Logger logger = LoggerFactory.getLogger(LoginFilter.class);

	private static final String[] unsecuredPaths = { "/javax.faces.resource/", "/login.jsf" };

	private static boolean isUnsecuredPath(final String path) {
		for (final String unsecuredPath : LoginFilter.unsecuredPaths) {
			if (path.startsWith(unsecuredPath)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response,
			final FilterChain chain) throws IOException, ServletException {
		final HttpServletRequest req = (HttpServletRequest) request;
		final Object loggedInObject = req.getSession().getAttribute("loggedin");
		final boolean loggedIn = loggedInObject != null && loggedInObject instanceof Boolean && (Boolean) loggedInObject;

		if (loggedIn || LoginFilter.isUnsecuredPath(req.getServletPath())) {

			chain.doFilter(request, response);
		} else {
			logger.info("Not logged in. Redirecting {} to /login.jsf", req.getServletPath());

			final HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect(req.getContextPath() + "/login.jsf");
		}
	}

	@Override
	public void init(final FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}



}
