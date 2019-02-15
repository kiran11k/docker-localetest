package com.pf;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.*;
import static java.lang.System.out;

public class ShowLanguageAndLocale {
	
    public static void main(String[] args) {
		// System properties
        out.println();
        final String[] sysProps = {"os.name", "os.version", "user.language", "user.country", "user.timezone", "file.encoding"};
        Arrays.stream(sysProps)
                .forEach(prop -> {
                    out.print(prop + " : ");
                    out.println(System.getProperty(prop));
                });
			
        // Defaults
        out.println();
        out.println("TimeZone : " + Calendar.getInstance().getTimeZone().getDisplayName());
        out.println("Time     : " + DateFormat.getDateTimeInstance().format(new Date()));
		out.println("Currency : " + NumberFormat.getCurrencyInstance().getCurrency());
		out.println("Locale   : " + Locale.getDefault());
        out.println("Charset  : " + Charset.defaultCharset());
        out.println("Encoding : " + getEncoding());
    }
	
   /**
    * Supplies the default encoding without using Charset.defaultCharset()
    * and without accessing getProperty("file.encoding").
    *
    * @return Default encoding (default charset).
    */
	public static String getEncoding() {
		final byte [] bytes = {'D'};
		final InputStream inputStream = new ByteArrayInputStream(bytes);
		final InputStreamReader reader = new InputStreamReader(inputStream);
		final String encoding = reader.getEncoding();
		return encoding;
   }
}