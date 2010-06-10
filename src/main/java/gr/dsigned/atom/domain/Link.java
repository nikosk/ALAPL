package gr.dsigned.atom.domain;

//<link rel="alternate" href="http://prasinanea.gr/football/article104938.ece" /> 
//<link rel="enclosure" type="image/jpeg" href="http://prasinanea.gr/incoming/article104874.ece/BINARY/w300/670245.jpg" title="" /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104926.ece" title="Η Φιέστα του Παναθηναϊκού" /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104935.ece" title="Η Φιέστα του Παναθηναϊκού" /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104923.ece" title="Η φιέστα του Παναθηναϊκού" /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104925.ece" title="Η φιέστα του Παναθηναϊκού" /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104927.ece" title="Η Φιέστα του Παναθηναϊκού" /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104920.ece" title="Οι Αμαζόνες του Τριφυλλιού πανηγυρίζουν με τους οργανωμένους φιλάθλους." /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104932.ece" title="Η Φιέστα του Παναθηναϊκού" /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104929.ece" title="Η Φιέστα του Παναθηναϊκού" /> 
//<link rel="related" type="text/html" href="http://prasinanea.gr/football/article104937.ece" title="Η Φιέστα του Παναθηναϊκού" />

public class Link {

	private String rel;
	private String type;
	private String href;
	private String title;
	private String via;

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

}
