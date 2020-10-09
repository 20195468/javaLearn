import java.util.PrimitiveIterator;

/**
 * @program: 建模竞赛
 * @description 找出最短路径后工厂工作天数的计算
 * @author: 李星泽
 * @create: 2020-09-12 20:23
 **/
public class PassGame {

    public static void main(String[] args) {
        int[] weather = {2, 2, 1, 3, 1, 2, 3, 1, 2, 2,
                3, 2, 1, 2, 2, 2, 3, 3, 2, 2,
                1, 1, 2, 1, 3, 2, 1, 1, 2, 2};//天气状况
        int[] road = {1, 25, 24, 23, 22, 9, 15, 13, 12, 14, 15, 9, 21, 27};//最短路径
        int surplusDay = 30;//剩余天数
        Run run = new Run();
        int roadPointer = 0;//路径指针
        int money = 10000;//金钱总额
        int water = 0, food = 0;
        int needWater, needFood;
        int villageFlag = 0;//到达村庄后的时间标记
        int mineFlagFromStart = 0;//到达矿山后的时间标记
        for (int i = 1; i <= 30; i++) {
            if (weather[i - 1] != 3) roadPointer++;
            System.out.println("第" + i + "天已经走到" + road[roadPointer]);
            //到达村庄需要的总水重
            water = water + run.consumeWaterWeight(weather[i - 1], 0);
            //到达村庄需要的总食物重
            food = food + run.consumeFoodWeight(weather[i - 1], 0);
            System.out.println("第" + i + "天需要食物" + run.consumeFoodWeight(weather[i - 1], 0));
            System.out.println("第" + i + "天需要水" + run.consumeWaterWeight(weather[i - 1], 0));
            //到达村庄后跳出循环
            if (road[roadPointer] == 15) {
                villageFlag = i;
                break;
            }
        }
        System.out.println("到达村庄一共需要食物" + food);
        System.out.println("到达村庄一共需要水" + water);
        System.out.println("走到村庄是第" + villageFlag + "天");
        System.out.println("在最开始要购买" + water / 3 * 5 + "kg的水  " + food / 2 * 10 + "的食物");
        System.out.println("买水花费" + (water / 3 * 5) + "元，买食物花费" + (food / 2 * 10) + "元");
        money = money - (water / 3 * 5) - (food / 2 * 10);
        System.out.println("现在还剩" + money + "元");
        int tempMoney = money;

        //从村庄走到矿山
        water = 0;
        food = 0;
        int isWorkflag = 0;
        int workStopDay = 0;
        for (int i = villageFlag; i <= 30; i++) {
            if (weather[i - 1] != 3) roadPointer++;
            System.out.println("+++++++++"+roadPointer);
            System.out.println("第" + i + "天已经走到" + road[roadPointer]);
            //到达村庄需要的总水重
            water = water + run.consumeWaterWeight(weather[i - 1], 0);
            //到达村庄需要的总食物重
            food = food + run.consumeFoodWeight(weather[i - 1], 0);
            System.out.println("第" + i + "天需要食物" + run.consumeFoodWeight(weather[i - 1], 0));
            System.out.println("第" + i + "天需要水" + run.consumeWaterWeight(weather[i - 1], 0));
            //到达村庄后跳出循环
            if (road[roadPointer] == 12) {
                villageFlag = i;
                break;
            }
        }

        //在矿山工作
        for (int i = villageFlag + 1; i <= 30; i++) {
            if (weather[i - 1] != 3) roadPointer++;
            System.out.println("第" + i + "天已经走到" + road[roadPointer]);
            //是否开始工作
            if (road[roadPointer] == 12) {
                isWorkflag = 1;
                water = water + run.consumeWaterWeight(weather[i - 1], 0);
                food = food + run.consumeFoodWeight(weather[i - 1], 0);
                System.out.println("第" + i + "天需要食物" + run.consumeFoodWeight(weather[i - 1], 0));
                System.out.println("第" + i + "天需要水" + run.consumeWaterWeight(weather[i - 1], 0));
                continue;
            }
            if (isWorkflag == 1) {
                water = water + run.consumeWaterWeight(weather[i - 1], 1);
                food = food + run.consumeFoodWeight(weather[i - 1], 1);
                money = money + 1000;
                System.out.println("第" + i + "天需要食物" + run.consumeFoodWeight(weather[i - 1], 1));
                System.out.println("第" + i + "天需要水" + run.consumeWaterWeight(weather[i - 1], 1));
            }
            boolean stillWork = run.stillWork(water, food, weather, i, tempMoney);
            if (stillWork) {
                workStopDay = i - 1;
                break;
            }
            if (roadPointer == road.length) break;
        }

        //从矿山到村庄
        for (int i = workStopDay; i <= 30; i++) {
            if (weather[workStopDay] != 3) roadPointer++;
            water = water + run.consumeWaterWeight(weather[workStopDay], 0);
            food = food + run.consumeFoodWeight(weather[workStopDay], 0);
            if (road[roadPointer] == 15) break;
        }

        System.out.println("到达村庄一共需要食物" + food);
        System.out.println("到达村庄一共需要水" + water);
        System.out.println("走到村庄是第" + villageFlag + "天");
        System.out.println("在最开始要购买" + water / 3 * 5 + "kg的水  " + food / 2 * 10 + "的食物");
        System.out.println("买水花费" + (water / 3 * 5) + "元，买食物花费" + (food / 2 * 10) + "元");
        money = money - (water / 3 * 5) - (food / 2 * 10);
        System.out.println("现在还剩" + money + "元");


    }
}

class Run {
    int waterSunWeight = 5, foodSunWeight = 7;
    int waterHighWeight = 8, foodHighWeight = 6;
    int waterStormWeight = 10, foodStormWeight = 10;

    public int consumeWaterWeight(int weather, int isWork) {
        if (weather == 1) {
            if (isWork == 1) return waterSunWeight * 3 * 3;
            return waterSunWeight * 3 * 2;
        } else if (weather == 2) {
            if (isWork == 1) return waterSunWeight * 3 * 3;
            return waterHighWeight * 3 * 2;
        } else if (weather == 3) {
            if (isWork == 1) return waterSunWeight * 3 * 3;
            return waterStormWeight * 3;
        }
        return 0;
    }

    public int consumeFoodWeight(int weather, int isWork) {
        if (weather == 1) {
            if (isWork == 1) return foodSunWeight * 2 * 3;
            return foodSunWeight * 2 * 2;
        } else if (weather == 2) {
            if (isWork == 1) return foodHighWeight * 2 * 3;
            return foodHighWeight * 2 * 2;
        } else if (weather == 3) {
            if (isWork == 1) return foodStormWeight * 2 * 3;
            return foodStormWeight * 2;
        }
        return 0;
    }

    public boolean stillWork(int water, int food, int[] weather, int day, int money) {
        int[] road = {12, 14, 15};
        int roadPointer = 0;
        for (int i = day; i <= 30; i++) {
            if (weather[day - 1] != 3) roadPointer++;
            water = water + consumeWaterWeight(weather[day - 1], 0);
            food = food + consumeFoodWeight(weather[day - 1], 0);
            if (road[roadPointer] == 15) break;
        }
        if ((water + food > 1200) || (water / 3 * 5 + food / 2 * 10 > money)) {
            return true;
        }
        return false;
    }
}
