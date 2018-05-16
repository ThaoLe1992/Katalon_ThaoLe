package newpackage

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang.RandomStringUtils

import com.kms.katalon.core.annotation.Keyword
public class random_username {
	@Keyword
	def username (String uname){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMdd-HHmmss");
		LocalDateTime now = LocalDateTime.now();
		String user_name = "thao" + RandomStringUtils.random(3,uname) + dtf.format(now);
		return user_name;
	}
}
