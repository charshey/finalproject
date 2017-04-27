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
  private Item item;
  
  //the buyer who bought the item
  private Buyer buyer;
  
  //the seller who sold the item
  private Seller seller;
  
  //specifies whether the item has been shipped
  private boolean shipped;
  
  //the date and time that this order was made
  private LocalDateTime dateAndTime;
  

  /**
   * Constructs a new Order that will have the given order id number, item,
   * buyer, seller, and shipping status.
   * @param orderID the order id number
   * @param item the item that was bought
   * @param buyer the person who made the order
   * @param seller the person who is selling the item
   * @param shipped whether the item has been shipped or not
   */ 
  public Order(int orderID, Item item, Buyer buyer,
               Seller seller, boolean shipped) {
    this.orderID = orderID;
    this.item = item;
    this.buyer = buyer;
    this.seller = seller;
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
   * Returns this order's item.
   * @return this order's item
   */ 
  public Item getItem() {
    return item;
  }
  
  /**
   * Sets this order's item.
   * @param item this order's item
   */ 
  public void setItem(Item item) {
    this.item = item;
  }
  
  /**
   * Returns this order's buyer.
   * @return this order's buyer
   */ 
  public Buyer getBuyer() {
    return buyer;
  }
  
  /**
   * Sets this order's buyer.
   * @param buyer a buyer
   */ 
  public void setBuyer(Buyer buyer) {
    this.buyer = buyer;
  }
  
  /**
   * Returns this order's seller.
   * @return this order's seller
   */ 
  public Seller getSeller() {
    return seller;
  }
  
  /**
   * Sets this order's seller.
   * @param seller a seller
   */ 
  public void setSeller(Seller seller) {
    this.seller = seller;
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