package topic.stub;

public class HtmlParser {

	private final String html;

	public HtmlParser(String html) {
		this.html = html;
	}

	public String extractTagContentForClass(String classname) {
		return stripFromNextCloseTag(stripToNextOpenTagEnd(afterClassDeclarationRaw(classname)));
	}

	private String stripFromNextCloseTag(String inTag) {
		return inTag.substring(0, inTag.indexOf("</"));
	}

	private String stripToNextOpenTagEnd(String inTagOpen) {
		return inTagOpen.substring(inTagOpen.indexOf(">") + 1);
	}

	private String afterClassDeclarationRaw(String classname) {
		String classDeclaration = "class=\"" + classname;
		int declarationEnd = html.indexOf(classDeclaration) + classDeclaration.length();
		return html.substring(declarationEnd);
	}

}
