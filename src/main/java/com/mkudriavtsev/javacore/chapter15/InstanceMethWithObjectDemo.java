package main.java.com.mkudriavtsev.javacore.chapter15;

//Использование ссылки на метод экземпляра вместе с разными объектами
interface MyFunc2<T> {
    boolean func(T v1, T v2);
}
//Класс для хранения макисмальной температуры за день
class HighTemp {
    private int hTemp;
    HighTemp(int ht) {
        hTemp = ht;
    }
    boolean sameTemp(HighTemp ht2) {
        return hTemp == ht2.hTemp;
    }
    boolean lessThanTemp(HighTemp ht2) {
        return hTemp < ht2.hTemp;
    }
}
class InstanceMethWithObjectDemo {
    static <T> int counter(T[] vals, MyFunc2<T> f, T v) {
        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            if(f.func(vals[i], v)) count++;
        }
        return count;
    }


    public static void main(String[] args) {
        int count = 0;
        HighTemp [] weekDayHighs = {
                new HighTemp(89), new HighTemp(82),
                new HighTemp(90), new HighTemp(89),
                new HighTemp(89), new HighTemp(91),
                new HighTemp(84), new HighTemp(83) };
        count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));
        System.out.println("Дней когда максимальная температура была 89: " + count);
        count = counter(weekDayHighs, HighTemp::lessThanTemp, new HighTemp(89));
        System.out.println("Дней, когда максимальная температура была меньше 89: " + count);
    }

}
