package de.mn.pollux.views;

import java.io.Serializable;

import com.vaadin.data.util.BeanItemContainer;

import de.mn.pollux.entities.Poll;

@SuppressWarnings("serial")
public class PollsOverviewBeanItemContainer extends BeanItemContainer<Poll> implements
        Serializable {

    /**
     * Natural property order for Person bean. Used in tables and forms.
     */
    public static final Object[] NATURAL_COL_ORDER = new Object[] {
            "title", "description"};

    /**
     * "Human readable" captions for properties in same order as in
     * NATURAL_COL_ORDER.
     */
    public static final String[] COL_HEADERS_ENGLISH = new String[] {
            "Titel", "Beschreibung" };

    public PollsOverviewBeanItemContainer() throws InstantiationException,
            IllegalAccessException {
        super(Poll.class);
    }

}
