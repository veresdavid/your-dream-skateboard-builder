package models;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Egy rendelést reprezentáló osztály.
 */
public class Order {
	
	/**
	 * A megrendelni kívánt gördeszka.
	 */
	private Skateboard skateboard;
	/**
	 * A vásárló teljes neve.
	 */
	private String customerName;
	/**
	 * A vásárló címe.
	 */
	private String customerAddress;
	/**
	 * A vásárló telefonszáma.
	 */
	private String customerPhone;
	/**
	 * A vásárló e-mail címe.
	 */
	private String customerEmail;
	/**
	 * A vásárló megjegyzése a rendeléshez.
	 */
	private String customerComment;

	/**
	 * Visszaadja a megrendelni kívánt gördeszkát, egy {@link models.Skateboard} objektumot.
	 * 
	 * @return a megrendelni kívánt gördeszka, egy {@link models.Skateboard} objektum
	 */
	public Skateboard getSkateboard() {
		return skateboard;
	}

	/**
	 * Beállítja a megrendelni kívánt gördeszkát.
	 * 
	 * @param skateboard az a {@link models.Skateboard} objektum, ami a megrendelni kívánt gördeszka lesz
	 */
	public void setSkateboard(Skateboard skateboard) {
		this.skateboard = skateboard;
	}

	/**
	 * Visszaadja a vásárló teljes nevét.
	 * 
	 * @return a vásárló teljes neve
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Beállítja a vásárló teljes nevét.
	 * 
	 * @param customerName az a {@code String}, ami a vásárló teljes neve lesz
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * Visszaadja a vásárló címét.
	 * 
	 * @return a vásárló címe
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}

	/**
	 * Beállítja a vásárló címét.
	 * 
	 * @param customerAddress az a {@code String}, ami a vásárló címe lesz
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	/**
	 * Visszaadja a vásárló telefonszámát.
	 * 
	 * @return a vásárló telefonszáma
	 */
	public String getCustomerPhone() {
		return customerPhone;
	}

	/**
	 * Beállítja a vásárló telefonszámát.
	 * 
	 * @param customerPhone az a {@code String}, ami a vásárló telefonszáma lesz
	 */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	/**
	 * Visszaadja a vásárló e-mail címét.
	 * 
	 * @return a vásárló e-mail címe
	 */
	public String getCustomerEmail() {
		return customerEmail;
	}

	/**
	 * Beállítja a vásárló e-mail címét.
	 * 
	 * @param customerEmail az a {@code String}, ami a vásárló e-mail címe lesz
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * Visszaadja a vásárló megjegyzését.
	 * 
	 * @return a vásárló megjegyzése
	 */
	public String getCustomerComment() {
		return customerComment;
	}

	/**
	 * Beállítja a vásárló megjegyzését.
	 * 
	 * @param customerComment az a {@code String}, ami a vásárló megjegyzése lesz
	 */
	public void setCustomerComment(String customerComment) {
		this.customerComment = customerComment;
	}

	/**
	 * A rendelés sztring reprezentációját adja vissza. Ennek előállításához az 
	 * {@code org.apache.commons.lang3.builder.ReflectionToStringBuilder} osztályt
	 * használjuk fel.
	 * 
	 * @return a rendelés sztring reprezentációja
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
