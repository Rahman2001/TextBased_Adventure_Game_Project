package gazi.university;

public interface ActiveAndPassive {

    // I thought that default attack should be int. So that it'll return enemy's next health value.
    void defaultAttack(Enemy enemy);

    // I'm not sure about this part. But it looks good.
    void activeSkill(Enemy enemy);

    // I removed passiveSkill function. We can add it later if required.
}
