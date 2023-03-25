import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Indent {
    public static ArrayList<Address> addresses = new ArrayList<>();
    public static Address address;

    public static void main(String[] args) {
        requestAddresses();
        address.showCount();
        shows();
        showByCondition1();
        showByCondition2();
    }

    public static void requestAddresses() {
        Scanner sc = new Scanner(System.in);
        String STREET;
        int HOUSE_NUMBER, APARTMENT_NUMBER;
        String continueEnteringAddresses;

        System.out.println("Введите адреса:");
        do {
            System.out.print("Улица: ");
            STREET = sc.next();
            System.out.print("Номер дома: ");
            HOUSE_NUMBER = sc.nextInt();
            System.out.print("Номер квартиры: ");
            APARTMENT_NUMBER = sc.nextInt();
            address = new Address(STREET, HOUSE_NUMBER, APARTMENT_NUMBER);
            addresses.add(address);
            System.out.print("Продолжить ввод адресов? (y/n): ");
            continueEnteringAddresses = sc.next();
            showEmptyParagraph();
        } while (continueEnteringAddresses.equals("y"));
    }

    public static void shows() {
        System.out.println("Адреса:");
        for (Address address : addresses) {
            address.show();
        }
        showEmptyParagraph();
    }
    public static void showByCondition1() {
        boolean isObjectFound = false;
        System.out.println("Номер дома четный или номер квартиры меньше 30");
        for (Address address : addresses) {
            if (address.getHouseNumber() % 2 == 0 || address.getApartmentNumber() < 30) {
                address.show();
                isObjectFound = true;
            }
        }
        if (!isObjectFound)
            System.out.println("Не существует чётного номера дома или номер квартиры меньше 30");
        showEmptyParagraph();
    }

    public static void showByCondition2() {
        boolean isObjectFound = false;
        System.out.println("Название улицы не начинается на букву «П» и «Т»");
        for (Address address : addresses) {
            String firstLetter = String.valueOf(address.getStreet().charAt(0));
            if (!firstLetter.equals("П") && !firstLetter.equals("Т")) {
                address.show();
                isObjectFound = true;
            }
        }
        if (!isObjectFound)
            System.out.println("Не существует названии улиц не начинающиеся на букву «П» и «Т»");
    }
}

class Address extends Indent {
    private final String STREET;
    private final int HOUSE_NUMBER;
    private final int APARTMENT_NUMBER;
    private static int count;

    Address() {
        STREET = "Кехфых";
        HOUSE_NUMBER = 91;
        APARTMENT_NUMBER = 100;
        increaseCount();
    }

    public void increaseCount() {
        count++;
    }

    Address(String STREET, int HOUSE_NUMBER, int APARTMENT_NUMBER) {
        this.STREET = STREET;
        this.HOUSE_NUMBER = HOUSE_NUMBER;
        this.APARTMENT_NUMBER = APARTMENT_NUMBER;
        increaseCount();
    }

    Address(Address address) {
        STREET = address.STREET;
        HOUSE_NUMBER = address.HOUSE_NUMBER;
        APARTMENT_NUMBER = address.APARTMENT_NUMBER;
        increaseCount();
    }

    public void show() {
        System.out.println("Улица " + STREET);
        System.out.println("Номер дома " + HOUSE_NUMBER);
        System.out.println("Номер квартиры " + APARTMENT_NUMBER);
        showEmptyParagraph();
    }

    public void showCount() {
        System.out.println("Количество адресов " + count);
        showEmptyParagraph();
    }

    public String getStreet() {
        return STREET;
    }

    public int getHouseNumber() {
        return HOUSE_NUMBER;
    }

    public int getApartmentNumber() {
        return APARTMENT_NUMBER;
    }
}

class Indent {
    public static void showEmptyParagraph() {
        System.out.println();
    }
}
