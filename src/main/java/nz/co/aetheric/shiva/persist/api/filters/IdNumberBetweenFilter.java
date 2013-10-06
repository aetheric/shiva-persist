package nz.co.aetheric.shiva.persist.api.filters;

import nz.co.aetheric.shiva.persist.api.Query;
import nz.co.aetheric.shiva.persist.api.QueryFilter;
import nz.co.aetheric.shiva.persist.api.types.Identifiable;

/**
 * Filters a query to make sure all the ids are within a particular inclusive range.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public interface IdNumberBetweenFilter<
		QueryType extends Query<? extends Identifiable<IdType>, ?>,
		IdType extends Number
>
		extends QueryFilter<QueryType> {

	public IdType getMinimum();

	public IdType getMaximum();

	@Override
	public abstract void apply(QueryType query);

	public abstract void apply(QueryType query, IdType minimum, IdType maximum);

}
