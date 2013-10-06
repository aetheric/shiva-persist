package nz.co.aetheric.shiva.persist.api.filters;

import nz.co.aetheric.shiva.persist.api.Query;
import nz.co.aetheric.shiva.persist.api.QueryFilter;
import nz.co.aetheric.shiva.persist.api.types.Identifiable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Filters an Identifiable entity query on whether the id is within a particular collection.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public interface IdMatchesFilter<
		QueryType extends Query<? extends Identifiable<IdType>, ?>,
		IdType extends Serializable
>
		extends QueryFilter<QueryType> {

	public Collection<IdType> getIds();

	@Override
	public void apply(QueryType query);

	public void apply(QueryType query, Collection<IdType> ids);

	public void apply(QueryType query, IdType... ids);

}
