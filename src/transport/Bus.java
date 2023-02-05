package transport;
import com.company.BusDriver;

public class Bus extends Transport<BusDriver> implements Participant {
    Type type = Type.valueOf("BUS");

    public Bus(String brand, String model, String engineVolume, BusDriver driver) {
        super(brand, model, engineVolume, driver);
    }

    @Override
    public void startMove() {
        System.out.println("Bus starts moving...");
    }
    @Override
    public void stopMove() {
        System.out.println("Bus stops moving...");
    }
    @Override
    public void pit_stop() {
        System.out.println("Автобус ушел на пит-стоп");
    }
    @Override
    public void bestTime() {
        System.out.println("Лучшее время автобуса:__:__");
    }
    @Override
    public void maxSpeed() {
        System.out.println("Максимальная скорость автобуса:___");
    }

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void printType() {
        if (type != null) {
            System.out.println("Тип машины:" + type.getName());
        }
        else {
            System.out.println("Данных по транспортному средству недостаточно");
        }
    }

    @Override
    public String toString() {
        return "Bus{" +
                super.toString() +
                '}';
    }

    enum Capacity{
        specialSmall(null, 10),
        small(null, 25),
        middle(25, 50),
        large(50, 80),
        specialLarge(80, 120);

        private Integer lower_bound;
        private Integer upper_bound;

        Capacity(Integer lower_bound, Integer upper_bound) {
            this.lower_bound = lower_bound;
            this.upper_bound = upper_bound;
        }

        @Override
        public String toString() {
            if (lower_bound == null) {
                return "Вместимость до " +
                        upper_bound + " мест";
            }
            else if (upper_bound == null) {
                return "Вместимость от " +
                        lower_bound + " мест";
            }
            else {
                return "Вместимость от " +
                        lower_bound + " до " + upper_bound + " мест";
            }
        }
    }
}
