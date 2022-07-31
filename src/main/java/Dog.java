class Dog {
    String name;
    public static void main(String[] args) {
            // Создаем объект Dog и получаем к нему доступ
        Dog d1 = new Dog();
        d1.name = "Арчибальд";
        d1.bark();

        Dog[] my = new Dog[5];
        my[0] = new Dog();
        my[1] = new Dog();
        my[2] = my[0];
        my[0].name = "Шпонка";
        my[0].bark();

        int k = 0;
        while (k<my.length) {
            if (my[k] != null)
                my[k].bark();
            k++;
        }
    }

    public void bark() {
        System.out.println(name + " сказал вау вау!");
    }
}
