/* Kyle Riley, Clare Harshey, Federico Ortiz
 * Group 38
 * 4/14/2017
 * Marketplace Project
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;

/**
 * This class simulates an online marketplace where people can buy and sell
 * items. The marketplace maintains the information on all the registered 
 * buyers and sellers, the items available for sale, and the orders made by
 * buyers.
 */ 
public class Marketplace {
  
  //contains all the buyers registered with the marketplace
  private ArrayList<Buyer> buyers;
  
  //contains all the sellers registered with the marketplace
  private ArrayList<Seller> sellers;
  
  //contains all the items available for sale through the marketplace
  private ArrayList<Item> items;
  
  //contains all the orders made by the buyers
  private ArrayList<Order> orders;
  
  //contains all the item categories of the marketplace
  private ArrayList<String> categories;
  
  //the currently logged in user
  private int currentUser;
  
  //the marketplace administrator's name
  private String adminName;
  
  //the marketplace administrator's password
  private String adminPassword;
  
  /**
   * Constructs a Marketplace.
   */
  public Marketplace() throws FileNotFoundException {
    buyers = new ArrayList<Buyer>();
    sellers = new ArrayList<Seller>();
    orders = new ArrayList<Order>();
    items = new ArrayList<Item>();
    categories = new ArrayList<String>();
    loadData();
  }
  
  /**
   * Writes the current state of the marketplace to the hard disk.
   * @throws FileNotFoundException if a file is not found
   */ 
  public void writeData() throws FileNotFoundException {
    writeBuyers();
    writeSellers();
    writeCategories();
    writeItems();
    writeAdmin();
  }
  
  /**
   * Writes the buyers into the buyers.txt file.
   * @throws FileNotFoundException if the buyers.txt file is not found
   *         and cannot be created
   */ 
  private void writeBuyers() throws FileNotFoundException {
    PrintWriter out = new PrintWriter("../data/buyers.txt");
    for (Buyer b : buyers) {
      out.println("%");
      out.println(b.getName());
      out.println(b.getID());
      out.println(b.getEmailAddress());
      out.println(b.getPassword());
    }
    out.close();
  }
  
  /**
   * Writes the sellers into the sellers.txt file.
   * @throws FileNotFoundException if the sellers.txt is not found and
   *         cannot be created
   */ 
  private void writeSellers() throws FileNotFoundException {
    PrintWriter out = new PrintWriter("../data/sellers.txt");
    for (Seller s : sellers) {
      out.println("%");
      out.println(s.getName());
      out.println(s.getID());
      out.println(s.getEmailAddress());
      out.print(s.getPassword());
    }
    out.close();
  }
  
  /**
   * Writes the categories into the categories.txt file.
   * @throws FileNotFoundException if the categories.txt file is not found and
   *         cannot be created
   */ 
  private void writeCategories() throws FileNotFoundException {
    PrintWriter out = new PrintWriter("../data/categories.txt");
    for (String c : categories) {
      out.println("%");
      out.println(c);
    }
    out.close();
  }
  
  /**
   * Writes the items into the items.txt file.
   * @throws FileNotFoundException if the items.txt file is not found and
   *         cannot be created
   */
  private void writeItems() throws FileNotFoundException {
    PrintWriter out = new PrintWriter("../data/items.txt");
    for (Item e : items) {
      out.println("%");
      out.println(e.getName());
      out.println(e.getID());
      out.println(e.getDescription());
      out.println(e.getSellerID());
      out.println(e.getPrice());
      out.println(e.getQuantity());
      out.println(e.getCategory());
    }
    out.close();
  }
  
  /**
   * Writes the orders into the orders.txt file.
   * @throws FileNotFoundException if the orders.txt file is not found and
   *         cannot be created
   */
  private void writeOrders() throws FileNotFoundException {
    PrintWriter out = new PrintWriter("../data/orders.txt");
    for (Order o : orders) {
      out.println("%");
      out.println(o.getID());
      out.println(o.getItem());
      out.println(o.getBuyer());
      out.println(o.getSeller());
      out.println(o.getDateAndTime());
      out.println(o.getShipped());
    }
    out.close();
  }
  
  /**
   * Writes the administrator credentials into the admin.txt file.
   * @throws FileNotFoundException if the admin.txt file is not found and
   *         cannot be created
   */
  private void writeAdmin() throws FileNotFoundException {
    PrintWriter out = new PrintWriter("../data/admin.txt");
    out.println(adminName);
    out.print(adminPassword);
    out.close();
  }
  
  /**
   * Loads a marketplace state from the hard disk.
   * @throws FileNotFoundException if a file is not found
   */ 
  public void loadData() throws FileNotFoundException {
    loadBuyers();
    loadSellers();
    loadCategories();
    loadItems();
    loadAdmin();
  }
  
  /**
   * Loads the buyers into the marketplace.
   * @throws FileNotFoundException if the buyers.txt file is not found
   */ 
  private void loadBuyers() throws FileNotFoundException {
    Scanner input = new Scanner(new File("../data/buyers.txt"));
    while (input.hasNextLine() && input.nextLine().equals("%")) {
      Buyer temp = new Buyer();
      temp.setName(input.nextLine());
      temp.setID(Integer.parseInt(input.nextLine()));
      temp.setEmailAddress(input.nextLine());
      temp.setPassword(input.nextLine());
      buyers.add(temp);
    }
    input.close();
  }
  
  /**
   * Loads the sellers into the marketplace.
   * @throws FileNotFoundException if the sellers.txt file is not found
   */ 
  private void loadSellers() throws FileNotFoundException {
    Scanner input = new Scanner(new File("../data/sellers.txt"));
    while (input.hasNextLine() && input.nextLine().equals("%")) {
      Seller temp = new Seller();
      temp.setName(input.nextLine());
      temp.setID(Integer.parseInt(input.nextLine()));
      temp.setEmailAddress(input.nextLine());
      temp.setPassword(input.nextLine());
      sellers.add(temp);
    }
    input.close();
  }
  
  /**
   * Loads the categories into the marketplace.
   * @throws FileNotFoundException if the categories.txt file is not found
   */ 
  private void loadCategories() throws FileNotFoundException {
    Scanner input = new Scanner(new File("../data/categories.txt"));
    while (input.hasNextLine() && input.nextLine().equals("%")) {
      categories.add(input.nextLine());
    }
    input.close();
  }
  
  /**
   * Loads the items into the marketplace.
   * @throws FileNotFoundException if the items.txt file is not found
   */ 
  private void loadItems() throws FileNotFoundException {
    Scanner input = new Scanner(new File("../data/items.txt"));
    while (input.hasNextLine() && input.nextLine().equals("%")) {
      Item temp = new Item();
      temp.setName(input.nextLine());
      temp.setID(Integer.parseInt(input.nextLine()));
      temp.setDescription(input.nextLine());
      temp.setSellerID(Integer.parseInt(input.nextLine()));
      temp.setPrice(input.nextLine());
      temp.setQuantity(Integer.parseInt(input.nextLine()));
      temp.setCategory(input.nextLine());
      items.add(temp);
    }
    input.close();
  }
  
  /**
   * Loads the orders into the marketplace.
   * @throws FileNotFoundException if the orders.txt file is not found
   */ 
  private void loadOrders() throws FileNotFoundException {
    Scanner input = new Scanner(new File("../data/orders.txt"));
    while (input.hasNextLine() && input.nextLine().equals("%")) {
      Order temp = new Order();
      int orderID = Integer.parseInt(input.nextLine());
      int itemID = Integer.parseInt(input.nextLine());
      int buyerID = Integer.parseInt(input.nextLine());
      int sellerID = Integer.parseInt(input.nextLine());
      LocalDateTime dateAndTime = (LocalDateTime.parse(input.nextLine()));
      boolean shippedStatus = Boolean.parseBoolean(input.nextLine());
      temp.setID(orderID);
      temp.setItem(itemID);
      temp.setBuyer(buyerID);
      temp.setSeller(sellerID);
      temp.setDateAndTime(dateAndTime);
      temp.setShipped(shippedStatus);
      orders.add(temp);
    }
    input.close();
  }
  
  /**
   * Loads the administrator credentials into the marketplace.
   * @throws FileNotFoundException if the admin.txt file is not found
   */ 
  private void loadAdmin() throws FileNotFoundException {
    Scanner input = new Scanner(new File("../data/admin.txt"));
    adminName = input.nextLine();
    adminPassword = input.nextLine();
  }
  
  /**
   * Returns the item that has the given item id. If no item is found that
   * has the given id, then null is returned.
   * @param id an item id
   * @return the item containing the supplied item id, or null if no item is
   *         found with that id
   */ 
  public Item searchItemsByID(int id) {
    for (Item e : items) {
      if (e.getID() == id) {
        return e;
      }
    }
    return null;
  }

  /**
   * Returns the buyer that has the given buyer id. If no buyer is found that
   * has the given id, then null is returned.
   * @param id a buyer id
   * @return the buyer containing the supplied buyer id, or null if no buyer is
   *         found with that id
   */ 
  public Buyer searchBuyersByID(int id) {
    for (Buyer b : buyers) {
      if (b.getID() == id) {
        return b;
      }
    }
    return null;
  }
  
  /**
   * Returns the seller that has the given seller id. If no seller is found that
   * has the given id, then null is returned.
   * @param id a seller id
   * @return the seller containing the supplied seller id, or null if no seller is
   *         found with that id
   */ 
  public Seller searchSellersByID(int id) {
    for (Seller s : sellers) {
      if (s.getID() == id) {
        return s;
      }
    }
    return null;
  }

  
  /**
   * Creates a new buyer or seller account on the marketplace.
   */ 
  public void createAccount() {
    
  }
  
  /**
   * Prompts the user to login. A user can login as either a seller, buyer, or
   * administrator.
   */
  public void login() {
  }
  
  /**
   * Prompts a seller to upload inventory to the marketplace.
   */
  public void uploadInventory() {
  }
  
  /**
   * Returns all of the items whose names contain the given keyword.
   * @param keyword the word or phrase to search for
   * @return an array list containing the items that have the keyword somewhere
   *         in their names.
   */ 
  public ArrayList<Item> searchItemsByKeyword(String keyword) {
    ArrayList<Item> matchingItems = new ArrayList<Item>();
    for (Item e : items) {
      if (e.getName().contains(keyword)) {
        matchingItems.add(e);
      }
    }
    return matchingItems;
  }
  
 
  /**
   * Returns all of the items that belong to the given marketplace category.
   * @param category a category of the marketplace
   * @return an array list containing the items that belong to the category.
   */
  public ArrayList<Item> searchItemsByCategory(String category) {
    ArrayList<Item> matchingItems = new ArrayList<Item>();
    for (Item e : items) {
      if (categories.contains(e.getCategory())) {
        matchingItems.add(e);
      }
    }
    return matchingItems;
  }
  
  /**
   * Returns all of the items that belong to the given seller.
   * @param seller a seller
   * @return an array list containing the items that belong to the seller.
   */ 
  public ArrayList<Item> searchItemsBySeller(Seller seller) {
    ArrayList<Item> matchingItems = new ArrayList<Item>();
    int id = seller.getID();
    for (Item e : items) {
      if (e.getSellerID() == id) {
        matchingItems.add(e);
      }
    }
    return matchingItems;
  }
  
  /**
   * Returns all of the orders that have been received by the given seller.
   * @param seller a seller
   * @return an array list containing the orders received by the seller
   */
  public ArrayList<Order> obtainSellerOrders(Seller seller) {
    ArrayList<Order> matchingOrders = new ArrayList<Order>();
    int id = seller.getID();
    for (Order o : orders) {
      if (o.getSeller() == id) {
        matchingOrders.add(o);
      }
    }
    return matchingOrders;
  }
  
  /**
   * Returns all of the orders that were made by the given buyer.
   * @param buyer a buyer
   * @return an array list containing the orders made by the buyer
   */ 
  public ArrayList<Order> obtainBuyerOrders(Buyer buyer) {
    ArrayList<Order> matchingOrders = new ArrayList<Order>();
    int id = buyer.getID();
    for (Order o : orders) {
      if (o.getBuyer() == id) {
        matchingOrders.add(o);
      }
    }
    return matchingOrders;
  }
  
  /**
   * Returns all of the items belonging to the given seller that are out of
   * stock.
   * @param seller a seller
   * @return an array list containing the given seller's out of stock items
   */
  public ArrayList<Item> checkOutOfStock(Seller seller) {
    ArrayList<Item> itemsBySeller = searchItemsBySeller(seller);
    ArrayList<Item> outOfStockItems = new ArrayList<Item>();
    for (Item e : itemsBySeller) {
      if (e.getQuantity() <= 0) {
         outOfStockItems.add(e);
      }
    }
    return outOfStockItems;
  }
  
  /**
   * Returns all of the orders made between the given beginning date-time and
   * the ending date-time.
   * @param beginning the beginning date-time
   * @param ending the ending date-time
   * @return the orders made between the beginning date-time and ending date-time
   */ 
  public ArrayList<Order> getOrdersBetweenDates(LocalDateTime beginning,
                                                LocalDateTime ending) {
    if (ending.isAfter(beginning)) {
      throw new IllegalArgumentException("beginning date-time is after " +
                                         "ending date-time");
    }
    
    ArrayList<Order> matchingOrders = new ArrayList<Order>();
    for (Order o : orders) {
      LocalDateTime dateAndTime = o.getDateAndTime();
      if (dateAndTime.isAfter(beginning) && dateAndTime.isAfter(ending)) {
        matchingOrders.add(o);
      }
    }
    return matchingOrders;
  }
  
  
  //some quick tests of the loadData and writeData methods. I'll create a JUnit client
  //for this stuff eventually.
  public static void main(String[] args) throws FileNotFoundException {
    Marketplace test = new Marketplace();
    for (Buyer b : test.buyers) {
      System.out.println("Name: " + b.getName());
      System.out.println("ID: " + b.getID());
      System.out.println("Password: " + b.getPassword());
      System.out.println("E-mail: " + b.getEmailAddress());
      System.out.println();
    }
    
    for (Seller s : test.sellers) {
      System.out.println("Name: " + s.getName());
      System.out.println("ID: " + s.getID());
      System.out.println("Password: " + s.getPassword());
      System.out.println("E-mail: " + s.getEmailAddress());
      System.out.println();
    }
    
    for (Item i : test.items) {
      System.out.println("Name: " + i.getName());
      System.out.println("ID: " + i.getID());
      System.out.println("Description: " + i.getDescription());
      System.out.println("Seller ID: " + i.getSellerID());
      System.out.println("Category: " + i.getCategory());
      System.out.println("Price: " + i.getPrice());
      System.out.println("Quantity: " + i.getQuantity());
      System.out.println();
    }
    
    for (Order o : test.orders) {
      System.out.println("ID: " + o.getID());
      System.out.println("Seller: " + test.searchSellersByID(o.getSeller()).getName());
      System.out.println("Buyer: " + test.searchBuyersByID(o.getBuyer()).getName());
      System.out.println("Item: " + test.searchItemsByID(o.getItem()).getName());
      System.out.println("DateAndTime: " + o.getDateAndTime());
      System.out.println("Shipped: " + o.getShipped());
      System.out.println();
    }
    
    for (String s : test.categories) {
      System.out.println(s);
    }
    
    System.out.println();
    
    System.out.println("Admin name: " + test.adminName);
    System.out.println("Admin name: " + test.adminPassword);
  }
}
