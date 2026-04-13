package academy.tochkavhoda.school;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Group {
    private String name;

    private String room;

    private final List<Trainee> trainees;

    public Group(String name, String room) {
        if (name == null || name.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }
        if (room == null  || room.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }
        this.name = name;
        this.room = room;
        this.trainees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null  || name.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) throws TrainingException {
        if (room == null || room.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }
        this.room = room;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void addTrainee(Trainee trainee) {
        this.trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) {
        if (!this.trainees.contains(trainee)) {
            throw  new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        this.trainees.remove(trainee);
    }

    public void removeTrainee(int index) {
        if (index < 0 || index >= trainees.size()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        trainees.remove(index);
    }

    public Trainee getTraineeByFirstName(String firstName) {
        return trainees.stream()
                .filter(t -> t.getFirstName().equals(firstName))
                .findFirst()
                .orElseThrow(() -> new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND));

    }

    public Trainee getTraineeByFullName(String fullName) {
        return trainees.stream()
                .filter(t -> t.getFullName().equals(fullName))
                .findFirst()
                .orElseThrow(() -> new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND));
    }

    public void sortTraineeListByFirstNameAscendant() {
        trainees.sort(Comparator.comparing(Trainee::getFirstName));
    }

    public void sortTraineeListByRatingDescendant() {
        trainees.sort(Comparator.comparing(Trainee::getRating).reversed());
    }

    public void reverseTraineeList() {
        Collections.reverse(trainees);
    }

    public void rotateTraineeList(int positions) {
        Collections.rotate(trainees, positions);
    }

    public List<Trainee> getTraineesWithMaxRating() {
        if (trainees.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }

        int maxRating = trainees.stream()
                .map(Trainee::getRating)
                .max(Integer::compareTo)
                .get();

        return trainees.stream()
                .filter(t -> t.getRating() == maxRating)
                .toList();
    }

    public boolean hasDuplicates() {
        Set<Trainee> traineeSet = new HashSet<>(trainees);

        return traineeSet.size() != trainees.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) && Objects.equals(room, group.room) && Objects.equals(trainees, group.trainees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, room, trainees);
    }
}
