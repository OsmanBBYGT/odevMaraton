public class Maraton {
    private String[] runnersNameArrays;
    private final int[] runnersMinutesArrays;

    public Maraton(String[] runners, int[] runnersMinute) {
        this.runnersNameArrays = runners;
        this.runnersMinutesArrays = runnersMinute;
    }

    public String[] getRunnersNameArrays() {
        return runnersNameArrays;
    }

    public void setRunnersNameArrays(String[] runnersNameArrays) {
        this.runnersNameArrays = runnersNameArrays;
    }

    public int getFirst() {
        int minMinutes = runnersMinutesArrays[0];

        for (int i = 1; i < runnersMinutesArrays.length; i++) {
            if (runnersMinutesArrays[i] < minMinutes) {
                minMinutes = runnersMinutesArrays[i];
            }
        }

        return minMinutes;
    }

    public String getFirstName() {
        int minMinutes = runnersMinutesArrays[0];
        String minRunnerName = runnersNameArrays[0];

        for (int i = 1; i < runnersMinutesArrays.length; i++) {
            if (runnersMinutesArrays[i] < minMinutes) {
                minMinutes = runnersMinutesArrays[i];
                minRunnerName = runnersNameArrays[i];
            }
        }

        return minRunnerName;
    }


    public int getSecond() {
        int firstMin = getFirst();
        int secondMin = runnersMinutesArrays[0];

        for (int i = 0; i < runnersMinutesArrays.length; i++) {
            int currentMinute = runnersMinutesArrays[i];

            if (currentMinute > firstMin && currentMinute < secondMin) {
                secondMin = currentMinute;
            }
        }

        return secondMin;
    }

    public String getSecondName() {
        int firstMin = getFirst();
        int secondMin = runnersMinutesArrays[0];
        String secondRunner = "";

        for (int i = 0; i < runnersMinutesArrays.length; i++) {
            int currentMinute = runnersMinutesArrays[i];

            if (currentMinute > firstMin && currentMinute < secondMin) {
                secondMin = currentMinute;
                secondRunner = runnersNameArrays[i];
            }
        }

        return secondRunner;
    }


    public int getThird() {
        int firstMin = getFirst();
        int secondMin = getSecond();
        int thirdMin = runnersMinutesArrays[0];

        for (int i = 0; i < runnersMinutesArrays.length; i++) {
            int currentMinute = runnersMinutesArrays[i];

            if (currentMinute > secondMin && currentMinute < thirdMin) {
                thirdMin = currentMinute;
            }
        }

        return thirdMin;
    }

    public String getThirdName() {
        int thirdMin = getThird();
        String thirdRunner = "";

        for (int i = 0; i < runnersMinutesArrays.length; i++) {
            if (runnersMinutesArrays[i] == thirdMin) {
                thirdRunner = runnersNameArrays[i];
                return thirdRunner;
            }
        }

        return thirdRunner;
    }


    public String getClassification() {
        int A = 0, B = 0, C = 0;

        for (int i = 0; i < runnersMinutesArrays.length; i++) {
            int minutes = runnersMinutesArrays[i];

            if (200 <= minutes && minutes <= 299) {
                A++;
            } else if (300 <= minutes && minutes <= 399) {
                B++;
            } else if (400 <= minutes) {
                C++;
            }
        }

        return "A -> " + A + "\nB -> " + B + "\nC -> " + C;
    }


    public void procces() {
        System.out.println("Birinci: " + getFirstName() + " " + getFirst() + " Dakika");
        System.out.println("İkinci: " + getSecondName() + " " + getSecond() + " Dakika");
        System.out.println("Üçüncü: " + getThirdName() + " " + getThird() + " Dakika");
        System.out.println(getClassification());
    }
}
