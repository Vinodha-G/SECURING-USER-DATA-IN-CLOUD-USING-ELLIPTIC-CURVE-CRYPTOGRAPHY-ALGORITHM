package project;

import java.math.BigInteger;


public class EllipticCurve {
    
   
    private BigInteger a;
    private BigInteger b;
    private BigInteger p;
    
    
    private ECPoint g = null;
    
    
    private static BigInteger THREE = new BigInteger("3");
    
    public EllipticCurve(BigInteger a, BigInteger b, BigInteger p) {
        this.a = a;
        this.b = b;
        this.p = p;
    }
    
    public EllipticCurve(BigInteger a, BigInteger b, BigInteger p, ECPoint g) {
        this.a = a;
        this.b = b;
        this.p = p;
        this.g = g;
    }
    
    public EllipticCurve(long a, long b, long p) {
        this.a = BigInteger.valueOf(a);
        this.b = BigInteger.valueOf(b);
        this.p = BigInteger.valueOf(p);
    }

    public EllipticCurve(long a, long b, long p, ECPoint g) {
        this.a = BigInteger.valueOf(a);
        this.b = BigInteger.valueOf(b);
        this.p = BigInteger.valueOf(p);
        this.g = g;
    }
    
    public ECPoint getBasePoint() {
        return g;
    }
    
    public void setBasePoint(ECPoint g) {
        this.g = g;
    }
    
    public BigInteger getA() {
        return a;
    }
    
    public BigInteger getB() {
        return b;
    }
    
    public BigInteger getP() {
        return p;
    }
    
   
    
    public static final EllipticCurve NIST_P_192 = new EllipticCurve(
            new BigInteger("-3"),
            new BigInteger("64210519e59c80e70fa7e9ab72243049feb8deecc146b9b1", 16),
            new BigInteger("6277101735386680763835789423207666416083908700390324961279"),
            new ECPoint(
                    new BigInteger("188da80eb03090f67cbf20eb43a18800f4ff0afd82ff1012", 16),
                    new BigInteger("07192b95ffc8da78631011ed6b24cdd573f977a11e794811", 16)
            )
    );

    
    public static final EllipticCurve NIST_P_224 = new EllipticCurve(
            new BigInteger("-3"),
            new BigInteger("b4050a850c04b3abf54132565044b0b7d7bfd8ba270b39432355ffb4", 16),
            new BigInteger("26959946667150639794667015087019630673557916260026308143510066298881"),
            new ECPoint(
                    new BigInteger("b70e0cbd6bb4bf7f321390b94a03c1d356c21122343280d6115c1d21", 16),
                    new BigInteger("bd376388b5f723fb4c22dfe6cd4375a05a07476444d5819985007e34", 16)
            )
    );
    
    public static final EllipticCurve NIST_P_256 = new EllipticCurve(
            new BigInteger("-3"),
            new BigInteger("5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", 16),
            new BigInteger("115792089210356248762697446949407573530086143415290314195533631308867097853951"),
            new ECPoint(
                    new BigInteger("6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16),
                    new BigInteger("4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16)
            )
    );
    
    public static final EllipticCurve NIST_P_384 = new EllipticCurve(
            new BigInteger("-3"),
            new BigInteger("b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef", 16),
            new BigInteger("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319"),
            new ECPoint(
                    new BigInteger("aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", 16),
                    new BigInteger("3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f", 16)
            )
    );
    
    public static final EllipticCurve NIST_P_521 = new EllipticCurve(
            new BigInteger("-3"),
            new BigInteger("051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00", 16),
            new BigInteger("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151"),
            new ECPoint(
                    new BigInteger("c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", 16),
                    new BigInteger("11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650", 16)
            )
    );
    
  
    public boolean isPointInsideCurve(ECPoint point) {
        if (point.isPointOfInfinity()) return true;
        
        return point.x.multiply(point.x).mod(p).add(a).multiply(point.x).add(b)
                .mod(p).subtract(point.y.multiply(point.y)).mod(p)
                .compareTo(BigInteger.ZERO) == 0;
    }
    
    
    public ECPoint add(ECPoint p1, ECPoint p2) {
        if (p1 == null || p2 == null) return null;
        
        if (p1.isPointOfInfinity()) {
            return new ECPoint(p2);
        } else if (p2.isPointOfInfinity()) {
            return new ECPoint(p1);
        }
        
        
        BigInteger lambda;
        if (p1.x.subtract(p2.x).mod(p).compareTo(BigInteger.ZERO) == 0) {
            if (p1.y.subtract(p2.y).mod(p).compareTo(BigInteger.ZERO) == 0) {
              
                BigInteger nom = p1.x.multiply(p1.x).multiply(THREE).add(a);
                BigInteger den = p1.y.add(p1.y);
                lambda = nom.multiply(den.modInverse(p));
            } else {
            
                return ECPoint.INFINTIY;
            }
        } else {
            
            BigInteger nom = p2.y.subtract(p1.y);
            BigInteger den = p2.x.subtract(p1.x);
            lambda = nom.multiply(den.modInverse(p));
        }
        
        
        BigInteger xr = lambda.multiply(lambda).subtract(p1.x).subtract(p2.x).mod(p);
        BigInteger yr = lambda.multiply(p1.x.subtract(xr)).subtract(p1.y).mod(p);
        return new ECPoint(xr, yr);
    }
    
   
    public ECPoint subtract(ECPoint p1, ECPoint p2) {
        if (p1 == null || p2 == null) return null;
        
        return add(p1, p2.negate());
    }

    
    public ECPoint multiply(ECPoint p1, BigInteger n) {
        if (p1.isPointOfInfinity()) {
            return ECPoint.INFINTIY;
        }
        
        ECPoint result = ECPoint.INFINTIY;
        int bitLength = n.bitLength();
        for (int i = bitLength - 1; i >= 0; --i) {
            result = add(result, result);
            if (n.testBit(i)) {
                result = add(result, p1);
            }
        }
        
        return result;
    }
    
    public ECPoint multiply(ECPoint p1, long n) {
        return multiply(p1, BigInteger.valueOf(n));
    }

   
    public BigInteger calculateRhs(BigInteger x) {
        return x.multiply(x).mod(p).add(a).multiply(x).add(b).mod(p);
    }
    
   
    public static void main(String[] args) {
        
        System.out.println("NIST_P_192: " + EllipticCurve.NIST_P_192.isPointInsideCurve(EllipticCurve.NIST_P_192.getBasePoint()));
        System.out.println("NIST_P_224: " + EllipticCurve.NIST_P_224.isPointInsideCurve(EllipticCurve.NIST_P_224.getBasePoint()));
        System.out.println("NIST_P_256: " + EllipticCurve.NIST_P_256.isPointInsideCurve(EllipticCurve.NIST_P_256.getBasePoint()));
        System.out.println("NIST_P_384: " + EllipticCurve.NIST_P_384.isPointInsideCurve(EllipticCurve.NIST_P_384.getBasePoint()));
        System.out.println("NIST_P_521: " + EllipticCurve.NIST_P_521.isPointInsideCurve(EllipticCurve.NIST_P_521.getBasePoint()));
        
        for (int i = 0; i < 20; ++i) {
            System.out.println("NIST_P_521 x " + i + " = " + EllipticCurve.NIST_P_521.multiply(EllipticCurve.NIST_P_521.getBasePoint(), i).toString(16));
        }
        
        
        EllipticCurve e = new EllipticCurve(1, 6, 11);
        ECPoint p = new ECPoint(3, 5);
        ECPoint q = new ECPoint(5, 9);
        
        System.out.println(p + " + " + q + " = " + e.add(p, q));
        for (int i = 0; i < 20; ++i) {
            System.out.println(p + " x " + i + " = " + e.multiply(p, i));
        }
    }

}
