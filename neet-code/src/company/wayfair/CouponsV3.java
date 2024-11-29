package company.wayfair;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CouponsV3 {

    private static final Map<String, String> childParentMap = new HashMap<>();
    private static final Map<String, String> categoryCoupons = new HashMap<>();
    private static final Map<String, List<Pair>> categoryDiscounts = new HashMap<>();
    private static final LocalDate today = LocalDate.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        CouponsV3 coupon = new CouponsV3();

        String[][] coupons = {
                {"Comforter Sets", "Comforters Sale"},
                {"Bedding", "Savings on Bedding"},
                {"Bed & Bath", "Low price for Bed & Bath"}
        };

        String[][] coupons1 = {
                {"Comforter Sets", "Comforters Sale", "2020-01-01"},
                {"Comforter Sets", "Cozy Comforter Coupon", "2020-01-01"},
                {"Bedding", "Best Bedding Bargains", "2019-01-01"},
                {"Bedding", "Savings on Bedding", "2019-01-01"},
                {"Bed & Bath", "Low price for Bed & Bath", "2018-01-01"},
                {"Bed & Bath", "Bed & Bath extravaganza", "2019-01-01"},
                {"Bed & Bath", "Big Savings for Bed & Bath", "2030-01-01"}
        };

        String[][] coupons2 = {
                {"Comforter Sets", "Comforters Sale", "2020-01-01", "10%"},
                {"Comforter Sets", "Cozy Comforter Coupon", "2020-01-01", "$15"},
                {"Bedding", "Best Bedding Bargains", "2019-01-01", "35%"},
                {"Bedding", "Savings on Bedding", "2019-01-01", "25%"},
                {"Bed & Bath", "Low price for Bed & Bath", "2018-01-01", "50%"},
                {"Bed & Bath", "Bed & Bath extravaganza", "2019-01-01", "75%"}
        };

        String[][] categories = {
                {"Comforter Sets", "Bedding"},
                {"Bedding", "Bed & Bath"},
                {"Bed & Bath", null},
                {"Soap Dispensers", "Bathroom Accessories"},
                {"Bathroom Accessories", "Bed & Bath"},
                {"Toy Organizers", "Baby And Kids"},
                {"Baby And Kids", null}
        };

        String[][] products = {
                {"Cozy Comforter Sets", "100.00", "Comforter Sets"},
                {"All-in-one Bedding Set", "50.00", "Bedding"},
                {"Infinite Soap Dispenser", "500.00", "Bathroom Accessories"},
                {"Rainbow Toy Box", "257.00", "Baby And Kids"}
        };

        String[] inputs = {
                "Comforter Sets",
                "Bedding",
                "Bathroom Accessories",
                "Soap Dispensers",
                "Toy Organizers"
        };

        String[] input2 = {
                "Bed & Bath",
                "Bedding",
                "Bathroom Accessories",
                "Comforter Sets"
        };

        for (String[] category : categories) {
            childParentMap.put(category[0], category[1]);
        }

        // Case 1
        coupon.preComputeCouponV1(coupons, categories);
        for (String input : inputs) {
            System.out.println(coupon.getCoupons(input));
        }

        // Case 2 and 3
        coupon.preComputeCouponV2(coupons1, categories);
        for (String input : input2) {
            System.out.println(coupon.getCoupons(input));
        }

        // Case 4
        coupon.preComputeCouponV3(coupons2, categories, products);
        for (String[] product : products) {
            System.out.println(coupon.getDiscountedPrice(product));
        }
    }

    public String getCoupons(String categoryName) {
        return categoryCoupons.get(categoryName);
    }

    // case 1
    private void preComputeCouponV1(String[][] coupons, String[][] categories) {
        Map<String, List<String>> tempMap = new HashMap<>();
        for (String[] coupon : coupons) {
            tempMap.computeIfAbsent(coupon[0], k -> new ArrayList<>()).add(coupon[1]);
        }

        for (String[] category : categories) {
            String parentCategory = preComputeParentWithCouponV1(category[0], tempMap);
            if (parentCategory != null) {
                categoryCoupons.put(category[0], String.join(" | ", tempMap.get(parentCategory)));
            }
        }
    }

    private String preComputeParentWithCouponV1(String s, Map<String, List<String>> tempMap) {
        if (s == null || !childParentMap.containsKey(s)) return null;
        if (tempMap.containsKey(s)) return s;
        String parent = childParentMap.get(s);
        return preComputeParentWithCouponV1(parent, tempMap);
    }

    // case 2 and 3
    private void preComputeCouponV2(String[][] coupons, String[][] categories) {
        Map<String, Map<String, List<String>>> tempMap = new HashMap<>();
        for (String[] coupon : coupons) {
            tempMap
                    .computeIfAbsent(coupon[0], k -> new TreeMap<>(Comparator.reverseOrder()))
                    .computeIfAbsent(coupon[2], k -> new ArrayList<>())
                    .add(coupon[1]);
        }

        for (Map.Entry<String, Map<String, List<String>>> entry : tempMap.entrySet()) {
            String category = entry.getKey();
            for (Map.Entry<String, List<String>> dateEntry : entry.getValue().entrySet()) {
                if (!LocalDate.parse(dateEntry.getKey(), formatter).isAfter(today)) {
                    categoryCoupons.put(category, String.join(" | ", dateEntry.getValue()));
                    break;
                }
            }
        }

        for (String[] category : categories) {
            String parentCategory = preComputeParentWithCouponV2(category[0], tempMap);
            if (parentCategory != null) {
                categoryCoupons.put(category[0], categoryCoupons.get(parentCategory));
            }
        }
    }

    private String preComputeParentWithCouponV2(String s, Map<String, Map<String, List<String>>> tempMap) {
        if (s == null || !childParentMap.containsKey(s)) return null;
        if (tempMap.containsKey(s)) return s;
        String parent = childParentMap.get(s);
        return preComputeParentWithCouponV2(parent, tempMap);
    }

    //case 4
    private void preComputeCouponV3(String[][] coupons, String[][] categories, String[][] products) {
        Map<String, Map<String, List<Pair>>> tempMap = new HashMap<>();
        for (String[] coupon : coupons) {
            tempMap
                    .computeIfAbsent(coupon[0], k -> new TreeMap<>(Comparator.reverseOrder()))
                    .computeIfAbsent(coupon[2], k -> new ArrayList<>())
                    .add(new Pair(coupon[1], coupon[3]));
        }

        for (Map.Entry<String, Map<String, List<Pair>>> entry : tempMap.entrySet()) {
            String category = entry.getKey();
            for (Map.Entry<String, List<Pair>> dateEntry : entry.getValue().entrySet()) {
                if (!LocalDate.parse(dateEntry.getKey(), formatter).isAfter(today)) {
                    categoryDiscounts.put(category, dateEntry.getValue());
                    break;
                }
            }
        }

        for (String[] category : categories) {
            String parentCategory = preComputeParentWithCouponV3(category[0], tempMap);
            if (parentCategory != null) {
                categoryDiscounts.put(category[0], categoryDiscounts.get(parentCategory));
            }
        }

        // Precompute discounted prices for products
        for (String[] product : products) {
            String category = product[2];
            double price = Double.parseDouble(product[1]);
            List<Pair> discounts = categoryDiscounts.get(category);
            if (discounts != null) {
                StringBuilder sb = new StringBuilder();
                for (Pair discount : discounts) {
                    if (discount.b.contains("%")) {
                        Matcher matcher = Pattern.compile("(\\d{1,3})%").matcher(discount.b);
                        if (matcher.find()) {
                            double percentage = Double.parseDouble(matcher.group(1));
                            double discountedPrice = price * (1 - percentage / 100);
                            sb.append(String.format("%.2f", discountedPrice)).append(" OR ");
                        }
                    } else if (discount.b.contains("$")) {
                        BigDecimal discountValue = new BigDecimal(discount.b.substring(1));
                        BigDecimal discountedPrice = BigDecimal.valueOf(price).subtract(discountValue).setScale(2, RoundingMode.HALF_UP);
                        sb.append(String.format("%.2f", discountedPrice.doubleValue())).append(" OR ");
                    }
                }
                if (sb.length() > 0) sb.setLength(sb.length() - 4); // Remove trailing " OR "
                categoryDiscounts.put(product[0], Collections.singletonList(new Pair("", sb.toString())));
            }
        }
    }

    private String preComputeParentWithCouponV3(String s, Map<String, Map<String, List<Pair>>> tempMap) {
        if (s == null || !childParentMap.containsKey(s)) return null;
        if (tempMap.containsKey(s)) return s;
        String parent = childParentMap.get(s);
        return preComputeParentWithCouponV3(parent, tempMap);
    }

    public String getDiscountedPrice(String[] product) {
        if (product == null || product.length < 3) return null;
        List<Pair> discounts = categoryDiscounts.get(product[0]);
        return discounts == null ? product[1] : discounts.get(0).b;
    }

    static class Pair {
        String a;
        String b;

        Pair(String a, String b) {
            this.a = a;
            this.b = b;
        }
    }

}