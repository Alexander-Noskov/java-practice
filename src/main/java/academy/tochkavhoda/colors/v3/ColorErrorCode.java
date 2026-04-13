package academy.tochkavhoda.colors.v3;

public enum ColorErrorCode {
    WRONG_COLOR_STRING("Некорректная строка цвета"),
    NULL_COLOR("Цвет не может быть null");

    private final String errorString;

    ColorErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
