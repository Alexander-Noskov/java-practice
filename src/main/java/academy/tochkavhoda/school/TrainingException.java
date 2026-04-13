package academy.tochkavhoda.school;

public class TrainingException extends RuntimeException {
    private TrainingErrorCode errorCode;

    public TrainingException(TrainingErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public TrainingErrorCode getErrorCode() {
        return errorCode;
    }
}
