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
      out.println(s.getPassword());
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
      out.println(o.getShippingDate());
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
    loadOrders();
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
      LocalDateTime dateAndTime = LocalDateTime.parse(input.nextLine());
      boolean shippedStatus = Boolean.parseBoolean(input.nextLine());
      LocalDateTime shippingDate = null;
      String shipDate = input.nextLine();
      if (!(shipDate.equals("null"))) {
        shippingDate = LocalDateTime.parse(shipDate);
      }
      temp.setID(orderID);
      temp.setItem(itemID);
      temp.setBuyerID(buyerID);
      temp.setSellerID(sellerID);
      temp.setDateAndTime(dateAndTime);
      temp.setShipped(shippedStatus);
      temp.setShippingDate(shippingDate);
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
   * @throws FileNotFoundException
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
            input.nextLine();
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
      System.out.println();
      adminMenu();
    } else if (id >= 10000 && id < 20000) {
      System.out.println();
      buyerMenu();
    } else if (id >= 20000 && id < 30000) {
      System.out.println();
      sellerMenu();
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
            input.nextLine();
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
      System.out.println();
      sellerMenu();
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
   * The admin menu.
   */ 
  private void adminMenu() {
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.println("Admin Menu");
      System.out.println("----------");
      System.out.println("1. Access seller information ");
      System.out.println("2. Access buyer information");
      System.out.println("3. Add item category");
      System.out.println("4. Remove item category");
      System.out.println("5. Show sales history");
      System.out.println("6. Logout");
      System.out.println();
      System.out.print("Enter the number of the desired option: ");
      if (input.hasNextInt()) {
        switch (input.nextInt()) {
          case 1:
            accessSellerInfoMenu();
            break;
          case 2:
            accessBuyerInfoMenu();
            break;
          case 3:
            addCategory();
            break;
          case 4:
            removeCategory();
            break;
          case 5:
            showSalesHistoryMenu();
            break;
          case 6:
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
   * Prompts the administrator to select the time period for displaying orders.
   */
  private void showSalesHistoryMenu() {
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.println("\nDisplay all sales within: ");
      System.out.println("1. Past day");
      System.out.println("2. Past month");
      System.out.println("3. Past year");
      System.out.println("4. All time");
      System.out.println();
      System.out.print("Enter a number: ");
      if (input.hasNextInt()) {
        switch (input.nextInt()) {
          case 1:
            displayOrders(1);
            input.close();
            return;
          case 2:
            displayOrders(30);
            input.close();
            return;
          case 3:
            displayOrders(365);
            input.close();
            return;
          case 4:
            displayOrders(10000);
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
   * Prints out a list of the orders made within given number of days.
   * @param daysAgo the number of days ago.
   */
  private void displayOrders(int daysAgo) {
      LocalDateTime currentDate = LocalDateTime.now();
      LocalDateTime previousDate = currentDate.minusDays(daysAgo);
      ArrayList<Order> recentOrders = new ArrayList<>();
      for (Order o : orders) {
        if (o.getDateAndTime().isAfter(previousDate)) {
          recentOrders.add(o);
        }
      }
      if (recentOrders.isEmpty()) {
        System.out.println("\nNo orders were made within the selected date.\n");
        return;
      } else {
        System.out.println("\nThe following orders were " +
                           "made within the selected date:");
        printOrders(recentOrders);
    }
  }
  
  /**
   * The administrator uses this method to access seller information.
   */ 
  private void accessSellerInfoMenu() {
    Scanner input = new Scanner(System.in);
    System.out.println("\nChoose a seller from the list below.");
    printSellers(sellers);
    Seller seller = selectFromList(sellers);
    System.out.println();
    while (true) {
      System.out.println("Access Seller Information");
      System.out.println("-------------------------");
      System.out.println("Seller: " + seller.getName());
      System.out.println("1. Access this seller's account information");
      System.out.println("2. Access this seller's items");
      System.out.println("3. Access this seller's orders");
      System.out.println("4. Return to previous menu");
      System.out.println();
      System.out.print("Enter number: ");
      if (input.hasNextInt()) {
        switch (input.nextInt()) {
          case 1:
            changeSellerAccountInfo(seller.getID());
            break;
          case 2:
            updateItemInfo(seller.getID());
            break;
          case 3:
            updateOrderStatus(seller.getID());
            break;
          case 4:
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
   * The administrator uses this method to access buyer information.
   */ 
  private void accessBuyerInfoMenu() {
    Scanner input = new Scanner(System.in);
    System.out.println("\nChoose a Buyer from the list below.");
    printBuyers(buyers);
    Buyer buyer = selectFromList(buyers);
    System.out.println();
    while (true) {
      System.out.println("Access Buyer Information");
      System.out.println("------------------------");
      System.out.println("Buyer: " + buyer.getName());
      System.out.println("1. Access this buyer's account information");
      System.out.println("2. See this buyer's order history");
      System.out.println("3. Return to previous menu");
      System.out.println();
      System.out.print("Enter number: ");
      if (input.hasNextInt()) {
        switch (input.nextInt()) {
          case 1:
            changeBuyerAccountInfo(buyer.getID());
            break;
          case 2:
            buyerOrderHistory(buyer.getID());
            break;
          case 3:
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
   * Prompts the administrator to add a category to the marketplace.
   */ 
  private void addCategory() {
    Scanner input = new Scanner(System.in);
    System.out.print("\nEnter the category name to add to the marketplace: ");
    String category = input.nextLine();
      while (category.equals("")) {
        System.out.println("\nInvalid input. A category must have a name.");
        System.out.print("\nEnter the category name to add to the marketplace: ");
        category = input.nextLine();
      }
    categories.add(category);
    System.out.println("\nThe category was added to the marketplace.\n");
  }
  
  /**
   * Prompts the administrator to remove a category from the marketplace.
   */ 
  private void removeCategory() {
    System.out.println("\nChoose one of the following categories to remove:");
    String category = selectACategory();
    categories.remove(category);
    System.out.println("\nThe category was removed from the marketplace.\n");
  }
  
  /**
   * The buyer menu.
   */ 
  private void buyerMenu() {
    Scanner input = new Scanner(System.in);
    displayShippedItems();
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
            changeBuyerAccountInfo(currentUser);
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
   * Prints a list of items that were shipped within the past two days.
   */ 
  private void displayShippedItems()  {
    Buyer buyer = searchBuyersByID(currentUser);
    ArrayList<Order> orderList = obtainBuyerOrders(buyer);
    LocalDateTime currentDate = LocalDateTime.now();
    LocalDateTime twoDaysAgo = currentDate.minusDays(2);
    ArrayList<Order> recentOrders = new ArrayList<>();
    for (Order o : orderList) {
      if (o.getShipped()) {
        if (o.getShippingDate().isAfter(twoDaysAgo)) {
          recentOrders.add(o);
        }
      }
    }
    if (recentOrders.isEmpty()) {
      return;
    } else {
      System.out.println("The following orders were recently shipped:");
      for (int i = 0; i < recentOrders.size(); i++) {
        Order o = recentOrders.get(i);
        Item item = searchItemsByID(o.getItemID());
        System.out.println("\tItem: " + item.getName());
        System.out.println("\tOrder Number: " + o.getID());
        if (i != (recentOrders.size() - 1)) {
          System.out.println();
        }
      }
      System.out.println();
    }
  }
  
    
  /**
   * Seller Menu
   */ 
  private void sellerMenu() {
   Scanner input = new Scanner(System.in);
   if(checkOutOfStock(searchSellersByID(currentUser)).size() > 0){
     System.out.println("The following items in your inventory are out of stock:");
     for(Item i : checkOutOfStock(searchSellersByID(currentUser))){
	  System.out.println(i.getID() + ": " + i.getName());
     }
     System.out.println();
   }
    while (true) {
      System.out.println("Seller Menu");
      System.out.println("-----------");
      System.out.println("1. Add item(s) to marketplace");
      System.out.println("2. Remove item from marketplace");
      System.out.println("3. Update an item's information");
      System.out.println("4. Update the status of an order");
      System.out.println("5. Change your account information");
      System.out.println("6. Logout");
      System.out.println();
      System.out.print("Enter the number of the desired option: ");
      if (input.hasNextInt()) {
        switch (input.nextInt()) {
          case 1:
            addItemsMenu();
            break;
          case 2:
            removeItemMenu();
            break;
          case 3:
            updateItemInfo(currentUser);
            break;
          case 4:
            updateOrderStatus(currentUser);
            break;
          case 5:
            changeSellerAccountInfo(currentUser);
            break;
          case 6:
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
   * Displays a list of orders by the seller with the given seller ID, and then
   * prompts the user to select and update one of the orders.
   */ 
  private void updateOrderStatus(int sellerID) {
    Seller seller = searchSellersByID(sellerID);
    ArrayList<Order> orderList = obtainSellerOrders(seller);
    if (orderList.isEmpty()) {
      System.out.println("\nThere are no orders to update.\n");
      return;
    }
    Scanner input = new Scanner(System.in);
    System.out.println("\nOrders");
    System.out.println("------");
    printOrders(orderList);
    Order order = selectAnOrder(orderList);
    if (order.getShipped()) {
      System.out.println("\nThe order has already been shipped.\n");
      input.close();
      return;
    }
    System.out.print("Change order status to shipped? Enter y or n: ");
    String choice = input.nextLine();
    while (!choice.equals("y") && !choice.equals("n")) {
      System.out.print("\nPlease enter either y or n: ");
      choice = input.nextLine();
    }
    if (choice.equals("y")) {
      order.setShipped(true);
      order.setShippingDate(LocalDateTime.now());
      System.out.println("\nThe order status was successfully updated");
    }
    System.out.println();
    input.close();
    return;
  }
  
    
    /**
     * Displays a prompt for a seller to an item or multiple items to the
     * marketplace.
     */ 
    private void addItemsMenu() {
      Scanner input = new Scanner(System.in);
      while (true) {
        System.out.println("\nAdd items");
        System.out.println("---------");
        System.out.println("1. Add a single item");
        System.out.println("2. Add multiple items from a file");
        System.out.println("3. Return to previous menu");
        System.out.print("\nEnter the number of the desired option: ");
        if (input.hasNextInt()) {
          switch (input.nextInt()) {
            case 1:
              addSingleItem();
              break;
            case 2:
              addItemsFromFile();
              break;
            case 3:
              input.close();
              System.out.println();
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
     * Prompts the seller to add a single item to the marketplace.
     */
    private void addSingleItem() {
      Scanner input = new Scanner(System.in);
      System.out.print("\nEnter the name of the item to add: ");
      String itemName = input.nextLine();
      while (itemName.equals("")) {
        System.out.println("\nInvalid input. An item must have a name.\n");
        System.out.print("Enter a name for the item: ");
        itemName = input.nextLine();
      }
      System.out.print("Enter a description of the item: ");
      String description = input.nextLine();
      while (description.equals("")) {
        System.out.println("\nInvalid input. An item must have a description.\n");
        System.out.print("Enter a description for the item: ");
        description = input.nextLine();
      }
      System.out.print("Enter the price of the item: ");
      String price = input.nextLine();
      while (price.equals("")) {
        System.out.println("\nInvalid input. An item must have a price.\n");
        System.out.print("Enter a price: ");
        price = input.nextLine();
      }
      System.out.print("Enter the quantity available: ");
        int quantity = 0;
        while (true) {
          if (!input.hasNextInt()) {
            input.nextLine();
            System.out.print("\nThe quantity must be a number. ");
          } else {
            quantity = input.nextInt();
            if (quantity > 0) {
              break;
            } else {
              System.out.print("\nThe quantity must be greater than zero. ");
            }
          }
          System.out.print("Enter in a new number: ");
        }
        System.out.println("\nChoose one of the categories below " +
                            "to add the item to.");
        System.out.println("\nCategories\n----------");
        String category = selectACategory();
        items.add(new Item(itemName, description, price, generateItemID(),
                           currentUser, quantity, category));
        System.out.println("\nThe item was added to the marketplace.");
        input.close();
    }
    
    /**
     * Prompts the seller to add items to the marketplace from a file.
     */
    private void addItemsFromFile() {
      Scanner input = new Scanner(System.in);
      System.out.print("\nEnter the path of the file: ");
      Scanner fileScanner;
      try {
      fileScanner = new Scanner(new File(input.nextLine()));
      }
      catch (FileNotFoundException e) {
        System.out.println("\nNo file was found.");
        return;
      }
      while (fileScanner.hasNextLine() && fileScanner.nextLine().equals("%")) {
        Item temp = new Item();
        temp.setName(fileScanner.nextLine());
        temp.setID(Integer.parseInt(fileScanner.nextLine()));
        temp.setDescription(fileScanner.nextLine());
        temp.setSellerID(Integer.parseInt(fileScanner.nextLine()));
        temp.setPrice(fileScanner.nextLine());
        temp.setQuantity(Integer.parseInt(fileScanner.nextLine()));
        temp.setCategory(fileScanner.nextLine());
        items.add(temp);
      }
      input.close();
      System.out.println("\nThe items were added to the marketplace.");
    }
    
    /**
     * Displays a list of items from the current seller, then prompts the seller
     * to remove one of the items from the marketplace.
     */ 
    private void removeItemMenu() {
      Seller seller = searchSellersByID(currentUser);
      ArrayList<Item> itemList = searchItemsBySeller(seller);
      if (itemList.isEmpty()) {
        System.out.println("\nYou have no items to remove.\n");
        return;
      }
      Scanner input = new Scanner(System.in);
      System.out.println("\nYour items");
      System.out.println("----------");
      printItems(itemList);
      Item item = selectAnItem(itemList);
      items.remove(item);
      System.out.println("\nThe item was successfully removed\n");
      input.close();
    }
    
    /**
     * Displays a list of items from the seller with the given seller id, then
     * prompts the user to select and update an item.
     * @param sellerID a seller id
     */ 
    private void updateItemInfo(int sellerID) {
      Seller seller = searchSellersByID(sellerID);
      ArrayList<Item> itemList = searchItemsBySeller(seller);
      if (itemList.isEmpty()) {
        System.out.println("\nThere are no items to update.\n");
        return;
      }
      Scanner input = new Scanner(System.in);
      System.out.println("\nItems");
      System.out.println("------");
      printItems(itemList);
      Item item = selectAnItem(itemList);
      while (true) {
        System.out.println("\nSelect the attribute that you wish to update.");
        System.out.println("1. name");
        System.out.println("2. description");
        System.out.println("3. price");
        System.out.println("4. quantity");
        System.out.println("5. category");
        System.out.print("\nEnter the number of the desired option: ");
        if (input.hasNextInt()) {
          switch (input.nextInt()) {
            case 1:
              input.nextLine();
              System.out.println("\nCurrent item name: " + item.getName());
              System.out.print("Enter new item name: ");
              item.setName(input.nextLine());
              System.out.println("\nThe item has been updated.\n");
              return;
            case 2:
              input.nextLine();
              System.out.println("\nCurrent item description: " + item.getDescription());
              System.out.print("Enter new item description: ");
              item.setDescription(input.nextLine());
              System.out.println("\nThe item has been updated.\n");
              return;
            case 3:
              input.nextLine();
              System.out.println("\nCurrent item price: " + item.getPrice());
              System.out.print("Enter new item price: ");
              item.setPrice(input.nextLine());
              System.out.println("\nThe item has been updated.\n");
              return;
            case 4:
              input.nextLine();
              System.out.println("\nCurrent item quantity: " + item.getQuantity());
              System.out.print("Enter new quantity: ");
              item.setQuantity(input.nextInt());
              System.out.println("\nThe item has been updated.\n");
              return;
            case 5:
              input.nextLine();
              System.out.println("\nCurrent item category: " + item.getCategory());
              System.out.println("Choose one of the following categories.");
              String category = selectACategory();
              item.setCategory(category);
              System.out.println("\nThe item has been updated.\n");
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
      System.out.println("No orders have been made.\n");
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
    System.out.println("------------");
    if (categories.size() == 0) {
      System.out.println("Sorry. No categories.\n");
      return;
    }
    String category = selectACategory();
    ArrayList<Item> itemList = searchItemsByCategory(category);
    System.out.println("\n" + category);
    for (int i = 0; i < category.length(); i++) {
      System.out.print("-");
    }
    System.out.println();
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
    int count = 1;
    Scanner input = new Scanner(System.in);
    for (String s : categories) {
      System.out.println(count + ". " + s);
      count++;
    }
    while (true) {
      System.out.print("\nSelect a category: ");
      if (input.hasNextInt()) {
        int choice = input.nextInt();
        if (choice < 0 || choice > categories.size()) {
          input.nextLine();
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
   * Prompts the user to select an item from the list. The selected item is then
   * returned. Note: the list is not displayed. You must display the list prior 
   * to calling this method.
   * @return the selected item from the list
   */ 
  private Item selectAnItem(ArrayList<Item> itemList) {
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.print("\nSelect an item: ");
      if (input.hasNextInt()) {
        int choice = input.nextInt();
        if (choice < 0 || choice > itemList.size()) {
          input.nextLine();
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
   * Prompts the user to select an order from the list. The selected order is
   * then returned. Note: the list is not displayed. You must display
   * the list prior to calling this method.
   * @return the selected order from the list
   */ 
  private Order selectAnOrder(ArrayList<Order> orderList) {
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.print("Select an order: ");
      if (input.hasNextInt()) {
        int choice = input.nextInt();
        if (choice < 0 || choice > orderList.size()) {
          input.nextLine();
          System.out.println("\nThe numbered you entered is out of range.\n");
        } else {
          input.close();
          return orderList.get(choice - 1);
        }
      } else {
        input.nextLine();
        System.out.println("\nInvalid input.\n");
      }
    }
  }
  
  /**
   * Prompts the user to select an element from the given list. The selected 
   * element is then returned. Note: the list is not displayed. You must display
   * the list prior to calling this method.
   * @return the selected element from the list
   */ 
  private <T> T selectFromList(ArrayList<T> aList) {
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.print("\nMake a selection: ");
      if (input.hasNextInt()) {
        int choice = input.nextInt();
        if (choice < 0 || choice > aList.size()) {
          input.nextLine();
          System.out.println("\nThe numbered you entered is out of range.");
        } else {
          input.close();
          return aList.get(choice - 1);
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
   * Prints out the names of the Sellers in the given list. Each seller name is
   * placed on its own line.
   * @param sellerList the sellers to print
   */ 
  public void printSellers(ArrayList<Seller> sellerList) {
    int count = 1;
    for (Seller s : sellerList) {
      System.out.printf("%d. %-35s ID: %s\n", count, s.getName(), s.getID());
      count++;
    }
  }
  
  /**
   * Prints out the names of the buyers in the given list. Each buyer name is
   * placed on its own line.
   * @param buyerList the buyers to print
   */ 
  public void printBuyers(ArrayList<Buyer> buyerList) {
    int count = 1;
    for (Buyer s : buyerList) {
      System.out.printf("%d. %-35s ID: %s\n", count, s.getName(), s.getID());
      count++;
    }
  }
  
  /**
   * Prints out the names of the orders in the given list. Each order name is
   * placed on its own line.
   * @param orderList the orders to print
   */ 
  public void printOrders(ArrayList<Order> orderList) {
    int count = 1;
    for (Order o : orderList) {
      System.out.println(count + ". Order ID: " + o.getID());
      Item item = searchItemsByID(o.getItemID());
      Buyer buyer = searchBuyersByID(o.getBuyerID());
      System.out.println("   Item : " + item.getName());
      System.out.println("   Buyer : " + buyer.getName());
      String status = (o.getShipped()) ? "Shipped" : "Processing";      
      System.out.println("   Status : " + status);
      System.out.println();
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
             input.nextLine();
             System.out.println("\nThe number you entered is out of range");
           } else {
             System.out.println();
             itemPage(results.get(choice - 1));
             break;
           }
        } else {
          input.nextLine();
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
          input.nextLine();
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
            input.nextLine();
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
   * Changes account information for the buyer with the given buyer id.
   * @param buyerID a buyer id
   */ 
  private void changeBuyerAccountInfo(int buyerID) {
    Scanner input = new Scanner(System.in);    
    Buyer buyer = searchBuyersByID(buyerID);
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
   * Changes account information for the seller with the given seller id.
   * @param sellerID a seller id
   */ 
  private void changeSellerAccountInfo(int sellerID) {
    Scanner input = new Scanner(System.in);
    Seller seller = searchSellersByID(sellerID);
    boolean dontExitMenu = true;
    while (dontExitMenu) {
      System.out.println("\nChange Seller Account Information");
      System.out.println("---------------------------------");
      System.out.println("1. Change name");
      System.out.println("2. Change e-mail address");
      System.out.println("3. Change password");
      System.out.println("4. Return to the previous menu");
      System.out.print("\nEnter the number of the desired option: ");
      if (input.hasNextInt()) {
        switch (input.nextInt()) {
          case 1:
            System.out.print("\nCurrent Name: " + seller.getName());
            System.out.print("\nEnter new name: ");
            input.nextLine();
            seller.setName(input.nextLine());
            System.out.println("\nName was successfully changed.");
            break;
          case 2:
            System.out.print("\nCurrent e-mail address: " + seller.getEmailAddress());
            System.out.print("\nEnter new e-mail address: ");
            input.nextLine();
            seller.setEmailAddress(input.nextLine());
            System.out.println("\nE-mail address was successfully changed.");
            break;
          case 3:
            System.out.print("\nEnter new password: ");
            input.nextLine();
            seller.setPassword(input.nextLine());
            System.out.println("\nPassword was successfully changed.");
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
   * Runs the marketplace program.
   */ 
  public void run() throws FileNotFoundException {
    mainMenu();
  }
 
  public static void main(String[] args) throws FileNotFoundException {
    Marketplace marketplace = new Marketplace();
    marketplace.run();
  }
}
