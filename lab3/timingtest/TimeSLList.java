package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<Integer>();
        int M = 10000;

        int temp = 1000;
        while(temp <= 128000){
            Ns.addLast(temp);
            opCounts.addLast(temp);
            temp *= 2;
        }

        for(int i = 0; i < Ns.size(); i++){
            int N = Ns.get(i);
            int j = 0;
            SLList<Integer> list = new SLList<Integer>();
            while(j < N){
                list.addLast(j);
                j++;
            }

            Stopwatch sw = new Stopwatch();
            for(int k = 0; k < M; k++){
                list.getLast();
            }
            times.addLast(sw.elapsedTime());
        }
        printTimingTable(Ns, times, opCounts);
    }

}
