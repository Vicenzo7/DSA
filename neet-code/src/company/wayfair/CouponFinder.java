package company.wayfair;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CouponFinder {


    // https://leetcode.com/discuss/interview-question/4491846/Wayfair-or-SDE2-L2-4-Onsite-Virtual-or-Coupon-category

    public static void main(String[] args) {
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
            String child = category[0];
            String parent = category[1];
            childParentMap.put(child, parent);
        }

        // first case
        for (String input : inputs) {
            System.out.println(computeV1(input, coupons));
        }
        System.out.println("End of question1");
        System.out.println();

        // second need TC of O(1)
        computeCouponV2(coupons, categories);
        for (String input : inputs) {
            System.out.println(getCoupon(input));
        }
        System.out.println("End of question2");
        System.out.println();


        // third need the latest modified coupon
        computeV3(coupons1, categories);
        for (String input : input2) {
            System.out.println(getCoupon(input));
        }
        System.out.println("End of question3");
        System.out.println();


        computeV4(coupons2, categories, products);
        for (String[] product : products) {
            System.out.println(getDiscountedPrice(product));
        }
        System.out.println("End of question4");
        System.out.println();

    }

    private static String computeV1(String category, String[][] coupons) {
        for (String[] coupon : coupons) {
            if (category.equalsIgnoreCase(coupon[0])) {
                return coupon[1];
            }
        }
        String parentCategory = childParentMap.get(category);
        if (parentCategory == null) {
            return null;
        }
        return computeV1(parentCategory, coupons);

    }

    private static String getCoupon(String input) {
        return categoryCouponMap.getOrDefault(input, null);
    }


    private static final Map<String, String> childParentMap = new HashMap<>();
    private static final Map<String, String> categoryCouponMap = new HashMap<>();
    private static final Map<String, List<Pair>> categoryDiscountMap = new HashMap<>();
    private static final LocalDate TODAY = LocalDate.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    private static void computeCouponV2(String[][] coupons, String[][] categories) {
        Map<String, String> tempMap = new HashMap<>();
        for (String[] coupon : coupons) {
            String categoryName = coupon[0];
            String couponName = coupon[1];
            tempMap.put(categoryName, couponName);
        }

        for (String[] category : categories) {
            String childCategory = category[0];
            String parentCategory = computeParentCouponV2(childCategory, tempMap);
            if (parentCategory != null) {
                categoryCouponMap.put(childCategory, tempMap.get(parentCategory));
            }
        }
    }

    private static String computeParentCouponV2(String childCategory, Map<String, String> tempMap) {
        if (childCategory == null || !childParentMap.containsKey(childCategory))
            return null;

        if (tempMap.containsKey(childCategory)) return childCategory;

        String parentCategory = childParentMap.get(childCategory);
        return computeParentCouponV2(parentCategory, tempMap);
    }


    private static void computeV3(String[][] coupons1, String[][] categories) {
        Map<String, Map<String, List<String>>> tempMap = new HashMap<>();
        for (String[] couponInfo : coupons1) {
            String category = couponInfo[0];
            String coupon = couponInfo[1];
            String date = couponInfo[2];
            tempMap.computeIfAbsent(category, k -> new TreeMap<>(Collections.reverseOrder()))
                    .computeIfAbsent(date, k -> new ArrayList<>())
                    .add(coupon);
        }

        for (Map.Entry<String, Map<String, List<String>>> entry : tempMap.entrySet()) {
            String category = entry.getKey();
            Map<String, List<String>> dateToCoupons = entry.getValue();
            for (Map.Entry<String, List<String>> dateEntry : dateToCoupons.entrySet()) {
                String date = dateEntry.getKey();
                List<String> coupons = dateEntry.getValue();
                if (!LocalDate.parse(date, formatter).isAfter(TODAY)) {
                    categoryCouponMap.put(category, String.join(" | ", coupons));
                    break;
                }
            }
        }

        for (String[] category : categories) {
            String childCategory = category[0];
            String parentCategory = computeParentCouponV3(childCategory, tempMap);
            if (parentCategory != null) {
                categoryCouponMap.put(childCategory, categoryCouponMap.get(parentCategory));
            }
        }
    }

    private static String computeParentCouponV3(String childCategory, Map<String, Map<String, List<String>>> tempMap) {
        if (childCategory == null || !childParentMap.containsKey(childCategory))
            return null;

        if (tempMap.containsKey(childCategory)) return childCategory;

        String parentCategory = childParentMap.get(childCategory);
        return computeParentCouponV3(parentCategory, tempMap);
    }


    private static void computeV4(String[][] coupons, String[][] categories, String[][] products) {

        Map<String, Map<String, List<Pair>>> tempMap = new HashMap<>();

        for (String[] couponInfo : coupons) {
            String category = couponInfo[0];
            String coupon = couponInfo[1];
            String date = couponInfo[2];
            String discount = couponInfo[3];

            tempMap.computeIfAbsent(category, k -> new TreeMap<>(Collections.reverseOrder()))
                    .computeIfAbsent(date, k -> new ArrayList<>())
                    .add(new Pair(coupon, discount));
        }


        for (Map.Entry<String, Map<String, List<Pair>>> entry : tempMap.entrySet()) {
            String category = entry.getKey();
            Map<String, List<Pair>> dateEntry = entry.getValue();
            for (Map.Entry<String, List<Pair>> dateEntryInfo : dateEntry.entrySet()) {
                String date = dateEntryInfo.getKey();
                if (!LocalDate.parse(date, formatter).isAfter(TODAY)) {
                    List<Pair> couponsAndDiscounts = dateEntryInfo.getValue();
                    categoryDiscountMap.put(category, couponsAndDiscounts);
                    break;
                }
            }
        }


        for (String[] categoryInfo : categories) {
            String childCategory = categoryInfo[0];
            String parentCategory = computeParentCouponV4(childCategory, tempMap);
            if (parentCategory != null) {
                categoryDiscountMap.put(childCategory, categoryDiscountMap.get(parentCategory));
            }
        }

        for (String[] product : products) {
            double price = Double.parseDouble(product[1]);
            String category = product[2];
            List<Pair> discountsInfo = categoryDiscountMap.get(category);
            if (discountsInfo != null && !discountsInfo.isEmpty()) {
                StringJoiner stringJoiner = new StringJoiner(" OR ");
                for (Pair pair : discountsInfo) {
                    String discount = pair.getDiscount();
                    if (discount.contains("%")) {
                        discount = discount.replaceAll("%", "");
                        double percentage = Double.parseDouble(discount);
                        double discountedPrice = price * (1 - percentage / 100);
                        stringJoiner.add(String.format("%.2f", discountedPrice));
                    } else if (discount.contains("$")) {
                        BigDecimal discountValue = new BigDecimal(discount.substring(1));
                        BigDecimal discountedPrice = BigDecimal.valueOf(price).subtract(discountValue);
                        stringJoiner.add(String.format("%.2f", discountedPrice));
                    }
                }
                categoryDiscountMap.put(category, Collections.singletonList(new Pair("", stringJoiner.toString())));
            }
        }
    }

    private static String computeParentCouponV4(String category, Map<String, Map<String, List<Pair>>> tempMap) {
        if (category == null || !childParentMap.containsKey(category))
            return null;

        if (tempMap.containsKey(category))
            return category;
        String parentCategory = childParentMap.get(category);
        return computeParentCouponV4(parentCategory, tempMap);
    }


    private static String getDiscountedPrice(String[] product) {
        if (product == null || product.length < 3) {
            return null;
        }
        String price = product[1];
        String category = product[2];
        List<Pair> discounts = categoryDiscountMap.get(category);
        return discounts == null ? price : discounts.get(0).discount;
    }


    static class Pair {
        private String coupon;
        private String discount;

        public Pair(String coupon, String discount) {
            this.coupon = coupon;
            this.discount = discount;
        }

        public String getCoupon() {
            return coupon;
        }

        public void setCoupon(String coupon) {
            this.coupon = coupon;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }
    }

}
