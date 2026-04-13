package academy.tochkavhoda.school;

public enum TrainingErrorCode {
    GROUP_WRONG_NAME("Неверное имя группы"),
    GROUP_WRONG_ROOM("Неверный номер аудитории"),
    TRAINEE_NOT_FOUND("Ученик не найден"),
    SCHOOL_WRONG_NAME("Неверное имя школы"),
    DUPLICATE_GROUP_NAME("Группа с таким именем уже существует"),
    GROUP_NOT_FOUND("Группа не найдена"),
    DUPLICATE_TRAINEE("Этот ученик уже существует"),
    EMPTY_TRAINEE_QUEUE("Очередь учеников пуста"),
    DUPLICATE_PASSPORT("Паспорт с таким номером уже существует"),
    PASSPORT_NOT_FOUND("Паспорт не найден");

    private String message;
    TrainingErrorCode(String message) {
        this.message = message;
    }
}
