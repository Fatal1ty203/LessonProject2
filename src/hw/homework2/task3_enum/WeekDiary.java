package hw.homework2.task3_enum;

class WeekDiary {
    private Plan[] ar = new Plan[7];

    public void addPlan(Days day, String plan) {
        if (ar[day.getDayIndex()] == null) {
            ar[day.getDayIndex()] = new Plan(day);
        }
        ar[day.getDayIndex()].planList.add(plan);
    }

    public void print() {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] != null) {
                System.out.println(ar[i].day.toString());
                System.out.println(ar[i].planList);
            }else {
                System.out.println("Список дел пуст");
            }
        }
    }
}
