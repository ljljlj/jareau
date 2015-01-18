package net.yorkjr.jareau.dao;

import net.yorkjr.jareau.pojo.Section;

/**
 * Created by ley on 15/1/18.
 */

public interface SectionDao {
    Section get(int id);
    void update(Section section);
    void save(Section section);
}
