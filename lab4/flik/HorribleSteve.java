package flik;

public class HorribleSteve {
    public static void main(String [] args) throws Exception {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            boolean flag = Flik.isSameNumber(i, j);
            if (j % 128 == 0 || j >=128){
                int ja=-127,ia=-127;
                flag = Flik.isSameNumber(ja, ia);
                ja++;
                ia++;
                if (ja == 127){
                    ja = -127;
                    ia = -127;
                }
            }
            if (!flag) {
                throw new Exception(
                        String.format("i:%d not same as j:%d ??", i, j));
            }
        }
        System.out.println("i is " + i);
    }
}
