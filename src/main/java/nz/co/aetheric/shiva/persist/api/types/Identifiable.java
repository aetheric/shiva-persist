package nz.co.aetheric.shiva.persist.api.types;

import java.io.Serializable;

/**
 * Describes an entity that has an identity field.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public interface Identifiable<IdentityType extends Serializable> {
	public static final String FIELD_ID = "id";

	public IdentityType getId();

	public void setId(IdentityType id);

}
