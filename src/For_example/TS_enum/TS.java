package For_example.TS_enum;

public enum TS {
    OLGA("Власенко Ольга", "89615028809"),
    MAMA("Галина Гончаренко", "89530874069"),
    PAPA("Сергей Гочаренко", "89528190469"),
    STAS("Станислав босых", "89628723800"),
    GRISHA("Григорий Карпов", "89064381426");

    private String name;
    private String number;

    TS(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void GetData() {
        System.out.println("ФИО: " + getName() + " \nНомер телефона: " + getNumber());
    }
}


