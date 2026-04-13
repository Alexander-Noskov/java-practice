package academy.tochkavhoda.school;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TraineeMap {
    private final Map<Trainee, String> trainees;

    public TraineeMap() {
        this.trainees = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) {
        if (trainees.containsKey(trainee) && trainees.get(trainee).equals(institute)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
        trainees.put(trainee, institute);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) {
        if (!trainees.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        trainees.put(trainee, institute);
    }

    public void removeTraineeInfo(Trainee trainee) {
        if (trainees.remove(trainee) == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public int getTraineesCount() {
        return trainees.size();
    }

    public String getInstituteByTrainee(Trainee trainee) {
        String institute = trainees.get(trainee);
        if (institute == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        return institute;
    }

    public Set<Trainee> getAllTrainees() {
        return trainees.keySet();
    }

    public Set<String> getAllInstitutes() {
        return new HashSet<>(trainees.values());
    }

    public boolean isAnyFromInstitute(String institute) {
        return trainees.containsValue(institute);
    }
}
