package academy.tochkavhoda.school;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class School {
    private String name;

    private int year;

    private final Set<Group> groups;

    public School(String name, int year) {
        if (name == null || name.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
        this.name = name;
        this.year = year;
        this.groups = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        boolean groupExists = groups.stream()
                .anyMatch(existingGroup -> existingGroup.getName().equals(group.getName()));

        if (groupExists) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
        }

        groups.add(group);
    }

    public void removeGroup(Group group) {
        if (!this.groups.contains(group)) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
        this.groups.remove(group);
    }

    public void removeGroup(String name) {
        Group group = groups.stream()
                .filter(g -> g.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND));
        this.groups.remove(group);
    }

    public boolean containsGroup(Group group) {
        return this.groups.contains(group);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return year == school.year && Objects.equals(name, school.name) && Objects.equals(groups, school.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, groups);
    }
}
