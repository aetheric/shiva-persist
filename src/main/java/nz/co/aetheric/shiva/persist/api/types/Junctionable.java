package nz.co.aetheric.shiva.persist.api.types;

/**
 * Describes an entity that is used to map two other entity types together.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public interface Junctionable<LeftType, RightType> {
	public static final String FIELD_LEFT = "left";
	public static final String FIELD_RIGHT = "right";

	public LeftType getLeft();

	public void setLeft(LeftType left);

	public RightType getRight();

	public void setRight(RightType right);

}
