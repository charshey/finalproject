/* Kyle Riley, Clare Harshey, Federico Ortiz
 * Group 38
 * 4/14/2017
 * Marketplace Project
 */

/**
 * An object of this class represents an item within the marketplace.
 */ 
public class Item {
  //the name of the item
  private String name;
  
  //the unique item identification number
  private int itemID;
  
  //the brief description of the item
  private String description;
  
  //the id of the seller who sold the item
  private int sellerID;
  
  //the price of the item
  private String price;
  
  //the quantity of the item available in stock by the seller
  private int quantity;
  
  //the marketplace category that the item belongs to
  private String category;
  
  /**
   * Constructs a new Item whose name, description, price, and category
   * are empty-string, whose item id and seller id are -1, and whose quantity
   * is 0.
   */ 
  public Item() {
    name = "";
    description = "";
    price = "";
    category = "";
    itemID = -1;
    sellerID = -1;
    quantity = 0;
  }
  
  /**
   * Constructs a new Item that will have the given name, description, price, 
   * item id number, seller id number, quantity, and category.
   * @param name the name of the item
   * @param description the description of the item
   * @param price the price of the item
   * @param itemID the item id number
   * @param sellerID the serller id number
   * @param quantity the quantity of the item available
   * @param category the marketplace category that the item is in
   */ 
  public Item(String name, String description, String price, int itemID,
              int sellerID, int quantity, String category) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.itemID = itemID;
    this.sellerID = sellerID;
    this.quantity = quantity;
    this.category = category;
  }
  
  /**
   * Returns the name of the item.
   * @return the name of the item
   */ 
  public String getName() {
    return name;
  }
  
  /**
   * Sets the name of the item to the given name.
   * @param name the name that the item will have
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /**
   * Returns the item's unique identification number.
   * @return the item's id number
   */
  public int getID() {
    return itemID;
  }
  
  /**
   * Sets the items's unique identification number to the given id number.
   * @param id an id number that will uniquely represent the item
   */ 
  public void setID(int id) {
   itemID = id;
  }
  
  /**
   * Returns the description of the item.
   * @return the item description
   */
  public String getDescription() {
    return description;
  }
  
  /**
   * Sets the description of the item to the given description.
   * @param description a brief description of the item
   */
  public void setDescription(String description) {
   this.description = description;
  }
  
  /**
   * Returns the id of the seller.
   * @return the seller id number
   */
  public int getSellerID() {
    return sellerID;
  }
  
  /**
   * Sets the seller id to the given seller id number.
   * @param id a seller id number
   */
  public void setSellerID(int id) {
    sellerID = id;
  }
  
  /**
   * Returns the price of the item.
   * @return the price of the item
   */
  public String getPrice() {
    return price;
  }
  
  /**
   * Sets the price of the item.
   * @param price the price that the item will have
   */
  public void setPrice(String price) {
   this.price = price;
  }
  
  /**
   * Returns the quantity of this item that the seller has in stock.
   * @return the available quantity of this item
   */
  public int getQuantity() {
    return quantity;
  }
  
  /**
   * Sets the quantity of this item to the given amount.
   * @param quantity the quantity of this item that will be available
   *        to purchase
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  
  /**
   * Returns the marketplace category that the item belongs to.
   * @return the marketplace category that the item belongs to
   */
  public String getCategory() {
    return category;
  }
  
  /**
   * Sets the item's marketplace category to the given category.
   * @param category the marketplace category that the item will belong to
   */
  public void setCategory(String category) {
    this.category = category;
  }
}