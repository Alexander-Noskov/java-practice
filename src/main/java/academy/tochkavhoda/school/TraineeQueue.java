package academy.tochkavhoda.school;

import java.util.LinkedList;
import java.util.Queue;

public class TraineeQueue {
    private final Queue<Trainee> trainees;

    public TraineeQueue() {
        this.trainees = new LinkedList<>();
    }

    public void addTrainee(Trainee trainee) {
        this.trainees.add(trainee);
    }

    public Trainee removeTrainee() {
        if (this.trainees.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        }
        return this.trainees.remove();
    }

    public boolean isEmpty() {
        return this.trainees.isEmpty();
    }


}
