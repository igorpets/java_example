package FloodTheSite;

public class TheSite {
    // Размеры игрового  поля 1x7.
    public static int AREA_SIZE = 7;
    // Размер сайта на игровом поле 1x3.
    public static int SITE_SIZE = 3;
    public static String AWAY="Мимо";
    public static String HIT="Попал";
    public static String SUNK="Потопил";
    private boolean test = false;
    // Координаты полей сайта на игровом поле.
    private final int[] locationCells = new int[SITE_SIZE];
    // Количество попаданий.
    int numOfHits = 0;

    public TheSite(){
    }
    public TheSite(boolean _test){
        test = _test;
    }
    // Параметры:
    // Ход пользователя:String - 1, 3 ,5 и т.д..
    // Результат:String - Попал, Мимо, Потопил.
    public String checkTarget(String _target) {
        // По умолчанию - нет попаданий, возвращаем "Мимо".
        String result = AWAY;
        if (numOfHits < locationCells.length) {
            // Проверяем полученный ход.
            if (_target.length() > 1 || _target.compareTo("1") < 0 || _target.compareTo(Integer.toString(AREA_SIZE)) > 0) {
                if (!test)
                    System.out.println("Координата должна быть числом от 1 до " + AREA_SIZE + "!");
            } else {
                // Преобразуем полученный ход пользователя в целое число.
                int target = Integer.parseInt(_target);
                if ((target < 1) || (target > AREA_SIZE)) {
                    if (!test)
                        System.out.println("Координата выстрела выходит за пределы игрового поля " + AREA_SIZE + "x" + AREA_SIZE + "!");
                } else {
                    // цикл по всем полям, занятым сайтом.
                    int current;
                    for (int i = 0; i < locationCells.length; i++) {
                        current = locationCells[i];
                        //System.out.println("current=" + current +" target="+target);
                        // Сравниваем ход пользователя с адресом очередного поля сайта.
                        if (current == target) {
                            // Если пользователь угадал, то увеличиваем счетчик попаданий.
                            numOfHits++;
                            // Определяем, было ли это последнее "живое" поле сайта.
                            if (numOfHits >= locationCells.length) {
                                // Если было 3 попадания, то возвращаем "потопил"
                                result = SUNK;
                            } else {
                                // Иначе возвращаем "Попал"
                                result = HIT;
                            }
                            // Отмечаем что данное поле сайта уже "подбито".
                            locationCells[i] = -1;
                            break;
                        }
                    }// конец цикла
                }
            }
        }
        // Печатаем результат выстрела в консоль.
        if (!test)
            System.out.println(result);
        // Возвращаем результат выстрела.
        return result;
    }

    // Выполняет запись координат полей, в которых располагается сайт.
    // Возвращает 1, при ошибке, иначе 0.
    public int setLocationCells(int left_cell) {
        // Проверяем полученную координату левой точки на соответствие игровому полю 7х7.
        if (left_cell<1 || left_cell>AREA_SIZE-2) {
            if (!test)
                System.out.println("Координаты сайта выходят за пределы поля 7х7!");
            return 1;
        }
        // Записываем массив координат сайта во внутреннее хранилище.
        locationCells[0] = left_cell;
        locationCells[1] = left_cell + 1;
        locationCells[2] = left_cell + 2;
        return 0;
    }
}
