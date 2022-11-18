public class Main {
    private int idNum = 99;
    private String name = "Steve";
    private int age = 55;
    private int lotteryNumbers[];

    public int getIdNum() {
        return idNum;
    }

    public Main() {
        this.lotteryNumbers = new int[6];
        this.chargeLotteryNumbers();
    }

    public void chargeLotteryNumbers() {
        for (int i = 0; i < lotteryNumbers.length; i++) {//write random numbers in randoms[]
            lotteryNumbers[i] = (int) Math.round(Math.random() * 10);
        }
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nId: " + this.idNum + "\nAge: " + this.age;
    }

    public void bubbleSortLottery() {

        for (int i = 0; i < lotteryNumbers.length - 1; i++) {
            //System.out.println("iteration " + i);
            boolean swapped = true;
            for (int j = 0; j < lotteryNumbers.length - i - 1; j++)
                if (lotteryNumbers[j] > lotteryNumbers[j + 1]) {
                    int temp = lotteryNumbers[j];
                    lotteryNumbers[j] = lotteryNumbers[j + 1];
                    lotteryNumbers[j + 1] = temp;
                    swapped = false;
                }
            if (swapped == true)
                break;
        }
    }

    public void printLottery() {
        System.out.println("\n");
        for (int i = 0; i < lotteryNumbers.length; i++) {//print randoms[]
            System.out.println("lotteryNumber " + i + " is: " + lotteryNumbers[i]);
        }
    }


    public final static void main(String[] args) {
        Main m = new Main();
        System.out.println(m);

        if (m.getIdNum() > 100) {
            System.out.println("Id > 100");
        } else {
            System.out.println("Id <= 100");
        }

        m.printLottery();
        m.bubbleSortLottery();
        m.printLottery();


    }


}