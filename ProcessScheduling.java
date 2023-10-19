package processAdjust;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @version 18.0
 * Create at 2023/5/23 17:47
 * @ProblemDetile: ���̵����㷨
 */

public class ProcessScheduling {
    private static ArrayList<Process> processes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void start() {
        initialProcesses();
        option();
    }


    private static void option() {
        System.out.println("��������ĵ���ѡ��");
        System.out.println("1.ʱ��Ƭ��ת����");
        System.out.println("2.���ȶȵ���");
        System.out.println("3.�˳������㷨");

        w1:
        while (true) {
            switch (sc.nextInt()) {
                case 1:

                    System.out.println("������ʱ��Ƭ���ȣ�");
                    roundTimeDispatch(sc.nextInt());
                    break;

                case 2:

                    System.out.println("������ʱ��Ƭ���ȣ�");
                    priorityDispatch(sc.nextInt());
                    break;
                case 3:
                    System.out.println("�ѳɹ��˳���");
                    break w1;
                default:
                    System.out.println("���������������������룡");


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
                return o2.getPrio() -  o1.getPrio() ;//�ɴ�С����
            }
        });
        int i  = 0;

        while (true){
            if (Process.count == 0){
                System.out.println("���н��������н����������²��õ��ȳ���");
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
                System.out.println("ʣ��������� = " + processes.size());
                System.out.println("========================================================");
            }

            Collections.sort(processes, new Comparator<Process>() {
                @Override
                public int compare(Process o1, Process o2) {
                    return o2.getPrio() -  o1.getPrio() ;//�ɴ�С����
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
        System.out.println("�ý���Ĭ�ϴӵ�һ������ĳ�����");
        while (true) {
            if (Process.count == 0){
                System.out.println("���н��������н����������²��õ��ȳ���");
                break;
            }

            processes.get(i).setNeedTime(processes.get(i).getNeedTime() - roundTime);
            System.out.println(processes.get(i).toString());
            if (processes.get(i).getNeedTime() <= 0) {
                Process.count--;

                processes.remove(i);
                System.out.println("ʣ��������� = " + processes.size());
                System.out.println("========================================================");


            }

            i++;


            if (i >= processes.size()) {
                i = 0;
            }
        }


    }



    public static void initialProcesses() {
        System.out.println("�����������");
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            Process p = new Process();
            System.out.println("�������������������ɻ���Ҫ��ʱ�䣺");
            p.setProcessName(sc.next());
            p.setNeedTime(sc.nextInt());
            Process.count++;
            processes.add(p);
        }

    }
}
