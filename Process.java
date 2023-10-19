package processAdjust;

/**
 * @version 18.0
 * Create at 2023/5/23 17:29
 * @ProblemDetile:
 */

public class Process {
    private String ProcessName;
    private int startTime;
    private int prio;
    private int roundTime;
    private int occupyTime;
    private int needTime;
     static int count;

    public Process() {
    }

    public Process(String ProcessName, int startTime, int priority, int roundTime, int occupyTime, int needTime, int count) {
        this.ProcessName = ProcessName;
        this.startTime = startTime;
        this.prio = priority;
        this.roundTime = roundTime;
        this.occupyTime = occupyTime;
        this.needTime = needTime;
        this.count = count;
    }

    /**
     * 获取
     * @return count
     */
    public static int getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public static void setCount(int count) {
        Process.count = count;
    }

    /**
     * 获取
     * @return ProcessName
     */
    public String getProcessName() {
        return ProcessName;
    }

    /**
     * 设置
     * @param ProcessName
     */
    public void setProcessName(String ProcessName) {
        this.ProcessName = ProcessName;
    }

    /**
     * 获取
     * @return startTime
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * 设置
     * @param startTime
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取
     * @return prio
     */
    public int getPrio() {
        return prio;
    }

    /**
     * 设置
     * @param prio
     */
    public void setPrio(int prio) {
        this.prio = prio;
    }

    /**
     * 获取
     * @return roundTime
     */
    public int getRoundTime() {
        return roundTime;
    }

    /**
     * 设置
     * @param roundTime
     */
    public void setRoundTime(int roundTime) {
        this.roundTime = roundTime;
    }

    /**
     * 获取
     * @return occupyTime
     */
    public int getOccupyTime() {
        return occupyTime;
    }

    /**
     * 设置
     * @param occupyTime
     */
    public void setOccupyTime(int occupyTime) {
        this.occupyTime = occupyTime;
    }

    /**
     * 获取
     * @return needTime
     */
    public int getNeedTime() {
        return needTime;
    }

    /**
     * 设置
     * @param needTime
     */
    public void setNeedTime(int needTime) {
        this.needTime = needTime;
    }

    public String toString() {
        return "Process{ProcessName = " + ProcessName + ", startTime = " + startTime + ", prio = " + prio + ", roundTime = " + roundTime + ", occupyTime = " + occupyTime + ", needTime = " + needTime + ", count = " + count + "}";
    }


    /**
     * 获取
     * @return ProcessName
     */


    enum state {
        RUNNING, READY, FINISHING;

        state() {
        }


    }

}
