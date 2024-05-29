

public class DinnerFullCource {

    private Dish[] list = new Dish[5];// [0]-[4]の計5個

    public static void main(String[] args) {

        DinnerFullCource fullcourse = new DinnerFullCource();
        fullcourse.eatAll();
    }

    DinnerFullCource() {

        for (int i = 0; i < 5; i++) {
            list[i] = new Dish();
        }

        list[0].setName("シーザーサラダ");
        list[0].setValune(5);

        list[1].setName("コーンポタージュ");
        list[1].setValune(4);

        list[2].setName("パン");
        list[2].setValune(2);

        list[3].setName("魚");
        list[3].setValune(7);

        list[4].setName("ステーキ");
        list[4].setValune(10);
    }

    public void eatAll() {
        String str = "";
        for(Dish dish: list){
            str += dish.getName() + ":" +  dish.getValune() + " 円 → ";
        }
        System.out.println("本日の献立はこちらになります;" + str);

    }
}
