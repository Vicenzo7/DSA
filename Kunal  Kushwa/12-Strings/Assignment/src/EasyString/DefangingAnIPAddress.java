package EasyString;

public class DefangingAnIPAddress {

    public static void main(String[] args) {
        String ads = "1.1.1.1";
        System.out.println(defangIPaddr(ads));
    }


    public static String defangIPaddr(String address) {
        String ans = address.replace(".","[.]");
        return ans;
    }
}
