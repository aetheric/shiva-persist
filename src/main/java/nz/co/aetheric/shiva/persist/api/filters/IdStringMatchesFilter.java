package nz.co.aetheric.shiva.persist.api.filters;

import nz.co.aetheric.shiva.persist.api.Query;
import nz.co.aetheric.shiva.persist.api.QueryFilter;
import nz.co.aetheric.shiva.persist.api.types.Identifiable;

/**
 * Filters a query on whether the provided string matches the result ids.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public abstract class IdStringMatchesFilter<QueryType extends Query<? extends Identifiable<String>, ?>>
		implements QueryFilter<QueryType> {

	private final String match;

	protected IdStringMatchesFilter(String match) {
		this.match = match;
	}

	public String getMatch() {
		return match;
	}

	@Override
	public abstract void apply(QueryType query);

	public abstract void apply(QueryType query, String match);

}
