/* Kyle Riley, Clare Harshey, Federico Ortiz
 * Group 38
 * 4/14/2017
 * Marketplace Project
 */

import java.time.LocalDateTime;

/**
 * An object of this class represents an order made by a buyer. 
 */ 
public class Order {
  
  //the unique order identification number
  private int orderID;
  
  //the id of the item that was bought
  private int itemID;
  
  //the id of the buyer who bought the item
  private int buyerID;
  
  //the id of the seller who sold the item
  private int sellerID;
  
  //specifies whether the item has been shipped
  private boolean shipped;
  
  //the date and time that this order was made
  private LocalDateTime dateAndTime;
  
  //the date and time that the order was shipped
  private LocalDateTime shippingDate;

  /**
   * Constructs a new Order that will have the given item, buyer, seller,
   * shipping status, and an order id of -1.
   * @param itemID the id of the item that was bought
   * @param buyerID the id of the person who made the order
   * @param sellerID the id of the person who is selling the item
   * @param shipped whether the item has been shipped or not
   */ 
  public Order(int itemID, int buyerID,
               int sellerID, boolean shipped) {
    orderID = -1;
    this.itemID = itemID;
    this.buyerID = buyerID;
    this.sellerID = sellerID;
    this.shipped = shipped;
  }
  
  /**
   * Constructs a new Order that has an order id, buyer id, Seller id, and
   * item id of -1; a shipped status of false, an order date-time of null, and
   * a shipping date of null;
   */ 
  public Order() {
    orderID = -1;
    itemID = -1;
    buyerID = -1;
    sellerID = -1;
    shipped = false;
  }
  
  /**
   * Returns this order's unique identification number.
   * @return this order's id number
   */ 
  public int getID() {
    return orderID;
  }
  
  /**
   * Sets this order's unique identification number to the given id number.
   * @param id an id number that will uniquely represent this order
   */ 
  public void setID(int id) {
    orderID = id;
  }
  
  /**
   * Returns this order's item id.
   * @return this order's item id
   */ 
  public int getItemID() {
    return itemID;
  }
  
  /**
   * Sets this order's item id.
   * @param item this order's item id
   */ 
  public void setItem(int itemID) {
    this.itemID = itemID;
  }
  
  /**
   * Returns this order's buyer id.
   * @return this order's buyer id
   */ 
  public int getBuyerID() {
    return buyerID;
  }
  
  /**
   * Sets this order's buyer id.
   * @param buyer a buyer id
   */ 
  public void setBuyerID(int buyerID) {
    this.buyerID = buyerID;
  }
  
  /**
   * Returns this order's seller id.
   * @return this order's seller id
   */ 
  public int getSellerID() {
    return sellerID;
  }
  
  /**
   * Sets this order's seller id.
   * @param seller a seller id
   */ 
  public void setSellerID(int sellerID) {
    this.sellerID = sellerID;
  }
  
  /**
   * Returns true if the item has been shipped.
   * @return true if item was shipped, or false if the item has not been
   *         shipped.
   */ 
  public boolean getShipped() {
    return shipped;
  }
  
  /**
   * Sets the shipping status of the item.
   * @param status true to set the item's status as shipped, 
   *               false to set the item's status as not shipped.
   */ 
  public void setShipped(boolean status) {
    shipped = status;
  }
  
  /**
   * Returns the date and time that this order was made.
   * @return the date and time that this order was made
   */
  public LocalDateTime getDateAndTime() {
    return dateAndTime;
  }
  
  /**
   * Sets this order's date and time.
   * @param dateAndTime the date and time that this order will have
   */
  public void setDateAndTime(LocalDateTime dateAndTime) {
    this.dateAndTime = dateAndTime;
  }
  
  /**
   * Returns the date that this order was shipped. If the order hasn't
   * been shipped, then returns null;
   */ 
  public LocalDateTime getShippingDate() {
    return shippingDate;
  }
  
  /**
   * Sets the date that this order was shipped.
   */ 
  public void setShippingDate(LocalDateTime dateAndTime) {
    shippingDate = dateAndTime;
  }
}