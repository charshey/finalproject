/* Kyle Riley, Clare Harshey, Federico Ortiz
 * Group 38
 * 4/14/2017
 * Marketplace Project
 */

/**
 * Objects of this class represent buyers within a marketplace.
 */ 
public class Buyer {
  
  //the buyer's name
  private String name;
  
  //the buyer's unique identification number
  private int buyerID;
  
  //the buyer's e-mail address
  private String emailAddress;
  
  //the buyer's account password
  private String password;
  
  /**
   * Constructs a new Buyer whose name, email address, and password are
   * empty-string, and whose id is -1.
   */ 
  public Buyer() {
    name = "";
    emailAddress = "";
    password = "";
    buyerID = -1;
  }
  
  /**
   * Constructs a new Buyer who will have the given name, id, e-mail address,
   * and password.
   * @param name the name of the buyer
   * @param id the id of the buyer
   * @param email the e-mail address of the buyer
   * @param password the password of the buyer
   */ 
  public Buyer(String name, int id, String email, String password) {
    this.name = name;
    buyerID = id;
    emailAddress = email;
    this.password = password;
  }
  
  /**
   * Returns the name of the buyer.
   * @return the buyer's name
   */ 
  public String getName() {
    return name;
  }
  
  /**
   * Sets the buyer's name to the given name
   * @return name the name that the buyer will have
   */ 
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * Returns the buyer's unique identification number.
   * @return the buyer's id number
   */ 
  public int getID() {
    return buyerID;
  }
  
  /**
   * Sets the buyer's unique identification number to the given id number.
   * @param id an id number that will uniquely represent the buyer
   */ 
  public void setID(int id) {
    buyerID = id;
  }
  
  /**
   * Returns the buyer's e-mail address.
   * @return the buyer's e-mail address
   */ 
  public String getEmailAddress() {
    return emailAddress;
  }
  
  /**
   * Sets the buyer's e-mail address to the given email address.
   * @param emailAddress the e-mail address that the buyer will have
   */ 
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }
  
  /**
   * Returns the buyer's account password
   * @return the buyer's account password
   */ 
  public String getPassword() {
    return password;
  }
  
  /**
   * Sets the buyer's account password to the given password.
   * @param password the password that the buyer will use to login
   */ 
  public void setPassword(String password) {
    this.password = password;
  }
  
  /**
   * Buys an item from the marketplace.
   */ 
  public Order buy(Item item) {
    return new Order(item.getID(), buyerID, item.getSellerID(), false);
  }
}