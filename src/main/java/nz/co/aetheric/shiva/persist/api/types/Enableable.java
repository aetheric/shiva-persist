package nz.co.aetheric.shiva.persist.api.types;

/**
 * Describes an entity that can be enabled or disabled.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public interface Enableable {
	public static final String FIELD_ENABLED = "enabled";

	public Boolean isEnabled();

	public void setEnabled(boolean enabled);

}
