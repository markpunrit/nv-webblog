import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        int managerID[] = {1,2};
        String managerName[] = {"mark", "ma"};
        String managerTel[] = {"099-9999999", "088-7569842"};
        Manager manager = new Manager(managerID, managerName, managerTel);


        int employeeDoID[] = {1,2};
        String employeeDoName[] = {"mox", "mix"};
        String employeeDoTel[] = {"099-5556686", "098-8944587"};
        EmployeeDo employeeDo = new EmployeeDo(employeeDoID, employeeDoName, employeeDoTel);

        int examinerID[] = {1,2};
        String examinerName[] = {"big", "box"};
        String examninerTel[] = {"065-8459787", "074-8859632"};
        Examiner examiner = new Examiner(examinerID, examinerName, examninerTel);

        int cupID[] = {1,2,3};
        String cupSize[] = {"glass S size 16 oz.", "glass M size 18 oz.", "glass L size 22 oz."};
        int cupNumber[] = {51,23,97};
        Cup cup = new Cup(cupID, cupSize, cupNumber);

        int rawID[] = {1,2,3,4};
        String rawName[] = {"fresh milk", "khi mukh", "coffee"};
        int rawNumber[] = {80, 10, 98, 50};
        Rawmaterial raw = new Rawmaterial(rawID, rawName, rawNumber);

        int productID[] = {1,2,3,4,5,6,7,8,9};
        String productName[] = {"Cocoa", "green tea", "Thai tea", "latte", "espresso", "cappuccino", "mocha", "chocolate", "americano"};
        double productPrice[] = {35.00, 35.00, 35.00, 35.00, 35.00, 35.00, 35.00, 35.00, 35.00};
        String productSize[] = {"S", "S", "S", "S", "S","S", "S", "S", "S"};
        Product product = new Product(productID, productName, productPrice, productSize);

        Order order = new Order(1, "in progress", "12/11/2565", "12:00", 1,  product);

        Receipt receipt = new Receipt(1, "01/10/2564", "13:45", 150);

        Scanner sc = new Scanner(System.in);
        int select;
        do {
            System.out.println("******************** Bubble tea shop management system ********************");
            System.out.println("   (1) manager");//ผุ้จัดการ
            System.out.println("   (2) stock");//ผู้ตรวจสอบและรับวัตถุดิบเข้าสต็อก
            System.out.println("   (3) employeeSale");//พนักงานขาย
            System.out.println("   (4) employeeDo");//พนักงานทำ
            System.out.println("   (0) exit menu");
            System.out.print("select menu: ");
            select = sc.nextInt();
            if(select == 3) { // ------------------- salesperson -------------------
                System.out.print(" ID : ");
                int id = sc.nextInt();
                int selectMenu;
                String listIdProduct = ""; //เก็บรหัสอาหารหรือเครื่องดื่มที่ลูกค้าสั่ง
                do {
                    System.out.println("******************** Bubble tea shop management system ********************");
                    System.out.println("position: salesperson");
                    System.out.println("   (1) view order");//ดูออเดอร์สินค้า
                    System.out.println("   (2) take orders");//รับออเดอร์
                    System.out.println("   (0) log out");
                    System.out.print("select menu: ");
                    selectMenu = sc.nextInt();
                    if(selectMenu == 2) {
                        String selectProduct ;
                            do {
                                System.out.println("===================== drink list =====================");
								System.out.println("1. Cocoa     (Fresh Milk Cocoa)       price 35.00 baht");
                                System.out.println("2. green tea   (Fresh Milk Green Tea)   price 35.00 baht");
                                System.out.println("3. Thai tea    (Fresh Milk Cocoa)       price 35.00 baht");
                                System.out.println("4. latte          (Latte)                  price 35.00 baht");
                                System.out.println("5. espresso     (Espresso)               price 35.00 baht");
                                System.out.println("6. cappuccino     (cappuccino)               price 35.00 baht");
                                System.out.println("7. mocha     (mocha)               price 35.00 baht");
                                System.out.println("8. chocolate     (chocolate)               price 35.00 baht");
                                System.out.println("9. americano    (americano)               price 35.00 baht");
                                System.out.println("========================================================" + "\n");
								System.out.println("select menudrink (/ y finish, x n cancel)");
								System.out.print("numberdrink: ");//ใส่หมายเลขเครื่องดื่ม
								selectProduct = sc.nextLine();
                                if(selectProduct.equals("y")) {
                                    String confirm;
                                    do {
                                        System.out.println("========================================");
										System.out.println("           drink list         ");//รายการเครื่องดื่มที่สั่ง
                                        System.out.println("========================================");
                                        for(int i=0;i<listIdProduct.length();i++) {
                                            char IdProduct = listIdProduct.charAt(i);
                                            int idProduct = Integer.parseInt(String.valueOf(IdProduct));
                                            System.out.println(" No." + product.getProductID(idProduct) + " " + product.getProductName(idProduct) + "   price " + product.getProductPrice(idProduct) + " baht");
                                        }
                                        System.out.println("========================================" + "\n");
                                        System.out.println(" y confirm,  n cancel");
										confirm = sc.nextLine();
                                        if(confirm.equals("y")) {
                                            order.setOrder(listIdProduct, id);
                                            System.out.println("******************** finish ********************");//ใบเสร็จ
                                            System.out.println(order.getShowOrderDetails());
                                            System.out.println("*******************************************************");
                                            break;
                                        }
                                    } while(!confirm.equals("n"));
                                    break;
                                }
                                else {
                                    listIdProduct += selectProduct;
                                }
                            } while(!selectProduct.equals("n"));
                    }
                    else if(selectMenu == 1) {
                        System.out.println("==================== food order ====================");
                        System.out.println(order.getShowOrderDetails());
                        System.out.println("==================================================" + "\n");
                    }
                } while(selectMenu != 0);
            }
            else if(select == 4) { // ------------------- staff do -------------------
                System.out.print(" ID : ");
                int idDo = sc.nextInt();
                if(employeeDo.getEmployeeDoID(idDo) == true);
                int selectMD;
                do {
                    System.out.println("******************** Bubble tea shop management system ********************");
                    System.out.println("Hi " + employeeDo.getEmployeeDoName(idDo));
                    System.out.println("position: staff do");
                    System.out.println("   (1) order");
                    System.out.println("   (0) log out");
                    System.out.print("select menu: ");
                    selectMD = sc.nextInt();
                    if ( selectMD == 1) {
                        int menuN ;
                        System.out.println("==================== orderdrink ====================");
                        System.out.println(order.getShowOrderDetails());
                        System.out.println("staff do " + employeeDo.getEmployeeDoName(idDo));
                        System.out.println("==================================================" + "\n");
                        System.out.println(" 1 confirm inish,  2 cancel");
                        menuN = sc.nextInt();
                        if(menuN == 1 ) {
                            System.out.println("==================== orderdrink ====================");
                            System.out.println(order.getOrderComplet());
                            System.out.println("staff do " + employeeDo.getEmployeeDoName(idDo));
                            System.out.println("==================================================" + "\n");
                        }
                        break;
                    }
                } while(selectMD != 0);
            }
            else if(select == 2) { // stock
                System.out.print(" ID : ");
                int idEx = sc.nextInt();
                if(examiner.getExaminerID(idEx) == true);
                int selectEx;
                do {
                    // glass
                    int cupS = cup.getCupNumber(1);
                    int cupM = cup.getCupNumber(2);
                    int cupL = cup.getCupNumber(3);
                    // raw material
                    int milkJ = raw.getRawNumber(1);
                    int milkS = raw.getRawNumber(2);
                    int kaimuk = raw.getRawNumber(3);
                    int coffee = raw.getRawNumber(4);
                    System.out.println("******************** Bubble tea shop management system ********************");
                    System.out.println("Hi " + examiner.getExaminerName(idEx));
                    System.out.println("position: stock");
                    System.out.println("   (1) stock check");
                    System.out.println("   (2) increase");
                    System.out.println("   (0) log out");
                    System.out.print("select menu: ");
                    selectEx = sc.nextInt();
                    if ( selectEx == 1 ) {
                        System.out.println("==================== stock check ====================");
                        System.out.println("       list                        quantity   ");
                        System.out.println("equipment");
                        System.out.println("     1. glass S size 16 oz.        " + cupS + " blade");
                        System.out.println("     2. glass M size 18 oz.        " + cupM + " blade");
                        System.out.println("     3. glass L size 22 oz.        " + cupL + " blade");
                        System.out.println("                  ");
                        System.out.println("raw material");
                        System.out.println("     1. fresh milk                      " + milkJ + " bag");
                        System.out.println("     3. khi mukh                      " + kaimuk + " bag");
                        System.out.println("     4. coffee                      " + coffee + " bag");
                        System.out.println("=================================================");
                    } 
                    else if( selectEx == 2) {
                        int Stock ;
                        do {
                            System.out.println("========= increase stock =========");
                            System.out.println("   (1) raw material");
                            System.out.println("   (2) equipment");
                            System.out.println("   (0) retrospective");
                            System.out.print("chooselist : ");
                            Stock = sc.nextInt();
                            if (Stock == 2) {
                                System.out.println("==================== increase stock ====================");
                                System.out.println("       list                        quantity   ");
                                System.out.println("equipment");
                                System.out.println("     1. glass S size 16 oz.        " + cupS + " blade");
                                System.out.println("     2. glass M size 18 oz.        " + cupM + " blade");
                                System.out.println("     3. glass L size 22 oz.        " + cupL + " blade");
                                System.out.println("=================================================");
                                System.out.print("choose type : ");
                                int plusRaw = sc.nextInt();
                                    if (plusRaw == 1) {
                                        System.out.print("increase glass S quantity : ");
                                        cupS += sc.nextInt();
                                    }else if (plusRaw == 2) {
                                        System.out.print("increase glass M quantity : ");
                                        cupM += sc.nextInt();
                                    }else if (plusRaw == 3) {
                                        System.out.print("increase glass L quantity : ");
                                        cupL += sc.nextInt(); 
                                    }
                            }
                            else if (Stock == 1) {
                                System.out.println("==================== increase ====================");
                                System.out.println("       list                        quantity   ");
                                System.out.println("raw material");
                                System.out.println("     1. fresh milk                      " + milkJ + " bag");
                                System.out.println("     3. khi mukh                      " + kaimuk + " bag");
                                System.out.println("     4. coffee                      " + coffee + " bag");
                                System.out.println("=================================================");
                                System.out.print("choose type : ");
                                int plusCup = sc.nextInt();
                                    if (plusCup == 1) {
                                        System.out.print(" increase fresh milk quantity : ");
                                        milkJ += sc.nextInt();
                                    }else if (plusCup == 2) {
                                        System.out.print(" increase khi mukh quantity : ");
                                        kaimuk += sc.nextInt();
                                    }else if (plusCup == 3) {
                                        System.out.print(" increase coffee quantity : ");
                                        coffee += sc.nextInt();
                                    }
                            }       
                        } while(Stock != 0);
                    }
                } while(selectEx != 0);
            }
            else if ( select == 1) {
                System.out.print(" ID : ");
                int idM = sc.nextInt();
                if(manager.getManagerID(idM) == true);
                int selectMana;
                do {
                    System.out.println("******************** Bubble tea shop management system ********************");
                    System.out.println("Hi " + manager.getManagerName(idM));
                    System.out.println("position: manager");
                    System.out.println("   (1) View all orders");
                    System.out.println("   (2) stock check");
                    System.out.println("   (0) log out");
                    System.out.print("select menu: ");
                    selectMana = sc.nextInt();
                    if (selectMana == 1) {
                        System.out.println("==================== ordersdrink ====================");
                        System.out.println(order.getShowOrderDetails());
                        System.out.println("==================================================" + "\n");
                    }else if ( selectMana == 2) {
                        // glass
                        int cupS = cup.getCupNumber(1);
                        int cupM = cup.getCupNumber(2);
                        int cupL = cup.getCupNumber(3);
                        // raw material
                        int milkJ = raw.getRawNumber(1);
                        int milkS = raw.getRawNumber(2);
                        int kaimuk = raw.getRawNumber(3);
                        int coffee = raw.getRawNumber(4);
                        System.out.println("==================== stock check ====================");
                        System.out.println("       list                        quantity   ");
                        System.out.println("equipment");
                        System.out.println("     1. glass S size 16 oz.        " + cupS + " blade");
                        System.out.println("     2. glass M size 18 oz.        " + cupM + " blade");
                        System.out.println("     3. glass L size 22 oz.        " + cupL + " blade");
                        System.out.println("                  ");
                        System.out.println("raw material");
                        System.out.println("     1. fresh milk                      " + milkJ + " bag");
                        System.out.println("     3. khi mukh                      " + kaimuk + " bag");
                        System.out.println("     4. coffee                      " + coffee + " bag");
                        System.out.println("=================================================");
                        int Mp ;
                        do {
                            System.out.println("   (1) increaseraw material");//เพิ่มวัตถุดิบ
                            System.out.println("   (2) increaseequipment");//เพิ่มอุปกรณ์
                            System.out.println("   (0) retrospective");//ย้อนกลับ
                            System.out.print("select menu: ");
                            Mp = sc.nextInt();
                            if (Mp == 2) {
                                System.out.println("==================== increase stock====================");
                                System.out.println("       list                        quantity   ");
                                System.out.println("equipment");
                                System.out.println("     1. glass S size 16 oz.        " + cupS + " blade");
                                System.out.println("     2. glass M size 18 oz.        " + cupM + " blade");
                                System.out.println("     3. glass L size 22 oz.        " + cupL + " blade");
                                System.out.println("=================================================");
                                System.out.print("choose type : ");
                                int plusRaw = sc.nextInt();
                                    if (plusRaw == 1) {
                                        System.out.print("increase glass S quantity : ");
                                        cupS += sc.nextInt();
                                    }else if (plusRaw == 2) {
                                        System.out.print("increase glass M quantity : ");
                                        cupM += sc.nextInt();
                                    }else if (plusRaw == 3) {
                                        System.out.print("increase glass L quantity : ");
                                        cupL += sc.nextInt(); 
                                    }
                            }
                            else if (Mp == 1) {
                                System.out.println("==================== increase ====================");
                                System.out.println("       list                        quantity   ");
                                System.out.println("raw material");
                                System.out.println("     1. fresh milk                      " + milkJ + " bag");
                                System.out.println("     3. khi mukh                      " + kaimuk + " bag");
                                System.out.println("     4. coffee                      " + coffee + " bag");
                                System.out.println("=================================================");
                                System.out.print("choose type : ");
                                int plusCup = sc.nextInt();
                                    if (plusCup == 1) {
                                        System.out.print(" increase fresh milk quantity : ");
                                        milkJ += sc.nextInt();
                                    }else if (plusCup == 2) {
                                        System.out.print(" increase khi mukh quantity : ");
                                        kaimuk += sc.nextInt();
                                    }else if (plusCup == 3) {
                                        System.out.print(" increase coffee quantity : ");
                                        coffee += sc.nextInt();
                                    }
                            }       
                        } while(Mp != 0);
                    }
                } while(selectMana != 0);
            }
        }  while(select != 0);
    }
}