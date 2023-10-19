package processAdjust;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @version 18.0
 * Create at 2023/5/23 17:47
 * @ProblemDetile: 进程调度算法
 */

public class ProcessScheduling {
    private static ArrayList<Process> processes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void start() {
        initialProcesses();
        option();
    }


    private static void option() {
        System.out.println("请输入你的调度选择");
        System.out.println("1.时间片轮转调度");
        System.out.println("2.优先度调度");
        System.out.println("3.退出调度算法");

        w1:
        while (true) {
            switch (sc.nextInt()) {
                case 1:

                    System.out.println("请输入时间片长度：");
                    roundTimeDispatch(sc.nextInt());
                    break;

                case 2:

                    System.out.println("请输入时间片长度：");
                    priorityDispatch(sc.nextInt());
                    break;
                case 3:
                    System.out.println("已成功退出！");
                    break w1;
                default:
                    System.out.println("您的输入有误，请重新输入！");


            }
        }
    }


    private static void priorityDispatch(int roundTime) {


        for (Process p : processes) {

            p.setPrio(50 - p.getNeedTime());
            p.setRoundTime(roundTime);
            p.setOccupyTime(roundTime);

        }
        Collections.sort(processes, new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                return o2.getPrio() -  o1.getPrio() ;//由大到小排序
            }
        });
        int i  = 0;

        while (true){
            if (Process.count == 0){
                System.out.println("所有进程已运行结束，请重新采用调度程序");
                break;
            }



            Process p0 = processes.get(0);
            System.out.println(p0.toString());

            p0.setNeedTime(p0.getNeedTime() - roundTime);
            p0.setPrio(0 - i ++);

            if (p0.getNeedTime() <= 0) {
                Process.count--;

                processes.remove(p0);
                System.out.println(processes.size());
                System.out.println("剩余进程数量 = " + processes.size());
                System.out.println("========================================================");
            }

            Collections.sort(processes, new Comparator<Process>() {
                @Override
                public int compare(Process o1, Process o2) {
                    return o2.getPrio() -  o1.getPrio() ;//由大到小排序
                }
            });
        }
    }




    private static void roundTimeDispatch(int roundTime) {
        for (Process p : processes) {

            p.setRoundTime(roundTime);
            p.setOccupyTime(roundTime);
        }

        int i = 0;
        System.out.println("该进程默认从第一个加入的程序开启");
        while (true) {
            if (Process.count == 0){
                System.out.println("所有进程已运行结束，请重新采用调度程序");
                break;
            }

            processes.get(i).setNeedTime(processes.get(i).getNeedTime() - roundTime);
            System.out.println(processes.get(i).toString());
            if (processes.get(i).getNeedTime() <= 0) {
                Process.count--;

                processes.remove(i);
                System.out.println("剩余进程数量 = " + processes.size());
                System.out.println("========================================================");


            }

            i++;


            if (i >= processes.size()) {
                i = 0;
            }
        }


    }



    public static void initialProcesses() {
        System.out.println("请输入进程数");
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            Process p = new Process();
            System.out.println("请输入进程名，进程完成还需要的时间：");
            p.setProcessName(sc.next());
            p.setNeedTime(sc.nextInt());
            Process.count++;
            processes.add(p);
        }

    }
}
