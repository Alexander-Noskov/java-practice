package academy.tochkavhoda.school;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.Set;

public class TraineeBidiMap {
    private final BidiMap<String, Trainee> trainees;

    public TraineeBidiMap() {
        this.trainees = new DualHashBidiMap<>();
    }

    public void addTrainee(Trainee trainee, String passport) {
        if (this.trainees.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_PASSPORT);
        }
        if (this.trainees.containsValue(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
        this.trainees.put(passport, trainee);
    }

    public void replaceTraineePassport(Trainee trainee, String passport) {
        if (!this.trainees.containsValue(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        if (this.trainees.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_PASSPORT);
        }
        this.trainees.put(passport, trainee);
    }

    public void removeTrainee(Trainee trainee) {
        if (!this.trainees.containsValue(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        this.trainees.removeValue(trainee);
    }

    public void removeTraineeByPassport(String passport) {
        if (!this.trainees.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.PASSPORT_NOT_FOUND);
        }
        this.trainees.remove(passport);
    }

    public Trainee getTraineeByPassport(String passport) {
        if (!this.trainees.containsKey(passport)) {
            throw new TrainingException(TrainingErrorCode.PASSPORT_NOT_FOUND);
        }
        return this.trainees.get(passport);
    }

    public String getPassportByTrainee(Trainee trainee) {
        if (!this.trainees.containsValue(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        return this.trainees.getKey(trainee);
    }

    public Set<Trainee> getAllTrainees() {
        return this.trainees.values();
    }

    public Set<String> getAllPassports() {
        return this.trainees.keySet();
    }

    public boolean hasAnybodyPassport(String passport) {
        return this.trainees.containsKey(passport);
    }

    public int getTraineesCount() {
        return this.trainees.size();
    }
}
