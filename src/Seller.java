/* Kyle Riley, Clare Harshey, Federico Ortiz
 * Group 38
 * 4/14/2017
 * Marketplace Project
 */

/**
 * Objects of this class represent sellers within a marketplace.
 */ 
public class Seller {
  
  //the seller's name
  private String name;
  
  //the seller's unique identification number
  private int sellerID;
  
  //the seller's e-mail address
  private String emailAddress;
  
  //the seller's account password
  private String password;
  
  /**
   * Constructs a new Seller whose name, email address, and password are
   * empty-string, and whose id is -1.
   */ 
  public Seller() {
    name = "";
    emailAddress = "";
    password = "";
    sellerID = -1;
  }
  
  /**
   * Constructs a new Seller who will have the given name, id, e-mail address,
   * and password.
   * @param name the name of the seller
   * @param id the id of the seller
   * @param email the e-mail address of the seller
   * @param password the password of the seller
   */ 
  public Seller(String name, int id, String email, String password) {
    this.name = name;
    sellerID = id;
    emailAddress = email;
    this.password = password;
  }
  
  
  /**
   * Returns the name of the seller.
   * @return the seller's name
   */ 
  public String getName() {
    return name;
  }
  
  /**
   * Sets the name of the seller to the given name
   * @return name the name that this seller will have
   */ 
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * Returns the seller's unique identification number.
   * @return the seller's id number
   */ 
  public int getID() {
    return sellerID;
  }
  
  /**
   * Sets the seller's unique identification number to the given id number.
   * @param id an id number that will uniquely represent the seller
   */ 
  public void setID(int id) {
    sellerID = id;
  }
  
  /**
   * Returns the seller's e-mail address.
   * @return the seller's e-mail address
   */ 
  public String getEmailAddress() {
    return emailAddress;
  }
  
  /**
   * Sets the seller's e-mail address to the given email address.
   * @param emailAddress the e-mail address that the seller will have
   */ 
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }
  
  /**
   * Returns the seller's account password
   * @return the seller's account password
   */ 
  public String getPassword() {
    return password;
  }
  
  /**
   * Sets the seller's account password to the given password.
   * @param password the password that the seller will use to login
   */ 
  public void setPassword(String password) {
    this.password = password;
  }
}