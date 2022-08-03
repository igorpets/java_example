// Тест для класса TheSite.
package TestFloodTheSite;
import FloodTheSite.TheSite;

public class TestTheSite {
    private TheSite ts = new TheSite(true);
    private int err_count = 0;
    public static void main(String[] args) {
        // Создаем тестовый объект и сразу запускаем проверку.
        TestTheSite tts = new TestTheSite();
    }
    public TestTheSite(){
        System.out.print("Запуск теста класса TheSite...   ");
        // Проверки метода setLocationCells.
        err_count += 1 - ts.setLocationCells(0);
        err_count += 1 - ts.setLocationCells(TheSite.AREA_SIZE-1);
        err_count += ts.setLocationCells(TheSite.AREA_SIZE-2);
        err_count += ts.setLocationCells(1);
        err_count += ts.setLocationCells(3);
        // Проверки метода checkTarget.
        err_count += check_away("не число");
        err_count += check_away("0");
        err_count += check_away("1");
        err_count += check_away("2");
        err_count += check_away("6");
        err_count += check_away("7");
        err_count += check_hit("4");
        err_count += check_hit("5");
        err_count += check_sunk("3");
        err_count += check_away("4");
        err_count += check_away("5");
        // Завершение теста, успешно/неуспешно.
        if (err_count>0)
            System.out.println("Всего найдено: "+err_count + " ошибок.");
        else
            System.out.println("OK");
    }
    // Проверка значения "Мимо".
    private int check_away(String target) {
        String res = ts.checkTarget(target);
        if (res != TheSite.AWAY) {
            System.out.println("Error1: target="+target+" ожидается "+TheSite.AWAY+" получен "+res);
            return 1;
        }
        return  0;
    }
    // Проверка значения "Попал".
    private int check_hit(String target) {
        String res = ts.checkTarget(target);
        if (res != TheSite.HIT) {
            System.out.println("Error2: target="+target+" ожидается "+TheSite.HIT+" получен "+res);
            return 1;
        }
        return 0;
    }
    // Проверка значения "Потопил".
    private int check_sunk(String target) {
        String res = ts.checkTarget(target);
        if (res != TheSite.SUNK) {
            System.out.println("Error3: target="+target+" ожидается "+TheSite.SUNK+" получен "+res);
            return 1;
        }
        return 0;
    }
}
