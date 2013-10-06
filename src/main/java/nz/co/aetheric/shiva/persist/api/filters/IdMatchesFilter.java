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
public abstract class IdMatchesFilter<
		QueryType extends Query<? extends Identifiable<IdType>, ?>,
		IdType extends Serializable
>
		implements QueryFilter<QueryType> {

	private final Collection<IdType> ids;

	protected IdMatchesFilter(Collection<IdType> ids) {
		this.ids = Collections.unmodifiableCollection(ids);
	}

	protected IdMatchesFilter(IdType... ids) {
		this(Arrays.asList(ids));
	}

	public Collection<IdType> getIds() {
		return ids;
	}

	@Override
	public abstract void apply(QueryType query);

	public abstract void apply(QueryType query, Collection<IdType> ids);

	public void apply(QueryType query, IdType... ids) {
		apply(query, Arrays.asList(ids));
	}

}
