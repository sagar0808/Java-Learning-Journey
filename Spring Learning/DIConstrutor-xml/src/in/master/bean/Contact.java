package in.master.bean;

public class Contact {
    private String contactName;
    private String number;

    public Contact(String contactName, String number) {
	super();
	this.contactName = contactName;
	this.number = number;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
	return contactName + " , " + number;
    }
}
