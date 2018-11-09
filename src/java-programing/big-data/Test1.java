import java.math.BigDecimal;
import java.math.BigInteger;

public class Test1 {
    public static void main(String[] args) {
        // 计算 1949的2016次方
        BigDecimal bd = new BigDecimal(1949);
        bd = bd.pow(2016); // 1949^2016
        System.out.println(bd);

        // 计算2016的阶乘 result=2016！
        BigInteger n = BigInteger.valueOf(2016);
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        System.out.println(result);
    }
}

