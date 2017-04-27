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
  
  //the item that was bought
  private int itemID;
  
  //the buyer who bought the item
  private int buyerID;
  
  //the seller who sold the item
  private int sellerID;
  
  //specifies whether the item has been shipped
  private boolean shipped;
  
  //the date and time that this order was made
  private LocalDateTime dateAndTime;
  

  /**
   * Constructs a new Order that will have the given order id number, item,
   * buyer, seller, and shipping status.
   * @param itemID the ID of the item that was bought
   * @param buyerID the ID of the person who made the order
   * @param sellerID the ID of the person who is selling the item
   * @param shipped whether the item has been shipped or not
   */ 
  public Order(int itemID, int buyerID,
               int sellerID, boolean shipped) {
    this.orderID = 0;
    this.itemID = itemID;
    this.buyerID = buyerID;
    this.sellerID = sellerID;
    this.shipped = shipped;
  }
  
  /**
   * Constructs a new Order that has an order id of -1; a Buyer, Seller, and
   * Item of null; a shipped status of false, and an order date-time of null.
   */ 
  public Order() {
    orderID = -1;
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
   * Returns this order's item ID.
   * @return this order's itemID
   */ 
  public int getItemID() {
    return itemID;
  }
  
  /**
   * Sets this order's item ID.
   * @param itemID this order's itemID
   */ 
  public void setItem(int itemID) {
    this.itemID = itemID;
  }
  
  /**
   * Returns this order's buyer ID.
   * @return this order's buyer ID
   */ 
  public int getBuyerID() {
    return buyerID;
  }
  
  /**
   * Sets this order's buyer ID.
   * @param buyerID this order's buyerID
   */ 
  public void setBuyerID(int buyerID) {
    this.buyerID = buyerID;
  }
  
  /**
   * Returns this order's sellerID.
   * @return this order's sellerID
   */ 
  public int getSellerID() {
    return sellerID;
  }
  
  /**
   * Sets this order's seller.
   * @param sellerID a seller ID
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
}
