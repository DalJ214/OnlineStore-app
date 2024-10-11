package com.pluralsight;
import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
import java.io.IOException;

        public class Main {
            public static void main(String[] args) {
                try {
                    HashMap<String, Product> inventory = loadInventory();
                    //ArrayList<String> sortedKeys = sortbyKey();


                    Scanner scanner = new Scanner(System.in);
                    FileReader fileReader = new FileReader("src/main/resources/products.csv");
                    BufferedReader bufReader = new BufferedReader(fileReader);
                    String input;
                    while (true) {
                        System.out.println("\n1: Display Products \n  2: Display cart \n 3: Exit");
                        String selection = scanner.nextLine().trim().toLowerCase();

                        if (selection.equals("1")) {
                            while ((input = bufReader.readLine()) != null) {
                                if (input.startsWith("SKU")) {
                                    continue;
                                }
                                String[] lineSplit = input.split(Pattern.quote("|"));
                                String SKU = lineSplit[0];
                                String name = lineSplit[1];
                                float price = Float.parseFloat(lineSplit[2]);
                                String Department = lineSplit[3];
                                Product object = new Product(SKU, name, price, Department);


                                System.out.print(object.getSKU() + " - ");
                                System.out.print(object.getName() + " - ");
                                System.out.print(object.getPrice() + " - ");
                                System.out.print(object.getDepartment() + "\n");


                                inventory.put(name, new Product(SKU, name, price, Department));
                            }

                                System.out.print("Would you like to sort? (yes/no): ");
                                String choice = scanner.nextLine();
                                boolean answer = choice.equalsIgnoreCase("yes");
                                if (answer) {
                                    sortbyKey(inventory);
                                }



                            List<String> map = new ArrayList<>(inventory.keySet());
                            Collections.sort(map);

                                /*System.out.print("What item name are you interested in? ");
                                String wang = scanner.nextLine();

                                Product matchedProduct = inventory.get(wang);
                                if (matchedProduct == null) {
                                    System.out.println("We don't carry that product");
                                    return;
                                }
                                System.out.printf("We carry %s and the price is $%.2f",
                                        matchedProduct.getName(), matchedProduct.getPrice());

                                 */
                                break;

                        } else if (selection.equalsIgnoreCase("2")) {
                            System.out.println("");
                        } else if (selection.equalsIgnoreCase("3")) {
                            System.out.println("Goodbye");
                            break;
                        } else {
                            System.out.println("Invalid option please try again.");

                        }
                    }


                } catch (IOException e) {
                    e.getStackTrace();
                    e.printStackTrace();
                }

            }
                    public static HashMap<String, Product> loadInventory() {
                        HashMap<String, Product> inventory = new HashMap<String, Product>();
                        return inventory;
                    }
                    static Map<String, Product> map = new HashMap<>();

                    public static void sortbyKey() {
                        ArrayList<String> sortedKeys = new ArrayList<String>(map.keySet());
                        Collections.sort(sortedKeys);

                        for (String x : sortedKeys) {
                            System.out.println("Key = " + x + ", Value = " + map.get(x));
                }
                    }
                }







