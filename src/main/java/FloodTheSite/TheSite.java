package FloodTheSite;
public class TheSite {
    // Адреса полей расположения сайта на игровом поле.
    private final int[] locationCells = new int[3];
    // Количество попаданий.
    int numOfHits = 0;

    // Параметры:
    // Ход пользователя:String - 1, 3 ,5 и т.д..
    // Результат:String - Попал, Мимо, Потопил.
    public String checkTarget(String target) {
        numOfHits--;
        return "";
    }

    // Выполняет запись адресов полей, в которых располагается сайт.
    public void setLocationCells(int[] cells) {
        locationCells[0] = 0;
    }
}
