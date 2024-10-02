package in.master.bean;

public class Contact {
    private String contactName;
    private String number;

    public Contact(String contactName, String number) {
	super();
	this.contactName = contactName;
	this.number = number;
    }

    @Override
    public String toString() {
	return contactName + " , " + number;
    }
}
