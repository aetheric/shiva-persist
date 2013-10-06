package nz.co.aetheric.shiva.persist.api.types;

/**
 * Describes an entity that keeps track of its version.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public interface Versionable {
	public static final String FIELD_VERSION = "version";

	public Long getVersion();

	public void setVersion(Long version);

}
