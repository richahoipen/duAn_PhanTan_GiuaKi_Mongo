package entity;

public class PhoneNumbers 
{
	@Override
	public String toString() {
		return "PhoneNumbers [type=" + type + ", number=" + number + "]";
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	private String type, number;

	public PhoneNumbers(String type, String number) {
		super();
		this.type = type;
		this.number = number;
	}

	public PhoneNumbers() {
		super();
	}
	
}
