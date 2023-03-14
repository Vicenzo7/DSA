## Brute force
- Traverse from 1 to min(a,b).
- And check if i is divisible by both a and b.If yes store it in the answer.
- Find the maximum value of i which divides both a and b.


## Euclid's Algorithm

Euclid's Algorithm provides a more efficient way to find the HCF and lowest common multiple (LCM) of two integers, a and b. The HCF of a and b is equal to the minimum positive value of the equation ax + by, where x and y are integers.

### HCF Formula

The HCF of a and b can be calculated using the following formula:

HCF(a,b) == `HCF(remainder(b % a),a)` 

if a == 0, hcf is b;


### LCM Formula

The LCM of a and b can be calculated using the following formula:

LCM(a,b) = `(a*b) / HCF(a,b)`
