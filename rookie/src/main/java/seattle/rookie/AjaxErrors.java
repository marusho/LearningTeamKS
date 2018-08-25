package seattle.rookie;

class AjaxErrors {
	  private String fields;
	  private String messages;	  

	  public AjaxErrors(String fields, String messages) {
	    this.fields = fields;
	    this.messages = messages;
	  }

	  public String toString() {
	    return "fields=" + fields + ", messages=" + messages;
	  }
}