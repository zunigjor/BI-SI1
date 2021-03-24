package fit.cvut.si1.semestralka.tattooPro.web.html.generator;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Class that stores html that all .jsp files have in common
 */
public class HtmlGenerator {

    /**
     * Page header
     */
    public static String getHeader() {

        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
            return 
            "<header class=\"main-header\">\n" +
	            "<div class=\"container\">\n" +
	            	"<a href=\"/\">\n" +
		            	"<h1 class=\"mh-logo\">\n" +
		            		"<img src=\"/source/Logo_L.svg\" class=\"logo-img\" alt=\"TATTOO-pro\">\n" +
			            "</h1>\n" +
		            "</a>\n" +
		            "<nav class=\"main-nav\">\n" +
			            "<ul>\n" +
				            "<li>\n" +
				            	"<a href=\"/users/artists\">Artists</a>\n" +
				            "</li>\n" +
				            "<li>\n" +
					           	"<a href=\"/users/customers\">Customers</a>\n" +
				            "</li>\n" +
				            "<li>\n" +
					            "<a href=\"/info\">Info</a>\n" +
				            "</li>\n" +
				            "<li>\n" +
					            "<a href=\"/myprofile\">Profile</a>\n" +
				            "</li>\n" +
				            "<li>\n" +
					            "<a href=\"/myprofile/messages/received\">Messages</a>\n" +
				            "</li>\n" +
				            "<li>\n" +
					            "<a href=\"/logout\">Log out</a>\n" +
				            "</li>\n" +
			            "</ul>\n" +
		            "</nav>\n" +
	            "</div>\n" +
            "</header>";
        }
        return 
        "<header class=\"main-header\">\n" +
	        "<div class=\"container\">\n" +
		        "<a href=\"/\">\n" +
			        "<h1 class=\"mh-logo\">\n" +
			        	"<img src=\"/source/Logo_L.svg\" class=\"logo-img\" alt=\"TATTOO-pro\">\n" +
			        "</h1>\n" +
		        "</a>\n" +
		        "<nav class=\"main-nav\">\n" +
			        "<ul>\n" +
				        "<li>\n" +
					        "<a href=\"/users/artists\">Artists</a>\n" +
				        "</li>\n" +
				        "<li>\n" +
					        "<a href=\"/users/customers\">Customers</a>\n" +
				        "</li>\n" +
				        "<li>\n" +
					        "<a href=\"/info\">Info</a>\n" +
				        "</li>\n" +
				        "<li>\n" +
					        "<a href=\"/login\">Log in</a>\n" +
				        "</li>\n" +
			        "</ul>\n" +
		        "</nav>\n" +
	        "</div>\n" +
        "</header>";
    }
}