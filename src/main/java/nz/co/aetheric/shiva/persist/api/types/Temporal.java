package nz.co.aetheric.shiva.persist.api.types;

import java.util.Calendar;

/**
 * Describes an entity that keeps track of modifications.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public interface Temporal {
	public static final String FIELD_DATE_CREATED = "dateCreated";
	public static final String FIELD_LAST_UPDATED = "lastUpdated";

	public Calendar getDateCreated();

	public void setDateCreated();

	public Calendar getLastUpdated();

	public void setLastUpdated();

}
