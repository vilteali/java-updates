package java13.bloques;

public class BloquesTexto {

	public static void main(String[] args) {
		// ANTES
		String html = "<html>\n" +
			    "   <body>\n" +
			    "      <p class=\"text\">Hello, Escapes</p>\n" +
			    "   </body>\n" +
			    "</html>\n";
		
		System.out.println(html);
		System.out.println("----------------------------------");
		
		// AHORA
		var a = "lalla";
		String html2 = """
			    <html>
			    a
			        <body>
			            <p class="text">Hello, Text Blocks</p>
			        </body>
			    </html>
			    """ +a;
		System.out.println(html2);
	}
}
