package company.wayfair;

public class IPAddressBucket {

    public static void main(String[] args) {
        // Test cases
        String[] ips = {"192.168.1.1", "10.0.0.1", "256.100.50.25", "225.0.0.1"};
        for (String ip : ips) {
            System.out.println(ip + " -> " + getBucket(ip));
        }
    }

    private static int getBucket(String ipAddress) {
        // Validate and parse the IP address
        String[] parts = ipAddress.split("\\.");
        if (parts.length != 4) {
            return -1; // Not a valid IP address
        }

        int[] octets = new int[4];
        try {
            for (int i = 0; i < 4; i++) {
                octets[i] = Integer.parseInt(parts[i]);
                if (octets[i] < 0 || octets[i] > 255) {
                    return -1; // Invalid octet
                }
            }
        } catch (NumberFormatException e) {
            return -1; // Invalid format
        }

        // Determine the bucket based on the first octet
        int firstOctet = octets[0];
        if (firstOctet >= 0 && firstOctet <= 127) {
            return 0;
        } else if (firstOctet >= 128 && firstOctet <= 191) {
            return 1;
        } else if (firstOctet >= 192 && firstOctet <= 223) {
            return 2;
        } else if (firstOctet >= 224 && firstOctet <= 239) {
            return 3;
        } else if (firstOctet >= 240 && firstOctet <= 255) {
            return 4;
        } else {
            return -1; // Should never reach here
        }
    }
}
