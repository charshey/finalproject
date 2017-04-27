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
import java.util.Random;

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
  
  //the random number generator used to generate ids
  private Random generator;
  
  /**
   * Constructs a Marketplace.
   */
  public Marketplace() throws FileNotFoundException {
    buyers = new ArrayList<Buyer>();
    sellers = new ArrayList<Seller>();
    orders = new ArrayList<Order>();
    items = new ArrayList<Item>();
    categories = new ArrayList<String>();
    generator = new Random();
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
      out.println(o.getItemID());
      out.println(o.getBuyerID());
      out.println(o.getSellerID());
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
      temp.setBuyerID(buyerID);
      temp.setSellerID(sellerID);
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
   * Returns the order that has the given order id. If no order is found that
   * has the given id, then null is returned.
   * @param id an order id
   * @return the order containing the supplied order id, or null if no order is
   *         found with that id
   */ 
  public Order searchOrdersByID(int id) {
    for (Order o : orders) {
      if (o.getID() == id) {
        return o;
      }
    }
    return null;
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
    String lowerCaseKeyWord = keyword.toLowerCase();
    for (Item e : items) {
      if (e.getName().toLowerCase().contains(lowerCaseKeyWord)) {
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
      if (e.getCategory().equals(category)) {
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
      if (o.getSellerID() == id) {
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
      if (o.getBuyerID() == id) {
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
  
  /**
   * Returns a unique buyer id number.
   * @return a unique buyer id number
   */ 
  public int generateBuyerID() {
    int value;
    do {
      value = generator.nextInt(10000) + 10000;
    } while (!(searchBuyersByID(value) == null));
    return value;
  }
  
  /**
   * Returns a unique seller id number.
   * @return a unique seller id number
   */ 
  public int generateSellerID() {
    int value;
    do {
      value = generator.nextInt(10000) + 20000;
    } while (!(searchSellersByID(value) == null));
    return value;
  }
  
  /**
   * Returns a unique order id number.
   * @return a unique order id number
   */ 
  public int generateOrderID() {
    int value;
    do {
      value = generator.nextInt(10000) + 40000;
    } while (!(searchOrdersByID(value) == null));
    return value;
  }
  
  /**
   * Returns a unique item id number.
   * @return a unique item id number
   */ 
  public int generateItemID() {
    int value;
    do {
      value = generator.nextInt(10000) + 30000;
    } while (!(searchItemsByID(value) == null));
    return value;
  }
  
  /**
   * The main menu of the program.
   */ 
  private void mainMenu() throws FileNotFoundException {
    Scanner input = new Scanner(System.in);
    boolean dontExitMenu = true;
    while (dontExitMenu) {
      System.out.println("Main Menu");
      System.out.println("---------");
      System.out.println("1. Login");
      System.out.println("2. Create an account");
      System.out.println("3. Quit");
      System.out.print("\nEnter the number of the desired option: ");
      if (input.hasNextInt()) {
        switch (input.nextInt()) {
          case 1:
            login();
            break;
          case 2:
            createAccount();
            break;
          case 3:
            writeData();
            dontExitMenu = false;
            break;
          default:
            System.out.println("\nInvalid input\n");
        }
      } else {
	input.nextLine();
        System.out.println("\nInvalid input\n");
      }
    }
    input.close();
  }  
   
  /**
   * The login menu. A user can login as either a seller, buyer, or
   * administrator.
   */
  private void login() {
    Scanner input = new Scanner(System.in);
    System.out.println("\nLogin menu");
    System.out.println("----------");
    int id = -1;
    while (id == -1) {
      System.out.print("Enter e-mail address: ");
      String emailAddress = input.nextLine();
      System.out.print("Enter password: ");
      String password = input.nextLine();
      id = getUserID(emailAddress, password);
      if (id == -1) {
        while (true) {
          System.out.println("\nThe e-mail address or password is incorrect.");
          System.out.print("\nWould you like to try again? Enter y or n: ");
          String choice = input.nextLine();
          if (choice.equals("y")) {
            System.out.println();
            break;
          } else if (choice.equals("n")) {
            System.out.println();
            input.close();
            return;
          }
          System.out.println();
        }
      }
    }
    input.close();
    currentUser = id;
    if (id == -2) {
      //adminMenu();
    } else if (id >= 10000 && id < 20000) {
      System.out.println();
      buyerMenu();
    } else if (id >= 20000 && id < 30000) {
      //sellerMenu();
    }
  }
  
/**
 * Returns the id of the user with the given email address and password. If no
 * user is found with the given credentials, then -1 is returned. If the
 * credentials match the administrator's, then -2 is returned.
 * @param emailAddress the email address of a user
 * @param password 
 */ 
private int getUserID(String emailAddress, String password) {
  for (Buyer b : buyers) {
      if (b.getEmailAddress().equals(emailAddress) &&
          b.getPassword().equals(password)) {
        return b.getID();
      }
    }
    for (Seller s : sellers) {
      if (s.getEmailAddress().equals(emailAddress) &&
          s.getPassword().equals(password)) {
        return s.getID();
      }
    }
    if (emailAddress.equals(adminName) && password.equals(adminPassword)) {
      return -2;
    }
    return -1;
} 
  
  /**
   * Creates an account.
   */ 
  private void createAccount() {
    Scanner input = new Scanner(System.in);
    int choice = 0;
    boolean dontExitLoop = true;
    while (dontExitLoop) {
      System.out.println("\nCreate Account");
      System.out.println("--------------");   
      System.out.println("1. Buyer");
      System.out.println("2. Seller");
      System.out.print("\nEnter the type of account you wish to create: ");
      if (input.hasNextInt()) {
        choice = input.nextInt();
        switch (choice) {
          case 1:
            dontExitLoop = false;
            break;
          case 2:
            dontExitLoop = false;
            break;
          default:
            System.out.println("\nInvalid input.");
        }
      } else {
        input.nextLine();
        System.out.println("\nYou didn't enter a number.");
      }
    }
    input.nextLine();
    System.out.print("\nEnter name: ");
    String name = input.nextLine();
    System.out.print("Enter e-mail address: ");
    String emailAddress = input.nextLine();
    while (emailAlreadyTaken(emailAddress)) {
      System.out.println("\nSomeone already has an account with that " +
                         " e-mail address.");
      System.out.print("Please enter a different e-mail address: ");
      emailAddress = input.next();
    }
    System.out.print("Enter a password: ");
    String password = input.next();
    int id;
    if (choice == 1) {
       buyers.add(new Buyer(name, id = generateBuyerID(),
                            emailAddress, password));
    } else {
      sellers.add(new Seller(name, id = generateSellerID(),
                             emailAddress, password));
    }
    System.out.println("\nYour account has been created!");
    currentUser = id;
    if (id >= 10000 && id < 20000) {
      System.out.println();
      buyerMenu();
    } else if (id >= 20000 && id < 30000) {
      //sellerMenu();
    }
    input.close();
  }
  
  /**
   * Returns true if the given e-mail address is already being used by someone
   * in the marketplace.
   * @param emailAddress an e-mail address
   * @return true if the marketplace already contains a user with the supplied
   *         e-mail address, otherwise false
   */ 
  private boolean emailAlreadyTaken(String emailAddress) {
    for (Buyer b : buyers) {
      if (b.getEmailAddress().equals(emailAddress)) {
        return true;
      }
    }
    
    for (Seller s : sellers) {
      if (s.getEmailAddress().equals(emailAddress)) {
        return true;
      }
    }
    
    if (emailAddress.equals(adminName)) {
      return true;
    }
    return false;
  }
  
  
  /**
   * The buyer menu.
   */ 
  private void buyerMenu() {
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.println("Buyer Menu");
      System.out.println("----------");
      System.out.println("1. Search for items");
      System.out.println("2. Browse for items");
      System.out.println("3. See order history");
      System.out.println("4. Change account info");
      System.out.println("5. Logout");
      System.out.println();
      System.out.print("Enter the number of the desired option: ");
      if (input.hasNextInt()) {
        switch (input.nextInt()) {
          case 1:
            searchItemsMenu();
            break;
          case 2:
            browseItemsMenu();
            break;
          case 3:
            buyerOrderHistory(currentUser);
            break;
          case 4:
            changeBuyerAccountInfo();
            break;
          case 5:
            input.close();
            System.out.println();
            return;
          default:
            input.nextLine();
            System.out.println("\ninvalid input\n");
        }
      } else {
        input.nextLine();
        System.out.println("\ninvalid input\n");
      }
    }
  }
  
  /**
   * Displays a list of all the orders that were made by the buyer with the
   * given id.
   * @param buyerID the id of a buyer
   */ 
  private void buyerOrderHistory(int buyerID) {
    System.out.println("\nOrder History");
    System.out.println("-------------");
    boolean noOrdersMade = true;
    for (Order o : orders) {
      if (o.getBuyerID() == buyerID) {
        noOrdersMade = false;
        Seller seller = searchSellersByID(o.getSellerID());
        Item item = searchItemsByID(o.getItemID());
        System.out.println("Item name: " + item.getName());
        System.out.println("Seller: " + seller.getName());
        System.out.println("Order status: " +
                           (o.getShipped() ? "Shipped" : "Processing"));
        System.out.println();
      }
    }
    if (noOrdersMade) {
      System.out.println("You have not made any orders.\n");
    }
  }
  
    
  /**
   * Search for products menu
   */ 
  private void searchItemsMenu() {
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.println("\nItem Search");
      System.out.println("-----------");
      System.out.println("1. Search by item number");
      System.out.println("2. Search by keyword");
      System.out.println("3. Return to previous menu");
      System.out.print("\nEnter the number of the desired option: ");
      if (input.hasNextInt()) {
        switch (input.nextInt()) {
          case 1:
            searchItemsByIDMenu();
            break;
          case 2:
            searchItemsByKeywordMenu();
            break;
          case 3:
            System.out.println();
            input.close();
            return;
          default:
            input.nextLine();
            System.out.println("\ninvalid input");
        }
      } else {
        input.nextLine();
        System.out.println("\ninvalid input");
      }
    }
  }
  
  /**
   * Browse for items menu.
   */ 
  private void browseItemsMenu() {
    System.out.println("\nBrowse Items");
    System.out.println("--------------");
    if (categories.size() == 0) {
      System.out.println("Sorry. No categories.\n");
      return;
    }
    int count = 1;
    for (String s : categories) {
      System.out.println(count + ". " + s);
      count++;
    }
    String category = selectACategory();
    ArrayList<Item> itemList = searchItemsByCategory(category);
    System.out.println("\n" + category);
    System.out.println("--------");
    printItems(itemList);
    Item item = selectAnItem(itemList);
    System.out.println();
    itemPage(item);
  }
  
  /**
   * Displays a listing of all the categories in the marketplace, and prompts
   * the user to select one of them. The selected category is returned as a
   * String.
   * @return the selected category
   */ 
  private String selectACategory() {
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.print("\nSelect a category: ");
      if (input.hasNextInt()) {
        int choice = input.nextInt();
        if (choice < 0 || choice > categories.size()) {
          System.out.println("\nThe numbered you entered is out of range.");
        } else {
          input.close();
          return categories.get(choice - 1);
        }
      } else {
        input.nextLine();
        System.out.println("\nInvalid input.");
      }
    }
  }
  
  /**
   * Displays the given list of items, and prompts the user to select an item
   * from the list. The selected item is then returned.
   * @return the selected item from the list
   */ 
  private Item selectAnItem(ArrayList<Item> itemList) {
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.print("\nSelect an item: ");
      if (input.hasNextInt()) {
        int choice = input.nextInt();
        if (choice < 0 || choice > itemList.size()) {
          System.out.println("\nThe numbered you entered is out of range.");
        } else {
          input.close();
          return itemList.get(choice - 1);
        }
      } else {
        input.nextLine();
        System.out.println("\nInvalid input.");
      }
    }
  }
  
  /**
   * Prints out the names of the items in the given list. Each item name is
   * placed on its own line.
   * @param itemList the items to print
   */ 
  public void printItems(ArrayList<Item> itemList) {
    int count = 1;
    for (Item e : itemList) {
      System.out.println(count + ". " + e.getName());
      count++;
    }
  }
    
    
  
  /**
   * Displays a menu that allows a user to search for items by keyword.
   */ 
  private void searchItemsByKeywordMenu() {
    Scanner input = new Scanner(System.in);
    System.out.print("\nEnter keyword: ");
    ArrayList<Item> results = searchItemsByKeyword(input.nextLine());
    if (results.size() == 0) {
      System.out.println("\nNo results\n");
    } else {
      System.out.println("\nSearch Results");
      System.out.println("--------------");
      int count = 1;
      for (Item i : results) {
        System.out.println(count + ". " + i.getName());
        System.out.println();
      }
      while (true) {
        System.out.print("\nEnter the number corresponding to an " +
                         "item to go to its item page: ");
        if (input.hasNextInt()) {
           int choice = input.nextInt();
           if (choice > results.size() || choice <= 0) {
             System.out.println("\nThe number you entered is out of range");
           } else {
             System.out.println();
             itemPage(results.get(choice - 1));
             break;
           }
        } else {
          System.out.println("\ninvalid input");
        }
      }
    }
    input.close();
  }
  
  /**
   * Displays a menu that allows a user to search for items by item id number.
   */ 
  private void searchItemsByIDMenu() {
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.print("\nEnter an item id.");
      System.out.println(" A valid item id is any number between 30000 " +
                         "and 39999, inclusive");
      if (input.hasNextInt()) {
        int itemID = input.nextInt();
        if (itemID > 39999 || itemID < 30000) {
          System.out.println("\nThe item id is out of range.");
        } else {
          Item item = searchItemsByID(itemID);
          if (item == null) {
            System.out.println("\nNo items were found with that id.");
            break;
          } else {
            System.out.println();
            itemPage(item);
            break;
          }
        }        
      } else {
        input.nextLine();
        System.out.println("\nInvalid input");
      }
    }
    input.close();
  }
  

  /**
   * Displays the page of an item.
   * @param item an item
   */
  private void itemPage(Item item) {
    Scanner input = new Scanner(System.in);
    System.out.println("Item Page");
    System.out.println("---------");
    System.out.println(item.getName());
    System.out.println();
    System.out.println("Description: " + item.getDescription());
    System.out.println("Item id number: " + item.getID());
    Seller seller = searchSellersByID(item.getSellerID());
    System.out.println("\nSeller: " + seller.getName());
    System.out.println("Price: $" + item.getPrice());
    System.out.println("Quantity available: " + item.getQuantity());
    if (currentUser == -2 || (currentUser >= 20000 && currentUser <= 29999)) {
      //admin and sellers shouldn't be able to buy products
    } else {
      while (true) {
        System.out.println("\nSelect an option: ");
        System.out.println("1. Purchase item");
        System.out.println("2. Return to the Buyer Menu");
        if (input.hasNextInt()) {
          int choice = input.nextInt();
          if (choice == 1) {
            if (item.getQuantity() == 0) {
              System.out.println("\nSorry. This item is not in stock.\n");
              break;
            }
            Buyer buyer = searchBuyersByID(currentUser);
            Order order = buyer.buy(item);
            order.setID(generateOrderID());
            order.setDateAndTime(LocalDateTime.now());
            orders.add(order);
            item.setQuantity(item.getQuantity() - 1);
            System.out.println("\nThe item has been purchased!\n");
            break;
          } else if (choice == 2) {
            System.out.println();
            break;
          } else {
            System.out.println("\nInvalid input");
          }
        } else {
          input.nextLine();
          System.out.println("\nInvalid input");
        }
      }
    }
    input.close();
  }
  
  /**
   * Change account information
   */ 
  private void changeBuyerAccountInfo() {
    Scanner input = new Scanner(System.in);    
    Buyer buyer = searchBuyersByID(currentUser);
    boolean dontExitMenu = true;
    while (dontExitMenu) {
      System.out.println("\nChange Buyer Account Information");
      System.out.println("--------------------------------");
      System.out.println("1. Change name");
      System.out.println("2. Change e-mail address");
      System.out.println("3. Change password");
      System.out.println("4. Return to the buyer menu");
      System.out.print("\nEnter the number of the desired option: ");
      if (input.hasNextInt()) {
        switch (input.nextInt()) {
          case 1:
            System.out.print("\nCurrent Name: " + buyer.getName());
            System.out.print("\nEnter new name: ");
            input.nextLine();
            buyer.setName(input.nextLine());
            System.out.println("\nYour name was successfully changed.");
            break;
          case 2:
            System.out.print("\nCurrent e-mail address: " + buyer.getEmailAddress());
            System.out.print("\nEnter new e-mail address: ");
            input.nextLine();
            buyer.setEmailAddress(input.nextLine());
            System.out.println("\nYour e-mail address was successfully changed.");
            break;
          case 3:
            System.out.print("\nEnter new password: ");
            input.nextLine();
            buyer.setPassword(input.nextLine());
            System.out.println("\nYour password was successfully changed.");
            break;
          case 4:
            dontExitMenu = false;
            break;
          default:
            input.nextLine();
            System.out.println("\ninvalid input");
        }
      } else {
        input.nextLine();
        System.out.println("\ninvalid input");
      }
    }
    System.out.println();
  }
  
  /**
   * Returns true if the current user is a buyer.
   * @return true if the current user is a buyer
   */ 
  private boolean isCurrentUserABuyer() {
    return (currentUser >= 10000 && currentUser <= 19999);
  }
  
  /**
   * Returns true if the current user is a seller.
   * @return true if the current user is a seller
   */ 
  private boolean isCurrentUserASeller() {
    return (currentUser >= 20000 && currentUser <= 29999);
  }
  
  /**
   * Returns true if the current user is an admin.
   * @return true if the current user is an admin
   */ 
  private boolean isCurrentUserAnAdmin() {
    return (currentUser == -2);
  }
  
 
  public static void main(String[] args) throws FileNotFoundException {
    Marketplace test = new Marketplace();
    test.mainMenu();
  }
}
