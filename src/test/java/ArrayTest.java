public class ArrayTest {
    private void run(){
        A ab = new B("astr","bstr");
        ab.printStr();
        ((B) ab).printStr(5);
        ab.printA();
        ((B) ab).printB();

    }
    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest();
        arrayTest.run();
    }

    private class A{
        private String strDataA;

        public A(String atrDataA) {
            this.strDataA = atrDataA;
        }
        public void printStr(){
            System.out.println("A.strDataA = " + strDataA);
        }
        public void printA(){
            System.out.println("printA");
        }

    }

    private class B extends A{
        private String strDataB;

        public B(String atrDataA, String strDataB) {
            super(atrDataA);
            this.strDataB = strDataB;
        }
        public void printStr(){
            System.out.println("B.strDataB = " + strDataB);
        }

        public void printStr(int x){
            System.out.println("B.strDataB = " + strDataB.concat(String.valueOf(x)));
        }

        public void printB(){
            System.out.println("printB");
        }
    }
}
