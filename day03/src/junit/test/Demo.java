package junit.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class Demo {

	String d = "1980-09-09";
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	//Date date = df.parse(d);
	
	DateLocaleConverter dic = new DateLocaleConverter();
}
