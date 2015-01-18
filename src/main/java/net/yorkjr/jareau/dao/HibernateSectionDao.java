package net.yorkjr.jareau.dao;

import net.yorkjr.jareau.pojo.Section;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ley on 15/1/18.
 */
@Repository("sectionDao")
public class HibernateSectionDao implements SectionDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Section get(int id) {
        return (Section) sessionFactory.getCurrentSession().get(Section.class, id);
    }

    @Override
    public void update(Section section) {
        sessionFactory.getCurrentSession().update(section);
    }

    @Override
    public void save(Section section) {
        sessionFactory.getCurrentSession().save(section);
    }
}
